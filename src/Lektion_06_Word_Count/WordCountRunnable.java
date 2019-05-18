    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_06_Word_Count;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aalsc
 */
public class WordCountRunnable implements Runnable {
File file;
int count;


    public WordCountRunnable(String fileName) {
        this.file = new File(fileName);
        this.count = 0;
    }


    @Override
    public void run() {
        
    Scanner sc;
    try {
        sc = new Scanner(file);
        while (sc.hasNext()) {
            sc.next();
            count++;
            
            
        } sc.close();
    } catch (FileNotFoundException ex) {
        System.out.println("No file found"+ex);
    }
     System.out.println(file.toString() + " has "+ count + " words.");       
        
        
    }
    
}
