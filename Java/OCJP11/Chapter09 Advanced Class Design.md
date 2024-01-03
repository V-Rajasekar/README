# Chapter 9 Advanced Class Design
- Abstract class and methods
  * abstract keyword can be place before or after the modifier in methods.
  * `abstract public int claw(); or public abstract in claw();`
  * abstract modifier can't be placed after class `public class abstract Jackal`
  * compiler inserts a default no-argument constructor in abstract class,
   when its subclass is instantiated.
  *  The primary difference between a constructor in an abstract class and a nonabstract class is that a constructor in abstract class can be called only when it is being initialized by a nonabstract subclass
  - Invalid Modifiers
  * `abstract and final` Modifiers together is a invalid modifiers. neither the class or method declarations will compile because the are marked both abstract and final.
  * `abstract and private` Modifiers cannot be marked as both abstract and private.
  * `abstract and static` Modifiers cannot be overridden.If a static method cannot be overridden, then it follows that it also cannot be marked abstract since it can never be implemented.
    ```java
    abstract class Hippopotamus {
    abstract static void swim();  // DOES NOT COMPILE
    }
    ```
- Creating a Concrete Class
  * The first concrete subclass that extends an abstract class is required to implement all inherited abstract methods. This includes implementing any inherited abstract methods from inherited interfaces.
- Important abstract class definition rules.
  * All top-level types, including abstract classes, cannot be marked protected or privatte.
  `protected abstract class Animal {}`
  * Abstract classes may include zero or more abstract and nonabstract methods.
  * Abstract class constructors follow the same rules for initialization as regular constructors, except they can be called only as part of the initialization of a subclass.
- Abstract Method Definitions Rules
  * Abstract methods cannot be declared `private` or `final`
  * Implementing an abstract method in a subclass follows the same rules for overriding a method, including covariant return types, exception declarations, etc.
- Implementing Interfaces
  * Both abstract methods and constant variable included with an interface are implicitly assumed to be public.
  * With Java 8, interfaces were updated to include static and default methods.
  * In Java 9, interfaces were updated to support private and private static methods.
    Both of these types were added for code reusability within an interface declaration adn cannot be called outsdode the interface definition.
 - Defining an Interface.
    Interfaces are assumed to be abstract.
    Interface variables are assumed to be public, static, and final.
    Interface methods without a body are assumed to be abstract and public.
   * public abstract interface <interface name> //abstract is implicit
   * public abstract Float getSpeed(int age); // public abstract implicit
   * public static final int MIN_DEPTH = 2; //public static final implicit
   ![Alt text](image.png)
   * protected, private modifiers are not allowed in top-level class or interface only public and default are allowed.
   * The public top-level element could also be an enumeration, or enum.
   * When working with class members, omitting the access modifier indicates default access.When working with interface members, though, the lack of access modifier indicates public access.
 - Difference between Interfaces and Abstract Classes
    Eventhough abstract classes and interfaces are both considered abstract types, only interfaces nake use of implicit modifiers. 
      ```java
        abstract class Husky {
          abstract void play(); //Removing abstract will not compile
        }

        interface Poodle {
          void play(); //abstract is implicit.
        }

        class Webby extends Husky {
          void play() {}
        }

        class Georgette implements Poodle {
          void play() {} // doesn't compile Its public and default cause compile error.
          
        }
      ```
- Inheriting interface
  *  Duplicate interface method declarations is allowed compiler can resolve the conflicts.
  *  Duplicate methods with same signature but different return types? we need to review the rules for overriding methods.
 ```java
    interface Dances {
      String swingArms();
    }
    interface EatsFish {
      CharSequence swingArms();
    }

//class implementing this method compile since string is covariant return type of CharSequence.
    public String swingArms() {
          return "swing!";
    }
 ``` 
 - Polymorphism and Interfaces.
  * Casting Interfaces
    * Below code compiles and throw classCast exception at run time.  Canine reference type on line 7. Because of polymorphism, Java cannot be sure which specific class type the canine instance on line 8 is. Therefore, it allows the invalid cast on compile time, but throws in run time.
      ```java
      1: interface Canine {}
      2: class Dog implements Canine {}
      3: class Wolf implements Canine {}
      4:
      5: public class BadCasts {
      6:    public static void main(String[] args) {
      7:       Canine canine = new Wolf();
      8:       Canine badDog = (Dog)canine;
      9:    } }
      ```
    * Since String does not implement Canine, the compiler recognizes that this cast is not possible.
      `Object badDog = (String)canine;  // DOES NOT COMPILE`

