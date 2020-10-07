package dev.sandroalmeida.topKElements;

import java.util.PriorityQueue;

public class KthSmallestNumber_V2 {

    public static int findKthSmallestNumber(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        // insert all
        for(int i = 0; i < nums.length; i++)
            minHeap.add(nums[i]);

        // remove k - 1 elements
        for(int i = 1; i < k; i++){
            minHeap.poll();
        }

        // return k smallest
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber_V2.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber_V2.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber_V2.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
