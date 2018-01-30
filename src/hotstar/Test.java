package hotstar;

import java.util.Stack;

public class Test {
    private static int x;

    public static void main(String[] args) {
        int a = 1;

        int b = 2;

        int c = 3;

        a |= 4;


        b >>= 1;

        c <<= 1;

        a ^= c;

        System.out.println(a + "  " + b + " " + c );
    }



    static int fun() {
        return ++x;
    }
}

