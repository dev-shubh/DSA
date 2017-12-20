package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextHigherNumberWithSameDigits {
    public static void main(String[] args) {
        String s = "12143";

        System.out.println(solve(s));

    }

    private static String solve(String s) {
        int n = s.length();
        if(n == 1) return s;

        List<Integer> nums = new ArrayList<>();

        for(int i=0; i<n; i++){
            nums.add(Integer.parseInt(s.charAt(i) + ""));
        }

        int start = n-2;

        while(nums.get(start) > nums.get(start+1)) {
            start--;
        }

        int smallest = nums.get(n-1);
        int j = n-1;
        int smallestPosition = n-1;
        while (j > start){
            if(nums.get(j) < smallest) {
                smallest = nums.get(j);
                smallestPosition = j;
            }
            j--;
        }

        int temp = nums.get(start);
        nums.set(start, nums.get(smallestPosition));
        nums.set(smallestPosition, temp);

        Collections.sort(nums.subList(start + 1, n));

        String ans = "";

        for(int i=0; i<n; i++) {
            ans += nums.get(i);
        }

        return ans;
    }
}
