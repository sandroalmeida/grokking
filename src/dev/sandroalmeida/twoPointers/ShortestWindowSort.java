package dev.sandroalmeida.twoPointers;

public class ShortestWindowSort {

    public static int sort(int[] arr){

        /*
        * Steps -
        * 1-From the beginning and end of the array, find the first elements that are out of the sorting order. The two elements will be our candidate subArray.
          2-Find the maximum and minimum of this subArray.
          3-Extend the subArray from beginning to include any number which is bigger than the minimum of the subArray.
          4-Similarly,  extend the subArray from the end to include any number which is smaller than the maximum of the subArray.
        * */

        int low = 0, high = arr.length - 1;
        // find the first number out of sorting order from the beginning
        while(low < arr.length - 1 && arr[low] <= arr[low + 1])
            low++;

        // if the array is sorted
        if(low == arr.length - 1) return 0;

        // find the first number out of sorting order from the end
        while(high > 0 && arr[high] >= arr[high - 1])
            high--;

        // find the maximum and minimum of the subArray
        int subArrayMax = Integer.MIN_VALUE, subArrayMin = Integer.MAX_VALUE;
        for(int k = low; k <= high; k++){
            subArrayMax = Math.max(subArrayMax, arr[k]);
            subArrayMin = Math.min(subArrayMin, arr[k]);
        }

        // extend the subArray to include any number which is bigger than the minimum of the subArray
        while(low > 0 && arr[low - 1] > subArrayMin)
            low--;

        // extend the subArray to include any number which is smaller than the maximum of the subArray
        while(high < arr.length - 1 && arr[high + 1] < subArrayMax)
            high++;

        return high - low + 1;
    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}
