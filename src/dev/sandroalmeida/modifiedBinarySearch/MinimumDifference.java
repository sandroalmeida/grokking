package dev.sandroalmeida.modifiedBinarySearch;

public class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key){

        int start = 0, end = arr.length - 1;
        Integer possible = null;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(possible == null || Math.abs(key - arr[mid]) < Math.abs(key - possible))
                possible = arr[mid];
            if(key < arr[mid])
                end = mid - 1;
            else if(key > arr[mid])
                start = mid + 1;
            else
                return arr[mid];
        }

        return possible;
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
