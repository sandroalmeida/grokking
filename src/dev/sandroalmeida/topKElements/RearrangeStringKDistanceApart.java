package dev.sandroalmeida.topKElements;

import java.util.*;

public class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {

        Map<Character, Integer> charMap = new HashMap<>();
        for(char c: str.toCharArray())
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(charMap.entrySet());

        StringBuilder sb = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> current = maxHeap.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue() - 1);
            queue.offer(current);
            if(queue.size() == k){
                Map.Entry<Character, Integer> entry = queue.poll();
                if(entry.getValue() > 0)
                    maxHeap.add(entry);
            }
        }

        return sb.length() == str.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }

}
