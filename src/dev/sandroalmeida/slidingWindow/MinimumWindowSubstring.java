package dev.sandroalmeida.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String findSubstring(String str, String pattern) {

        int start = 0, matched = 0, minLength = str.length() + 1, subStringStart = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for(char c : pattern.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for(int end = 0; end < str.length(); end++){
            char rightChar = str.charAt(end);
            if(charMap.containsKey(rightChar)){
                charMap.put(rightChar, charMap.get(rightChar) - 1);
                if(charMap.get(rightChar) >= 0)
                    matched++;
            }

            while(matched == pattern.length()){
                if(minLength > end - start + 1){
                    minLength = end - start + 1;
                    subStringStart = start;
                }

                char leftChar = str.charAt(start);
                start++;
                if(charMap.containsKey(leftChar)){
                    if(charMap.get(leftChar) == 0)
                        matched--;
                    charMap.put(leftChar, charMap.get(leftChar) + 1);
                }
            }
        }

        return minLength > str.length() ? "" : str.substring(subStringStart, subStringStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdabca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}
