package dev.sandroalmeida.dynamicProgramming;

public class PartitionSet_V2 {

    static boolean canPartition(int[] num){

        int sum = 0;
        for(int i: num)
            sum += i;

        if(sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
        return canPartitionRecursive(dp, num, sum/2, 0);
    }

    static boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex){
        if(sum == 0) return true;

        if(num.length == 0 || currentIndex >= num.length)
            return false;

        // if we have not already processed a similar problem
        if (dp[currentIndex][sum] == null) {

            // if the number at currentIndex exceeds the sum, we shouldn't process this
            if(num[currentIndex] <=sum){
                // recursive call after choosing the number at the currentIndex
                if(canPartitionRecursive(dp, num, sum - num[currentIndex], currentIndex + 1))
                    dp[currentIndex][sum] = true;
                return true;
            }

            // recursive call after excluding the number at the currentIndex
            dp[currentIndex][sum] = canPartitionRecursive(dp, num, sum, currentIndex + 1);
        }
        return dp[currentIndex][sum];

    }

    public static void main(String[] args) {
        PartitionSet_V2 ps = new PartitionSet_V2();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
