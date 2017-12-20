package codechef;

import java.util.Scanner;

public class VK18 {


    private static long[] sum = new long[2000001];
    private static long[] cSum = new long[2000001];
    private static long[] solutions = new long[1000001];

    public static void main(String[] args) {

        for(int i=1; i<10; i++) {
            sum[i] = i;
        }
        for(int i=10; i<2000001; i++){
            sum[i] = Math.abs(diff(i));
        }

        cSum[0] = sum[0];

        for(int i=2; i<=2000000; i++){
            cSum[i] = sum[i] + cSum[i-1];
        }

        solutions[1] = 2;
        for(int i=2; i<=1000000; i++) {
            solutions[i] = solutions[i-1] + 2*(cSum[2*i -1] - cSum[i]) + sum[2*i];
        }

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(solutions[n]);
        }
    }

    private static long diff(int n){
        long even = 0;
        long odd = 0;

        while(n > 0){
            int digit = n % 10;
            if(digit % 2 == 0) {
                even += digit;
            }
            else {
                odd += digit;
            }
            n = n/10;
        }
        return (Math.abs(even-odd));
    }
}
