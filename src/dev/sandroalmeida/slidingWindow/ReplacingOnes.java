package dev.sandroalmeida.slidingWindow;

public class ReplacingOnes {

    public static int findLength(int[] arr, int k){

        int maxLength = 0, start = 0, maxOnesCount = 0;

        for(int end =  0; end < arr.length; end++){
            if(arr[end] == 1) maxOnesCount++;

            if(end - start + 1 - maxOnesCount > k){
                if(arr[start] == 1) maxOnesCount--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }


        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
