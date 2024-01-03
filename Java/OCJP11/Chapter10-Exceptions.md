# Chapter 10: Exceptions
- Exception hierarchy
  
    
```
    java.lang.Throwable 
              |
     Exception  Error     
         |
 Checked, UnChecked(RunTime exceptiom)     
``` 
- Checked Exceptions
`A checked exception is an exception that must be declared or handled by the application code where it is thrown. In Java, all checked exceptions inherit Exception `

- Unchecked Exceptions
<p>An unchecked exception is any exception that does not need to be declared or handled by the application code where it is thrown. Unchecked exceptions are often referred to as runtime exceptions, although in Java, unchecked exceptions include any class that inherits RuntimeException or Error.</p>

```java
//This code throws an ArrayIndexOutOfBoundException as there is no elements added at position 0 
String[] animals = new String[0];
System.out.println(animals[0]);
```
- Throw vs Throws
  * throw when you throw a newer or catched exception inside a method
  * throws used in the method declarations.

- **RuntimeException** classes you should know for the exam include the following:

* ArithmeticException
* ArrayIndexOutOfBoundsException
* ClassCastException
* IllegalArgumentException
* NullPointerException
* NumberFormatException
  
- IllegalArgumentException is typically thrown by the programmer, whereas the others are typically thrown by the standard Java library.
_Note:_ **NumberFormatException extends IllegalArgumentException**

- **Checked Exception** classes you should know for the exam include the following:
* IOException
* FileNotFoundException
_Note:_ **FileNotFoundException extends IOException**
 * 
- **Error**  classes
   Errors are unchecked exceptions that extend the Error class. They are thrown by the JVM and should not be handled or declared. Errors are rare, but you might see these:</p>

    **ExceptionInInitializerError** Thrown when a static initializer throws an exception and doesn’t handle it<br>

    **StackOverflowError** Thrown when a method calls itself too many times (This is called infinite recursion because the method typically calls itself without end.)<br>

    **NoClassDefFoundError** Thrown when a class that the code uses is available at compile time but not runtime<br>

    **ExceptionInInitializerError**
    Java runs static initializers the first time a class is used. If one of the static initializers throws an exception, Java can’t start using the class. It declares defeat by throwing an ExceptionInInitializerError. This code throws an ArrayIndexOutOfBounds in a static initializer:<br>

    ```java
    static {
    int[] countsOfMoose = new int[3];
    int num = countsOfMoose[-1];
    }
    public static void main(String... args) { }
    ```
- Handling Exception
  * Using try and Catch Statements
  * some Invalid try catch block
    1. try and catch block without curly braces {}
    2. try block without throwing checked exception and catch block catching a checked exception.
  * Legal to have empty try, catch with (RuntimeException or Exception), finally block.
  * Subclass exception should be top level than the super class in the catch chain.
  * Multi-Catch Block
    ```java
        public static void main(String[] args) {
        try {
            System.out.println(Integer.parseInt(args[1]));    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {

            System.out.println("Missing or invalid input");
        }
      } 

      catch(Exception1 e | Exception2 e | Exception3 e) // DOES NOT COMPILE
      
      catch(Exception1 e1 | Exception2 e2 | Exception3 e3) // DOES NOT COMPILE
      
      catch(Exception1 | Exception2 | Exception3 e)

      The first line is incorrect because the variable name appears three times. Just because it happens to be the same variable name doesn't make it okay.
    ```
- Multi catch block follows similarrules as chaining catch blocks. The difference between multi catch block and chaining block is the order doesn't matter in multi catch block.
   ```java
    try {
          throw new IOException();
    } catch (FileNotFoundException | IOException p) {} // DOES NOT COMPILE

    correct code is only catch (IOException p)
   ```
- Adding a finally Block
  * catch block is optional when finally is used 
  * finally block always executes, whether or not an exception occurs.
  * If an exception is thrown finally is run after catch block, if no exception runs after the try block.
  * finally block is the last statement in the program execution,so the method return will be -3
    ```java
    12: int goHome() {
    13:    try {
    14:       // Optionally throw an exception here
    15:       System.out.print("1");
    16:       return -1;
    17:    } catch (Exception e) {
    18:       System.out.print("2");
    19:       return -2;
    20:    } finally {
    21:       System.out.print("3");
    22:       return -3;
    23:    }
    24: }
    ```
    * finally block execution exception case System.exit();
    ```java
      try {
      System.exit(0); // tells java, stop, End the program right now.
    } finally {
      System.out.print("Never going to get here");  // Not printed
    }
    ```
