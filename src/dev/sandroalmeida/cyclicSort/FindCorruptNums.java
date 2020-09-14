package dev.sandroalmeida.cyclicSort;

public class FindCorruptNums {

    public static int[] findNumbers(int[] nums){
        int[] result = new int[2];

        int i = 0;
        while(i < nums.length){
            if(nums[i] != nums[nums[i] - 1])
                swap(i, nums[i] - 1, nums);
            else
                i++;
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + 1) {
                result[0] = nums[j];
                result[1] = j + 1;
            }
        }

        return result;
    }

    private static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]);
        nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]);
    }
}
