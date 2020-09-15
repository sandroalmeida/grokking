package dev.sandroalmeida.cyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k){
        List<Integer> missingNumbers = new ArrayList<>();

        int i = 0;
        while(i < nums.length){
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(i, nums[i] - 1, nums);
            }else {
                i++;
            }
        }

        Set<Integer> trackNumbers = new HashSet<>();
        for(i = 0; i < nums.length && missingNumbers.size() < k; i++){
            if(nums[i] != i + 1) {
                missingNumbers.add(i + 1);
                trackNumbers.add(nums[i]);
            }
        }

        for(i = 1; missingNumbers.size() < k; i++){
            int candidateNumber = i + nums.length;
            if(!trackNumbers.contains(candidateNumber))
                missingNumbers.add(candidateNumber);
        }

        return missingNumbers;
    }

    private static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 4);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}
