/*
Reentrant Locks
 */
package JavaReentrantLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author aalsc
 */
public class Runner {

    private int count = 0;

    //en lås der tæller hvor mange gange den er blevet låst og skal låses op tilsvarende mængde gange
    private Lock lock = new ReentrantLock();

    //en metoder der inkrementerer
    private void increment() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public void firstThread() {
        lock.lock();
        try { //put handlingen ind i en try
            increment();
        } finally { //altid put unluck i en finally, så den altid låses op
            lock.unlock();
        }
    }

    public void secondThread() {
        lock.lock();
        try {//put handlingen ind i en try
            increment();
        } finally {//altid put unluck i en finally, så den altid låses op
            lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }

}
