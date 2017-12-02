package dp;

/**
 * Created by shumishra on 11/25/17.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[amount+1][n+1];

        // dp[i][j] makes amount=i using first j coins.

        for(int i=0; i<=amount; i++) {
            dp[i][0] = -1;   // Not Possible to make amount i using 0 coins.
        }
        for(int j=1; j<=n; j++) {
            dp[0][j] = 0;   // No way to make amount=0 with j coins
        }

        for(int i=1; i<=amount; i++) {

            for(int j=1; j<=n; j++) {
                if(coins[j-1] == i) {     // jth coin is same as the amount i, minimum will be 1.
                    dp[i][j] = 1;
                }
                else if(coins[j-1] < i) { // if jth coin can be used.
                    if(dp[i-coins[j-1]][j] != -1) {
                        if(dp[i][j-1] != -1) {
                            dp[i][j] = Math.min(dp[i-coins[j-1]][j] + 1, dp[i][j-1]);
                        }
                        else {
                            dp[i][j] = dp[i-coins[j-1]][j] + 1;
                        }
                    }
                    else {
                        if(dp[i][j-1] != -1) {
                            dp[i][j] = dp[i][j-1];
                        }
                        else {
                            dp[i][j] = -1;
                        }

                    }

                }
                else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[amount][n];
    }
}
