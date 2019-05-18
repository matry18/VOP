/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_02_FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso
 */
public class WriteLines2File {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File output = new File("Output1.txt");

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(output, true))
                ; Scanner scan = new Scanner(System.in)) {
            String line = "";
            while(!line.equalsIgnoreCase("QUIT")){
                System.out.println("Enter a line (QUIT to stop):");
                line = scan.nextLine();
                pw.println(line);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteLines2File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
