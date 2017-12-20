package dp;

import java.util.*;

public class Uber1 {

    static class Point implements Comparable<Point>{
        int x;
        int y;

        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 0) {
            System.out.println(0);
            return;
        }

        ArrayList<Point> points = new ArrayList<>();
        for(int i=0; i<n; i++) {
            Point p = new Point();
            p.x = sc.nextInt();
            p.y = sc.nextInt();
            points.add(p);
        }

        Collections.sort(points);

        int start = points.get(0).x;
        int end = points.get(0).y;

        int ans = 0;

        for(int i=1; i<n; i++) {
            if(points.get(i).x <= end) {
                end = Math.max(points.get(i).y, end);
            }
            else {
                ans += end - start + 1;
                start = points.get(i).x;
                end = Math.max(points.get(i).y, end);
            }
        }

        ans += end - start + 1;

        System.out.println(ans);
    }
}

