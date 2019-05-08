/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_12.opg2_polymorphi;

/**
 *
 * @author aalsc
 */
public class PrimeChecker implements CheckerInterface {

    @Override
    public boolean check(int i) {
        int y = (int) ((Math.sqrt(i))+1);
        for (int j = 2; j < y; j++) {
            if(i%j == 0) {
                return false;
            }
        }
        return true;
    }
    
}
