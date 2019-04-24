/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lektion10stack_matchingbrackets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author aalsc
 */
public class MatchingBracketsWithList {

    public boolean ckeckBrackets(String expression) {
        LinkedList<Character> list = new LinkedList();
        char[] array = expression.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '{' || array[i] == '[' || array[i] == '(') {
                list.addFirst(array[i]);
                System.out.println(list);
            } else if (array[i] == '}' || array[i] == ']' || array[i] == ')') {
                try {
                    char open = list.removeFirst();

                    if (open == '(' && array[i] == ')'
                            || open == '[' && array[i] == ']'
                            || open == '{' && array[i] == '}') {
                        System.out.println(list);
                    }
                } catch (NoSuchElementException ex) {
                    return false;
                }

            }

        }
        return list.isEmpty();
    }

    public static void main(String[] args) {
        MatchingBracketsWithList pc = new MatchingBracketsWithList();
        try (Scanner in = new Scanner(new File("Test.java"))) {
            StringBuilder expression = new StringBuilder();
            while (in.hasNextLine()) {
                expression.append(in.nextLine());
            }
            System.out.println("The check is: " + pc.ckeckBrackets(expression.toString()));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
