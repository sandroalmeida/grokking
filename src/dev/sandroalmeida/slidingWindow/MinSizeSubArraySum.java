package dev.sandroalmeida.slidingWindow;

public class MinSizeSubArraySum {

    public static int findMinsubArray(int S, int[] arr){
        int start = 0, sum = 0, length, minLength = Integer.MAX_VALUE;
        for(int end = 0; end < arr.length; end ++){
            sum += arr[end];
            while(sum >= S){
                length = end - start + 1;
                minLength = Math.min(minLength, length);
                sum -= arr[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        System.out.println(findMinsubArray(7, arr));
        int[] arr2 = {2, 1, 5, 2, 8};
        System.out.println(findMinsubArray(7, arr2));
    }

}
