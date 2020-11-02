package dev.sandroalmeida.topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString_V2 {

    public static String rearrangeString(String str) {

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for(char chr: str.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(charFrequencyMap.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;

        StringBuilder resultString = new StringBuilder(str.length());
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> currencyEntry = maxHeap.poll();
            if(previousEntry != null && previousEntry.getValue() > 0)
                maxHeap.offer(previousEntry);
            resultString.append(currencyEntry.getKey());
            currencyEntry.setValue(currencyEntry.getValue() - 1);
            previousEntry = currencyEntry;
        }
        return resultString.length() == str.length() ? resultString.toString() : "";

    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString_V2.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString_V2.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString_V2.rearrangeString("aapa"));
    }
}
