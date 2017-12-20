package codechef;

import java.util.Scanner;

public class GIT01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];
            for (int i = 0; i<n; i++) {
                String row = scanner.next();
                for(int j=0; j<m; j++) {
                    grid[i][j] = row.charAt(j);
                }
            }

            System.out.println(solve(grid, n, m));
        }
    }

    private static int solve(char[][] grid, int n, int m) {

        return 0;
    }
}
