package dev.sandroalmeida.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring2 {

    public static int findLength(String str){

        int start = 0, maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for(int end = 0; end < str.length(); end++){
            char rightChar = str.charAt(end);
            if(charMap.containsKey(rightChar)){
                start = Math.max(start, charMap.get(rightChar) + 1);
            }
            charMap.put(rightChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String ex1 = "aabccbb";
        String ex2 = "abbb";
        String ex3 = "abccde";
        System.out.println(findLength(ex1));
        System.out.println(findLength(ex2));
        System.out.println(findLength(ex3));
    }
}
