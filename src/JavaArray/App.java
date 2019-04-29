/*
Arrays
 */
package JavaArray;

/**
 *
 * @author aalsc
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int value = 7; //variabel af typen int
       
       int[] values; //int-array der hedder values
       values = new int[3]; //values gives 3 pladser
       values[0] = 10; //giver plads 0 i arrayet en værdi
       values[1] = 20;
       values[2] = 30;
        System.out.println(values[0]);
        System.out.println(values[1]);
        System.out.println(values[2]);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        int[] numbers = {5, 6, 7};
                for (int i = 0; i < numbers.length; i++) {
                    System.out.println(numbers[i]);
            
        }
    }
    
}
