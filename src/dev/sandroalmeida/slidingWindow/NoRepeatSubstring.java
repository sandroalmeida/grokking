package dev.sandroalmeida.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstring {

    public static int findLength(String str){

        int start = 0, maxLength = 0;
        char[] arr = str.toCharArray();
        Set<Character> charSet = new HashSet<>();

        for(int end = 0; end < arr.length; end++){
            char endChar = arr[end];
            if(!charSet.contains(endChar)){
                charSet.add(endChar);
                maxLength = Math.max(maxLength, end - start + 1);
            } else{
                while(charSet.contains(endChar)){
                    charSet.remove(arr[start]);
                    start++;
                }
                end = start;
            }
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
