package dev.sandroalmeida.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParenthesesString {
    String str;
    int openCount;
    int closeCount;

    public ParenthesesString(String str, int openCount, int closeCount) {
        this.str = str;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

public class GenerateParentheses_V2 {

    public static List<String> generateValidParentheses(int num){
        List<String> result = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();

        queue.add(new ParenthesesString("", 0, 0));
        while(!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            if(ps.openCount == num && ps.closeCount == num){
                result.add(ps.str);
            }else {
                if(ps.openCount < num)
                    queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));

                if(ps.openCount > ps.closeCount)
                    queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses_V2.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses_V2.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
