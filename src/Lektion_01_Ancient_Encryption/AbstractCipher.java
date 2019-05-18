package Lektion_01_Ancient_Encryption;

import static Lektion_01_Ancient_Encryption.CipherInterface.ALPHABETH;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aalsc
 */
//Opretter en abstrakt klasse med et interface
public abstract class AbstractCipher implements CipherInterface {

    int findCharIndex(char ch) {
//        Metoden skal returnere det index, som ch findes på i arrayet, 
//        eller -1, hvis ch ikke er et bogstav i alfabetet
        for (int i = 0; i < ALPHABETH.length; i++) {
            if (ALPHABETH[i] == ch) {
                return i;
            }

        }
        return -1;
    }

    public char alphabethCheck(int charIndex) {
        if (charIndex > ALPHABETH.length) {
            charIndex -= ALPHABETH.length;
        }
        while (charIndex < 0) {
            charIndex += ALPHABETH.length;
        }
        return ALPHABETH[charIndex];
    }

}
    
