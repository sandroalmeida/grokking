package dev.sandroalmeida;

public class MaxSumSubArrayOfSizeK {

    public static int findMaxsumSubArray(int k, int[] arr){
        int start = 0, end, sum = 0, sumMax = 0;
        for(end = 0; end <= arr.length - 1; end++){
            sum += arr[end];
            if(sum > sumMax) sumMax = sum;
            if(end >= k - 1){
                sum -= arr[start];
                start++;
            }
        }
        return sumMax;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5};
        System.out.println(findMaxsumSubArray(2, arr));
        int[] arr2 = {2, 1, 5, 1, 3, 2};
        System.out.println(findMaxsumSubArray(3, arr2));
    }

}
