package dev.sandroalmeida.cyclicSort;

public class MissingNumber {

    public static int findMissingNumber(int[] nums){

        int sumIndex = 0, sumNumbers = 0;

        for(int i = 0; i < nums.length; i++){
                sumIndex += i;
                if(nums[i] < nums.length)
                    sumNumbers += nums[i];
        }

        return sumIndex - sumNumbers;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
