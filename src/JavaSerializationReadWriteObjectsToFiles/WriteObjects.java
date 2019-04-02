/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSerializationReadWriteObjectsToFiles;

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

    public static void main(String[] args) {
        System.out.println("Writing objects...");

        Person mike = new Person(543, "Mike");
        Person sue = new Person(123, "Sue");
        Person mathias = new Person(2611, "Mathias");

        System.out.println(mike);
        System.out.println(sue);

        //i parentesen for try er der autoclose
        //der opretes en fil som der kan skrives fra
        try (FileOutputStream outputStream = new FileOutputStream("people.bin")) {

            //der oprettes et obejct som kan gemmes i filen
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            
            //skriv os. og se hvilke skrive (write)-metoder der kommer frem
            //i dette tilfælde skriver to objekter i filen
            os.writeObject(mike);
            os.writeObject(sue);
            os.writeObject(mathias);
            
            //husk at lukke objektet, da det ikke er autoclosable
            os.close();

        } catch (IOException ex) {
            System.out.println("Can not write to file: " + ex);
        }
    }
}
