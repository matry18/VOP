/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaStringBuilderStringFormating;

/**
 *
 * @author aalsc
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Nedenståene er meget ueffektivt!!!
        String info = "";
        info += "My name is Bob.";
        info += " ";
        info += "I am a builder.";
        System.out.println(info);

        //Den korrekte metode ville være stringbuilder Obs. hvis der er tale om Threads brug String buffer!!!
        StringBuilder sb = new StringBuilder(""); //strenger initialiseres som værende tom = "".
        sb.append("My name is Sue.");
        sb.append(" ");
        sb.append("I am a lion tamer.");
        System.out.println(sb.toString());

        StringBuilder s = new StringBuilder();
        s.append("My name is Roger.")
                .append(" ")
                .append("I am a skydiver.");
        System.out.println(s.toString());
        
        ////////FORMATTING//////////////
        System.out.println("Here is some text \tThat was a tab. \nThat was a new line");
        
        //Formatting integers
        System.out.printf("Total cost is %-10d; quantity is %d\n", 5, 120);
        
        for (int i = 0; i < 20; i++) {
            System.out.printf("%-2d: %s\n",i, "some text here");
        }
        
        //Formatting floating point value
        System.out.printf("Total value: %.2f\n", 5.6789);
        System.out.printf("Total value: %6.1f\n", 532.1234);
    }

}
