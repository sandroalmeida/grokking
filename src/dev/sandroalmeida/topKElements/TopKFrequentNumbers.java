package dev.sandroalmeida.topKElements;

import java.util.*;

class NumbersFrequency{
    int number;
    int frequency;

    public NumbersFrequency(int number){
        this.number = number;
    }
}

public class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);

        PriorityQueue<NumbersFrequency> maxHeap = new PriorityQueue<>((n1, n2) -> n2.frequency - n1.frequency);
        Map<Integer, NumbersFrequency> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            NumbersFrequency current;
            if(map.containsKey(nums[i]))
                current = map.get(nums[i]);
            else{
                current = new NumbersFrequency(nums[i]);
                map.put(nums[i], current);
            }
            current.frequency++;
        }

        for(Map.Entry<Integer, NumbersFrequency> current: map.entrySet()){
            maxHeap.add(current.getValue());
        }

        for(int i = 0; i < k; i++)
            topNumbers.add(maxHeap.poll().number);

        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11, 1, 1}, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
