package dev.sandroalmeida.topKElements;

import java.util.*;

public class TopKFrequentNumbers_V2 {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for(int n: nums)
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);

        for(Map.Entry<Integer, Integer> entry: numFrequencyMap.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k)
                minHeap.poll();
        }

        while(!minHeap.isEmpty()){
            topNumbers.add(minHeap.poll().getKey());
        }

        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers_V2.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11, 1, 1}, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers_V2.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
