package dev.sandroalmeida.topKElements;

import java.util.PriorityQueue;

public class KthLargestNumberInStream_V2 {

    private int position;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> i1 - i2);

    public KthLargestNumberInStream_V2(int[] nums, int k){
        this.position = k;
        for(int i: nums)
            add(i);
    }

    public int add(int num){
        minHeap.add(num);
        if(minHeap.size() > this.position)
            minHeap.poll();
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream_V2 kthLargestNumber = new KthLargestNumberInStream_V2(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
