/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aalsc
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //opretter et filobjekt med filen som parameter
        File file = new File("alice30.txt"); //filen er oprettet og ligger udenfor src-mappen

        // instantiere BufferedReader udenfor min try-catch for at kunne lukke den efter try-catch. Peger på en null-værdi
        BufferedReader br = null;
        try {
            //opretter en filereader til at læse filen med fil-objektet som argument
            FileReader fr = new FileReader(file);

            //Henviser til BufferedReader-variablen og giver filereader-objektet som argument
            br = new BufferedReader(fr);

            String line;
            //puttes i en while-løkke for at læse hele filen og ikke kun første linje
            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + file.toString());
        } catch (IOException ex) {
            System.out.println("Can not read file: " + file.toString());
        }
        
        finally {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("Can not close file: "+file.toString());
            }
        } 
        
    }

}
