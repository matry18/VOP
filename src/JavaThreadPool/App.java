/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(2); //tallet (2) repræsenterer antallet af arbejdere aka. threads
        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }
        executor.shutdown();
        
        System.out.println("All tasks submitted.");
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("All taskt completed!");
    }
    
}
