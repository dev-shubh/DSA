package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by shumishra on 12/3/17.
 */
public class NonRepeatingCharacter {
    static class Element{
        int count;
        int firstPosition;
    }

    public static void main (String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            String s = sc.next();
            char ch = solve(s);
            if(ch == '0'){
                System.out.println("-1");
            }
            else {
                System.out.println(ch);
            }
            t--;
        }
    }

    private static char solve(String s) {
        int n = s.length();
        Map<Character, Element> chMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(chMap.containsKey(ch)){
                Element el = chMap.get(ch);
                el.count += 1;
                chMap.put(ch, el);
            }
            else {
                Element el = new Element();
                el.count = 1;
                el.firstPosition = i;
                chMap.put(ch, el);
            }
        }

        char ans = '0';
        int position = Integer.MAX_VALUE;

        for(Map.Entry<Character, Element> entry : chMap.entrySet()) {
            Element el = entry.getValue();
            if(el.count == 1 && el.firstPosition < position){
                position = el.firstPosition;
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
