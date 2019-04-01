/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaThreads2;

import java.util.logging.Level;
import java.util.logging.Logger;

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Error - InterruptedException: " + ex);
            }

        }
    }

}

/**
 *
 * @author aalsc
 */
public class Tråd2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Thread t1 = new Thread(new Runner());
    Thread t2 = new Thread(new Runner());
    t1.start();
    t2.start();
    t1.setDaemon(true);
    t2.setDaemon(true);
    }

}
