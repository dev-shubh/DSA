package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC755 {
    public static void main(String[] args) {
        int target = 1000000000;
        System.out.println("Minimum moves = " + reachNumberEfficient(target));
//        System.out.println("Minimum moves = " + reachNumber(target));

    }


    public static int reachNumberEfficient(int target) {
        int n = 0;
        int moves = 0;

        while (true) {
            if (n == target) return moves;
            moves++;
            n = n + moves;
//            System.out.println(" n = " + n);
            if( n > target) {
                n = n - moves;
                return moves + (target - n)*2 -1;
            }
        }
    }

    public static int reachNumber(int target) {
        int currentStep = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int moves = 0;
        while(true) {
            int currentElement = queue.remove();
//            System.out.println(currentElement);
            if(currentElement == target) {
                return moves;
            }

            ++moves;

            if(currentElement + currentStep == target) {
                return moves;
            }

            if(currentElement - currentStep == target) {
                return moves;
            }

            queue.add(currentElement + currentStep);
            queue.add(currentElement - currentStep);
            ++currentStep;
        }
    }
}
