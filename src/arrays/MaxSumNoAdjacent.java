package arrays;

import java.util.Scanner;

/**
 * Created by shumishra on 9/18/17.
 */
public class MaxSumNoAdjacent {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];

            for (int i=0; i<n; i++) {
                a[i] = scanner.nextInt();
            }

            System.out.println(maxNoAdjacent(a));
        }
    }

    private static int maxNoAdjacent(int[] a) {
        int n = a.length;
        if(n == 0) return -1;
        if(n == 1) return a[0];
        if(n == 2) return Math.max(a[0], a[1]);

        int maxInclusive = a[0];
        int maxExclusive = 0;
        int max = Math.max(maxExclusive, maxInclusive);

        for(int i = 1; i < n; i++) {
            // if the present element is included.
            maxInclusive = maxExclusive + a[i];
            // if the present element is excluded, ans is previous max, i.e excluding the present element.
            maxExclusive = max;
            // update max till present element, either by including/excluding the present element.
            max = Math.max(maxExclusive, maxInclusive);
        }

        return max;
    }
}

//5 600 511 52 100
//5 500 51 52
