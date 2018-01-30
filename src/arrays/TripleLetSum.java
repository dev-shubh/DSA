package arrays;

import java.util.HashMap;
import java.util.Map;

public class TripleLetSum {

    public static boolean findTriplets(int arr[] , int n)
    {
        if(n < 3) return false;
        Map<Integer, Boolean> dataMap = new HashMap<>();

        for(int i=0; i<n; i++) {
            dataMap.put(arr[i], true);
        }

        int x,y;

        for(int i=0; i<n; i++) {
            x = arr[i];
            for(int j = i+1; j<n; j++) {
                y = arr[j];
                if(dataMap.containsKey((x+y) * (-1)) && (x+y) * (-1) != x && (x+y) * (-1) !=y) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {6, 56, 93, -12, 26, 78, 79, 58, 53, 52, 51, 55, 77, -2, 61, -26, 91, 16, 100, -8, 72};
        boolean result = findTriplets(arr, 21);
        System.out.println(result);
    }
}
