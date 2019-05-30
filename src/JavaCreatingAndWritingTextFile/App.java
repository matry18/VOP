/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCreatingAndWritingTextFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
        File file = new File("Test2.txt"); //filen bliver oprettet

        //i parentesen for try oprettes en BufferedWriter med et FileWriter-object som parameter
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            //opretter en filereader til at læse filen med fil-objektet som argument
            
            br.write("Line one"); //uden br.newLine() skrives line one og two på samme linje
            br.write("Line two");
            br.newLine();
            br.write("Last line");

        } catch (IOException ex) {
            System.out.println("Can not write to file: " + file.toString());
        }

    }

}
