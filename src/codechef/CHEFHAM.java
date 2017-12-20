package codechef;

import java.util.HashMap;
import java.util.Scanner;

public class CHEFHAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int max = 1;
            for(int i=0; i<n; i++) {
                a[i] = scanner.nextInt();
                if(hashMap.containsKey(a[i])){
                    int currentCount = hashMap.get(a[i]);
                    max = Math.max(currentCount, max);
                    hashMap.put(a[i], currentCount + 1);
                }
                else {
                    hashMap.put(a[i], 1);
                }
            }

        }
    }
}
