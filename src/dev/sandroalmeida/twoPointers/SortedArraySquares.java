package dev.sandroalmeida.twoPointers;

import dev.sandroalmeida.util.ArrayUtil;

public class SortedArraySquares {

    public static int[] makeSquares(int[] arr){

        int l = arr.length;
        int leftPointer = 0, rightPointer = l - 1;
        int[] result = new int[l];
        int count = l - 1;

        while(leftPointer <= rightPointer){
            int leftSquare = arr[leftPointer] * arr[leftPointer];
            int rightSquare = arr[rightPointer] * arr[rightPointer];
            if(leftSquare > rightSquare){
                result[count] = leftSquare;
                leftPointer++;
            } else {
                result[count] = rightSquare;
                rightPointer--;
            }
            count--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {-2,-1,0,2,3};
        int[] arr2 = {-3,-1,0,1,2};

        ArrayUtil.showIntArray(makeSquares(arr1));
        ArrayUtil.showIntArray(makeSquares(arr2));
    }
}
