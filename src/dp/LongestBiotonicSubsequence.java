package dp;

import java.util.ArrayList;
import java.util.List;

public class LongestBiotonicSubsequence {

    public static int longestSubsequenceLength(final List<Integer> arr) {

        int n = arr.size();
        if(n == 0) return 0;
        int[] lis = new int[n];
        lis[0] = 1;

        int[] lds = new int[n];
        lds[n-1] = 1;

        for(int i=1; i<n; i++){
            lis[i] = 1;
            for(int j=0; j<i; j++) {
                if(arr.get(j) < arr.get(i)){
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        for(int i=n-1; i>=0; i--){
            lds[i] = 1;
            for(int j = n-1; j>i; j--) {
                if(arr.get(j) < arr.get(i)) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        int maxLength = 0;
        for(int i=0; i<n; i++) {
            maxLength = Math.max(maxLength, lis[i] + lds[i] - 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        List<Integer> seq = new ArrayList<>();
        seq.add(1);
        seq.add(11);
        seq.add(2);
        seq.add(10);
        seq.add(4);
        seq.add(5);
        seq.add(2);
        seq.add(1);

        System.out.println(longestSubsequenceLength(seq));
    }
}
