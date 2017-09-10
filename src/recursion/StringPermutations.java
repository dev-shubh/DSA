package recursion;

import java.util.*;

/**
 * Created by shumishra on 8/7/17.
 */
public class StringPermutations {
    public static void main(String[] args) {
        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while (t > 0) {
            List<String> ans = new ArrayList<>();
            String str = scanner.next();
            Character[] string = new Character[str.length()];
            for (int i=0; i<str.length(); i++){
                string[i] = str.charAt(i);
            }
            Arrays.sort(string);
            printAllPermutations(str,0, string.length-1, ans);
            Collections.sort(ans);
//            System.out.println(ans.size());
            ans.forEach(s -> {
                System.out.print(s.toString() + " ");
            } );
            System.out.print("\n");
            t--;
        }
    }

    private static void printAllPermutations(String str, int fix, int size, List<String> ans) {
        if(str == null){
            return;
        }
        if(fix == size){
            //print(str);
            ans.add(str);
            return;
        }
        else {
            for(int i = fix; i <= size; i++) {
                printAllPermutations(swap(str,fix, i,size), fix+1, size, ans);
            }
        }
        return;
    }

    private static String swap(String str, int i, int j, int size){
        String tempString = "";
        Character[] newS = new Character[size+1];
        for(int k=0; k<=size; k++){
            newS[k] = str.charAt(k);
        }
        Character temp = newS[i];
        newS[i] = newS[j];
        newS[j] = temp;

        for (int k=0; k<=size; k++) {
            tempString += newS[k];
        }
        return tempString;
    }

    private static void print(Character[] s){
        for (int i=0; i<s.length; i++) {
            System.out.print(s[i]);
        }
        System.out.print("\n");
    }
}
