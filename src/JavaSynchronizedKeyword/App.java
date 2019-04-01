/*
 Synchronized Keyword
 */
package JavaSynchronizedKeyword;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aalsc
 */
public class App {

    private int count = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        app.doWord();

    }

    public synchronized void increment() {
        //den variabel som skal synkroniseres bliver synkroniseret med et key word
        count++;
    }

    public void doWord() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();

                }
            }
        });
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();

        try {
            //kalder join for at ladew tråden vente
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //kalder join for at ladew tråden vente
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Count is: " + count);
    }

}
