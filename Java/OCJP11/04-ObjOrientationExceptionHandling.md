## Interface
- A top level interface can be declared with either public or default modifiers.
- @MarkerInterface public interface Printable {} is not allowed in Java
- All variables are implicit `public static final`
- All methods are implict `public abstract`
- Static methods in interface are accessable only using the interface name not even using the reference.
### Interface method rules.
1. Inside interface you can have n number of private, static, private static and default methods from Java 9.
✓  By default test method is public and abstract and it is allowed inside an interface.

default void test(String name) {
    System.out.println("Testing " + name);
} 
✓  As per Java 8, default methods were added in the interface. It is a valid syntax for the default method to be used inside an interface.

static void test(int x) {
    System.out.println(x);
} 
✓  As per Java 8, static methods were added in the interface. It is a valid syntax for the static method to be used inside an interface.

Even if all the above 3 methods [test(), test(String) and test(int)] are available in the same interface, there is no issue at all, it is the case of method overloading.

private default void log1() {}

✗  As per Java 9, private methods were added in the interface, these can be static or non-static but not default.

private void log2() {}

✓  As per Java 9, private methods were added in the interface, these can be static or non-static.

private static void log3() {}

✓  As per Java 9, private methods were added in the interface, these can be static or non-static.

### Interface default methods
default keyword for method is allowed only inside the interface and default methods are implicitly public. So overriding method should use public modifier and shouldn't use default keyword.

If you want to invoke the default method implementation from the overriding method, then the correct syntax is: [Interface_name].super.[default_method_name].

```java
public interface Profitable1 {
    default double profit() {
            return 12.5;
    }
}
public interface Profitable2 {
    default double profit() {
            return 25.5;
    }
}
public abstract class Profit implements Profitable1, Profitable2 {
    public double profit() {
      return Profitable1.super.profit();
    }
}

public class BusinessProfile implements Profitable2, Profitable1 {
}

BusinessProfile bp = new BusinessProfile();
bp.profit();// prints 25.5
```
### Interface overridden method.
  
<p>Abstract class Animal has non-abstract method move() and it is declared with no modifier (package scope). Abstract class in java can have 0 or more abstract methods. Hence Animal class compiles successfully.
</p>
 
```java 
public interface Moveable {
    void move(); //default its public abstract
}

//Animal.java

public abstract class Animal {
   public void move() { //It has overridden with public modifier, missing it is not overridding.
        System.out.println("ANIMAL MOVING");
    }
}
//Dog.java
public class Dog extends Animal implements Moveable {}// non public move method in class Animal will cause compile error
```
### Interface static method
The scope of the static method in an interface is within the interface it can be accessable only with the interface name.
```java
interface M {
    public static void log() {sout("M");}
     default void log() {
        System.out.println("ILog");
    }
}

abstract class Log {
    public static void log() { 
        System.out.println("Log");
    }
}


class MImpl extends Log, implements M {
    public static void log() {sout("M");}
}

/* MyLogger class has instance method log() [inherited from ILog interface] and static method log() [from Log class] and this causes conflict. Static and non-static methods with same signature are not allowed in one scope, therefore class MyLogger fails to compile.*/

M mobj = new MImpl();
mobj.log(); //cause compile error
```

```java
class Animal {}
class Horse extends Animal implements Rideable {
        public void ride(String name) {
                System.out.println(name.toUpperCase() + " IS RIDING THE HORSE");
        }
}
  Animal horse = new Horse();
((Horse)horse).ride("emma");
```
- **An interface in java can implement the abstract method of super type with default modifier.**

```java  
    interface X1 {
        default void print() {
            System.out.println("X1");
        }
    }
 
    interface X2 extends X1 {
        void print(); //Interface X2 extends X1 and it overrides the default method print() of X1
    }
    
    interface X3 extends X2 {
        default void print() { //implements the abstract method print() of X2, overriding method in X3 is default and implicitly public. 
            System.out.println("X3");
        }
    }
```
### Interface Array

```java  
    public interface Counter {
    int count = 10; //Line n1
    void count();
    }
    Counter [] arr = new Counter[2]; //Line n2 valid array of type Counter
    for(Counter ctr : arr) {
        System.out.print(ctr.count); //Line n3 prints 10
        ctr.count();// NPE
    }
```
### Interface static method
```java
  interface I1 {
    public static void print(String str) {
        System.out.println("I1:" + str.toUpperCase());
    }

     default String getType() {
        return "TEXT";
    }
}

interface WordDocument extends I1 {
    String getType();
}

class Word implements WordDocument {}
 
class C1 implements I1 {
    void print(String str) {
        System.out.println("C1:" + str.toLowerCase());
    }
}
 
public class Test {
    public static void main(String[] args) {
        I1 obj = new C1(); 
        obj.print("Java");//compile error as print static method is accessable via I1.
        I1 doc = new Word(); //Line n1
        System.out.println(doc.getType()); //Line n2 compile error abstract method
    }
}
```
## FunctionalInterface.
<p>
Comparator has only one non-overriding abstract method, compare. Runnable has only one non-overriding abstract method, run.

