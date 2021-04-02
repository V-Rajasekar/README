package Coding_Skill;

public class RecursiveLinearSearch {

     public static void main(String[] args) {
         int [] a = new int[] {2, 5, 8, 10, 12, 34, 25, 40, 39};
        System.out.println("Completed call: "+ recursiveLinearSearch(a, 0, 8) );
        
    }

    public static int recursiveLinearSearch(int []a, int i, int x) {
        if (i > a.length-1) { // if evaluates to true, x is not found in the array
            return -1;
        } else if (a[i] == x) {
            return i;
        } else {
           System.out.println("index at: "+ i);
           return recursiveLinearSearch(a, i+1, x);
        }   
    }

    
}
