package dev.sandroalmeida.subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateValidParentheses(int num){
        List<String> result = new ArrayList<>();
        List<String> possibilities = new ArrayList<>();
        if(num <= 0) return result;

        possibilities.add("()");
        if(num == 1) return possibilities;

        for(int i = 1; i < num; i++){
            int n = possibilities.size();
            for(int j = 0; j < n; j++){
                String currentStr = possibilities.get(j);
                String permutation1 = "()" + currentStr;
                String permutation2 = currentStr + "()";
                String permutation3 = "(" + currentStr + ")";

                if(permutation1.length() == (num * 2)){
                    if(!result.contains(permutation1)) result.add(permutation1);
                    if(!result.contains(permutation2)) result.add(permutation2);
                    if(!result.contains(permutation3)) result.add(permutation3);
                } else{
                    if(!possibilities.contains(permutation1)) possibilities.add(permutation1);
                    if(!possibilities.contains(permutation2)) possibilities.add(permutation2);
                    if(!possibilities.contains(permutation3)) possibilities.add(permutation3);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
