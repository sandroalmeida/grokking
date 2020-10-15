package dev.sandroalmeida.topKElements;

import java.util.PriorityQueue;

public class SumOfElements {

    public static int findSumOfElements(int[] nums, int k1, int k2) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for(int i = 0; i < nums.length; i++)
            minHeap.add(nums[i]);

        for(int i = 0; i < k1; i++)
            minHeap.poll();

        int sum = 0;
        for(int i = 0; i< k2 - k1 - 1; i++)
            sum += minHeap.poll();

        return sum;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
