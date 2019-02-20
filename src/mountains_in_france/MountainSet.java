/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mountains_in_france;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aalsc
 */
public class MountainSet {

    private Set<Mountain> set;

    MountainSet() {
        set = new TreeSet<>();
    }

    public Set<Mountain> getSet() {
        return set;
    }
public Set<Mountain> sortByRange(Comparator comp) {
    Set<Mountain> set2 = new TreeSet<>(comp);
    set2.addAll(set);
    return set2;
} 
        
        
    public static void main(String[] args) {
        MountainSet m1 = new MountainSet();
        try (Scanner scanner = new Scanner(new File("FranskeBjerge.csv"))){
            while (scanner.hasNextLine())
            {
                Scanner sc = new Scanner(scanner.nextLine()).useDelimiter(";");
                Mountain m = new Mountain(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
                m1.getSet().add(m);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No file found!");
        }
//        System.out.println(m1.getSet());
        System.out.println(m1.sortByRange(new MountainRangeComparator()));
            
        }
        
    }

