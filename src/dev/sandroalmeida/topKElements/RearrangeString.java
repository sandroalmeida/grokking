package dev.sandroalmeida.topKElements;

import java.util.HashMap;
import java.util.Map;

public class RearrangeString {

    public static String rearrangeString(String str) {

        Map<Character, Integer> charMap = new HashMap<>();

        for(char c: str.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        Character previous = null;

        for(int i = 0; i < str.length(); i++){
            for(Map.Entry<Character, Integer> entry: charMap.entrySet()){
                if(entry.getValue() > 0 && entry.getKey() != previous){
                    previous = entry.getKey();
                    sb.append(previous);
                    charMap.put(previous, entry.getValue() - 1);
                    break;
                }
            }
        }

        return sb.toString().length() == str.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}
