/*
Java Synchronized Wait Notify Lock
 */
package JavaSynchronizedWaitNotifyLock;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author aalsc
 */
public class Processor {

    private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    //en metode der tilføjer til listen
    public void produce() throws InterruptedException {
        int value = 0;

        while (true) {
//synkroniserer og kalder wait så listen ikke bliver større end 10 (LIMIT)
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }
                list.add(value++);
                lock.notify(); //vækker de threads som er sat på wait i consume
            }
        }
    }
//en metode der trække fra listen

    public void comsume() throws InterruptedException {
        while (true) {

            Random random = new Random();

            //låser comsume-metoden med en wait, så listen ikke bliver mindre end 0
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }
                System.out.print("List size is :" + list.size());
                int value = list.removeFirst();
                System.out.println("; Value is: " + value);
                lock.notify(); //vækker de threads som er sat på wait i procude
            }
            //sleep-metoden gør at der er mindre comsume end produce
            Thread.sleep(random.nextInt(1000));
        }
    }
}