- Interfaces and the instanceOf operator
   
```java
Number tickets = 5;
if(tickets instanceof List) {} //compiles as its possible to have below scenario

public class MyNumber extends Number implements List
//That said, the compiler can check for unrelated interfaces if the reference is a class that is marked final.
  Integer tickets = 6;
  if(tickets instanceof List) {}  // DOES NOT COMPILE
```
###  Reviewing Interface Rules
 
- Interface Definition Rules  Interfaces cannot be instantiated.
- All top-level types, including interfaces, cannot be marked protected or private.
- Interfaces are assumed to be abstract and cannot be marked final.
- Interfaces may include zero or more abstract methods.
- An interface can extend any number of interfaces.
- An interface reference may be cast to any reference that inherits the interface, although this may produce an exception at runtime if the classes aren’t related.
- The compiler will only report an unrelated type error for an instanceof operation with an interface on the right side if the reference on the left side is a final class that does not inherit the interface.
- An interface method with a body must be marked `default, private, static, or private static` (covered when studying for the 1Z0-816 exam).
The following are the five rules for abstract methods defined in interfaces.

### Abstract Interface Method Rules

- Abstract methods can be defined only in abstract classes or interfaces.
- Abstract methods cannot be declared private or final.
- Abstract methods must not provide a method body/implementation in the abstract class in which is it declared.
- Implementing an abstract method in a subclass follows the same rules for overriding a method, including covariant return types, exception declarations, etc.
- Interface methods without a body are assumed to be abstract and public.
- Notice anything? The first four rules for abstract methods, whether they be defined in abstract classes or interfaces, are exactly the same! The only new rule you need to learn for interfaces is the last one.
  
Finally, there are two rules to remember for interface variables.

### Interface Variables Rules

1. Interface variables are assumed to be public, static, and final.
2. Because interface variables are marked final, they must be initialized with a value when they are declared.

### Introducing Inner Classes
- Member inner class
- A member inner class is a class defined at the member level of a class (the same level as the methods, instance variables, and constructors).
```java
   public class Zoo {
   private interface Paper {}
   public class Ticket implements Paper {}
}
```
<p>While top-level classes and interfaces can only be set with public or package-private access, member inner classes do not have the same restriction. A member inner class can be declared with all of the same access modifiers as a class member, such as `public, protected, default (package-private), or private`.</p>

### Using a Member Inner Class

  ```java
  public class Zoo {

    private interface Paper {
        public String getId();
    }

    public class Ticket implements Paper {
        private String serialNumber;
        public String getId() { return serialNumber; }
    }

    public Ticket sellTicket(String serialNumber) {
        var t = new Ticket();
        t.serialNumber = serialNumber;
        return t;
    }
  }
  ```
  <p>The advantage of using a member inner class in this example is that the Zoo class completely manages the lifecycle of the Ticket class.</p>

  ```java
  public class Zoo {
    ...
    public static void main(String... unused) {
        var z = new Zoo();
        var t = z.sellTicket("12345");
        System.out.println(t.getId()+" Ticket sold!");
    }
  }
  ```

  ### Review Questions:
  1. 2, 5
  2. 1, 2, 4, 5
  3. 2, 3, 4, 5
  4. 5
  5. 3, 6
  6. 5, 4
  7. 2
  8. 2, 3
  9. 2, 3, 5, 6
  10. 3, 7 (duplicate fly method in two diff interface which was implemented in Falcon doesn't compile.)
  11. 2, 6
  12. 6
  13. 2 (abstract class with static main String arg[] do compile and run)
  14. 3, 5, 6 (abstract implicit is only applicable to interfaces)
  15. 2 (duplicate method with different access modifiers private in parent and protected in child compiles)
  16.  2 (Dont think exam will give such easy problems) 5 (Assigning weaker modifier public -> default)
  17.  1, 5
  18.  1, 2, 4
```java
   interface Walk { public List move(); }
interface Run extends Walk { public ArrayList move(); }

  
  class Panther implements Run {
     public ArrayList move() { // Z List return will throw compile error.
        return null;
     }
  }
```
19. 2, 3, 4, 5, 6
20. 3, 5, 4, 1 // compiles.
   ```java
    abstract class Elephant {
     abstract private class SleepsAlot {
        abstract int sleep();
     }
  }
   ```
  
