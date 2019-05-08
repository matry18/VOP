/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_12.opg3_tour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author aalsc
 */
public class TourDeFranceMain {

    /**
     * @param args the command line arguments
     */
    private List<RacingCyclist> list;
    private File fileName;

    public TourDeFranceMain(String fileName) {
        this.fileName = new File(fileName);
        this.list = new ArrayList<>();
    }

    public List<RacingCyclist> getList() {
        return list;
    }

    public void readFile() {

        try (Scanner scan = new Scanner(fileName)) {

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] doc = line.split("\t");
                // Scanner line = new Scanner(scan.nextLine()).useDelimiter("\t");
                RacingCyclist rc = new RacingCyclist(doc[0], doc[1], doc[2], doc[3], Integer.parseInt(doc[4]), Integer.parseInt(doc[5]));
                list.add(rc);

            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + "\n" + fileName + " : \n" + ex);
        }
    }

    public void sort() {
        Collections.sort(list);
    }

    public Set<RacingCyclist> makeSortedSet(Comparator comp) {
        Set<RacingCyclist> sortedSet = new TreeSet<>(comp);
        sortedSet.addAll(list);
        
        return sortedSet;

    }

    public static void main(String[] args) {
        TourDeFranceMain tfm = new TourDeFranceMain("tourdefrance.txt");
        tfm.readFile();
        System.out.println("List:\n" + tfm.getList().subList(0, 10));
        tfm.sort();
        System.out.println("Sort:\n" + tfm.getList().subList(0, 10));
        Comparator<RacingCyclist> comp = new CountryMountainComparator();
        Set<RacingCyclist> countryMountainSet = tfm.makeSortedSet(comp);
        System.out.println("Country/Mountain:\n" + countryMountainSet);
    }

}
