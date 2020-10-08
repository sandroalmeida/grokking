package dev.sandroalmeida.topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public static String sortCharacterByFrequency(String str){

        Map<Character, Integer> charFrequency = new HashMap<>();
        for(char c: str.toCharArray())
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((c1, c2) -> c2.getValue() - c1.getValue());
        maxHeap.addAll(charFrequency.entrySet());

        StringBuilder newString = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            for(int i = 0; i < currentEntry.getValue(); i++)
                newString.append(currentEntry.getKey());
        }

        return newString.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
