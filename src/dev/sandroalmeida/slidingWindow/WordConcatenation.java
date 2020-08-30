package dev.sandroalmeida.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {

    public static List<Integer> findWordConcatenation(String str, String[] words){
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> charMap = new HashMap<>();

        for(String s : words){
            for(char c: s.toCharArray()){
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
        }

        int start = 0, matched = 0;

        for(int end = 0; end < str.length(); end++){
            char rightChar = str.charAt(end);

            if(charMap.containsKey(rightChar)){
                charMap.put(rightChar, charMap.get(rightChar) - 1);
                if(charMap.get(rightChar) == 0)
                    matched++;
            }

            if(matched == charMap.size()){
                result.add(start);

                int wordLength = words[0].length();
                for(int i = 0; i < wordLength; i++){
                    char leftChar = str.charAt(start);
                    start++;
                    if(charMap.containsKey(leftChar)){
                        charMap.put(leftChar, charMap.get(leftChar) + 1);
                        if(charMap.get(leftChar) > 0)
                            matched--;
                    }
                }
            } else{
                if((end - start + 1) >= (words[0].length() * words.length)){
                    char leftChar = str.charAt(start);
                    start++;
                    if(charMap.containsKey(leftChar)){
                        charMap.put(leftChar, charMap.get(leftChar) + 1);
                        if(charMap.get(leftChar) > 0)
                            matched--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[] arr = {"cat", "fox"};
        System.out.println(findWordConcatenation("catfoxcat", arr));
        System.out.println(findWordConcatenation("catcatfoxfox", arr));

    }
}
