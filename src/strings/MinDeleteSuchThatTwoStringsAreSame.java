package strings;

public class MinDeleteSuchThatTwoStringsAreSame {

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        dp[0][0] = 0; // When both the strings are empty, min delete required is zero.

        for(int i = 1; i <= n; i++) {
            dp[i][0] = i;  // If second string is empty, we have to delete all the elements from the first string
        }

        for(int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 2,
                            Math.min( dp[i-1][j] + 1 , dp[i][j-1] + 1) );
                }
            }
        }
        return dp[n][m];
    }
}
