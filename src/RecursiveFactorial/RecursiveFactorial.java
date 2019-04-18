/*
Eksempel på recursivt kald med factorial
 */
package RecursiveFactorial;

import java.util.Scanner;

/**
 *
 * @author aalsc
 */
public class RecursiveFactorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); //creates a scanner
        System.out.println("Enter an nonnegative integer: ");
        int n = sc.nextInt(); //reads in an integer
        
        System.out.println("Factorial of "+n + " is "+factorial(n)); //calls the method for factorial
        
     
    
    }

    private static long factorial(int n) { //Return the factorial for the specified number
        if (n == 0) //base case
        return 1;
        else 
        return n*factorial(n-1); //recursive call
    }
    }
    

