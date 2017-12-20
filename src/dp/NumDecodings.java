package dp;

public class NumDecodings {

    public static int numDecodings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        if(s.equalsIgnoreCase("0")) return 0;
        int[][] dp = new int[n][n];

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                int j = i + k;
                if( j >=n) break;
                if( i == j) {
                    if(Integer.parseInt(s.substring(i, j+1)) > 0)
                        dp[i][j] = 1;
                    else {
                        dp[i][j] = 0;
                    }
                }
                else if( k == 1) {
                    int val = Integer.parseInt(s.substring(i, j+1));
                    if(val == 10 || val == 20){
                        dp[i][j] = 1;
                    }
                    else if(val >=11 && val <=26){
                        dp[i][j] = 2;
                    }
                    else if(val < 10){
                        dp[i][j] = 0;
                    }
                    else if(val %10 == 0) {
                        return 0;
                    }
                    else {
                        dp[i][j] = 1;
                    }
                }
                else {
                    if(Integer.parseInt(s.substring(i, i+1)) > 0)
                        dp[i][j] = dp[i+1][j];
                    if(Integer.parseInt(s.substring(i, i+2)) <=26 && s.charAt(i) !='0')
                        dp[i][j] += dp[i+2][j];
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "2611055971756562";  // ZAJEE, AFAJEE
        System.out.println(numDecodings(s));
    }
}
/*

2611055

2 - 1   26 - 2    261 - 2
6 - 1   61 - 1    611 - 2
1 - 1   11 - 1    110 - 1
1 - 1   10 - 1    105 - 1
0 - 0   05 - 0    055 -
5 - 5   55 - 1
5 - 5


 */