- Finally Closing Resources (_try-with-resources_)
  * the compiler replaces a try-with-resources block with a try and finally block. 
  you can create a programmer defined finally block when using try-with-resources statement, how implicit one called first
  * Multiple resources can be mentioned in try with resources block separated by ;. **The resources opened are closed in the reverse order.**
  * Implicit finally block runs before any programmer-coded ones.
  * Random class is not allowed in a try-with-resources statement, java requires classed used in a try-with-resources implement the AutoCloseable interface, which includes a void close() method.
  * A try with resource doesn't support multiple variable dcl in a single statement, you should declare each variables in separate statement separated by (;).
  * Does the try with resources guarantee a resource will be closed ? no it guaranteed to call the close() method o the resource.

  ```java
  4:  public void readFile(String file) {
  5:     try (FileInputStream is = new FileInputStream("myfile.txt");
  FileOutputStream out = new FileOutputStream("output.txt");) {
  6:        // Read file data
  7:     } catch (IOException e) {
  8:        e.printStackTrace();
  9:     }
  10: }
  ```
- Catch block is optional in try-with-resources
  ```java
  4: public void readFile(String file) throws IOException {
  5:    try (FileInputStream is = new FileInputStream("myfile.txt")) {
  6:       // Read file data
  7:    }
  8: }
  ```
- Scope of Try-with-Resources.
  * The implicit close has run already, and the resource is no longer available. Do you see why lines 6 and 8 don’t compile in this
   * scanner scope has gone out once try block is executed.
   
    ```java
    3: try (Scanner s = new Scanner(System.in)) {
    4:    s.nextLine();
    5: } catch(Exception e) {
    6:    s.nextInt(); // DOES NOT COMPILE
    7: } finally {
    8:    s.nextInt(); // DOES NOT COMPILE
    9: }
  ```

- Throwing Addition Exception
   * You can throw multiple exception in catch or finally block.
    ```java
    26: try {
    27:    throw new RuntimeException();
    28: } catch (RuntimeException e) {
    29:    throw new RuntimeException();
    30: } finally {
    31:    throw new Exception();
    32: }
    ```
- Calling Methods That Throw Exceptions
   * noticed that eatCarrot() didn’t actually throw an exception; it just declared that it could. This is enough for the compiler to require the caller to handle or declare the exception.
```java
  class NoMoreCarrotsException extends Exception {}
public class Bunny {
   public static void main(String[] args) {
      eatCarrot(); // DOES NOT COMPILE
   }
   private static void eatCarrot() throws NoMoreCarrotsException {
   }
}
```
- Similary when the method is not throwing the checked exception and its handled it in the calling end then also it will not compile.
 
```java
public class Bunny {
   public static void main(String[] args) {
    try {
        eatCarrot();
    } catch (NoMoreCarrotsException e ) { // DOES NOT COMPILE
        System.out.print("sad rabbit");
    }
   }

   private static void eatCarrot()  {
   }
}
```
- Declaring and Overriding Methods with Exceptions.
  - Subclass cannot introduce newer are broader exception in the method override.
  - However, subclass can introduce specific check exception meaning
  (i.e) super class method throws `IOException` and Subclass method throws `FileNotFoundException`.
  - Overridden method in a subclass is allowed to declare fewer exceptions than the superclass or interface. This is legal because callers are already handling them.
  - Subclass can throw UnCheckedException
  
  ```java
    class Hopper {
    public void hop() { }
    }
    class Bunny extends Hopper {
      public void hop() throws IllegalStateException { } //Allowed
    }
  ```
- Printing an Exception
  
```java
    catch (Exception e) {
    9:        System.out.println(e);
    10:       System.out.println(e.getMessage());
    11:       e.printStackTrace();
    12:    }
    //Output 
   9:  java.lang.RuntimeException: cannot hop
   10: cannot hop
   11: java.lang.RuntimeException: cannot hop
        at Handling.hop(Handling.java:15)
        at Handling.main(Handling.java:7)
```

