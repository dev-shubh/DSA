package gfgs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZeroSumSubarrays {

    public static void main(String[] args) {
        int[] arr = new int[10001];
        int[] csum = new int[10001];
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            Map<Integer, Integer> countMap = new HashMap<>();
            int n = scanner.nextInt();
            for(int i=0; i<n; i++) {
                arr[i] = scanner.nextInt();
                csum[i] = (i==0) ? arr[i] : (arr[i] + csum[i-1]);
                if(countMap.containsKey(csum[i])) {
                    int count = countMap.get(csum[i]) + 1;
                    countMap.put(csum[i], count);
                }
                else {
                    countMap.put(csum[i], 1);
                }
            }
            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue();
                ans += (k == 0 ? (v + v*(v-1)/2) : v*(v-1)/2);
            }
            System.out.println(ans);
        }
    }

}
