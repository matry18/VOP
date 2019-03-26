/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaThreadPool;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aalsc
 */
public class Processor implements Runnable {
private int id;

public Processor(int id) {
    this.id = id;
}
    @Override
    public void run() {
        System.out.println("Starting: "+id);
    try {
        Thread.sleep(5000);
    } catch (InterruptedException ex) {
        Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
    }
        System.out.println("Completed: "+id);
    }
    
}
