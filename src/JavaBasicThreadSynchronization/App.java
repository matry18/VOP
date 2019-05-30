/*
Synchronization
 */
package JavaBasicThreadSynchronization;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Processor extends Thread {

    private volatile boolean running = true;

    public void run() {
        while (running) {
            try {
                System.out.println("Hello");

                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void shotdown() {
        running = false;
    }
}

public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.setDaemon(true);
        proc1.start();
        
        System.out.println("Pres Enter to stop!");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        
        proc1.shotdown();
    }

}
