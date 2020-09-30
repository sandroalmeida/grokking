package dev.sandroalmeida.subsets;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation_V2 {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<>();
        generateAbbreviationRecursive(word, new StringBuilder(), 0, 0, result);
        return result;
    }

    private static void generateAbbreviationRecursive(String word, StringBuilder abWord, int start, int count, List<String> result){
        if(start == word.length()){
            if(count != 0)
                abWord.append(count);
            result.add(abWord.toString());
        } else{
            generateAbbreviationRecursive(word, new StringBuilder(abWord), start + 1, count + 1, result);

            if(count != 0) abWord.append(count);
            generateAbbreviationRecursive(word, new StringBuilder(abWord).append(word.charAt(start)), start + 1, 0, result);
        }
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation_V2.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation_V2.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
