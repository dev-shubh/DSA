package codechef;

import java.util.Scanner;

public class Cplay {

    private static String teamA ="TEAM-A ";
    private static String teamB ="TEAM-B ";
    private static String tie ="TIE";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(s.length() < 20) {
                return;
            }
            solve(s);
        }
    }

    private static void solve(String s) {
        int a = 0;
        int b = 0;
        int i = 0;
        int j = 1;

        while (i < 3) {
            if(s.charAt(i) == '1') a++;
            if(s.charAt(j) == '1') b++;
            i = i+2;
            j = j+2;
        }
        // now, i = 4 and j = 5

        int ra = 3;
        int rb = 3;

        while (i < 9) {
            if(s.charAt(i) == '1') a++;
            ra--;

            if((a-b) > rb) {
                System.out.println(teamA + (i + 1)) ;
                return;
            }
            if((b-a) > ra) {
                System.out.println(teamB + (i + 1));
                return;
            }

            if(s.charAt(j) == '1') b++;
            rb--;

            if((b-a) > ra) {
                System.out.println(teamB + (j + 1));
                return;
            }
            if((a-b) > rb) {
                System.out.println(teamA + (j + 1)) ;
                return;
            }
            i = i+2;
            j = j+2;
        }

//        System.out.println(a + " " + b);

        // i = 10, j = 11

        while(i < 19) {
            if(s.charAt(i) == '1') a++;
            if(s.charAt(j) == '1') b++;
            if(a > b) {
                System.out.println(teamA + (j + 1));
                return;
            }
            else if(b > a) {
                System.out.println(teamB + (j + 1));
                return;
            }
            else {
                i = i+2;
                j = j+2;
            }
        }

        if(a == b) {
            System.out.println(tie);
        }
    }
}
