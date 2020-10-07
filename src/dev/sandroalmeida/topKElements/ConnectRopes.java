package dev.sandroalmeida.topKElements;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for(int i = 0; i < ropeLengths.length; i++)
            minHeap.add(ropeLengths[i]);

        int cost = 0;
        while(minHeap.size() > 1){
            int sum = minHeap.poll() + minHeap.poll();
            cost += sum;
            minHeap.add(sum);
        }

        return cost;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
