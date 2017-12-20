package dp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Uber2 {

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 0) {
            System.out.println(0);
            return;
        }

        int k = sc.nextInt();

        int[] ar = new int[k];

        for (int i=0; i<k; i++) {
            ar[i] = sc.nextInt();
        }


        System.out.println(minTime(ar, k, n));
    }

    private static int minTime(int cabs[], int n, int V)
    {
        Arrays.sort(cabs);

        int[][] dp = new int[V+1][n+1];

        for(int i=1; i<=V; i++) {
            for(int j=1; j<=n; j++) {
                if(i==1) {
                    dp[i][j] = cabs[0];
                }
                if(j==1) {
                    dp[i][j] = i*cabs[0];
                }
                else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j] + cabs[j-1]);
                }
            }
        }

        return dp[V][n];
    }


}