ActionListener has only one non-overriding abstract method, actionPerformed. Serializable and Cloneable are marker interfaces.</p>

## Enums
- An enum Directions contains more code after constant declarations, the last constant declaration must be followed by a semicolon.
- Enum constructor is invoked once for every constant 
- Using 'public' or 'protected' for enum constructors is not allowed. Enum constructors are implict private.
- Enum constant names must be unique, duplicate cause compile error.
- case labels accept unqualified names of enum constants.  meaning TrafficLight.RED is not allowed, but only RED allowed.
- Java enums cannot extend from another class or enum but an enum can implement interfaces. All java enums implicitly extend from java.lang.Enum class and not from java.util.Enum class.
- Enum constant list must be the first item in an enum.

  ```java
  enum Directions {
        NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
 
        private String notation;
        Directions(String notation) {
            sout("Hello");
            this.notation = notation;
        }
     }
     Directions dir = new Directions(); //compile error enum types may not be instantiated
     Directions.NORTH; // Hello printed 4 times for each Enum declarations.
 ```
- Enums Siblings cannot be compared using double equals operator (==). cause compile error.

```java
    enum JobStatus {
            SUCCESS, FAIL; //Line n1
    }
        
    enum TestResult {
            PASS, FAIL; //Line n2
    }

    JobStatus js = JobStatus.FAIL;
    TestResult tr = TestResult.FAIL;
    js.equals(tr);//false
    js == tr;
```
- Enum doesn't support clone. It throws compile error

## Exception

Throwable is the root class of the exception hierarchy and it contains some useful constructors:
<p>
1. public Throwable() {...} : No-argument constructor

2. public Throwable(String message) {...} : Pass the detail message

3. public Throwable(String message, Throwable cause) {...} : Pass the detail message and the cause

4. public Throwable(Throwable cause) {...} : Pass the cause

Exception and RuntimeException classes also provide similar constructors.

Hence all 3 statements Line n1, Line n2 and Line n3 compile successfully.

Throwable class also contains methods, which are inherited by all the subclasses (Exception, RuntimeException etc.)

1. public String getMessage() {...} : Returns the detail message (E.g. detail message set by 2nd and 3rd constructor)

2. public String toString() {} :

Returns a short description of this throwable. The result is the concatenation of:

the name of the class of this object

": " (a colon and a space)

the result of invoking this object's getLocalizedMessage() method

If getLocalizedMessage returns null, then just the class name is returned.
</p>
- If finally block throws exception, then exception thrown by try or catch block is ignored.
- catch(MyException e1 | YourException e2) wrong syntax only one variable ref is allowed
- catch(MyException | YourException e) {e = null} variable e used in multi catch block is final it cannot be reassigned with null.
- 
- Error

```java
Error obj = new Error();
boolean flag1 = obj instanceof RuntimeException; //Line n1 compilation error
boolean flag2 = obj instanceof Exception; //Line n2 compilation error
boolean flag3 = obj instanceof Error; //Line n3 true
boolean flag4 = obj instanceof Throwable; //Line n4 true
```
### Checked exceptions:

- Java doesn't allow to throw checked exception if the try block is not throwing one.
- All checked exception should be handled using relevant catch Exception or throws Exception at the method level. Failing so will cause compile error.
```java
 try {
            System.out.println(args[1].length());
    } catch (RuntimeException ex) {
        System.out.println("ONE");
    } catch (FileNotFoundException ex) { //compile error
        System.out.println("TWO");
    }
//Unhandled compile error
 public static void main(String [] args) {
      try {
           throw new Exception(); //unhandled exception compile error
        } finally {
            System.out.println("GAME ON");
        }
 }
```    

### RuntimeException: 
- Infinite loops, results runtime OOM exception
for(;;) {
    sout("Hello");
}
- ArithmeticExceptionMethod 
  - main(String []) doesn't handle ArithmeticException so it forwards it to JVM, but just before that, finally block is executed. This prints FINALLY on to the console.

    After that JVM prints the stack trace and terminates the program abruptly.printstack trace after FINALLY is printed
  ```java
  try {
    Test test = new Test();
    1/0;
  }  finally {
    System.out.println("FINALLY");
  }
 ``` 

### MultiCatch

- NullPointerException extends RuntimeException and in multi-catch syntax we can't specify multiple Exceptions related to each other in multilevel inheritance.

