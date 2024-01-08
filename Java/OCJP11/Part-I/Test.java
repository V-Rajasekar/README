import java.util.*;

class A {
  
    public void fly(int numMiles) {}
   // public int fly(int numMiles) {return 1;}     // DOES NOT COMPILE
    public void fly(int[] lengths) {}
    public void fly(int... lengths) {}     // DOES NOT COMPILE

    public void woof(List<Set> strings) {}
    public void woof(List<Integer> integers) {}  
    public void walk(List<String> strings) {}
    public void walk(List<Integer> integers) {}    // DOES NOT    COMPILE the methods are identical once the Generics is removed.

    public void baa(String c) {}
    public void baa(String[] c) {}
  //  public void baa(String... c) {} // Can't dcl both baa(String...) and baa(String[]) 
    public void baa(CharSequence c) {}

    public void woof(char... chars) {}
    public void woof(Character c) {}
  

}

class B extends A{
 
}
class Test {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}