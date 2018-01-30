package strings;

import java.util.Scanner;


public class DecodeExcel {
    private static char[] letters = {'A','A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main (String[] args) {


        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-- > 0) {
            for(int i = 0; i<1000; i++) {
//                int n = in.nextInt();
                System.out.println(" i = " + i + " : " +solve(i));
            }
        }
    }

    private static String solve(int n) {
        if( n < 27 ) {
            return letters[n] + "";
        }
        int remainder = n % 26;
        if(remainder == 0) {
            return solve(n/26 -1) + letters[26];
        }
        else {
            return solve(n/26) + letters[remainder];
        }
    }
}

