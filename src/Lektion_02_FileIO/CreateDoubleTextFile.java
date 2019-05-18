/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_02_FileIO;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso
 */
public class CreateDoubleTextFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Random generator = new Random();

        try (PrintWriter pw = new PrintWriter("Doubles.txt")) {
            for (int i = 0; i < 20; i++) {
                pw.println(String.format("%8.4f", generator.nextDouble() * 100).replace(',', '.'));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateDoubleTextFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

}
