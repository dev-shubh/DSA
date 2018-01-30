package hackerearth;

import java.util.Scanner;

public class FT2 {
    public static void main(String[] args) {
        for(int a = 1; a <10; a++) {
            for(int b = 0; b < 10; b++) {
                for(int c = 0; c<10; c++) {
                    for(int d = 0; d<10; d++) {
                        for(int e = 1; e<10; e++) {
                            int number = a * 10000 + b * 1000 + c * 100 + d * 10 + e;
                            int reverseNumber = e * 10000 + d * 1000 + c * 100 + b * 10 + a;
                            if(number*4 == reverseNumber) {
                                System.out.println(number);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
