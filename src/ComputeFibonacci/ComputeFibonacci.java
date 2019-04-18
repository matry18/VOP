/*
Test af Fibonacci med recursivt kald
 */
package ComputeFibonacci;

import java.util.Scanner;

/**
 *
 * @author aalsc
 */
public class ComputeFibonacci {
    private static long count = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //creates a scanner
        System.out.println("Enter an index for a Fibonacci number: ");
        int index = sc.nextInt(); //reads in from the scanner

        //find and display the Fibonacci number
        System.out.println("The Fibonacci number of index " + index + " is " + fib(index));
        System.out.println("Number of recursive calls = "+count);
        
    }
//method for fining Fibonacci number

    private static long fib(int index) {

        if (index == 0) //base case
        {
            return 0;
        }
        if (index == 1) //base case
        {
            return 1;
        }
//        else //reduction and recursive call
//            return fib(index -1)+ fib(index-2); 
        long f0 = 0; // For fib(0)
        long f1 = 1; // For fib(1)
        long currentFib; //For current number
        for (int i = 1; i <= index; i++) {
            count++;
            currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        } // After the loop, currentFib is fib(index)
        return f1;

    }

}
