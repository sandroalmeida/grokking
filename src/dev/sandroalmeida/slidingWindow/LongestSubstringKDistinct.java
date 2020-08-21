package dev.sandroalmeida.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static int findLength(String str, int k){
        char[] arr = str.toCharArray();
        int start = 0, maxLength = 0;
        Map<Character, Integer> mapChar = new HashMap<>();

        for(int end = 0; end < arr.length; end++){
            char rightChar = arr[end];
            mapChar.put(rightChar, mapChar.getOrDefault(rightChar,0) + 1);

            while(mapChar.size() > k) {
                char leftChar = arr[start];
                mapChar.put(leftChar, mapChar.get(leftChar) - 1);
                if(mapChar.get(leftChar) == 0){
                    mapChar.remove(leftChar);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength("araaci", 1));
        System.out.println(findLength("araaci", 2));
        System.out.println(findLength("araaci", 3));
    }
}
