/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_10_Stack_MatchingBrackets;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author aalsc
 */
public class MatchingBrackets {

    public boolean ckeckBrackets(String expression) {
        Stack<Character> stack = new Stack();
        char[] array = expression.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '{' || array[i] == '[' || array[i] == '(') {
                stack.push(array[i]);
            }
            if (array[i] == '}' || array[i] == ']' || array[i] == ')') {
                char open = stack.pop();
                if (open == '(' && array[i] == ')'
                        || open == '[' && array[i] == ']'
                        || open == '{' && array[i] == '}') {

                } else {
                    return false;
                }

            }

        }
        return stack.isEmpty();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatchingBrackets pc = new MatchingBrackets();

        Scanner in = new Scanner(System.in);
        String expression = "";
        do {
            System.out.println("Enter an expression with { [ ( ) ] }: ('q' to stop)");
            expression = in.nextLine();
            if (!expression.equalsIgnoreCase("q")) {
                boolean b = pc.ckeckBrackets(expression);
                System.out.println(expression + " has balanced brackets: " + b);
            }
        } while (!expression.equalsIgnoreCase("q"));

    }

}
