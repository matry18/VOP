/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_03_Mountains_In_France;

import java.util.Comparator;

/**
 *
 * @author aalsc
 */
public class MountainRangeComparator implements Comparator<Mountain> {

    @Override
    public int compare(Mountain o1, Mountain o2) {
        int i = o1.getRange().compareTo(o2.getRange());
        if (i == 0) {
           i = o1.compareTo(o2);
        }
          return i;
    }
    
}
