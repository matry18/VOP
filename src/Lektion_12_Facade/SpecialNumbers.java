package Lektion_12_Facade;

/**
 *
 * @author erso
 */
public class SpecialNumbers
{

    public boolean isEven(int x)
    {
        if (x % 2 == 0) {
            return true; //skal returnere true hvis x er et lige tal
        }
        return false;
    }

    public boolean isPrime(int x) //skal returnere true hvis x er et primtal
    { int y = (int) ((Math.sqrt(x))+1);
        for (int i = 2; i < y; i++) {
            if(x%i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isSquare(int x) //skal returnere true, hvis x er et kvadrattal
    {
        double y = Math.sqrt(x);
        return y == (int) y;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SpecialNumbers sn = new SpecialNumbers();
        int x = 1024;
        int y = 1021;
        System.out.println("Even\t" + x +": " + sn.isEven(x) + "\t" + y + ": " + sn.isEven(y));
        System.out.println("Prime\t" + x +": " + sn.isPrime(x) + "\t" + y + ": " + sn.isPrime(y));
        System.out.println("Square\t" + x +": " + sn.isSquare(x) + "\t" + y + ": " + sn.isSquare(y));

    }

}
