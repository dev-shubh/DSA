package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


/**
 * Created by shumishra on 11/5/17.
 */
public class JumpingNumbers {

    ArrayList<Integer> jNumbers = new ArrayList<>(1000);

    void findJumpingNumbers(int current, int limit) {
        if(current > limit) return;
        int lastDigit = current % 10;
        int first = current*10 + (( 10 + lastDigit - 1) % 10);
        int second = current*10 + (( 10 + lastDigit + 1) % 10);
        if(first <= limit && lastDigit != 0) {
            jNumbers.add(first);
            findJumpingNumbers(first, limit);
        }
        if(second <= limit && lastDigit != 9) {
            jNumbers.add(second);
            findJumpingNumbers(second, limit);
        }
    }

    public static void main(String[] args) {
        String ss = "\"";
        int x = (-1) % 10;
        System.out.println(x);
        int limit = 100000;
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(0);
        for(int i=1; i < 10; i++) {
            JumpingNumbers jumpingNumbers = new JumpingNumbers();
            if(i < limit) {

                jumpingNumbers.jNumbers.add(i);
                jumpingNumbers.findJumpingNumbers(i, limit);
            }
            Collections.sort(jumpingNumbers.jNumbers);
            answer.addAll(jumpingNumbers.jNumbers);
        }
        System.out.println(answer.size());
        for (int i=0; i< answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

}
