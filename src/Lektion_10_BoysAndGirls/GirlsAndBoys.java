package Lektion_10_BoysAndGirls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * VOP ReEksamen F16 Kodeskelet til opgave 4b
 *
 * @author erso
 */
public class GirlsAndBoys {

    private Map<String, Integer> girlsMap;
    private Map<String, Integer> boysMap;
    private Set<CommonName> commonSet;

    public GirlsAndBoys() {
        boysMap = createNameMap(new File("Boys.txt"));
        girlsMap = createNameMap(new File("Girls.txt"));
    }

    private Map<String, Integer> createNameMap(File file) {
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = null;
        Scanner scan = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNext()) {
                scan = new Scanner(sc.nextLine()).useDelimiter("\t");
                scan.nextInt();
                map.put(scan.next(), scan.nextInt());
                scan.nextInt();
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found " + file);
        }
        scan.close();
        return map;
    }

    public void makeCommonNames() {
        commonSet = new TreeSet<>();
        for (Map.Entry<String, Integer> entry : girlsMap.entrySet()) {
            if (boysMap.containsKey(entry.getKey())) {
                CommonName cn = new CommonName(entry.getKey(), entry.getValue(), boysMap.get(entry.getKey()));
                commonSet.add(cn);
            }
        }
    }

    @Override
    public String toString() {
        String st = commonSet.toString();
        st = st.substring(1);
        st = st.substring(0, st.length() - 1);
        st = st.replace(", ", "");
        return st;
    }

    public void sortCommonByName(Comparator<CommonName> comparator) {
        Set<CommonName> set = new TreeSet<>(comparator);
        set.addAll(commonSet);
        commonSet = set;
        
        
    }

    public void write2file(File f) {
        try (FileWriter fw = new FileWriter(f)) {
            for (CommonName name : commonSet) {
                fw.write(name.toString());
                fw.flush();
            }
        } catch (IOException ex) {
            System.out.println("Could not write to file "+f.getName());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GirlsAndBoys gAndB = new GirlsAndBoys();
        gAndB.makeCommonNames();

        System.out.println("Common Names sort by total:\n" + gAndB.toString());
        gAndB.write2file(new File("CommonSortByNumber.txt"));

        gAndB.sortCommonByName(new CommonNamesComparator());
        System.out.println("Common Names sort by name:\n" + gAndB.toString());
        gAndB.write2file(new File("CommonSortByName.txt"));    
    }

}
