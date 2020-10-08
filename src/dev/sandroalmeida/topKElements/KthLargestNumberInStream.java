package dev.sandroalmeida.topKElements;

import java.util.PriorityQueue;

public class KthLargestNumberInStream {

    private int position;
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);

    public KthLargestNumberInStream(int[] nums, int k){
        this.position = k;
        for(int i: nums)
            maxHeap.add(i);
    }

    public int add(int num){
        this.maxHeap.add(num);
        PriorityQueue<Integer> copyHeap = new PriorityQueue<>(this.maxHeap);
        int current = 0;
        for(int i = 0; i < this.position; i++)
            current = copyHeap.poll();
        return current;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
