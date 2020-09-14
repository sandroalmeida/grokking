package dev.sandroalmeida.cyclicSort;

public class FindDuplicate {

    public static int findNumber(int[] nums){

        int i = 0;
        while(i < nums.length){
            if(nums[i] != i + 1){
                if (nums[i] != nums[nums[i] - 1])
                    swap(i, nums[i] - 1, nums);
                else
                    return nums[i];
            }else {
                i++;
            }
        }

        return -1;
    }

    // swap position a --> b
    private static void swap(int a, int b, int[] arr) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static void main(String[] args) {
        System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
