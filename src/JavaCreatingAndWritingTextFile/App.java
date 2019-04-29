/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCreatingAndWritingTextFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        //OPretter et filobjekt med et navn på en fil, der IKKE eksisterer
       File file = new File("SkrivTilFil.txt");
       
       //try med nyt bufferedwriter-objekt med et nyt filewriterobjekt med filen som argument
       try(BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
                  br.write("Dette er linje 1");
                  br.newLine();
                  br.write("Dette er linje 2");
                  br.newLine();
                  br.write("Dette er linje 3");
           
       } catch (IOException ex) {
            System.out.println("Unable to read file: "+file.toString());
        }
    }
    
}
