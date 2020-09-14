package dev.sandroalmeida.cyclicSort;

public class FirstMissingPositive {

    public static int findNumber(int[] nums){

        int i = 0;
        while(i < nums.length){
            if(nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length)
                swap(i, nums[i] - 1, nums);
            else
                i++;
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + 1)
                return j + 1;
        }

        return -1;
    }

    private static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{-3,1,5,4,2}));
        System.out.println(findNumber(new int[]{3,-2,0,1,2}));
        System.out.println(findNumber(new int[]{3,2,5,1}));
    }
}
