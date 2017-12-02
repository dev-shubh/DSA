package dp;

import java.text.DecimalFormat;

public class PartitionInEqualSubset {

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }

        return false;
    }

    boolean hasSubsetWithSum(int sum, int[] nums){

        int[][] dp = new int[sum+1][nums.length +1];
//        DecimalFormat
        return false;
    }
}
