- [Chapter06 Lambdas and Functional Interfaces.](#chapter06-lambdas-and-functional-interfaces)
  - [Functional Interfaces](#functional-interfaces)
    - [Predicate boolean:test(T t)](#predicate-booleantestt-t)
    - [Consumer: void accept(T t)](#consumer-void-acceptt-t)
    - [Supplier: T get()](#supplier-t-get)
    - [Comparator:  int compare(T o1, T o2)](#comparator--int-comparet-o1-t-o2)

# Chapter06 Lambdas and Functional Interfaces.
A lambda expression is a short block of code which takes in parameters and returns a value.
Lambda expressions address the bulkiness of anonymous inner classes by converting five lines of code into a single statement
The break and continue keywords are illegal at the top level, but are permitted within loops. If the body produces a result, every control path must return something or throw an exception.
- Find below the lambda syntax rules.
```java

  public static boolean checkMe(Predicate<Integer> p) {
    return p.test(25);
  }

  CheckMe(i -> i == 5*5));//paranthese around the  parameter list may be omitted if its single parameter
  CheckMe((Integer i) -> i == 5*5)); //return not required when no {} around the body
  CheckMe((Integer i) -> {return i == 5*5);}); // Return must in enclosed body.
  CheckMe((i) -> {return i == 5*5);});
  //Autoboxing does not work when inferring predicates.
  CheckMe((int i) -> {return i == 5*5);});  //Does work
```
- Examples.
```java
(int x, int y) -> x + y

() -> 42

(String s) -> { System.out.println(s); }

```
- Comparator replace with Lambda
```java
  // Sort with Inner Class
17     Collections.sort(personList, new Comparator<Person>(){
18       public int compare(Person p1, Person p2){
19         return p1.getSurName().compareTo(p2.getSurName());
20       }
21     });

 Collections.sort(personList, (p1,  p2) -> p2.getSurName().compareTo(p1.getSurName()));
```

## Functional Interfaces
- A functional interface has only one abstract method.
- In some classes its mentioned @FunctionalInterface, irrespective whether this annotation is there or not, if an ibterface  has only one abstract method then its called Functional Interface.
- There are four functional interfaces you are likely to see on the exam. The next sections take a look at Predicate, Consumer, Supplier, and Comparator.
### Predicate boolean:test(T t)
 * Its a functional interface representing a single argument function returns boolean and takes any type. 
    
     ```java
      public interface Predicate<T> {
        boolean test(T t);
      }
     ```
  *  Java lambda expression simplifies the creation of Java Predicates. 
### Consumer: void accept(T t)

    Consumer<String> consumer = x -> System.out.println(x);

### Supplier: T get()

      1.  returns 42 each time the lambda is called.
      2.  returns random number each time it is called.   

  ```java
    Supplier<Integer> number = () ->  42;

    Supplier<Integer> random = () ->  new Random().nextInt();

    private static int returnNumber(Supplier<Integer> supplier) {
    return supplier.get();
    }
  ```
### Comparator:  int compare(T o1, T o2)
  - Comparator<Integer> ints = (i1, i2) -> i1 - i2;
  - Comparing in descending order
   ```java
   Comparator<String> strings = (s1, s2) -> s2.compareTo(s1);
   Comparator<String> moreStrings = (s1, s2) -> - s1.compareTo(s2);
   ```
  - Local Variables inside the Lambda Body
   (a, b) -> { int c = 0; return 5;} // local variable c is scoped to the lambda block.
There are three compile error the below code
```java
    public void variables(int a) {
    int b = 1;
    Predicate<Integer> p1 = a -> {
        int b = 0;
        int c = 0;
        return b == c;}
    }
```
* correct one. 
```java
public void variables(int a) {
       final int b = 1;
       Predicate<Integer> p1 = k -> {
            //int b = 0; variable b is already declared
            //b = 0;  local variables referenced from a lambda expression must be final or effectively final
            int   c = 0;
             return b == c;};
}
```
- Variables Referenced from the Lambda Body
  - lambda can access an instance variable, method parameter, or local variable under certain conditions. Instance variables (and class variables) are always allowed.
  - Method parameters and local variables are allowed to be referenced if they are effectively final. 
  - Variable type	Rule
    Instance variable	Allowed
    Static variable	Allowed
    Local variable	Allowed if effectively final
    Method parameter	Allowed if effectively final
    Lambda parameter	Allowed
 - Calling APIs with Lambdas
   1. List and set declare a `removeIf()` method that takes predicate. 
    ```java
        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        bunnies.removeIf(s -> s.charAt(0) != 'h');
        System.out.println(bunnies);  // [hoppy]
    ```
   2. `sort()`
       bunnies.sort((a,b) -> a.compareTo(b)); //[floppy, hoppy, long ear]
   3. `forEach()` It takes a Consumer and calls that lambda for each element encountered.  
       `bunnies.forEach(b -> System.out.println(b));`    
   4. BiConsumer like consumer but takes two parameters
        ```java
            Map<String, Integer> bunnies = new HashMap<>();
                bunnies.put("long ear", 3);
                bunnies.put("floppy", 8);
                bunnies.put("hoppy", 1);
                bunnies.forEach((k, v) -> System.out.println(k + " " + v));
        ```

  1. A
  2. C      
  3. A, C, D, F/ C wrong.
   ```java
   //commented throws compile error
      List<String> list = new ArrayList();
    list.add("");
    list.add("123");
    list.removeIf(s -> s.isEmpty());
    //  list.removeIf(s -> {s.isEmpty()});
    //   list.removeIf( s -> { s.isEmpty();});
    list.removeIf(s -> {return s.isEmpty();});
    //   list.removeIf(String s -> s.isEmpty());
    list.removeIf((String s) -> s.isEmpty());
   ```
  4. A,  F
  5. A, B, D, F/ A&F wrong
```java
   Which of the following lambda expressions can be passed to a function of Predicate<String> type? (Choose all that apply.)

 A.   () -> s.isEmpty()
 B.   s -> s.isEmpty()
 C.   String s -> s.isEmpty()
 D.   (String s) -> s.isEmpty()
 E.   (s1) -> s.isEmpty()
 F.   (s1, s2) -> s1.isEmpty()

**uses braces around the body. This means the return keyword and semicolon are required**

 //A & F incorrect parameter atleast one parameter. C missing paramtheses for single argument (String s). E param name mistmatch with actual impl s1 != s
```
  6. E
  7. A, B, E, F
  8. A, F/ C missed (careless)
  9.  C/ A, B missed (scope of variables inside lambda expression)
  10. C
  11. B/ A (Careless) UpperCase is stored before lowercase so [Olivia, leo] `cats.sort((c1, c2) -> -c1.compareTo(c2));` since there is - answer [leo, Olivia]
  12. C,E, F/ CDE
```java
     _______________ first = () -> Set.of(1.23);
  _______________ second = x -> true;

A) Consumer<Set<Double>> //consumer take params
B) Consumer<Set<Float>> //consumer take params
C) Predicate<Set<Double>> //second line predicate returning boolean
D) Predicate<Set<Float>> //second line 
E) Supplier<Set<Double>>// First returning double(Autoboxed)
Supplier<Set<Float>>
```
  13. A/E // `Supplier<Integer> supplier = () -> length; ` compiles.
  14. E/C
  15. A/C
  16. A, D
  17. A/C (Lambda using braces around the body missing return and semicolon;)
```java
 import java.util.function.*;
 public class Panda {
    int age;
    public static void main(String[] args) {
       Panda p1 = new Panda();
       p1.age = 1;
       check(p1, p -> {p.age < 5});
    }
    private static void check(Panda panda,
       Predicate<Panda> pred) {
       String result = pred.test(panda)
          ? "match" : "not match";
       System.out.print(result);
 } }
```
  18. C/D
   **Lambda parameters are not allowed to use the same name as another variable in the same scope.**
```java
  s.forEach(s -> System.out.println(s));
  x.forEach(x -> System.out.println(x));
```
  19. A, C
  20. A, C, E/ E wrong (care less)
  ```java
  Which of the following lambda expressions can be passed to a function of Predicate<String> type
  (StringBuilder s) -> s.isEmpty()
  ```