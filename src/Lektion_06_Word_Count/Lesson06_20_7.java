/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_06_Word_Count;

/**
 *
 * @author aalsc
 */
public class Lesson06_20_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] fileNames = {"alice30.txt", "Snow White.txt"};
        for (int i = 0; i < fileNames.length; i++) {
            Runnable wcr = new WordCountRunnable(fileNames[i]);
            Thread t = new Thread(wcr);
            t.start();
        }             // Start a Thread for the Runnable here:         } 
        
    }

}
