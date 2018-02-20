package dp;


/*
Solution of cutting a rod of length N depends on optimal solution of cutting smaller length rods.

 */


public class RodCutting {
    public static void main(String[] args) {
//        int[] cost = {1,5,8,9,10, 17, 17, 20, 24, 30};
        int[] cost = {1,5,8,9};
        int max = solve(cost);
        System.out.println("Ans = " + max);
    }

    private static int solve(int[] cost) {
        int n = cost.length;
//        int recMax = solveRecursively(cost, 0, n-1);
        int dpMax = solveDP(cost);
        return dpMax;
    }

/*
This function aims at finding optimal solution for a rod of length (end-start+1).
At any moment of time, if the length of rod is n, we have 2 options :
1. there is no need of cut
2. we made a cut, and if we made a cut, we have n-1 options
                    the cut can be at length 1 and then optimally solving the remaining rod
                    the cut can be at length 2 and then optimally solving the remaining rod
                    ...
                    ...
                    the cut can be at length n-1 and then optimally solving the remaining rod
 */
    private static int solveRecursively(int[] cost, int start, int end) {
        System.out.println(start + "..." + end);
        if(start + 1 == end) {
            return cost[1];
        }
        int max = cost[end - start];
        for(int i = start + 1; i < end; i++) {
            int lengthOfCurrentCut = i - start -1;
            max = Math.max(max, solveRecursively(cost, i, end) + cost[lengthOfCurrentCut]);
        }
        return max;
    }

/*
In the recursive solution, we are solving various sub-problems many times.
A careful observation will help us to understand that its the length of the rod that matters no the exact rod[start,end]
So to optimally solve a rod of length n, if we have optimal solutions to all the smaller size rods, we can easily solve
in better complexity using bottom-up approach.
We save the optimal result of cutting rod of length in an array ans[];
e.g ans[8] will give the cost of optimally cutting a rod of length 8.
Hence ans[n] = max( ans[i] + ans[n-1]) for 0 < i < n;
 */
    private static int solveDP(int[] cost) {
        int n = cost.length;
        int[] ans = new int[n+1];
        ans[1] = cost[0];
        ans[2] = Math.max( 2*ans[1], cost[2-1]);
        for(int i = 3; i <= n; i++) {
            ans[i] = cost[i-1]; // Initial ans is cost with no cut.
            for(int cut = 1; cut < i; cut++) {
                ans[i] = Math.max(ans[i], ans[cut] + ans[i - cut]);
            }
        }
        return ans[n];
    }


}
