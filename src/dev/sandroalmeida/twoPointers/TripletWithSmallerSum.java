package dev.sandroalmeida.twoPointers;

import java.util.Arrays;

public class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target){
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0; i < arr.length - 2; i++){
            count += searchPair(arr, target - arr[i], i+1);
        }

        return count;
    }

    private static int searchPair(int[] arr, int targetPair, int left) {

        int count = 0;
        int right = arr.length - 1;
        while(left < right){
            int currentSum = arr[left] + arr[right];
            if(currentSum < targetPair){
                count += right - left;
                left++;
            }else{
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
