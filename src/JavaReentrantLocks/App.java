/*
Reentrant Locks
 */
package JavaReentrantLocks;

/**
 *
 * @author aalsc
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        final Runner runner = new Runner();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        runner.finished();
    }
    
}
