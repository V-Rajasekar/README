- [Chapter06 Lambdas and Functional Interfaces](#chapter06-lambdas-and-functional-interfaces)
  - [Functional Interfaces](#functional-interfaces)
    - [Predicate boolean:test(T t)](#predicate-booleantestt-t)
    - [Consumer: void accept(T t)](#consumer-void-acceptt-t)
    - [Supplier: T get()](#supplier-t-get)
    - [Comparator:  int compare(T o1, T o2)](#comparator--int-comparet-o1-t-o2)
  - [Exercise](#exercise)
  
# Chapter06 Lambdas and Functional Interfaces

- A lambda expression is a short block of code which takes in parameters and returns a value.
- Lambda expressions address the bulkiness of anonymous inner classes by converting five lines of code into a single statement 
- The break and continue keywords are illegal at the top level, but are permitted within loops. If the body produces a result, every control path must return something or throw an exception.

- Find below the lambda syntax rules.
<p>
  Lambda expressions in Java are a concise way to represent anonymous functions – functions without a name, which can be passed around as if they were objects and executed on demand. Lambda expressions were introduced in Java 8 to provide a more functional approach to programming. Here are the key rules for using lambda expressions in Java:

Syntax: The syntax for a lambda expression in Java is as follows:

```
(parameters) -> expression
or
(parameters) -> { statements; }
```
Parameters: Lambda expressions can take zero or more parameters. If there's only one parameter, you can omit the parentheses. If there are no parameters, you still need to include empty parentheses (). For example:

```java

() -> System.out.println("Hello");
(int x, int y) -> x + y;
x -> x * x;
```
Body: The body of a lambda expression can consist of a single expression or a block of code (enclosed in curly braces {}). If the body contains a single expression, the return value of the lambda is the result of that expression. If the body is a block of code, you must explicitly use a return statement if the block computes a value to return. For example:

```java

() -> System.out.println("Hello"); // Single expression body
```
(int x, int y) -> { return x + y; } // Block body
Type Inference: In many cases, the types of parameters can be inferred by the compiler, so you don't need to specify them explicitly. However, in some cases, you might need to specify the types explicitly. For example:

```java
(String s) -> System.out.println(s);
```
Functional Interfaces: Lambda expressions can only be used where the type they're being assigned to is a functional interface. A functional interface is an interface with a single abstract method. For example:


```java
interface MyInterface {
    void myMethod();
}
```

MyInterface myLambda = () -> System.out.println("My Method");
Effectively Final Variables: Lambda expressions can access local variables of the enclosing scope, but those variables must be effectively final, meaning their value should not change after initialization. This is because lambda expressions capture the value of variables, not the variable itself.

Exceptions: Lambda expressions can throw checked exceptions, but they must be declared in the functional interface's abstract method. Alternatively, you can handle the exceptions within the lambda expression itself.

Lambda expressions provide a concise and expressive way to represent simple behavior in Java, especially when working with collections, streams, and functional interfaces. They are a fundamental part of modern Java programming, enabling more functional and declarative coding styles.
</p>

```java

  public static boolean checkMe(Predicate<Integer> p) {
    return p.test(25);
  }

  CheckMe(i -> i == 5*5));//paranthese around the  parameter list may be omitted if its single parameter
  CheckMe((Integer i) -> i == 5*5)); //return not required when no {} around the body
  CheckMe((Integer i) -> {return i == 5*5);}); // Return must in enclosed body.
  CheckMe((i) -> {return i == 5*5);});
  checkMe((i) -> i == 25));
  //Autoboxing does not work when inferring predicates.
  CheckMe((int i) -> {return i == 5*5);});  //Does work
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
- In some classes its mentioned `@FunctionalInterface`, irrespective whether this annotation is there or not, if an interface  has only one abstract method then its called Functional Interface.
- There are four functional interfaces you are likely to see on the exam. The next sections take a look at ***Predicate, Consumer, Supplier, and Comparator***.

### Predicate boolean:test(T t)

- Its a functional interface representing a single argument function returns boolean and takes any type.

     ```java
      public interface Predicate<T> {
        boolean test(T t);
      }
     ```

- Java lambda expression simplifies the creation of Java Predicates.

### Consumer: void accept(T t)

   `Consumer<String> consumer = x -> System.out.println(x);`

### Supplier: T get()

  ```java
    //returns 42 each time is called 
    Supplier<Integer> number = () ->  42;

  //returns random number each time called.
    Supplier<Integer> random = () ->  new Random().nextInt();

    private static int returnNumber(Supplier<Integer> supplier) {
    return supplier.get();
    }
  ```

### Comparator:  int compare(T o1, T o2)

- `Comparator<Integer> ints = (i1, i2) -> i1 - i2;`
- Comparing in descending order

   ```java
   List<String> fruits = Arrays.asList(new String[]{"mango", "banana", "apple"});
    Collections.sort(fruits, (s1, s2) -> s1.compareTo(s2));// fruits ==> [apple, banana, mango]
       or
    Collections.sort(fruits, String::compareTo);
    Comparator<String> moreStrings = (s1, s2) -> - s2.compareTo(s1); //descending
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

- correct one.

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
  - Variable type Rule
    - Instance variable Allowed
    - Static variable Allowed
    - Local variable Allowed if effectively final
    - Method parameter Allowed if effectively final
    - Lambda parameter Allowed
    - Lambda parameters are not allowed to use the same name as another variable in the same scope. `s.forEach(s -> System.out.println(s));`
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

## Exercise

  1. A
  2. C
  3. A, C, D, F/ C wrong.

  ```java
  //commented throws compile error
    List<String> list = new ArrayList();
  list.add("");
  list.add("123");
  list.removeIf(s -> s.isEmpty());
  //  list.removeIf(s -> {s.isEmpty()}); //missing return
  //   list.removeIf( s -> { s.isEmpty();}); //missing return
  list.removeIf(s -> {return s.isEmpty();});
  //   list.removeIf(String s -> s.isEmpty());
  list.removeIf((String s) -> s.isEmpty());
  ```

  4. A,F
   `(e) -> { String e = ""; return "Poof"; } //compile error e is reused`
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

  6. E code in lambda compiles and var represents the corresponding type in the method DCL
   ```java
    public void method() {
      x((var x) -> {}, (var x, var y) -> 0);
    }
    public void x(Consumer<String> x, Comparator<Boolean> y) {
    }
   ```
  7. A, B, E, F
   ```java
    Map map = Map.of(1, 2, 3, 4);
    //only map compile error allowed: list, set, keySet->k and values -> value
    map.values()/keySet().forEach(x -> System.out.println(x)); 
   ```
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

  13. A/E // `Supplier<Integer> supplier = () -> length;` compiles.
  14. E/C
     ```java
   //compiles char c, start = '1' or end = '1' doesn't compiles
   public void remove(List<Character> chars) {
     char end = 'z';
    chars = null;
     chars.removeIf(c -> {
        char start = 'a'; return start <= c && c <= end; });
  }
  ```
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
Set<String> s = Set.of("mickey", "minnie");
List<String> x = new ArrayList<>(s);
s.forEach(s -> System.out.println(s));
x.forEach(x -> System.out.println(x));
```

  19. A, C
  20. A, C, E/ E wrong (care less)

  ```java
  Which of the following lambda expressions can be passed to a function of Predicate<String> type
  (StringBuilder s) -> s.isEmpty()
  ```
