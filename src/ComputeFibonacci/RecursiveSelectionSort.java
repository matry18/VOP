/*
Listing 18.5 RecursiveSelectionSort
 */
package ComputeFibonacci;

/**
 *
 * @author aalsc
 */
public class RecursiveSelectionSort {

    public static void sort(double[] list) {
            sort(list, 0, list.length - 1); //sort the entire list
        }
    private static void sort(double[] list, int low, int high) {
        if (low < high) {
            //find the smallest number and its index in list[low .. high]
            int indexOfMin = low;
            double min = list[low];
            for (int i = low +1 ; i < high; i++) {
                if (list[i] < min) {
                    min = list[i];
                    indexOfMin = i;
                }
            }
            //Swap the smallest in list[low .. high] wit list[low]
            list[indexOfMin] = list[low];
            list[low] = min;
            
            //Sort the remaining list[low+1 .. high]
            sort(list, low + 1, high);
        }
    }
    
    public static void main(String[] args) {
       
    }
    
}
