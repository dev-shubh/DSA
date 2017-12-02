package hackerearth;


import java.math.BigDecimal;
import java.text.DecimalFormat;

import java.util.*;

class WinTheGame {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.######");
        int t = s.nextInt();
        while(t > 0){

            int r = s.nextInt();
            int g = s.nextInt();

            System.out.println(String.format("%8f", solve(r,g)));

            t--;
        }
    }

    private static double format(double value, int n) {
        BigDecimal b = new BigDecimal(String.valueOf(value));
        return b.doubleValue();
    }

    private static double solve(int r, int g) {
        if(r == 0 || g == 0) return 1;
        int n = r + g;
        double prob_r =(double) r/n;
        double prob_g =(double) g/n;

        double ans = prob_r;
        double factor = prob_g*prob_g;

        while(g > 1) {
            ans += factor*ans;
            factor = factor*factor;
            g--; g--;
        }
        return ans;
    }
}


