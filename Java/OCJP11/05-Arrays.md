# 05 Arrays

```java
//legal and illegal array initalization
char [] arr = new char[] {'A', 'B'}; char arr[] = new char[2];
char [] arr1 [] = new char[5][]; 
//char [] arr = new char[2] {'A', 'B'}; //illegal


    int [] arr1 = {5, 10, 15};
    int [] arr2 = {'A', 'B'};
    arr1 = arr2;
    System.out.println(arr1.length + arr2.length); // prints 4

    int[] arr1 = { 10, 100, 1000 }; //Line n1
        char[] arr2 = { 'x', 'y', 'z' }; //Line n2
        arr1 = arr2; // Line n3 // compilation error  compilation error as char [] is not compatible with int []
    String arr1 [], arr2, arr3 = null; //Line n1 arr1 is String[], and arr2, arr3 are String. 
    arr2 = arr3 = arr1; // compilation error.

    byte [] arr = new byte[0]; // arr refers array object of size 0
    System.out.println(arr[0]);// index 0 not available, so ArrayIndexOutOfBoundsException is thrown at runtime.

    short[] arr;
    arr = new short[3]; // You can create an array object in the same stmt or next stmt.

    double [] arr = new int[2]; //Line n1 compile error.

    //prints 40, 20, 40 here left operand is evaluated first, so arr[i++] next arr[++i]
    int [] arr = {10, 20, 30}; //Line n1
        int i = 0;
        arr[i++] = arr[++i] = 40; //Line n2
        for(var x : arr) //Line n3
            System.out.println(x);
    }

//Assignment left to right x = y = z <-3 prints 9
     var x = new int[]{1};
        var y = new int[]{2};
        var z = new int[]{3};
        System.out.println((x = y = z)[0] + y[0] + z[0]);
```        

### Arrays.mismatch and Arrays.compare

Arrays class has following overloaded mismatch methods for primitive type arrays. It find and return the index of the first mismatch between two primitive arrays. If no mismatch found returns 0. It throws NullPointerException
if either array is null.

int mismatch​(boolean[] a, boolean[] b)
int mismatch​(byte[] a, byte[] b)
int mismatch​(short[] a, short[] b)
int mismatch​(char[] a, char[] b)
int mismatch​(int[] a, int[] b)
int mismatch​(long[] a, long[] b)
int mismatch​(float[] a, float[] b)
int mismatch​(double[] a, double[] b)

similarly like mismatch, compare also has the same overloaded methods

0:  if the first and second array are equal and contain the same elements in the same order

<0: if the first array is lexicographically less than the second array

>0: if the first array is lexicographically greater than the second array

- For comparing the array contents, these methods take help of static compare(x, y) method defined in respective Wrapper classes

```yml
- For Character, Byte & Short; compare method returns x - y.
- For Integer and Long; compare method returns -1 if x < y, it returns 1 if x > y and it returns 0 if x == y.
- For Float and Double; logic is almost same as Integer type but logic is bit complex for finding equality of two floats or two doubles (not part of the exam).
- For Boolean; compare method returns 0 if x == y, 1 if x is true and -1 if x is false.
- If one array is the proper prefix of the other, then return a.length - b.length, where a refers to 1st array and b refers to 2nd array.
- For unequal arrays, respective compare methods of wrapper classes are invoked and it returns non-zero value (positive or negative) based on the array element comparison:

```

```java
int[] a1 = { 10, 15, 20 };
int[] a2 = { 10, 20, 30 };

Arrays.mismatch(a1, a2); // prints 1
Arrays.compare(c1, c2);// compare(15, 20) prints -1

char[] c1 = { 'T', 'A', 'L', 'L' };
char[] c2 = { 'T', 'A', 'L', 'K' };
Arrays.mismatch(c1, c2); //Difference in index 3, so prints 3
Arrays.compare(c1, c2);  //  L > K in the alphetic order, so prints1
Arrays.compare(new boolean[] {false}, new boolean[]{true});//false

```
### Arrays.mismatch/Arrays.compare/Arrays.equals (null)

```java
    //Either of the param is null throws NPE
    Arrays.mismatch(new char[] {'A'}, null) // NPE
    //compare lexical order return 1 or -1
    Arrays.compare(new char[] {'A'}, null)// 1
    Arrays.compare(null, new char[] {'A'})//-1
    Arrays.compare(null, null); //compile error ambiguous call
    float[] a;
    float[] b;
    //when values are same or both null true. if diff false
    Arrays.equals(a, b); // true
    Arrays.equals(a, new float[1]); //false
    Arrays.equals(new float[1], b);//false
    Arrays.equals(new float[1], new float[1]);//true
```
### Arrays of non-equal comparision

