package dev.sandroalmeida.twoPointers;

import java.util.*;

public class TripletSumToZero_V2 {

    public static List<List<Integer>> searchTriplets(int[] arr){
        List<List<Integer>> triplets = new ArrayList<>();

        for(int i = 0; i < arr.length - 2; i++){
            if(i > 0 && arr[i] == arr[i-1]) continue;
            searchPair(arr, -arr[i], i+1, triplets);
        }

        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets){
        Map<Integer, Integer> mapTarget = new HashMap<>();

        for(int i = left; i < arr.length; i++){
            if(mapTarget.containsKey(targetSum - arr[i])) {
                Integer[] tripletArr = {-targetSum, targetSum - arr[i], arr[i]};
                Arrays.sort(tripletArr);
                List<Integer> triplet = Arrays.asList(tripletArr);
                if(!triplets.contains(triplet)) triplets.add(triplet);
            }
            mapTarget.put(arr[i], i);
        }

    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero_V2.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero_V2.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
