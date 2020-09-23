package dev.sandroalmeida;

import java.util.PriorityQueue;

public class MedianOfAStream_V2 {

    private PriorityQueue<Integer> maxHeap; //first half
    private PriorityQueue<Integer> minHeap; //second half

    public MedianOfAStream_V2() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // first half sorted by bigger -> smaller
        minHeap = new PriorityQueue<>((a, b) -> a - b); // second half sorted by smaller -> bigger
    }

    public void insertNum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        if(maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if(maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian(){
        if(maxHeap.size() == minHeap.size())
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream_V2 medianOfAStream = new MedianOfAStream_V2();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