```java
char [] arr1 = {'A'};
char [] arr2 = {'A', 'A', 'A', 'A'};
Arrays.compare(arr1, arr2) // -3

//If one array is the proper prefix of the other, then return a.length - b.length, where a refers to 1st array and b refers to 2nd array.
Arrays.compare(new char[] {'A', 'C', 'E'}, new char[] {'A'})  // 3-1=> 2
//For unequal arrays, respective compare methods of wrapper classes are invoked and it returns non-zero value (positive or negative) based on the array element comparison:
Arrays.compare(new char[] {'A', 'C', 'E'}, new char[] {'E', 'Y'}) returns -4, which is the result of Character.compare('A', 'E').

Arrays.compare(new int[] {5, 10, 15, 20}, new int[] {5, 100, 150, 200}) returns -1 , which is the result of Integer.compare(10, 100).

Arrays.compare(new byte[] {5, 10, 100, 20}, new byte[] {5, 10, 15}) returns 85, which is the result of Byte.compare((byte)100, (byte)15).

int [] array1 = {};
int [] array2 = {100, 200};
Arrays.compare(array1, array2); // -2
Arrays.mismatch(array1, array2);// 0 index=0 mismatched. 

char [] arr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'j', 'k'};
char [] arr2 = {'f', 'g', 'a', 'i', 'k'};
//Arrays.mismatch(arr1, startIndex, endIndex, arr2, startIndex, endIndex);
System.out.println(Arrays.mismatch(arr1, 5, 10, arr2, 0, 5)); // prints 2
Arrays.compare(arr1, 5, 10, arr2, 0, 5) //prints 8 its like compare(i, a)
```
## Arrays Generic comparision

 <p>Finds and returns the index of the first mismatch between two Object arrays, otherwise return -1 if no mismatch is found. Array elements are compared based on the obj.equals(Object) method, 2nd method based on the comparator.</p>

```java
int compare​(T[] a, T[] b): Compares two Object arrays, with Comparable elements, lexicographically.

int compare​(T[] a, T[] b, Comparator<? super T> cmp): Compares two Object arrays using a specified comparator.

  StringBuilder[] array1 = { new StringBuilder("Manners"), new StringBuilder("maketh"), new StringBuilder("Man") };
  StringBuilder[] array2 = { new StringBuilder("Manners"), new StringBuilder("maketh"), new StringBuilder("man") };

  /*Statement Arrays.mismatch(array1, array2) returns 0 as StringBuilder class doesn't override equals(Object) method and hence the implementation of equals(Object) method Object class is invoked. equals(Object) method defined in Object class uses == operator to check the equality and based on that 1st element (at index 0) of both the arrays don't match.*/

  System.out.print(Arrays.mismatch(array1, array2)); // 0
  System.out.print(Arrays.compare(array1, array2)); // M-m 77-109=-32
```

1. **A null array is less than a non-null array:**
   
    A. If 1st array is null and 2nd array is not null, return -1.
        E.g., Arrays.compare(null, new String[] {"JAVA"}); returns -1.
    B. If 2nd array is null and 1st array is not null, return 1.
        E.g., Arrays.compare(new String[] {"JAVA"}, null); returns 1.
    C. If both the arrays are null, return 0.
        E.g., Arrays.compare((String []) null, null); returns 0.

2. **While comparing, a null element is less than a non-null element:**

    A. If element from 1st array is null, and corresponding element from 2nd array is not null, return -1
       E.g., Arrays.compare(new String[] {null}, new String[] {"JAVA"}); returns -1.
    B. If element from 2nd array is null, and corresponding element from 1st array is not null, return 1.
       E.g., Arrays.compare(new String[] {"JAVA"}, new String[] {null}); returns 1.
    C. If element from 1st array is null, and corresponding element from 2nd array is also null, return 0.
       Arrays.compare(new String[] {null}, new String[] {null}); returns 0.

