package dev.sandroalmeida.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public static boolean findPermutation(String str, String pattern){
        int start = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for(int end = 0; end < str.length(); end++){
            char rightChar = str.charAt(end);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
            if(end - start + 1 > pattern.length()){
                char leftChar = str.charAt(start);
                charMap.put(leftChar, charMap.get(leftChar) - 1);
                start++;
                if(charMap.get(leftChar) == 0) charMap.remove(leftChar);
            }
            if((end - start + 1) == pattern.length()){
                if(isPermutation(charMap, pattern))
                    return true;
            }
        }
        return false;
    }

    private static boolean isPermutation(Map<Character, Integer> charMap, String str){
        Map<Character, Integer> map = new HashMap<>(charMap);
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) map.remove(c);
            }
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("oidbcaf", "abc"));
        System.out.println(findPermutation("odicf", "dc"));
        System.out.println(findPermutation("bcdxabcdy", "bcdyabcdx"));
    }
}
