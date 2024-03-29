# Chapter 12 Java Fundamentals (TUFF)

- [Chapter 12 Java Fundamentals (TUFF)](#chapter-12-java-fundamentals-tuff)
    - [Declaring final Local Variables](#declaring-final-local-variables)
    - [Adding final to Instance and static Variables](#adding-final-to-instance-and-static-variables)
    - [Writing final Methods.](#writing-final-methods)
    - [Marking classes final](#marking-classes-final)
    - [Working with Enums](#working-with-enums)
    - [Creating Nested Classes](#creating-nested-classes)
    - [Local class](#local-class)
    - [Defining an Anonymous Class](#defining-an-anonymous-class)
      - [Syntax rules permitted in Nested classes](#syntax-rules-permitted-in-nested-classes)
    - [Understanding Interface  Members](#understanding-interface--members)
      - [Purpose of Default methods:](#purpose-of-default-methods)
    - [Abstract classes vs Interface](#abstract-classes-vs-interface)
    - [Introducing Functional Programming.](#introducing-functional-programming)
    - [Implementing Functional Interfaces with Lambdas](#implementing-functional-interfaces-with-lambdas)
  - [Review questions:](#review-questions)

### Declaring final Local Variables
  * <p> we don't need to assign a value when a final variable is declared. The rule is only that it must be assigned a value before it can be used.</p>

  * Just because a variable reference is marked final does not mean the object associated with it cannot be modified. Consider the following code snippet:
    ```java
    final StringBuilder cobra = new StringBuilder();
    cobra.append("Hssssss");
    cobra.append("Hssssss!!!");
    ```
  **_Note:_** Its not the same case for String literal, and Object.

### Adding final to Instance and static Variables
<p>Instance and static class variables can also be marked final. If an instance variable is marked final, then it must be assigned a value when it is declared or when the object is instantiated. Like a local final variable, it cannot be assigned a value more than once</p>

```java
  
public class PolarBear {
   final int age = 10;
   final int fishEaten;
   final String name;

   final static String name = "Ronda"
 
   static final int bamboo;
   static final double height; // DOES NOT COMPILE
   static { bamboo = 5;}
   static int wood; //static variable can be initialized in instance block, constructor.

   { fishEaten = 10; wood = 20; }
 
   public PolarBear() {
      name = "Robert";
      fishEaten = 20; //Don't compile. since its already intialized in the earlier instance initializer block.
      wood = 10;
   }
   public PolarBear(int height) {
      this();
   }
}
```
### Writing final Methods.
 * Methods marked final cannot be overridden by a subclass.
 * Methods cannot be assigned abstract or final modifier together.
### Marking classes final
 * final class cannot be extended.
 * abstract and interface cannot be final as they are ment to be implemented.<br>
    `public abstract final class Eagle {} // DOES NOT COMPILE`
   
    `public final interface Hawk {} // DOES NOT COMPILE`

### Working with Enums
- Simple Enum declaration
  
```java
  public enum Season {
   WINTER, SPRING, SUMMER, FALL
}
```
- Instantiating an enum using new is not allowed unlike class

```java
public class EnumTest {
Engine Type engineType;
   enum EngineType {
   THERMAL,
   PHYSICAL,
   ELECTRICAL
   };
   EnumTest(EngineType engineType) {
      this.engineType = engineType;
   }
}
```
- When an enum is declared inside a class it becomes static, so it can be accessed from ClassName
`EnumTest enumTest = new EnumTest(EnumTest.EngineType.THERMAL);`
`EnumTest enumTest = new EnumTest(EngineType.THERMAL);`

```

  
- You can use `equals()` or `==` to compare enums since each enum value is intialized only once in the JVM. Enum prints the name of the enum when toString() is called.
```java
Season s = Season.SUMMER;
System.out.println(Season.SUMMER); // SUMMER
System.out.println(s == Season.SUMMER); // true
```
- An enum provides a values() method to get an array of all the values.

```java
for(Season season: Season.values()) {
   System.out.println(season.name() + " " + season.ordinal());
}
//output
WINTER 0
SPRING 1
SUMMER 2
FALL 3
```
- Getting enum value from a String using valueOf()
  `Season s = Season.valueOf("SUMMER"); // SUMMER`
  `Season t = Season.valueOf("summer"); //Throws runtime exception.`
- enum can't be extended
  `public enum ExtendedSeason extends Season { } // DOES NOT COMPILE`
- Using Enums in Switch Statements
  - **Java treats the enum type as implicit. In fact, if you were to type case Season.FALL, it would not compile.**
```java
Season summer = Season.SUMMER;
switch (summer) {
   case WINTER:
      System.out.println("Get out the sled!");
      break;
   case SUMMER:
      System.out.println("Time for the pool!");
      break;
   case Season.FALL: //Will not compile
      System.out.println("Time for the walk!");
      break; 
   default:
      System.out.println("Is it summer yet?");
}
```
- Allows adding Constructors, Instant Fields, and Methods
 * All enum constructor are implicitly `private` specifying the private modifier is optional. `public, protected` are not allowed
 * The first time that we ask for any of the enum values, Java constructs all of the enum values. After that, Java just returns the already constructed enum values, **so constructor call is only once in enum**
 * enum allows abstract methods

```java
  public enum Season {
   WINTER {
      public String getHours() { return "10am-3pm"; }
   },
   SUMMER {
      public String getHours() { return "9am-7pm"; }
   },
   SPRING, FALL;
   public String getHours() { return "9am-5pm"; }

  //  public abstract String getHours(); 
}
```
 
**_Note_** We only code the special cases and let the others use the enum‐provided implementation. Of course, overriding getHours() is possible only if it is not marked final.<br>

### Creating Nested Classes
  
- **Types**: 
  * `Inner class:` A non‐ static type defined at the member level of a class
  * `Static nested` class: A static type defined at the member level of a class
  * `Local class:` A class defined within a method body, constructor or in a block of code.
  * `Anonymous class:` A special case of a local class that does not have a name, created on the fly.

- **Inner class**
  * An inner class, also called a member inner class, is a non‐ static type defined at the member level of a class (the same level as the methods, instance variables, and constructors). Inner classes have the following properties:
  * Can be declared `public, protected, package‐private (default), or private`
  * Can extend any class and implement interfaces
  * Can be marked abstract or final
  * `Cannot declare static fields or methods, except for static final fields`
  * Can access members of the outer class including private members

```java
public class Outer {
    private String greeting = "Hi";
     private int x = 10;
    protected class Inner {
        public int repeat = 3;
         private int x = 20;
        public void go() {
            for (int i = 0; i < repeat; i++)
                System.out.println(greeting);
        }
         public void allTheX() {
            System.out.println(x);        // 20
            System.out.println(this.x);   // 20
            System.out.println(Outer.this.x);        // 10
         }
    }
    
    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();

        //Another way 
      Outer outer = new Outer();
      Inner inner = outer.new Inner(); // create the inner class
      inner.go();
    }
 }
```

- **Static Nested class**
 * Defined at the member level(Class).
 * All rules apply same as instance nested class
 * _**Don't need a instance of Enclosing class to use it.**_
```java
package bird;
1: public class Enclosing {
2:    static class Nested {
3:       private int price = 6;
4:    }
5:    public static void main(String[] args) {
6:       Nested nested = new Nested();
7:       System.out.println(nested.price); //Allowed to access instance variables
8: } }
```
- Importing a Static Nested class
  * `import bird.Enclosing.Nested` or `import static bird.Enclosing.Nested` both works

### Local class
* A local class is a nested class defined `within a method, constructors, and initializers.`
* Scope of the local class is within the method level, so instance has to be created within the method, constructor or initializer.
* Properties 
  * They do not have an access modifier.
  * They cannot be declared `static` and cannot declare `static` fields or methods, except for static final fields.
  * They have access to all fields and methods of the enclosing class (when defined in an instance method).
  * They can access local variables if the variables are final or effectively final.
The length and height variables are final and effectively final, respectively, so neither causes a compilation issue. On the other hand, the width variable is reassigned during the method so it cannot be effectively final. For this reason, the local class declaration does not compile.
 ```java
  public void processData() {
   final int length = 5;
   int width = 10;
   int height = 2;
   class VolumeCalculator {
      public int multiply() {
         return length * width * height; // DOES NOT COMPILE
      }
   }
   width = 2;
}
 ```
### Defining an Anonymous Class
- A special class without name 
- You can defined an anonymous class where it required for an example as a method argument.
```java
1:  public class ZooGiftShop {
2:     abstract class SaleTodayOnly {
3:        abstract int dollarsOff();
4:     }
   //Interface version commented.
   /* interface SaleTodayOnly {
      int dollarsOff();
   } */
5:     public int admission(int basePrice) {
6:        SaleTodayOnly sale = new SaleTodayOnly() {
7:           int dollarsOff() { return 3; }
8:        };  // Don't forget the semicolon!
9:        return basePrice - sale.dollarsOff();
10: } }
```
- You can even define anonymous classes outside a method body.
```java
  public class Gorilla {
   interface Climb {}
   Climb climbing = new Climb() {};
}
```
- You can define them right where they are needed, even as a method argument.
```java
  return admission(5, new SaleTodayOnly() {
     public int dollarsOff() { return 3; }
  });

  public int admission(int basePrice, SaleTodayOnly sale) {
       return basePrice - sale.dollarsOff();
  }
```

#### Syntax rules permitted in Nested classes

|Permitted|Inner class|static nested class|Local class|Anonymous class|
|---|---|---|---|---|
|**Access modifers**|All|All|**None**|**None**|
|**abstract**|Yes|yes|yes|**No**|
|**Final**|Yes|Yes|Yes|**No**|
|InstanceMethods|Yes|Yes|Yes|Yes|
|Instance Var|Yes|Yes|Yes|Yes|
|**static** methods|**No**|yes|**No**|**No**|
|static var|Yes(final)|yes|Yes(final)|Yes(final)|
|Can extend class or <br>impl any no interfaces|Yes|Yes|Yes|**No-only one superclass or interface**|
|Can access instance<br>members of <br>enclosing class<br>without a reference|yes|No|Yes(if declared in an instance method)|Yes(if decl in an instance method)|
|Can access local var of enclosing method|NA|N/A|Yes(if final or effectively final)|Yes(if final or effectively final)|

### Understanding Interface  Members
 - `Java 8` introduction of `using default public method, static method`.
 - `Java 9` introduction of `private method. private static method`.
#### Purpose of Default methods:
   * A default method allows you to add a new method to an existing interface, without the need to modify older code that implements the interface.
   * comparator interface has `default reversed()` making it useful for all class implementing this interface.
 - Default Interface Method Definition Rules
    - **A default method may be declared only within an interface.**
    - **A default method must be marked with the default keyword and include a method body**.
    - **A default method is assumed to be public.**
    - **A default method cannot be marked abstract, final, or static**. Since they can be overridden in implemented classes.
    - **A default method are overridable** may be overridden by a class that implements the interface. or another interface which is extending that interface
    - **If a class implements two interfaces that have default methods with the same method signature, the compiler will report an error as it doesn't which method to use.**
    - If a class inherits two or more default methods with the same method signature, then the class must override the method to avoid compiler error.
   - Following is a valid default method overridding
   ```java
      interface Inter1 {
         default void f() {
         System.out.println("Inter1");
         }
      }

      interface Inter2 extends Inter1 {
         default void f() {
         System.out.println("Inter2");
         }
      }
   ```

- Calling a Hidden default Method
  - Calling Super class default using super `Walk.super.getSpeed()`
```java
public interface Walk {
   public default int getSpeed() { return 5; }
}

public interface Run {
   public default int getSpeed() { return 10; }
}

public class Cat implements Walk, Run {
   public int getSpeed() {
      return 1;
   }
 
   public int getWalkSpeed() {
      return Walk.super.getSpeed();
   }
 
   public static void main(String[] args) {
      System.out.println(new Cat().getWalkSpeed());
   }
}
```
- Using static Interface Methods
  - A static method without an access modifier is assumed to be public. you can use the private access modifier.
  - A static method cannot be marked abstract or final.

```java
   public interface Hop {
      static int getJumpHeight() {
         return 8;
      }
   }

   public class Bunny implements Hop {
      public void printDetails() {
         System.out.println(Hop.getJumpHeight());
      }
   }
```

- Introducing private Interface Methods.
  - Method is declared with private modifier and incl a method body. only be called from default and private methods within the interface definition.
- Introducing private static Interface Methods
   ```java
   public interface Swim {
      private static void breathe(String type) {
         System.out.println("Inhale");
         System.out.println("Performing stroke: " + type);
         System.out.println("Exhale");
      }
      static void butterfly()        { breathe("butterfly");  }
      public static void freestyle() { breathe("freestyle");  }
      default void backstroke()      { breathe("backstroke"); }
      private void breaststroke()    { breathe("breaststroke"); }
   }
   ```
   ### Abstract classes vs Interface
   - An interfaces do not implement constructors and are not part of the class ierarchy.
   - Interface method declartions by default public abstract
 ![Alt text](Abstract-vs-interface.png)
  ### Introducing Functional Programming.
  -  A functional interface is an interface that contains a single abstract method. (SAM)
  -  A functional interface cab contain more than one default, static, private and private static method
  - Class are never considered functional interfaces
  - Abstract methods with signatures that are contained in public methods of java.lang.Object do not count toward the abstract method count for a functional interface.
  - @FunctionalInterface is option as long as there is only one abstract method other than the Super class java.lang.Objects abstract methods an interface is considered as functional interface.
  -  Declaring a `int toString()` in an functional interface would not compile since object's version of the method returns a String
  - This a valid functional interface method containing one abstract method dive(), other methods are declaration of methods in Object class.
  
   ```java
   public interface Dive {
      String toString();
      public boolean equals(Object o);
      public abstract int hashCode();
      public void dive();
   }
  ```

  ### Implementing Functional Interfaces with Lambdas
    - Ways of defining a lambda
      - `a -> a.canHop()` //doesn't work for more than one statement
      - `(Animal a) -> {return a.canHop();}`
      > Note: The parentheses can be omitted only if there is a single parameter and its type is not explicitly stated <br>
      > omit curly braces when we have only a single statement <br>
      >  Java doesn't require you to type return or use a semicolon when no curly braces are used. This special shortcut doesn't work when we have two or more statements. 
         - Valid lambda expressions.
         ```java
            () -> new Duck() //creating a Duck object and returning
            d -> {return d.quack();}
            (Duck d) -> d.quack() //same as above without return.
            (Animal a, Duck d) -> d.quack()
            (x, y) -> new RuntimeException()
            (final Camel c) -> {} // could be assigned to a Consumer<Camel> reference.
         ```
         - Invalid lambda expressions.
         ```java
                  (Wolf w, var c) ‐> 39 //mixing var and non-var parameters
                  (a,b,c) ‐> {int b = 3; return 2;} //variable b is used twice. compile error
                  (var y) ‐> return 0; // return statement permitted inside ({})
                  () ‐> {float r}// Semicolon missing(;)
                  (Cat a, b) ‐> {} // If the type is specified for one argument, then it must be specified for each and every argument.
         ```
- Working with Lambda Variables
  1. ParameterList
   ```java
   Predicate<String> p = x -> true;
   Predicate<String> p = (var x) -> true;
   Predicate<String> p = (String x) -> true;
   ```
  2.  Var can be used in the predicated in certain cases like Generics
   ```java
      public void counts(List<Integer> list) {
         list.sort((var x, var y) -> x.compareTo(y));
      }
   ```
 - **Local Variables** Inside the Lambda Body
  
      ```java
        (a, b) -> { int c = 0; return 5;}

        (a, b) -> { int a = 0; return 5;} // DOES NOT COMPILE
      ```
   - **_Note_** We tried to redeclare a, which is not allowed. Java doesn't let you create a local variable with the same name as one already declared in that scope

- Variables Referenced from the Lambda Body
  
<p>Lambda bodies are allowed to use static variables, instance variables, and local variables if they are final or effectively final. Sound familiar? Lambdas follow the same rules for access as local and anonymous classes!</p>

```java
4:  public class Crow {
5:     private String color;
6:     public void caw(String name) {
7:        String volume = "loudly";
8:        color = "allowed";
9:        name = "not allowed";
10:       volume = "not allowed";
11:       Predicate<String> p =
12:          s -> (name+volume+color).length()==9; // DOES NOT COMPILE
13:    }
14: }
```

<p>In this example, the values of name and volume are assigned new values on lines 9 and 10. For this reason, the lambda expression declared on lines 11 and 12 does not compile since it references local variables that are not final or effectively final. If lines 9 and 10 were removed, then the class would compile.</p>

## Review questions: 
1. 1,2,4 Final modifer statements 
   - Instance and static variables can be marked final
   - Effectively final means a local variable is not marked final but whose value does not change after it is set
   - Final modifier not applicable to abstract class and interfaces, (Only) Classes.
   - Final refers only to the reference to an object, not its contents.
   - Var and final cannot be used together


2. When an `enum` contains only a list of values, the semicolon (;) after the list is optional. When an enum contains any other members, such as a constructor or variable, then it is required, following code throw compile error.
    ```java
    enum Flavors {
              VANILLA, CHOCOLATE, STRAWBERRY
              static final Flavors DEFAULT = STRAWBERRY;
           }
    ```
3. 3 **Inner class variable must be static final**
4. 2, 5, 6 (B, E, F) Interfaces can't define default static methods, private interface method can't be declared abstract, protected it can be static 
5. 2 valid lambda expressions ? 1. (final Camel c) ‐> {} 2. (x,y) ‐> new RuntimeException() [Lambda](#implementing-functional-interfaces-with-lambdas)

6. 3, 5
7. ~~5E ~~When using an enum in a switch statement, the case statement must be made up of the enum values only. If the enum name is used in the `case statement value`, then the code does not compile. For example,` VANILLA is acceptable` but `Flavors.VANILLA is not`. when this corrected the code compiles, but throws NPE  
    ```java
    Flavors STRAWBERRY = null;
              switch (STRAWBERRY) {
                 case Flavors.VANILLA: System.out.print("v");
                 case Flavors.CHOCOLATE: System.out.print("c");
                 case Flavors.STRAWBERRY: System.out.print("s");
                 break;
                 default: System.out.println("missing flavor"); }
           }
    ```
8.  [Functional Interface statement overview](#introducing-functional-programming) 
9.  F When entered independently into the blank, allow the code to print Not scared at runtime
    - Ans: Trick question—the code does not compile! **The Spirit class is marked final, so it cannot be extended. The main() method uses an anonymous inner class that inherits from Spirit, which is not allowed**. If Spirit was not marked final, then options C and F would be correct
   ```java
    public class Ghost {
           public static void boo() {
              System.out.println("Not scared");
           }
           protected final class Spirit {
              public void boo() {
                 System.out.println("Booo!!!");
              }
           }
           public static void main(String… haunt) {
              var g = new Ghost().new Spirit() {};
              ___________________________;
           }
        }
        //Options
         A. g.boo()
         B. g.super.boo()
         C. new Ghost().boo()
         D. g.Ghost.boo()
         E. new Spirit().boo()
         F. Ghost.boo()
         G. None of the above
   ```
10. E //error: non-static variable count cannot be referenced from a static context
    
```java
1: public class Ostrich {
2:    private int count;
3:    private interface Wild {}
4:    static class OstrichWrangler implements Wild {
5:       public int stampede() {
6:          return count;
7:       } } }
```
11. what is the result of the code ? 
- Line 10 incompatible walk() method inherited.
```java
   1:  public interface CanWalk {
   2:     default void walk() { System.out.print("Walking"); }
   3:     private void testWalk() {}
   4:  }
   5:  public interface CanRun {
   6:     abstract public void run();
   7:     private void testWalk() {}
   8:     default void walk() { System.out.print("Running"); }
   9:  }
   10: public interface CanSprint extends CanWalk, CanRun {
   11:    void sprint();
   12:    default void walk(int speed) { 
   13:       System.out.print("Sprinting");
   14:    }
   15:    private void testWalk() {}
   16: }
```
12. 3C
13. E, G protected access modifier not allowed in functional interface, abstract methods cannot have body.
```java
Which lines of the following interface declaration do not compile? (Choose all that apply.)
1: public interface Herbivore {
2:    int amount = 10;
3:    static boolean gather = true;
4:    static void eatGrass() {}
5:    int findMore() { return 2; } // wrong
6:    default float rest() { return 2; }
7:    protected int chew() { return 13; } // wrong
8:    private static void eatLeaves() {}
9: }
```
14. 5E
15. G
16. A, D, E, ~~F~~ A default method in a functional interface must provide a body. 
17.~~ A, B,c, f ~~
```java
Which lambda expression when entered into the blank line in the following code causes the program to print hahaha? (Choose all that apply.)

        import java.util.function.Predicate;
        public class Hyena {
           private int age = 1;
           public static void main(String[] args) {
              var p = new Hyena();
              double height = 10;
              int age = 1;
              testLaugh(p, ___________________);
              age = 2;
           }
           static void testLaugh(Hyena panda, Predicate<Hyena> joke) {
              var r = joke.test(panda) ? "hahaha" : "silence";
              System.out.print(r);
           }
        }
   //Options
   A. var ‐> p.age <= 10 (Correct)
   B. shenzi ‐> age==1 (Wrong since age is not final)
   C. p ‐> true (duplicate dcl p variable)
   D. age==1 (not even a lambda)
   E. shenzi ‐> age==2 (Wrong since age is not final)
   F. h ‐> h.age < 5 (Correct)
   G. None of the above, as the code does not compile.     
```

18.  ~~C~~ C,D, G Which of the following can be inserted in the rest() method? (Choose all that apply.)
   ```java
     public class Lion {
           class Cub {}
           static class Den {}
           static void rest() {
           ___________________;
           } }
     //Options
      A. Cub a = Lion.new Cub() (Wrong)
      B. Lion.Cub b = new Lion().Cub() (missing new Cub)
      C. Lion.Cub c = new Lion().new Cub() (Correct)
      D. var d = new Den() (Correct)
      E. var e = Lion.new Cub() (Wrong)
      F. Lion.Den f = Lion.new Den() (Wrong Invalid syntax, below is correct)
      G. Lion.Den g = new Lion.Den() (Correct)
      H. var h = new Cub()      
   ```
19.  D
20.  A, B, C, If the final 
21.  B
22.  D, F
23.  C, F
24.  E
25.  A


