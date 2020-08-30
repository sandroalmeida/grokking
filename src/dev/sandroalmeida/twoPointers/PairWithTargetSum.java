package dev.sandroalmeida.twoPointers;

public class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum){

        int end = arr.length - 1, start = 0;

        while(start < end){

            int sum = arr[end] + arr[start];
            if(sum == targetSum){
                return new int[] {start, end};
            } else if(sum < targetSum){
                start++;
            } else{
                end--;
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,6};
        int[] arr2 = {2,5,9,11};

        int[] result1 = search(arr1, 6);
        int[] result2 = search(arr2, 11);

        System.out.println(result1[0] + ":" + result1[1]);
        System.out.println(result2[0] + ":" + result2[1]);
    }
}
