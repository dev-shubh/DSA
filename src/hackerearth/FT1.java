package hackerearth;

import java.util.Scanner;

public class FT1 {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        String reverse = "";
        int n = name.length();
        for(int i = n - 1; i>=0; i--) {
            reverse += name.charAt(i);
        }
        System.out.println(reverse);

    }
}
