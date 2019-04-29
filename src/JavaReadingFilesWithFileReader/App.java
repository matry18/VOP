/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaReadingFilesWithFileReader;

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

        //Oprettet et fileobjekt med filnavnet på den alleredeoprettede fil
        File file = new File("TextScanner.txt");

        try {
            //Opretter et filereader-objekt og giver filen som argument
            FileReader in = new FileReader(file);

            //Bruger en bufferedreader til at læse lidt ad gange og give filereader som argument
            BufferedReader br = new BufferedReader(in);

            //Oprettet en string-variabel
            String line;

            
            //While-loop der indlæser fra line, sålænge den ikke er null
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + file.toString());
        } catch (IOException ex) {
            System.out.println("Unable to read file: " + file.toString());
        }
        
        //hvis br ligger udenfor try, kan man bruge finally til at lukke den

    }

}
