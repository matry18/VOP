/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_07_Circular_Buffer;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso Created on 08-02-2010, 09:33:34
 */
public class CircularBuff {

    private Integer[] buf;
    private int size;
    int putIndex = 0;
    int getIndex = 0;

    public CircularBuff(int size) {
        buf = new Integer[size];
        this.size = size;
    }

    // Implementer get() metoden
    public synchronized void get() {
        while (buf[getIndex] == null) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException "+ex);
            }
        }
            buf[getIndex] = null;
            getIndex = ++getIndex % size;
            notify();
    }
    // Implementer put() metoden

    public synchronized void put(int i) {
        while (buf[putIndex] != null) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException " + ex);
            }
        }
            buf[putIndex] = i;
            putIndex = ++putIndex % size;
            notify();
    }

    public String toString() {
        return "Buff: " + Arrays.toString(buf);
    }
}
