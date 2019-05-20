/*
Liang 20.6
Use iterators on ArrayList) Write a test program that stores 10 million integers
in ascending order (i.e., 1,2, . . ., 10m) in an ArrayList, displays the execution
time taken to traverse the list, and searches for the 10 millionth element using
the get(index) vs using the iterator method.
 */
package Lektion_10_Iterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author aalsc
 */
public class Lektion10Iterator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long starttime = 0;
        long stoptime = 0;

        ArrayList<Integer> list = new ArrayList();
        for (int i = 1; i <= 200000; i++) {
            list.add(i);
        }
        LinkedList<Integer> listLinked = new LinkedList();
        for (int i = 0; i < 200000; i++) {
            listLinked.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        Iterator<Integer> iteratorLinked = listLinked.iterator();

        starttime = System.currentTimeMillis();
        for (int i = 0; i < listLinked.size(); i++) {
            listLinked.get(i);
        }

        stoptime = System.currentTimeMillis();
        System.out.println("Time taking for the get(Index)-method in an LinkedList is: " + (stoptime - starttime));

        starttime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        stoptime = System.currentTimeMillis();
        System.out.println("Time taking for the get(Index)-method in an ArrayList is: " + (stoptime - starttime));

        starttime = System.currentTimeMillis();
        while (iterator.hasNext()) {
            int buffer = iterator.next();
            if (buffer == 200000) {
            }
        }
        stoptime = System.currentTimeMillis();
        System.out.println("Time taking for the iterator-method for an ArrayList is: " + (stoptime - starttime));

        starttime = System.currentTimeMillis();
        while (iteratorLinked.hasNext()) {
            int buffer = iteratorLinked.next();
            if (buffer == 200000) {}
        }
        stoptime = System.currentTimeMillis();
        System.out.println("Time taking for the iterator-method for a LinkedList is: " + (stoptime - starttime));
    }
}