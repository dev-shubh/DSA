package arrays;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by shumishra on 9/16/17.
 */
public class SortColors {
}


class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.isPalindrome(100));
    }

//    public boolean isPalindrome(int n) {
//        if(n < 0) return false;
//        if(n < 10) return true;
//        int d = (int) Math.log10(n) + 1; // No. of Digits
//        int start = d-1;
//        int end = 1;
//        while (end <= start) {
//            if(((int ) (n / Math.pow(10, start))) != (int)(n % Math.pow(10,end))) return false;
//            start--;
//            end++;
//        }
//        return true;
//    }
//
//    public boolean isPalindrome(int n) {
//        if(n < 0) return false;
//        if(n < 10) return true;
//        int d = (int) Math.log10(n) + 1; // No. of Digits
//        int base = (int) Math.pow(10, d-1);
//        int start = (int) n/base;
//        int end = (int) n % 10;
//        if(start == end) {
//            int remainingNumber = (n - start*base);
//            remainingNumber = remainingNumber / 10;
//            return isPalindrome(remainingNumber);
//        }
//        return false;
//    }

    public boolean isPalindrome(int n) {
        if (n < 0) return false;
        if (n < 10) return true;
        int original = n;
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + (n % 10);
            n = n / 10;
        }

        return (original == reverse);
    }
//
//        int d = (int) Math.log10(n) + 1; // No. of Digits
//        int base = (int) Math.pow(10, d-1);
//        int start = (int) n/base;
//        int end = (int) n % 10;
//        if(start == end) {
//            int remainingNumber = (n - start*base);
//            remainingNumber = remainingNumber / 10;
//            return isPalindrome(remainingNumber);
//        }
//        return false;
//    }
//
//
//


    public void sortColors(int[] nums) {
        int size = nums.length;
        int low = 0;
        int high = size - 1;
        int current = 0;

        while(current <= high) {

            switch (nums[current]) {
                case 0: {
                    int temp = nums[current];
                    nums[current] = nums[low];
                    nums[low] = temp;
                    current++;
                    low++;
                    break;
                }
                case 1: {
                    current++;
                    break;
                }
                case 2: {
                    int temp = nums[current];
                    nums[current] = nums[high];
                    nums[high] = temp;
                    high--;
                    break;
                }
            }

        }
    }

    public boolean isValid(String s) {

        Stack characterStack = new Stack();
        HashMap<Character, Character> compliment = new HashMap<>();
        compliment.put(')','(');
        compliment.put('}','{');
        compliment.put(']','[');


        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' :
                case '{' :
                case '[' :
                    {
                    characterStack.push(s.charAt(i));
                    break;
                }
                case ')' :
                case '}' :
                case ']' : {
                    if( characterStack.isEmpty() ||
                            ((Character) characterStack.pop()).compareTo(compliment.get(s.charAt(i))) != 0) {
                        return false;
                    }
                }

            }
        }
        return characterStack.isEmpty();
    }



}