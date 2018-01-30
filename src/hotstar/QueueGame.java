package hotstar;

import java.util.*;

public class QueueGame {



    public static void main(String args[] ) throws Exception {
        class Data {
            int val;
            int pos;
        }

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int X = scanner.nextInt();
        Queue<Data> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            Data data = new Data();
            data.pos = i + 1;
            data.val = scanner.nextInt();
            queue.add(data);
        }
        List<Integer> sol = new ArrayList<>();

        int x = X;
        while(x-- > 0 && !queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int ans = 0;
            int count = 0;
            List<Data> list = new ArrayList<>();
            while(count < X && !queue.isEmpty()) {
                list.add(queue.remove());
                count++;
            }
            for(int i=0; i<list.size(); i++) {
                if(list.get(i).val > max) {
                    max = list.get(i).val;
                    ans = i;
                }
                Data data = list.get(i);
                if(data.val > 0) {
                    data.val--;
                }
                list.set(i,data);
            }
            if (list.size() > 0) {
                sol.add(list.get(ans).pos);
                list.remove(ans);
            }

            for(int i=0; i<list.size(); i++) {
                queue.add(list.get(i));
            }
        }
        for (int i=0; i<sol.size(); i++) {
            System.out.print(sol.get(i) + " ");
        }
    }
}
