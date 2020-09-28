package dev.sandroalmeida.subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str){
        List<String> permutations = new ArrayList<>();
        if(str == null) return permutations;

        permutations.add(str);

        for(int i = 0; i < str.length(); i++){
            int n = permutations.size();
            for(int j = 0; j < n; j++){
                String currentPermutation = permutations.get(j);
                String currentChar = currentPermutation.substring(i,i+1);
                if(Character.isLetter(currentChar.charAt(0))){
                    String firstPart = currentPermutation.substring(0,i);
                    String secondPart = currentPermutation.substring(i+1);
                    if(currentChar.equals(currentChar.toLowerCase())) {
                        permutations.add(firstPart + currentChar.toUpperCase() + secondPart);
                    } else{
                        permutations.add(firstPart + currentChar.toLowerCase() + secondPart);
                    }
                }
            }
        }

        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
