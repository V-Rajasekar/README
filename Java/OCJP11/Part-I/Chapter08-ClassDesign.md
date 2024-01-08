- [Class Design](#class-design)
  - [Declaring Constructor](#declaring-constructor)
  - [Complex initialization flow.](#complex-initialization-flow)
  - [Inheriting Members.](#inheriting-members)
    - [Overriding Method.](#overriding-method)
  - [Overloading vs Overriding](#overloading-vs-overriding)
  - [Overloading and Overriding a Generic Method(compile error).](#overloading-and-overriding-a-generic-methodcompile-error)
  - [Generics and WildCards in Overloaded and Overridden methods.](#generics-and-wildcards-in-overloaded-and-overridden-methods)
  - [Hiding Parent ins method, Static Methods with non static method, ins method name (Compile error)](#hiding-parent-ins-method-static-methods-with-non-static-method-ins-method-name-compile-error)
  - [Hiding parent variables in child class.](#hiding-parent-variables-in-child-class)
  - [Casting Objects.](#casting-objects)
  - [Polymorphism and Method Overriding](#polymorphism-and-method-overriding)
  - [Overriding vs Hiding Members](#overriding-vs-hiding-members)


# Class Design
- Inheritance 
  * Java doesn't support multiple inheritance, but allows multi level inheritance.
  * A subclass inherits the parent class public, protected members, Also default if both parent and subclass in the same package.
  * All java objects inherits java.lang.Object
- Designing class
  * `public abstract/final class HelloWorld extends/implements <class/interface>`
  * A class can't be both abstract final
  * A top level class is a class which is available in another class file. It can only be `default`. no private or protected allowed. To make it public you have to move to a separate file.
- Accessing `this` Reference 
 ```java
   public class Flamingo {
      private String color;
      public void setColor(String color) {
         color = color;
         color = this.color // Backwards – no good! still null;
         this.color = color; //works
         
      }
   }
 ```
_Note:_ value of color = null. when compiler see color == color it thinks your assigning the method param value to itself. Fix is use this.color
  
 - Calling the `super` Reference
   * Diff between this and super, The super reference is similar to the this reference, except that it excludes any members found in the current class. In otherwords the member must be accessible via inheritance.
   * what is the output of this code ? 
   * line 10, 11 prints buggy, buggy, line 12 prints 3, line 13 compile error, line 14 6. 
        ```java
        1:  class Insect {
        2:     protected int numberOfLegs = 4;
        3:     String label = "buggy";
        4:  }
        5:  
        6:  public class Beetle extends Insect {
        7:     protected int numberOfLegs = 6;
        8:     short age = 3;
        9:     public void printData() {
        10:       System.out.print(this.label);
        11:       System.out.print(super.label);
        12:       System.out.print(this.age);
        13:       System.out.print(super.age);
        14:       System.out.print(numberOfLegs);
        15:    }
        16:    public static void main(String []n) {
        17:       new Beetle().printData();
        18:    }
        ```
## Declaring Constructor
  * `var` as param is not allowed in constructor.
  * Default constructor is provided by default, but when you overload the default constructor with overloaded constructor with param, you need to override the default constructor.
    ```java
        public class Mammal {
        public Mammal(int age) {}
        }
        
        public class Elephant extends Mammal {  // DOES NOT COMPILE
        }
    ```
  * Calling Overloaded Constructors with this()
    * this() must be the first statement in the constructor call.
    * Overloaded constructor are not allowed to call itself, instead this(...).  
  ```java
   public Hamster(int weight) {
      Hamster(weight, "brown");      // DOES NOT COMPILE
   }

    public Hamster(int weight) {
      new Hamster(weight, "brown");  // Compiles, but incorrect
   }
   //solution using this
    public Hamster(int weight) {
      this(weight, "brown");
   }

    public Gopher() {
      this(5);  // DOES NOT COMPILE
   }
   public Gopher(int dugHoles) {
      this();   // DOES NOT COMPILE
   }
  ```
  * the first line of every constructor is a call to either `this() or super()`
  * `super()` followed by `this()`, `and viceverse are not allowed`. Remember super/this can be the first statement in the constructor.
- Final fields in Constructor parama
  * final field can be assigned values in the instance initializer block, constructor.
  * remember all final variables should be initalized before the constructor completes.
- Class Initialization
- Initialize Instance of X
  1. If there is a superclass Y of X, then initialize the instance of Y first.
  2. Process all instance variable, initializers declarations in the order they appear in the class.
  3. Initialize the constructor including any overloaded constructors referenced with this().

```java
1:  public class ZooTickets {
2:     private String name = "BestZoo";
3:     { System.out.print(name+"-"); }
4:     private static int COUNT = 0;
5:     static { System.out.print(COUNT+"-"); }
6:     static { COUNT += 10; System.out.print(COUNT+"-"); }
7:  
8:     public ZooTickets() {
9:        System.out.print("z-");
10:    }
11:
12:    public static void main(String... patrons) {
13:       new ZooTickets();
14:    }
15: }
// Result 0-10-BestZoo-z-
```
  
- The order of initialization as follows
  * Line 4, 5, 6 class loading happens so all static var and initialization happens in the order they are mentioned in the class 0-10-
  * Line 3 class instance block BestZoo-
  * Line 9 class constructor z-
  * Result: `0-10-BestZoo-z-`
  
## Complex initialization flow.
 * We first process the static variables and static initializers—lines 4 and 5, with line 5 printing 0. Now that the static initializers are out of the way, the main() method can run, which prints Ready. Lines 2, 3, and 6 are processed, with line 3 printing swimmy and line 6 printing 1. Finally, the constructor is run on lines 8–10, which print Constructor.
```java
1:  public class Cuttlefish {
2:     private String name = "swimmy";
3:     { System.out.println(name); }
4:     private static int COUNT = 0;
5:     static { System.out.println(COUNT); }
6:     { COUNT++; System.out.println(COUNT); }
7:  
8:     public Cuttlefish() {
9:        System.out.println("Constructor");
10:    }
11:
12:    public static void main(String[] args) {
13:       System.out.println("Ready");
14:       new Cuttlefish();
15:    }
16: }
//Result 0 Ready swimmy 1 Constructor
  
```
- Difficult example. 

```java
1:  class GiraffeFamily {
2:     static { System.out.print("A"); }
3:     { System.out.print("B"); }
4:    
5:     public GiraffeFamily(String name) {
6:        this(1);
7:        System.out.print("C");  
8:     }
9:    
10:    public GiraffeFamily() {
11:       System.out.print("D");  
12:    }
13:    
14:    public GiraffeFamily(int stripes) {
15:       System.out.print("E");  
16:    }
17: }
18: public class Okapi extends GiraffeFamily {
19:    static { System.out.print("F"); }
20:    
21:    public Okapi(int stripes) {
22:       super("sugar");
23:       System.out.print("G");  
24:    }
25:    { System.out.print("H"); }
26:    
27:    public static void main(String[] grass) {
28:       new Okapi(1);
29:       System.out.println();
30:       new Okapi(2);
31:    }
32: }
```
   * Result: AFBECHG
           * BECHG 
  1. Super class, sub class class static initialization block AF
  2. Super class instance block B
  3. Super class constructors in reverse order parent..descendant child
  4. Subclass instance block H
  5. Subclass constrcutor G
   When you create one more object instance, All class loading static instance, block are not called again.

- Constructor declaration and call in sub class.
  
   * If the parent class doesn’t have a no-argument constructor, then every constructor in the child class must start with an explicit this() or super() constructor call.
  
  ```java
  class Animal {
    public Animal(String name) {
        this.name = name;
    }
  }

  class Dog extends Animal {
    Dog() {
      super(null);
    }
  }

   Dog dog = new Dog();
  ```
  * If the parent class doesn’t have a no-argument constructor and the child doesn’t define any constructors, then the child class will not compile.
  
  ```java
  class Animal {
    public Animal(String name) {
        this.name = name;
    }
  }

  class Dog extends Animal {

  }
  ```
 ## Inheriting Members.

  * A child class inherits any parent class public or protected member including methods, primitives, or object references. and a child class can access parent class default members If the parent class and child class are part of the same package. 
  * super class private aren't accessable directly.
  ### Overriding Method.

  * The method in the child class **_must have the same signature_** as the method in the parent class.
  * The method in the child class must be at least as accessible as the method in the parent class.
  * The method in the child class **_may not declare a checked exception that is new or broader_** than the class of any exception declared in the parent class method.
  * If the method **_returns a value, it must be the same or a subtype of the method in the parent class_**, known as covariant return types.
    (e.g) Parent/Child return types: CharSequence/String, List/ArrayList, Object/String <br>
  * A method is not considered as **overridden with covariant method param** in the method eventhough the method name are same, This method rather called as overloaded method instead of overriden method.
  

## Overloading vs Overriding
  *  `If two methods have the same name but different signatures, the methods are overloaded,` not overridden. Overloaded methods are considered independent and do not share the same polymorphic properties as overridden methods.
  *  Overriding method will have same method name with the following rules
  *  Java limiting the overriding method to access modifiers that are as accessiable or more accessiable than the inherited version public, protected, default are the more accessiable modifier in the order.
  *  Overridden method signature must match exactly the inherited method no covariant with the method param in the inherited method.
  
```java
abstract class Bird {
   void fly(CharSequence charSequence) { System.out.println("Bird"); 

   final void legs() {
      System.out.println("Two legs");
   }
}

class Pelican extends Bird {
   @Override
   protected void fly(String name) { System.out.   println("Pelican"); //Compile error as fly is not overridden the method param should match exactly.
   }
   // Private and final methods are not inherited so you can't override with @Override, allowed to define method with the same name and param.
   public void legs() {
      System.out.println("Pelican legs");
   }
}
```

  *  overriding a method cannot declare new checked exceptions or checked exceptions broader than the inherited method. The exception can be more specific.

```java
  public class Reptile {
   protected void sleepInShell() throws IOException {}
 
   protected void hideInShell() throws NumberFormatException {}
  
   protected void exitShell() throws FileNotFoundException {}
}
 
public class GalapagosTortoise extends Reptile {
   public void sleepInShell() throws FileNotFoundException {}
 
   public void hideInShell() throws IllegalArgumentException {}
  //hideInShell compiles since its unchecked exception.
   public void exitShell() throws IOException {} // DOES NOT COMPILE
}
```
  *  The overriding method must use a return type that is covariant with the return type of the inherited method.<br>
 _Note:_  String implements CharSequence
```java
public class Rhino {
   protected CharSequence getName() {
      return "rhino";
   }
   protected String getColor() {
      return "grey, black, or white";
   }
}
 
class JavanRhino extends Rhino {
   public String getName() {
      return "javan rhino";
   }
   public CharSequence getColor() {  // DOES NOT COMPILE
      return "grey";
   }
}
```
## Overloading and Overriding a Generic Method(compile error).
  * generic methods cannot be overloaded by changing the generic parameter type only.
```java
   public class LongTailAnimal {
      protected void chew(List<Object> input) {}
      protected void chew(List<Double> input) {}  // DOES NOT COMPILE
   }
   // Overriding
   * generic methods cannot be overridden by changing the generic parameter type only.
   public class LongTailAnimal {
      protected void chew(List<Object> input) {}
   }
   
   public class Anteater extends LongTailAnimal {
      protected void chew(List<Double> input) {}  // DOES NOT COMPILE
   }
```
## Generics and WildCards in Overloaded and Overridden methods.

* Its overloaded not overriden implementation.

```java
   public class LongTailAnimal {
      protected void chew(List<Object> input) {}
   }
   
   public class Anteater extends LongTailAnimal {
      protected void chew(ArrayList<Double> input) {}
   }
 ```

  ```java
  void sing1(List<?> v) {}                 // unbounded wildcard
  void sing2(List<? super String> v) {}    // lower bounded wildcard
  void sing3(List<? extends String> v) {}  // upper bounded wildcard
  ```
  - Generic Return Types
  - In a overridden the method of the return type generics values must be covariant.
   <p>The Monkey class compiles because ArrayList is a subtype of List. The play() method in the Goat class does not compile, though. For the return types to be covariant, the generic type parameter must match. Even though String is a subtype of CharSequence, it does not exactly match the generic type defined in the Mammal class. Therefore, this is considered an invalid override.</p>
```java
public class Mammal {
   public List<CharSequence> play() { ... }
   public CharSequence sleep() { ... }
}
 
public class Monkey extends Mammal {
   public ArrayList<CharSequence> play() { ... }
}
 
public class Goat extends Mammal {
   public List<String> play() { ... }  // DOES NOT COMPILE
   public List<CharSequence> play() {} // COMPILE.
   public String sleep() { ... }
}
```
## Hiding Parent ins method, Static Methods with non static method, ins method name (Compile error)
  * When a parent class static method is overridden with the child class static method. 
  * If one is marked `static` and the other is not, the class will not compile.

```java
//Parent class
    public static void sneeze() {
      System.out.println("Bear is sneezing");
   }

    public void hibernate() {
      System.out.println("Bear is hibernating");
   }
    public final static void flyAway() {}

//Child class.
     public void sneeze() {           // DOES NOT COMPILE
      System.out.println("Panda sneezes quietly");
   }

  public static void hibernate() { // DOES NOT COMPILE
        System.out.println("Panda is going to sleep");
    }

  public final static void flyAway() {}  // DOES NOT COMPILE
```
## Hiding parent variables in child class.
   * A hidden variable occurs when a child class defines a variable with the same name as an inherited variable defined in the parent class. This creates two distinct copies of the variable
   * The output changes depending on the reference variable used.
  ```java
  Carnivore 
     protected boolean hasFur = false;
   Meerkat extends Carnivore
      protected boolean hasFur = true;
    Meerkat m = new Meerkat();
      Carnivore c = m;
      System.out.println(m.hasFur); // true
      System.out.println(c.hasFur); //false

  ```
## Casting Objects.

```java
1. Object obj = new String("Hello");
2. System.out.println(obj);
3. String s1 = (String)obj;

public class Rodent {}
 
public class Capybara extends Rodent {
   public static void main(String[] args) {
      Rodent rodent = new Rodent();
4.    Capybara capybara = (Capybara)rodent;  // ClassCastException
   }
}
```
1. Casting a reference from a **_subtype to a supertype doesn’t require an explicit cast_**. Line:1
2. Casting a reference from a **_supertype to a subtype requires an explicit cast_**. Line:3
3. The compiler disallows casts to an unrelated class.
* At runtime, an invalid cast of a reference to an unrelated type results in a ClassCastException being thrown. Line:4
4. The Rodent object created does not inherit the Capybara class in any way. 
```java
   Rodent rodent = new Capybara();
   Capybara capybara = (Capybara) rodent;
```
## Polymorphism and Method Overriding
  
 ```java
  class Animal
{
  String name;
  public Animal(String name) {
      this.name = name;
  }
  public void whereAmI() {
      System.out.println("I m Animal");
  }
  
  void onlyAnimal() {
    System.out.println("Only Animal");
  }
}

class Dog extends Animal
{
  public int age = 10;     
   public Dog(String name) {
       super(name);
   }
   public void whereAmI() {
      System.out.println("I m Dog");
  }
   public void isPetAnimal() {
      System.out.println("isPetAnimal=True");
  }
}

public class Main
{
  public static void main (String[]args)
  {
    Animal animal = new Dog("puppy");
  //  System.out.println("Age"+ animal.age);
     animal.whereAmI(); // Calls I'm Dog Runtime polymorphism
    // animal.isPetAnimal(); //error cannot find symbol
     ((Dog)animal).isPetAnimal();  
     Dog dog =(Dog) animal;//Downcasting to access method specific to subclass and members
     System.out.println("Age "+ dog.age);
     dog.isPetAnimal();
  }
}
 ```

## Overriding vs Hiding Members
 * Unlike method overriding, hiding members is very sensitive to the reference type and location where the member is being used. <br>
 _Note:_ It is legal to access the static variables and method using this, but not recommended. 

```java
class Penguin {
   public static int getHeight() { return 3; }
   public void printInfo() {
      System.out.println(this.getHeight());
   }
}
public class CrestedPenguin extends Penguin {
   public static int getHeight() { return 8; }
   public static void main(String... fish) {
      new CrestedPenguin().printInfo();
   }
}
 //Prints output: 3  
 //Prints output: 8 when the static keyword is removed from the methods.
```

 - static methods can only be hidden, not overridden, Java uses the reference type to determine which version of isBiped() should be called,


```java
class Marsupial {
   protected int age = 2;
   public static boolean isBiped() {
      return false;
   }
}
 
public class Kangaroo extends Marsupial {
   protected int age = 6;
   public static boolean isBiped() {
      return true;
   }
 
   public static void main(String[] args) {
      Kangaroo joey = new Kangaroo();
      Marsupial moey = joey;
      System.out.println(joey.isBiped());
      System.out.println(moey.isBiped());
      System.out.println(joey.age);
      System.out.println(moey.age);
   }
   //outputs true, false, 6, 2
}
```

Review Questions
//1.A 2.B 3.C 4.D 5.E 6.F
1. 5
2. 2,3,~~4,6~~
   a) Overloaded methods must have the same return type. //FALSE
   b) Hidden methods must have the same return type. //FALSE
3. 6
4. ~~3~~ 5 // careless showding variables
```java
    class Speedster {
     int numSpots;
  }
  public class Cheetah extends Speedster {
     int numSpots;
   
     public Cheetah(int numSpots) {
        // INSERT CODE HERE super.numSpots = numSpots; and not this.numSpots = numSpots;
     }
   
     public static void main(String[] args) {
        Speedster s = new Cheetah(50);
        System.out.print(s.numSpots);
     }
  }
```
1. ~~6~~, 1 (**an overridden method can have a broader access modifier, and protected access is broader than package-private access. **)
2. ~~1, 3,~~ 2,  5 (1. An overriden method must contain method param that are the same, no covariant.
3. An overridden method must have same or more accessible than the method in the parent class.)
4. 1, 3 (Took more time)
5. 3
6.  ~~1~~, 2, 6
7.  ~~3~~, 4
 - Line 2 var not allowed in constructor
 - Line 8 Subclass must implement default constructor calling explicitly super as there is no default constructor in parent.
 - Line 9: Number is not Covariant of Integer, inherited method in parent is static, and overridden method is non static 
   
```java
   How many lines of the following program contain a compilation error?
   
  1:  public class Rodent {
  2:     public Rodent(var x) {}
  3:     protected static Integer chew() throws Exception {
  4:        System.out.println("Rodent is chewing");
  5:        return 1;
  6:     }
  7:  }
  8:  class Beaver extends Rodent {
  9:     public Number chew() throws RuntimeException {
  10:       System.out.println("Beaver is chewing on wood");
  11:       return 2;
  12:    } }
```
11. 2, 3,(5) a final instance method cannot be overridden in a subclass, so calls in the parent class will not be replaced,
12. 1, 2, 5,/ Missed 6 (Careless)
13. 7,/ Missed 1 (Careless)
14. 2, 5,/Missed 6 
15. uq uq uqcrcrm 4 (took sometime)
16. ~~7~~ 2,  A valid override of a method with generic arguments must have the same signature with the same generic types
17. 6 (No concept of overriding variables, Variables are shadow)
18. c,~~ 5~~, 6. Calling a non static variable from static method is not allowed so option 5 is incorrect. option 6 You can access a private constructor with the main() method in the same class.
19. ~~4~~, 3, 6
20. ~~5~~, 6
 <p>The Reptile class defines a constructor, but it is not a no-argument constructor. Therefore, the Lizard constructor must explicitly call super(), passing in an int value.</p>
    ```java
    class Reptile {
       public Reptile(int hatch) {}
    }
     public class Lizard extends Reptile {
       public Lizard(int hatch) {}
     }
    ```
21. 5
22. ~~3~~, 4 static variables and methods are not overridden, so it uses the reference type and overridden method, so   t.setName ("Olivia"); actual calls the child's setName setting, so m.name = Olivia   
 
  ```java
    class Person
{
  static String name;
  void setName (String q)
  {
    System.out.println ("Person: " + q);
    name = q;
  }
}
class Child extends Person
{
  static String name;
  void setName (String w)
  {
    name = w;
    System.out.println ("Child:" + w);
  }
  public static void main (String[]p)
  {
    final Child m = new Child ();
    final Person t = m;
    m.name = "Elysia";
    t.name = "Sophia";
    System.out.println (m.name + " " + t.name);
    t.setName ("Olivia");
    System.out.println (m.name + " " + t.name);
}}
  ```
23. 2 qpzj
24. 6, Missed 1, 4
    - Ploymorphism and method inheritance rules:
    * It cannot be determined until runtime which overridden method will be executed in a parent class.
    * Marking a method final prevents it from being overridden or hidden.
    * The reference type of the variable determines which hidden method will be called at runtime.

25. ~~2~~ 3  order of execution: Parent, child static blocks(psi,csi). Parent initialization block, its constructors(pi,pc), then Child initialization block and its constructors(ci,cc).suppose you have a main method in child then psi,csi,main,pi,pc,ci,cc
26.  6

27. Which statements about the following classes are correct? (Choose all that apply.)

```java
  1:  public class Mammal {
  2:     private void eat() {}
  3:     protected static void drink() {}
  4:     public Integer dance(String p) { return null; }
  5:  }
  6:  class Primate extends Mammal {
  7:     public void eat(String p) {}
  8:  }
  9:  class Monkey extends Primate {
  10:    public static void drink() throws RuntimeException {}
  11:    public Number dance(CharSequence p) { return null; }
  12:    public int eat(String p) {}
  13: }
```
* The eat() method in Mammal is correctly overridden on line 7.
* The eat() method in Mammal is correctly overloaded on line 7.
* The drink() method in Mammal is correctly hidden on line 10.
* The drink() method in Mammal is correctly overridden on line 10.
* The dance() method in Mammal is correctly overridden on line 11.
* The dance() method in Mammal is correctly overloaded on line 11.
* The eat() method in Primate is correctly hidden on line 12.
* The eat() method in Primate is correctly overloaded on line 12.

<p>C, F. The eat() method is private in the Mammal class. Since it is not inherited in the Primate class, it is neither overridden nor overloaded, making options A and B incorrect. The drink() method in Mammal is correctly hidden in the Monkey class, as the signature is the same, making option C correct and option D incorrect. The version in the Monkey class throws a new exception, but it is unchecked; therefore, it is allowed. The dance() method in Mammal is correctly overloaded in the Monkey class because the signatures are not the same, making option E incorrect and option F correct. For methods to be overridden, the signatures must match exactly. Finally, line 12 is an invalid override and does not compile, as int is not covariant with void, making options G and H both incorrect. </p>