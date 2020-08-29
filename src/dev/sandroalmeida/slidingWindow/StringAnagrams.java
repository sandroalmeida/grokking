package dev.sandroalmeida.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern){

        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> charMap = new HashMap<>();
        int start = 0, matched = 0;

        for(char c : pattern.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for(int end = 0; end < str.length(); end++){
            char rightChar = str.charAt(end);

            if(charMap.containsKey(rightChar)){
                charMap.put(rightChar, charMap.get(rightChar) - 1);
                if(charMap.get(rightChar) == 0){
                    matched++;
                }
            }

            if(matched == charMap.size()){
                resultIndices.add(start);
            }

            if(end >= pattern.length() - 1){
                char leftChar = str.charAt(start);
                start++;
                if(charMap.get(leftChar) == 0)
                    matched--;
                charMap.put(leftChar, charMap.get(leftChar) + 1);

            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp", "pq"));
        System.out.println(findStringAnagrams("abbcabc", "abc"));
    }
}
