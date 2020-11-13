package dev.sandroalmeida.mergeKway;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int value;
    int elementIndex;
    int arrayIndex;

    Node(int value, int elementIndex, int arrayIndex) {
        this.value = value;
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

public class SmallestRange {

    public static int[] findSmallestRange(List<Integer[]> lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE, currentMaxNumber = Integer.MIN_VALUE;
        for(int i = 0; i <  lists.size(); i++){
            if(lists.get(i) != null){
                minHeap.add(new Node(lists.get(i)[0], 0 , i));
                currentMaxNumber = Math.max(currentMaxNumber, lists.get(i)[0]);
            }
        }

        while(minHeap.size() == lists.size()){
            Node node = minHeap.poll();
            if(rangeEnd - rangeStart > currentMaxNumber - lists.get(node.arrayIndex)[node.elementIndex]){
                rangeStart = lists.get(node.arrayIndex)[node.elementIndex];
                rangeEnd = currentMaxNumber;
            }
            int newIndex = node.elementIndex + 1;
            if(lists.get(node.arrayIndex).length > newIndex){
                int newValue = lists.get(node.arrayIndex)[newIndex];
                Node newNode = new Node(newValue, newIndex, node.arrayIndex);
                minHeap.add(newNode);
                currentMaxNumber = Math.max(currentMaxNumber, newValue);
            }
        }

        return new int[] { rangeStart, rangeEnd };
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
