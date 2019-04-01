/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaThreads3;

/**
 *
 * @author aalsc
 */
public class Tråd3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread t1 = new Thread(new Runnable() {
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
        });
        t1.start();
        t1.setDaemon(true);
        {

        }
    }

}
