/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSerialization_SavingObjectsToFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aalsc
 */
public class ReadObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Reading objects...");
        
        try { //opretter en fileinputstream i en try, med filnavnet som den skal læse som argument
            FileInputStream fi = new FileInputStream("people.bin");
            
            //oprettet et objektinputstream med filstrømmen som argument
            ObjectInputStream os = new ObjectInputStream(fi);
            
            //Oprettet person-objekter og definerer at disse skal indlæses
            Person person1 = (Person)os.readObject();
            Person person2 = (Person)os.readObject();
            
            os.close();
            
            //udskriver havd der er blevet indlæst
            System.out.println(person1);
            System.out.println(person2);
            
            fi.close();
        } catch (FileNotFoundException ex) {
            System.out.println("could not find the file!");
        } catch (IOException ex) {
            System.out.println("Could not close the file!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find the class!");
        }
    }
    
}