```java
    try {
        System.out.println(s.length());
    } catch(NullPointerException | RuntimeException ex) { //compile error
        System.out.println("DONE");
    }

    catch(SQLException | Exception ex) {}: ✗ Causes compilation error as SQLException extends Exception.

    catch(IOException | FileNotFoundException ex) {}: ✗ Causes compilation error as FileNotFoundException extends IOException.

    catch(IllegalArgumentException | RuntimeException | Exception e) //Causes compilation error
```
- Method with throw Exception inside the code block must handle the exception using catch block or that Exception must be declared in the method level.
- This is still ArithmeticException
```java
 try {
 try {
     5/0;
   }
   catch(ArithmeticException e) {
            throw (RuntimeException)e;
        }
    }
  } catch(ArithmeticException e) {
        print("ArithmeticException"); //This one is printed
  } catch (RuntimeException e) {

  }
  ```
- Exception initialization inside the catch block is not allowed

```java  
  } catch (Exception e) {
            e = new SQLException(); //compile error
            throw e;
        }

    } catch (Exception e) {
            e = null; //Line n1 compiles
            throw e; //Line n2 compilation error
        }      

    catch (Exception e) {
            throw null; //Line n1 compiles, but later program ends with NPE
        }    
```        
- If a method declares to throw Exception or its sub-type other than RuntimeException types, then calling method should follow handle or declare rule.
```java
   public static void main(String[] args) {
        check(); //Line n1 compilation error.
    }
    
    private static void check() throws Exception { //Line n2
        System.out.println("NOT THROWING ANY EXCEPTION"); //Line n3
    }
```    
- Calling code should always handle the broader exception declared in the method
  , no narrow exception is accepted.
  ```java 
    public void print() throws IOException {
        throw new FileNotFoundException();
    }

    try {
        b.print(); //compile error IOException must be handled
    } catch (FileNotFoundException e) {
        System.out.print("AWE");
    } //missing IOException handling.
  ```
## Exception throw in overridden methods
<p>
According to overriding rules, if super class / interface method declares to throw a checked exception, then overriding method of sub class / implementer class has following options:

1. May not declare to throw any checked exception.

2. May declare to throw the same checked exception thrown by super class / interface method.

3. May declare to throw the sub class of the exception thrown by super class / interface method.

4. Cannot declare to throw the super class of the exception thrown by super class / interface method.

5. Cannot declare to throw unrelated checked exception.

6. May declare to throw any RuntimeException or Error.
</p>

```java
abstract class Super {
    public abstract void m1() throws FileNotFoundException;
}
 
class Sub extends Super {
    
    public void m1() throws IOException {
        throw new IOException();
    }
}  
```
- `return` statement in try and catch (Unreachable code)
  
 If return; statement was present in both try and catch block or finally-block, then unreachable code compilation error would have caused by the last statement in the method.

  If line n1 is not present then compile and prints ex.message, Match Abandoned, DONE

    ```java
        try {
                play();
                return;
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
                return; //n1 if not presents 
            } finally {
                System.out.println("MATCH ABANDONED");
            }
            System.out.println("DONE"); //unreachable code
    ```    
- What is the output of the below program?

    ```java
        public static void main(String[] args) {
            try {
                find();
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    
        static void find() throws Exception {
            try {
                System.out.print(1);
                throw new FileNotFoundException("FNF");
            } catch(FileNotFoundException ex) {
                System.out.print(2);
                throw new IOException("IO");
            } catch(IOException ex) {
                System.out.print(3);
                throw new Exception("EXP");
            } finally {
                System.out.print(4);
                throw new Exception("FINALLY");
            }
        }
        //prints 124FINALLY
    ```  
- Casting from super to sub class exception results class cast exception
   ```java
      catch(RuntimeException e) {
            System.out.println(1);
            ArithmeticException ex = (ArithmeticException)e;     
   ```        
## Exception handling in Polymorphism/Overridden method

what are the allowed class in the *INSERT* ? 

```java
 void multiply(int... x) throws SQLException;

  public void multiply(int... x) throws /*INSERT*/ {
  }
```    
**Can:**
1. Can throw same exception dcl in the super class or interface
2. Can throw any subclass in this case SQLWarning
3. Can throw RuntimeException, or any type of runtimeException NPE
4. Can throw Error
**Cannot:**
1. Cannot throw super class (Exception, or Throwable)
2. Cannot throw unrelated checked exception

## Exception handling in calling

```java
 interface Printer {
    default void print() throws FileNotFoundException {
        System.out.println("PRINTER");
    }
}
 
class FilePrinter implements Printer {
    public void print() { //Line n1
        System.out.println("FILE PRINTER");
    }
}

 public static void main(String[] args) {
    Printer p = new FilePrinter();
    p.print(); //cause compile error as FileNotFoundException is not handled.
    ((FilePrinter)p).print()// compiles
    FilePrinter fp = new FilePrinter();
    fp.print(); // compiles fine. As this method doesn't throw any check exception
 }
``` 
## Overridden method can throw any runtime exception
class A{}
class B extends A{}
 
