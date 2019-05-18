/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_02_FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso
 */
public class ReadDoubleTextFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double min = 100;
        double max = 0;
        double sum = 0;
        int count = 0;
        Scanner sc = null;
        try {
            // TODO code application logic here
            sc = new Scanner(new File("Doubles.txt"));
            while (sc.hasNextLine()) {
                double d = Double.parseDouble(sc.nextLine());
                System.out.println("" + d);
                count++;
                sum += d;
                if (d < min) {
                    min = d;
                }
                if (d > max) {
                    max = d;
                }
            }
            System.out.println("sum: " + sum + "\tmin: " + min + "\tmax: " + max + "\taverage: " + (sum / count));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadDoubleTextFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            sc.close();
        }
    }

}
