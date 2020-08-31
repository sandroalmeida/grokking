package dev.sandroalmeida.twoPointers;

public class RemoveElement {

    public static int remove(int[] arr, int key){

        int nextSpot = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != key){
                arr[nextSpot] = arr[i];
                nextSpot++;
            }
        }

        return nextSpot;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,2,3,6,3,10,9,3};
        int[] arr2 = {2,11,2,2,1};
        System.out.println(remove(arr1, 3));
        System.out.println(remove(arr2, 2));
    }
}
