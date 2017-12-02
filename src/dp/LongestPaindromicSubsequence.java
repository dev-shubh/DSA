package dp;

/**
 * Created by shumishra on 11/15/17.
 */
public class LongestPaindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] ans = new int[n+1][];

        for (int i=0; i<n; i++) {
            ans[i] = new int[n+1];
            ans[i][i] = 1;
        }

        int start = 0;
        int end = n-1;

        while(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                ans[start][end] = 2 + ans[start + 1][end-1];
            }
        }
        return 0;
    }

}
