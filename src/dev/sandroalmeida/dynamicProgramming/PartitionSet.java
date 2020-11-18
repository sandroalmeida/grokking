package dev.sandroalmeida.dynamicProgramming;

public class PartitionSet {

    static boolean canPartition(int[] num){

        int sum = 0;
        for(int i: num)
            sum += i;

        if(sum % 2 != 0)
            return false;

        return canPartitionRecursive(num, sum/2, 0);
    }

    static boolean canPartitionRecursive(int[] num, int sum, int currentIndex){
        if(sum == 0) return true;

        if(num.length == 0 || currentIndex >= num.length)
            return false;

        // if the number at currentIndex exceeds the sum, we shouldn't process this
        if(num[currentIndex] <=sum){
            // recursive call after choosing the number at the currentIndex
            if(canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
                return true;
        }

        // recursive call after excluding the number at the currentIndex
        return canPartitionRecursive(num, sum, currentIndex + 1);

    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
