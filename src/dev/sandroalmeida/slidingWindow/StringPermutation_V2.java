package dev.sandroalmeida.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation_V2 {

    public static boolean findPermutation(String str, String pattern){

        int start = 0, matched = 0;

        Map<Character, Integer> charMap = new HashMap<>();
        for(char c : pattern.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for(int end = 0; end < str.length(); end++){
            char charRight = str.charAt(end);
            if(charMap.containsKey(charRight)){
                charMap.put(charRight, charMap.get(charRight) - 1);
                if(charMap.get(charRight) == 0){
                    matched++;
                }
            }

            if(matched == charMap.size())
                return true;

            if(end >= pattern.length() - 1){
                char leftChar = str.charAt(start++);
                if(charMap.containsKey(leftChar)){
                    if(charMap.get(leftChar) == 0)
                        matched--;
                    charMap.put(leftChar, charMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println("Permutation exist: " + StringPermutation_V2.findPermutation("oidbcaf", "abc"));
//        System.out.println("Permutation exist: " + StringPermutation_V2.findPermutation("odicf", "dc"));
//        System.out.println("Permutation exist: " + StringPermutation_V2.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation_V2.findPermutation("aaacb", "abc"));
    }

}
