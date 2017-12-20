package arrays;

public class SearchOnlyRepeatedElementInSortedArray {

    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,4,5};
        System.out.println(binarySearch(a));
    }

    private static int binarySearch(int[] a){
        int n = a.length;

        int start = 0;
        int end = n-1;

        while (start < end) {
            int mid = start + (end-start)/2;
            if( ( ((mid-1) >=0) || ((mid+1) < n) ) &&
                    ((a[mid] == a[mid-1]) || (a[mid] == a[mid + 1])) ) {
                int first = binarySearchForFirstOccurence(a, start, mid, a[mid]);
                int last = binarySearchForLastOccurence(a, start, mid, a[mid]);
                return (last-first+1);
            }
        }

        return 0;
    }

    private static int binarySearchForFirstOccurence(int[] a, int start, int end, int x) {
        return 0;

    }

    private static int binarySearchForLastOccurence(int[] a, int start, int end, int x) {
        return 0;
    }


}
