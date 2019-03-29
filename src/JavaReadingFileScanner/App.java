/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaReadingFileScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
        String fileName = "C:/Users/aalsc/Documents/NetBeansProjects/VOP/Teksteksempel.txt"; //fortæller placeringne af min fil
        File textFile = new File(fileName); //laver et File-objekt med tilhørende filplacering
        try {
            Scanner sc = new Scanner(textFile); //scanneren får filobjektet som parameter
            
            while (sc.hasNextLine()) {
                String line = sc.nextLine(); //kobler en string til den data der læses
                System.out.println(line);
            }
            
            sc.close(); //lukker scanner
        } catch (FileNotFoundException ex) {
            System.out.println("Kunne ikke finde filen: "+ex);
        } 
    }
    
}
