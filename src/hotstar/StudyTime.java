package hotstar;

import java.util.*;

public class StudyTime {

    public static void main(String[] args) throws Exception{
        class Data implements Comparable {
            int start;
            int end;
            int position;

            @Override
            public int compareTo(Object o) {
                if( Data.this == o) return 0;
                if(this.start  == this.end) {
                    return this.end - ((Data) o).end;
                }
                else {
                    return this.start - ((Data) o).start;
                }
            }
        }

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();
            List<Data> dataList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Data data = new Data();
                data.start = start;
                data.end = end;
                data.position = i;
                dataList.add(data);
            }

            Collections.sort(dataList);

            long left = 0;
            long right = 1000000;
            for(int iteration=0;iteration<100;iteration++){
                long  mid=(left+right)/2;
                long  currentPos=0;
                boolean flag=false;
                for(int i=0;i<n;i++){
                    int pos=dataList.get(i).position;
                    if(currentPos<dataList.get(pos).start){
                        currentPos=dataList.get(pos).start;
                    }
                    if(currentPos+mid>dataList.get(pos).end){
                        flag=true;
                    }
                    currentPos+=mid;
                }
                if(!flag)
                    left=mid;
                else
                    right=mid;
            }

            int denominator = 0;
            long  minDiff = Long.MAX_VALUE;
            for(int i=1;i<=n;i++)
            {
                long p=left*i;
                int value=(int)(p+0.5);
                long currentDiff= (Math.abs(p-value))/i;
                if(currentDiff<minDiff){
                    minDiff=currentDiff;
                    denominator=i;
                }
            }
            int numerator=(int)(left*denominator+0.5);
            int g= GCD(numerator,denominator);
            System.out.println(numerator/g + "/" + denominator/g);
        }

    }

    private static int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }


}