3. If one array is the proper prefix of the other, then return a.length - b.length, where a refers to 1st array and b refers to 2nd array.
   ```java
    String [] array1 = {"OCP", "11", null};
    String [] array2 = {"OCP", "11"};
    String [] array3 = {null, "OCP", "11"};
        
    System.out.print(Arrays.compare(array1, array2)); //length compar 3-2 = 1
    System.out.print(Arrays.compare(array2, array3)); // 1
    System.out.print(Arrays.compare(array3, array2));// -1
   ```
 ## Array declaration with var

 ```java
 var arr1 = new int[]{10};
 var arr2 = new String[][] {};
 var arr3 = new char[][] {{}};
var arr5 = new String[][] {new String[]{"LOOK"}, new String[] {"UP"}};

//illegal

var arr4 = {10, 20, 30}; // Explicit target-type is needed for the array initializer
var [] arr6 = new int[] {2, 3, 4}; // var is not allowed as an element type of an array
 ```  
 ## Generic Type
- Type parameter should not be a Java keyword & a valid Java identifier. Naming convention for Type parameter is to use uppercase single character. 
- note String can be used as a type parameter (e.g) Printer<String> is allowed, but  overriding `String:toString()` method cause compile error because String type parameter is not compatible with java.lang.String.

```java
 class T {
    @Override
    public String toString() {
        return "T";
    }
}
 
class Printer<T> {
    private T t;
    Printer(T t){
        this.t = t;
    }
    @Override
    public String toString(){
        return t.toString();
    }
}
 
  Printer<T> printer = new Printer<>(new T());
  sout("" + printer)//prints T

  class Printer<T extends String> {} // Allowed as generic class doesn't override toString its OK.
```
- NOTE: If a class extends from generic type, then it must pass type arguments to its super class. Third type parameter, 'T' in 'AbstractGenericPrinter<X,Y,T>' correctly passed type argument to super class, 'GenericPrinter<T>'. 

```java
class GenericPrinter<T> {}
abstract class AbstractGenericPrinter<X,Y,T> extends GenericPrinter<T>{}
```
- If a type parameter T is with multiple bounds, then type argument must be a subtype of all bound.

-  Generic type uses extends keyword for both class and interface with first being the class then any interfaces. Its invalid `class Printer<T implements Cloneable> {}` use extends instead of implements.
-  class B<T super String> {} //Invalid super is used with ?
-  static method generic
```java
public static <T> T get(T t) {
    return t;
}
String str = get("Hello");// str=HELLO
```

```java
    public static <T> void print1(A<? extends Animal> obj) {
        obj.set(new Dog()); //Line n1 cause compile error as ? can be Cat
        System.out.println(obj.get().getClass());
    }

     public static <T> void print2(A<? super Dog> obj) {
        obj.set(new Dog()); //Line n2 // compiles as ? can be Animal, Dog and Object
        System.out.println(obj.get().getClass());
    }
    A<Dog> obj = new A<>();
    print1(obj); //Line n3
    print2(obj); //Line n4
```
## Upper bound and lower bound behaviour

```java
   List<? extends String> list = new ArrayList<>(Arrays.asList("A", "E", "I", "O")); //Line n1
   list.add("U"); //compile error due to Upperbound extends
   List<? super String> list = new ArrayList<>(Arrays.asList("A", "E", "I", "O")); //Line n1
   list.add("U");//compiles lower bound it can be Object or String.

     List<? super String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        for(String str : list) { //cause compile error for(Object str: list) is correct
            System.out.print(str);
        }
```
### Generic method defined in a non-generic class
- If a generic method is defined in a non-generic class then type parameters must appear before the return type of the method.
```
public class Test {
    private static final <X extends Integer, Y extends Integer> void add(X x, Y y) {
        System.out.println(x + y);
    }
 
    public static void main(String[] args) {
        add(10, 20); //=> Auto-boxing converts int to Integer prints 30
    }
}
```
- Instantiation of a type parameter 'T obj = new T()' or an array of type parameter 'T obj = new T[5]' are not allowed. 
- static declaration of type parameter is not allowed, only instance declaration is possible.
```java
 public class Test<T> {
    static T obj;
}
```
- In generics syntax, Parameterized types are not polymorhic.

```java
abstract Animal {}
class Dog extends Animal{}
List<Animal> lst = new ArrayList<Dog>(); //compile error


List<String> list1 = new ArrayList<>();
list1.add("A");
list1.add("B");

List<? extends Object> list2 = list1;
list2.remove("A"); //Line n1  compiles
list2.add("C"); //Line n2 // compile error
```
<p>
list2.remove("A"); => remove is non-generic method. remove(Object) will be invoked and it will successfully remove "A" from list2.

list2.add("C"); => add is a generic method. add(? extends Object) would be invoked. This means it can take an instance of any UnknownType (extending from Object class).

Compiler can never be sure whether passed argument is a subtype of UnknownType (extending from Object class). Line n2 causes compilation failure.
</p>