/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_01_Ancient_Encryption;

/**
 *
 * @author aalsc
 */
public class CeasarCipher extends AbstractCipher {
//Får en int variabel
    private int rotFactor;

    //constructor for klassen, der anvender variablen
    public CeasarCipher(int rotFactor) {
        if (rotFactor < 0) { //sikrer at rotFactor ikke er negativ
            this.rotFactor = rotFactor * -1;
            System.out.println("rotFactor is less than 0 and is now converted to: " + rotFactor);
        } else {
            this.rotFactor = rotFactor;
        }
        while (rotFactor > ALPHABETH.length) { //sikrer at rotFactor ikke er længere end ALPHABETH
            this.rotFactor = rotFactor % ALPHABETH.length;
        }
    }

    @Override
    public String encrypt(String original) { //krypterer beskeden
        char[] originalArray = original.toCharArray();
        StringBuilder sb = new StringBuilder(original.length());
        for (int i = 0; i < originalArray.length; i++) {
            int charIndex = findCharIndex(originalArray[i]);
            if (charIndex != -1) {
                charIndex += rotFactor;
                sb.append(alphabethCheck(charIndex)); //krypterer alfabetiske tegn og bruger rotFactor
            } else {
                sb.append(originalArray[i]); //krypterer ikke ikke-alfabetiske tegn
            }
        }
        return sb.toString(); //returnerer beskede krypteret
    }

    @Override
    public String decrypt(String encrypted) { //dekrypterer beskeden
        char[] encryptedArray = encrypted.toCharArray();
        StringBuilder sb = new StringBuilder(encrypted.length());
        for (int i = 0; i < encryptedArray.length; i++) {
            int charIndex = findCharIndex(encryptedArray[i]);
            if (charIndex != -1) {
                charIndex -= rotFactor; //roterer den modsatte vej
                sb.append(alphabethCheck(charIndex));//dekrypterer alfabetiske tegn
            } else {
                sb.append(encryptedArray[i]); //dekrypterer ikke ikke-alfabetiske tegn
            }
        }
        return sb.toString();
    }

}