abstract class Super {
    abstract List<A> get() throws IndexOutOfBoundsException;
}
 
abstract class Sub extends Super {
    /*INSERT*/
}

abstract List<A> get() throws ArrayIndexOutOfBoundsException; => ✓ It returns the same return type 'List<A>' and it is allowed to throw any RuntimeException (ArrayIndexOutOfBoundsException is RuntimeException)



abstract List<B> get(); => ✗ List<B> is not subtype of List<A>, it is not covariant return type.

abstract ArrayList<A> get() throws Exception; => ✗ As overridden method declares to throw IndexOutOfBoundsException, which is a Runtime Exception, overriding method is not allowed to declare to throw any checked Exception. Class Exception and its subclasses are checked exceptions.

abstract ArrayList<B> get(); => ✗ ArrayList<B> is not subtype of List<A>, it is not covariant return type.

In generics syntax, Parameterized types are not polymorphic, this means even if B is subtype of A, List<B> is not subtype of List<A>. Remember this point. So below syntaxes are NOT allowed: 

List<A> list = new ArrayList<B>(); OR ArrayList<A> list = new ArrayList<B>();

## Constructor Exception handling behaviour.

It is legal for the constructors to have throws clause.

Constructors are not inherited by the Derived class so there is no method overriding rules related to the constructors but as one constructor invokes other constructors implicitly or explicitly by using this(...) or super(...), hence exception handling becomes interesting.
- super(); invokes the constructor of Super class (which declares to throw RuntimeException), as RuntimeException is unchecked exception, therefore no handling is necessary in the constructor of Sub class.
- super(); invokes the constructor of Parent class (which declares to throw IOException), but as no-argument constructor of Child class declares to throw Exception (super class of IOException), hence IOException is also handled. There is no compilation error
```java
class Base {
    Base() throws IOException { //throw RuntimeException compiles, no issue
        System.out.print(1);
    }
}
 
class Derived extends Base {
    Derived() throws FileNotFoundException {//compile error IOException must be handled. // throws Exception compiles, no issue
        System.out.print(2);
    }
}
```
## Try with resource
1. Resources used in try-with-resources statement are implicitly final, which means they can't be reassigned. fileReader = null; not allowed inside the try block.
2. FileReader, IOStream, BufferReader, all throws IOException and they have to be handled.
3. Resources used in try-with-resources statement must be initialized. //try(PrintWriter writer = null) compile error.
4. Classes used in try-with-resources statement must implement java.lang.AutoCloseable or its sub interfaces such as java.io.Closeable.
5. After the try block execution the resources are closed in the reverseOrder (LIFO)
6. Scope of the IO file reference is within the try block they can't be referenced outside try (e.g)
   ```java
    try(PrintWriter writer = new PrintWriter(System.out)) {
            writer.println("Hello");
        } catch(Exception ex) {
            writer.close();//compilation error
        }

    //prints HELLO
    try(PrintWriter writer = null) {
        System.out.println("HELLO");
    }
    ```
7.  AutoCloseable interface has below close method declaration:

    `void close() throws Exception;` 
    when ever the class implementing the Autocloseable overrides the method with the throws Exception, then the calling method must handle otherwise CompilationError. If throws Exception is left out no compilation error.
8. exception thrown from catch and finally block are supressed, only exception thrown from the try block is notified. To retrieve Suppressed exception use Throwable[]:e.getSuppressed()
    ```java
        class MyResource implements AutoCloseable {
                @Override
                public void close() throws IOException{
                        throw new IOException("IOException"); //Suppressed Exception
                }
            
                public void execute() throws SQLException {
                        throw new SQLException("SQLException");
                }
        }
        public class Test {
                public static void main(String[] args) {
                        try(MyResource resource = new MyResource()) {
                                resource.execute();
                        } catch(Exception e) {
                                System.out.println(e.getMessage()); //SQLException
                            System.out.println(java.util.Arrays.toString(e.getSuppressed()));//[java.io.IOException: IOException]
                        }
                }
        }
    ```
9.  `Resources` are always closes, even in case of exceptions. And in case of multiple resources, these are closed in the reverse order of their declaration. So r2 is closed first and then r1. Output will have 'EC' together.
```java
    try (Resource1 r1 = new Resource1();
        Resource2 r2 = new Resource2()) {
    r1.m1(); //Prints A throws Exception B close method: C
    r2.m2(); //Close method: E
} catch (Exception e) {
    System.out.print(e.getMessage());
}
//Prints AECB A(try print),E (r2 close method),C(r1 close method), B(r1 exception)
```

   