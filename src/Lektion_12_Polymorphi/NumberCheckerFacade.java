package Lektion_12_Polymorphi;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author erso
 */
public class NumberCheckerFacade
{

    public List<Integer> checkNumbers(int min, int max, CheckerInterface checker) //implemeterer metoden og tilføjer alle true-check til listen og returnerer denne
    {
        LinkedList<Integer> trueList = new LinkedList<>();
        for (int i = min; i <= max; i++) {
            if(checker.check(i)) {
                trueList.add(i);
            }
        }
        return trueList;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        NumberCheckerFacade ncf = new NumberCheckerFacade();

        CheckerInterface checker;
        
        checker = new EvenChecker();
        System.out.println("Evens: " + ncf.checkNumbers(10, 100, checker));

        checker = new PrimeChecker();
        System.out.println("Primes: " + ncf.checkNumbers(10, 100, checker));

        checker = new SquareChecker();
        System.out.println("Square Numbers: " + ncf.checkNumbers(10, 100, checker));

    }

}
