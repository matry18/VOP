/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opg3_tour;

import java.util.Comparator;

/**
 *
 * @author aalsc
 */
public class CountryMountainComparator implements Comparator<RacingCyclist>{

    @Override
    public int compare(RacingCyclist o1, RacingCyclist o2) {
        int compareCountry = o1.getCountry().compareTo(o2.getCountry());
        if (compareCountry == 0) {
            return Integer.compare(o1.getMountains(), o2.getMountains());
            
        }
        return compareCountry;
    }
    
}
