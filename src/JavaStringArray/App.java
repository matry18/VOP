/*
Arrays of strings
 */
package JavaStringArray;

/**
 *
 * @author aalsc
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] words = new String[3];
        
        words[0] =  "Hello";
        words[1] = "to";
        words[2] = "you";
        
        System.out.println(words[2]);
        
        String[] fruits = {"appel", "banana", "orange"};
        
        //for-each loop: for(type, navn på variabel : array der itereres igennem
        for(String fruit : fruits) {
            System.out.println(fruit); //udskriver hele arrayet ved at henvise til variabelnavnet på arrayet
        }
        int value = 0;
        
        String text = null; //default værdi for strings
        
        String[] texts = new String[2];
        System.out.println(texts[0]);
        
        texts[0] = "one";
        System.out.println(texts[0]);
        
    }
    
}
