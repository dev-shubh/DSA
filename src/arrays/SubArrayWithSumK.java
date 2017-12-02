package arrays;

/**
 * Created by shumishra on 10/1/17.
 */
public class SubArrayWithSumK {
    public int subarraySum(int[] nums, int k) {
        int size = nums.length;
        long[] cummulativeSum = new long[size];
        long sum = 0;
        for(int i=0; i<size; i++) {
            sum += nums[i];
            cummulativeSum[i] = sum;
        }
        int ans = 0;
        for(int i=0; i<size; i++) {
            for(int j = i+1; j < size; j++) {
                if(cummulativeSum[j] - cummulativeSum[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
