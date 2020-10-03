package dev.sandroalmeida.modifiedBinarySearch;

public class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key){

        int start = 0, end = arr.length - 1;
        int result = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int value = arr[mid];
            if(key <= value){
                result = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
