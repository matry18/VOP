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
public class SquareChecker implements CheckerInterface {

    @Override
    public boolean check(int i) {//Skal returnere true, hvis i er et kvadrattal
        double y = Math.sqrt(i);
        return y == (int) y;
    }

}
