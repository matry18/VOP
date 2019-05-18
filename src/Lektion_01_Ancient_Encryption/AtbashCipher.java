package Lektion_01_Ancient_Encryption;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aalsc
 */
public class AtbashCipher extends AbstractCipher {
//nedarver og implementerer to metoder
    @Override
    public String encrypt(String original) {
        char[] originalArray = original.toCharArray(); //tager parametre og putter dem i et array
        StringBuilder sb = new StringBuilder(original.length()); //opretter en stringbuilder på længde med parametren
        for (int i = 0; i < originalArray.length; i++) { //itererer igennem arrayet
            int charIndex = findCharIndex(originalArray[i]); //checker om ch er et bogstav i alfabetet
            if (charIndex != -1) { //hvis det indgår i alfabetret krypteres det og lægges til stringbuilderen
                sb.append (ALPHABETH[ALPHABETH.length - charIndex -1]);
            } else { //hvis det ikke gør, indsættes det unden at blive krypteret
                sb.append(originalArray[i]);
            }
        }
        return sb.toString();
//returnerer original krypteret, således at alle alfabetiske tegn i original er skiftet ud (’a’ -> ’Z’, ’A’-> ’z’, ’b’ -> ’Y’,osv.). 
//Ikke-alfabetiske tegn, skal ikke ændres
    }

    @Override
    public String decrypt(String encrypted) { //samme som encrypt-metoden,bare modsat input
        char[] encryptedArray = encrypted.toCharArray();
        StringBuilder sb = new StringBuilder(encrypted.length());
        for (int i = 0; i < encryptedArray.length; i++) {
            int charIndex = findCharIndex(encryptedArray[i]);
            if (charIndex != -1) {
                sb.append(ALPHABETH[ALPHABETH.length - charIndex-1]);
            } else {
                sb.append(encryptedArray[i]);
            }
        }
return sb.toString();
    }

}
