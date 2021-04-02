package Coding_Skill;

public class RecursiveBinarySearch {
    
    public static void main(String[] args) {
    
        int a[] = new int[] {1, 12, 23, 34, 56, 78, 91, 102, 204};
        int x = 91;
        int resultIndex = recursiveBinarySearch(a, 0, a.length - 1, x);
        System.out.println("Result Index:" + resultIndex);
        System.out.println("Result Index:"+ recursiveBinarySearch(a, 0, a.length - 1, 12));
        System.out.println("Can't find Result Index:"+ recursiveBinarySearch(a, 0, a.length - 1, 500));
    }

    private static int recursiveBinarySearch(int[] a, int p, int r, int x) {
       System.out.println("["+ p + "...." + r + "]");
        if (p > r) { //Base condition
           return -1;
       } else { 
        int q = (p+r) / 2;
            if (a[q] == x) {
                return q;
            } else if (a[q] > x) {
                return recursiveBinarySearch(a, p, q -1, x);
            } else {
                return recursiveBinarySearch(a, q+1, r, x);
            }
      //  }
    }

}
