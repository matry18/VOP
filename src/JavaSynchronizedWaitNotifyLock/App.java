/*
Java Synchronized Wait Notify Lock
 */
package JavaSynchronizedWaitNotifyLock;

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
final Processor processor = new Processor();

Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            processor.produce();
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
});
Thread t2 = new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            processor.comsume();
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
});
t1.isDaemon();
t2.isDaemon();
t1.start();
t2.start();

    }
    
}