## Review Questions

1. 1, 2, 3, 6 correct: ACDF, ABCF 
  a.  `you can handle java.lang.Error subclasses, which are not subclasses of Exception`
  b.  `all exceptions are subclasses of Throwable`
2. 2, 4, ~~6~~ (BDE)
3. ~~. 1,2, 4, 6~~ (G)
    //careless When using a multi-catch block, only one variable can be declared
4. 2, 4  correct
5. ~~3, 5~~ (C) stop providing options as and when the exception is thrown in a place.
6. ~~4~~ (E) Missed exception using same reference variable name.
7. 3
8. AEC 7
9.  5
10. 2
11. 1245 (4)
12. 12 (1)
13. ~~4,6~~ (ABCDF)
  * You can declare a method with Exception as the return type.
  * You can declare a method with RuntimeException as the return type.
  * You can declare any subclass of Error in the throws part of a method declaration.
  * You can declare any subclass of Exception in the throws part of a method declaration.
  * You can declare any subclass of RuntimeException in the throws part of a method declaration
14. 4 A,C,D,E
  
```java
  7: public void whatHappensNext() throws IOException {
  8:    // INSERT CODE HERE
  9: }  
  a.  System.out.println("it's ok");
  b. throw new Exception(); //broader exception can't be thrown 
  c. throw new IllegalArgumentException(); //Unchecked exception allowed
  d. throw new java.io.IOException(); // Exact match allowed.
  e. throw new RuntimeException(); //Unchecked exception allowed
```
15. 7
16. 1, 2, 3, 5, 7 (ABDEF)
17. ~~6~~ B,F `Error is an uncheched exception,so it can be thrown, eventhough it is not a good practise`
   ```java
   void rollOut() throws ClassCastException {}
   
    public void transform(String c) {
     try {
        rollOut();
     } catch (IllegalArgumentException | _______________) {
     }
  }
   ```
18. 1, 2 (only B)  `An element is not found when searching a list. not a scenario for throwing exception.`
19. 1, 2, 3, 4, (A,D,E,F)
```java
  class HasSoreThroatException extends Exception {}
  class TiredException extends RuntimeException {}
  interface Roar {
  void roar() throws HasSoreThroatException;
  }
  class Lion implements Roar {
  // INSERT CODE HERE
  }
public void roar() {} // ALLOWED
public int roar() throws RuntimeException {}  // NOT ALLOWED wrong return type int
public void roar() throws Exception {} // NOT ALLOWED Broader exception
public void roar() throws HasSoreThroatException {}  // ALLOWED
public void roar() throws IllegalArgumentException {} //ALLOWED Uncheck exception
public void roar() throws TiredException {} // ALLOWED UncheckedException
```
20. 2, 3, 5
21. 7
22. ~~2~~, 4, 5 D, F
```java
  public void dontFail() {
     try {
        System.out.println("work real hard");
     } catch (_________ e) {
     } catch (RuntimeException e) {}
  }

Exception // Not allowed Broader exception
IOException // Not allowed checked exception is not thrown inside the block.
IllegalArgumentException // Allowed
RuntimeException // Duplicate NOT ALLOWED
StackOverflowError // Allowed
```
23. 1 (1,5) Careless finally can throw exception
24. 2 OKLI **Remember that a try-with-resources statement executes the resource’s close() method before a programmer-defined finally block**
```java
  1:  public class MoreHelp {
  2:     class Sidekick implements AutoCloseable {
  3:        protected String n;
  4:        public Sidekick(String n) { this.n = n; }
  5:        public void close() { System.out.print("L"); }
  6:     } 
  7:     public void requiresAssistance() {
  8:        try (Sidekick is = new Sidekick("Adeline")) {
  9:           System.out.print("O");
  10:       } finally {
  11:          System.out.print("K");
  12:       }
  13:    }
  14:    public static void main(String... league) {
  15:       new MoreHelp().requiresAssistance();
  16:       System.out.print("I");    
  17:    } }
```
25.  4