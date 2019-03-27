/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circularbufferexercise;

import java.util.Arrays;

/**
 *
 * @author erso Created on 08-02-2010, 09:33:34
 */
public class CircularBuff {

    private Integer [] buf;
    private int size;
    int putIndex = 0;
    int getIndex = 0;

    public CircularBuff(int size){
        buf = new Integer[size];
        this.size = size;
    }

    // Implementer get() metoden

    // Implementer put() metoden

    public String toString(){
        return "Buff: "+Arrays.toString(buf);
    }
}

