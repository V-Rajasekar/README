package Coding_Skill;

public class BinarySearch {

    public static void main(String args[]) {
        
        int A[] = new int [] {12, 23, 34, 45, 56, 78, 100};
        System.out.println(binarySearch(A, 78));
        System.out.println(binarySearch(A, 13));
        System.out.println(binarySearch(A, 100));
        
    }

    private static int binarySearch(int[] a, int x) {
        int p = 0; 
        int r = a.length -1;
        while( p <= r) {
            int q = (p+r)/2;
            if (a[q] == x) return q;
            if (a[q] > x) 
             r = q - 1;
            else
             p = q + 1;   
        }
        return -1;
    }
    
    //Run through x=100 
    
    |p=0, r(index)=6 q=3| p=4, r=6, q=5       | p=6, r=6, q=6   |
    |45 == 100 -> false | 78 == 100 -- false  |100 == 100 --> 6 |
    |45 > 100 -> false  | 78  > 100 --> false |                 |
    |p= 4               | p= 6                |                 | 
        

}
