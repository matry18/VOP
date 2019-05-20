package Lektion_10_BoysAndGirls;

import java.util.Arrays;

/**
 * VOP ReEksamen F16 Kodeskelet til opgave 4a
 *
 * @author erso
 */
public class CommonName implements Comparable<CommonName> {
// Erklær variable, constructor og de to get()-metoder.

    private String name;
    private int girls;
    private int boys;

    public CommonName(String name, int girls, int boys) {
        this.name = name;
        this.girls = girls;
        this.boys = boys;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return (boys + girls);
    }

    @Override
    public String toString() {
        return String.format("%-12s Girls:%6d Boys:%6d Total:%6d\n", name, girls, boys, getTotal());

    }

    @Override
    public int compareTo(CommonName o) {
        int diff = o.getTotal() - getTotal();

        if (diff == 0) {
            return name.compareTo(o.getName());

        }
        return diff;

    }

    public static void main(String[] a) {
        CommonName[] testArray = new CommonName[4];

     
        testArray[0] = new CommonName("Ibi", 10, 20);
        testArray[1] = new CommonName("Ib", 20, 10);
        testArray[2] = new CommonName("Ea", 20, 20);
        testArray[3] = new CommonName("Eva", 20, 5);
        System.out.println("Usorteret:\n" + Arrays.toString(testArray));

      
        Arrays.sort(testArray);
        System.out.println("Sorteret:\n" + Arrays.toString(testArray));
    }

}
