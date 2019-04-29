/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSerialization_SavingObjectsToFiles;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aalsc
 */
public class WriteObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Writing objects...");

        Person mike = new Person(432, "Mike");
        Person sue = new Person(123, "Sue");

        System.out.println(mike);
        System.out.println(sue);

        try {
            //opretter et outputstream som en file, der bliver oprettet
            FileOutputStream fs = new FileOutputStream("people.bin");
            
            //Opretter en outputstream
            ObjectOutputStream os = new ObjectOutputStream(fs);
            
            //Vælger de objekter der skal skrives til filen
            os.writeObject(mike);
            os.writeObject(sue);
            
            fs.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file!");
        } catch (IOException ex) {
            System.out.println("Could not write to file!");
        }
    }

}
