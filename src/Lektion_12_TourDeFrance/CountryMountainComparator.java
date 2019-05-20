/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_12_TourDeFrance;

import java.util.Comparator;

/**
 *
 * @author aalsc
 */
public class CountryMountainComparator implements Comparator<RacingCyclist>{

    @Override
    public int compare(RacingCyclist o1, RacingCyclist o2) { //sammenlign to objekter, ført på...
        int compareCountry = o1.getCountry().compareTo(o2.getCountry());//sammenlignes på nationalitet
        if (compareCountry == 0) {//hvis nationaliteten er ens
            return Integer.compare(o1.getMountains(), o2.getMountains());//sorteres på faldende på bjergpoint
            
        }
        return compareCountry;
    }
    
}
