package dev.sandroalmeida.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class SubArrayProductLessThanK {

    public static List<List<Integer>> findSubArrays(int[] arr, int target){
        List<List<Integer>> subArrays = new ArrayList<>();

        for(int left = 0; left < arr.length; left++){
            int right = left;
            int product = arr[left];
            List<Integer> subArray = new ArrayList<>();

            while(product < target){
                subArray.add(arr[right]);
                subArrays.add(new ArrayList<>(subArray));
                right++;
                if(right < arr.length) product *= arr[right];
                else break;
            }
        }

        return subArrays;
    }

    public static void main(String[] args) {
        System.out.println(SubArrayProductLessThanK.findSubArrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubArrayProductLessThanK.findSubArrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
