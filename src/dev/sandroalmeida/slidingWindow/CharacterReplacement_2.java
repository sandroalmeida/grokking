package dev.sandroalmeida.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement_2 {

    public static int findLength(String str, int k){

        int maxLength = 0, start = 0, maxRepeat = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(int end = 0; end < str.length(); end++){
            char rightChar = str.charAt(end);
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeat = Math.max(maxRepeat, frequencyMap.get(rightChar));
            if(end - start + 1 - maxRepeat > k){
                char leftChar = str.charAt(start);
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str1 = "aabccbb";
        String str2 = "abbcb";
        String str3 = "abccde";
        System.out.println(findLength(str1,2));
        System.out.println(findLength(str2,1));
        System.out.println(findLength(str3,1));
    }
}
