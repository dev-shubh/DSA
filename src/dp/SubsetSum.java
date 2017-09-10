package dp;

import java.util.*;
import java.lang.*;

class SubsetSum {
    public static void main (String[] args) {
        int[] arr = new int[100007];

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            System.out.println(solve(arr, n));
            t--;
        }
    }

    private static String solve(int[] a, int n) {
        int sum = 0;
        for(int i=0; i<n ;i++) {
            sum = sum + a[i];
        }

        if(sum % 2 == 0) {
            int requiredSum = sum/2;
            if(subsetSum(a, n, requiredSum) == true){
                return "YES";
            }
            else {
                return "NO";
            }
        }
        else {
            return "NO";
        }

    }

    private static boolean subsetSum(int[] a, int n, int requiredSum){
        /* sum[i][j] = boolean, if its possible to make a sum i using a[0...j] sub array. */
        boolean[][] sum = new boolean[requiredSum+1][];
        for(int i=0; i<=requiredSum; i++) {
            sum[i] = new boolean[n+1];
        }

        for(int i=0; i<=requiredSum; i++) {
            int j = 0;     // Impossible to make sum i when the array.size is 0
            sum[i][j] = false;
        }
        for (int j=0; j<=n; j++) {
            int i = 0;     // Always possible to make sum = 0 whatever be the array size.
            sum[i][j] = true;
        }

        for (int i=1; i<=requiredSum; i++) {
            for(int j=1; j<=n; j++) {
                //check if the jth element of the array can be included
                if(i - a[j-1] >= 0) {
                    // we can make sum i by either including jth element of the array, or excluding it.
                    sum[i][j] = (sum[i - a[j - 1]][j - 1]) || (sum[i][j - 1]);
                }
            }
        }
        return sum[requiredSum][n];
    }
}

//2
//4
//1 5 11 5
//3
//1 3 5