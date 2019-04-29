/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaReadingTextFilesScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author aalsc
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        //Oprettet et string-objekt med en sti til filen, som allerede er oprettet
        String fileName = "C://Users//aalsc//OneDrive//Documents//NetBeansProjects//VOP//TextScanner.txt";

        //Opretter et file-object med parametre for string-objektet
        File textFile = new File(fileName);

        try ( //Opretter en scanner, der har File-objektet som argument.
                Scanner in = new Scanner(textFile)) {

            //Loop der indlæser filen. Sålænge der er en ny linje, indlæses næste linje
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);

            }

        }

    }
}
