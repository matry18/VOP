package facade;

import java.util.Arrays;
import java.util.Random;

/**
 * Kodeskelet til VOP eksamen F15, opgave 2.
 *
 * @author erso
 */
public class Facade {

    private int[] intArray;
    private Random random;

    public int[] getIntArray() {
        return intArray;
    }

    public Facade() {
        random = new Random();
    }

    public int[] fillArray(int size, int max) {
        intArray = new int[size];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(max);
        }

        return intArray;
    }

    public int sumOfDivisors(int divisor) {
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (i % divisor == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public int[] fillUniqueArray(int size, int max) {
        if (size >= max) {
            System.out.println("size er større end max!");
            return null;
        }
        intArray = new int[size];
            int tempArray;
        for (int i = 0; i < intArray.length; i++) {
            do {tempArray = random.nextInt(max);
            }
            while(!contains(tempArray, i+1)); {
        intArray[i]=tempArray;
        }
            
        }
        Arrays.sort(intArray);
        return intArray;
    }

    private boolean contains(int x, int beforeIndex) {
        for (int i = 0; i < intArray.length; i++) {
            if (x == intArray[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Facade facade = new Facade();

        System.out.println("fillArray: " + Arrays.toString(facade.fillArray(20, 10)));
        int divisor = 3;
        System.out.println("Divisors of " + divisor + " has Sum: " + facade.sumOfDivisors(divisor));

        System.out.println("fillUnique: " + Arrays.toString(facade.fillUniqueArray(20, 30)));

        System.out.println("Error: " + Arrays.toString(facade.fillUniqueArray(20, 20)));
    }

}
