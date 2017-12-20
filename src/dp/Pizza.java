package dp;

import java.util.Scanner;

public class Pizza {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            int x = sc.nextInt();
            int s = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();
            int cs = sc.nextInt();
            int cm = sc.nextInt();
            int cl = sc.nextInt();
            System.out.println(solve(x, s, m, l, cs, cm, cl));
            t--;
        }
    }

    private static int solve(int x, int s, int m, int l, int cs, int cm, int cl) {
        int[] size = new int[3];
        int[] value = new int[3];
        size[0] = s; size[1] = m; size[2] = l;
        value[0] = cs; value[1] = cm; value[2] = cl;

        int[][] dp = new int[x+1][4];

        for(int i=1; i<=x; i++) {
            for(int j=1; j<=3; j++) {
                if(size[j-1] <= i) {
                    int including = dp[i-size[j-1]][j] + value[j-1];
                    int excluding = dp[i][j-1];
                    if(excluding == 0) {
                        dp[i][j] = including;
                    }
                    else {
                        dp[i][j] = Math.min(including, excluding);
                    }
                }
                else {
                    if(dp[i][j-1] == 0) {
                        dp[i][j] = value[j-1];
                    }
                    else {
                        dp[i][j] = Math.min(dp[i][j-1], value[j-1]);
                    }
                }
            }
        }

        return dp[x][3];

    }
}
