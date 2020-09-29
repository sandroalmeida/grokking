package dev.sandroalmeida.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesesRecursive {

    public static List<String> generateValidParentheses(int num){
        List<String> result = new ArrayList<>();
        char[] parenthesesString = new char[2 * num];
        generateValidParenthesesRecursive(num, 0, 0, parenthesesString, 0, result);
        return result;
    }

    private static void generateValidParenthesesRecursive(int num, int openCount, int closeCount, char[] parenthesesString, int index, List<String> result){
        if(openCount == num && closeCount == num){
            result.add(new String(parenthesesString));
        }else {
            if(openCount < num){
                parenthesesString[index] = '(';
                generateValidParenthesesRecursive(num, openCount + 1, closeCount, parenthesesString, index + 1, result);
            }

            if(openCount > closeCount){
                parenthesesString[index] = ')';
                generateValidParenthesesRecursive(num, openCount, closeCount + 1, parenthesesString, index + 1, result);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = GenerateParenthesesRecursive.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParenthesesRecursive.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
