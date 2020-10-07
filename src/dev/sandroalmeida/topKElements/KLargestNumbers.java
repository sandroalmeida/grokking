package dev.sandroalmeida.topKElements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestNumbers {

    public static List<Integer> findKLargestNumbers(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for(int i = 0; i < k; i++)
            minHeap.add(nums[i]);

        for(int i = k; i < nums.length; i++){
            minHeap.poll();
            minHeap.add(nums[i]);
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
