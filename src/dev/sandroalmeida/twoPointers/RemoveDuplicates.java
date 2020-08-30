package dev.sandroalmeida.twoPointers;

public class RemoveDuplicates {

    public static int remove(int[] arr){

        int nextSpot = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[nextSpot - 1] != arr[i]){
                arr[nextSpot] = arr[i];
                nextSpot++;
            }
        }
        return nextSpot;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,3,3,6,9,9};
        int[] arr2 = {2,2,2,11};
        System.out.println(remove(arr1));
        System.out.println(remove(arr2));
    }
}
