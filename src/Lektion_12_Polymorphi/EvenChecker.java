/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_12_Polymorphi;

/**
 *
 * @author aalsc
 */
public class EvenChecker implements CheckerInterface {

    @Override
    public boolean check(int i) { //Skal returnere true, hvis input (i) er et lige tal
         if (i % 2 == 0) {
            return true;
        }
        return false;
    }
    
}
