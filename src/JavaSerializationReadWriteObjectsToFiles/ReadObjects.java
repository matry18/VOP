/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSerializationReadWriteObjectsToFiles;

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
    public static void main(String[] args) {
        System.out.println("Reading objects...");
        
        //opretter en FileOutputStream for at læse filen med filen som parameter
        //oprettes i en try-parentes for at gøre det autoclosable
        try (FileInputStream inputStream = new FileInputStream("people.bin")) {
            
            //opretter en ObjectInputStream for at indlæse objekterne fra filen
            ObjectInputStream os = new ObjectInputStream(inputStream);
            
            //Person castes til object og objecktet læses
            Person person1 = (Person)os.readObject();
            Person person2 = (Person)os.readObject();
            Person person3 = (Person)os.readObject();
            //hint skriv os. og se hvilke read-metoder der kommer
            
            //husk at lukke os
            os.close();
            
            //for at vise hvad der er blevet læst
            System.out.println(person1);
            System.out.println(person2);
            System.out.println(person3);
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: "+ex);
        } catch (IOException ex) {
            System.out.println("Problem reading from the file: "+ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("");
        }
    }
}
