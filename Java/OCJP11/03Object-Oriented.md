Class name and method name can be same and that is why given method can be declared in any of the given classes: 'emp', 'Emp', 'employee', 'Employee', 'Student' and '_emp_'.
- Top level class can be only default, final or abstract.
- Instance method can access both instance and static members.
- Non Instance method or variable can't be accessed from static context (static block or method)
- Immutable class should have private fields and no setters.
- Static method can access only static members.
- A constructor can call another constructor by using this(...) and not the constructor name.
- Local variable cannot be declared private
- Local variable must be initialized before use.(e.g) consider this str is a local variable which is not initialized it will throw Compilation error.
  `String str = str+ "Hello";` 

## Overridding method rules

1. A subclass having same instance variables as in super class are observed as hidden and not overridden, hence overriding rules are not for the instance variables.They can be accessed by using explicit casting
2. you cannot override methods with weaker access modifiers the order of `public, protected, default and private`. see below example child with protected access modifier where in parent has default.
3. Instance method of subclass cannot override the static method of superclass.//compile error
4. static method of subclass cannot hide the instance method of the super class. //compile error 
   
 ```java
  class Currency {
    String notation = "-"; //Line n1
    
    String getNotation() { //Line n2
        return notation;
    }
    static String type() {
        return "currenct"
    }
}
 
class USDollar extends Currency {
    String notation = "$"; //Line n3
 
    protected String getNotation() { //Line n4
        return notation;
    }

  //  String type() { return "US currency"} //compile error rule 3
}
  
    Currency c1 = new USDollar();
    System.out.println(c1.notation + ":" + c1.getNotation());
    //prints -:$

    USDollar us = new USDollar();
    us.notation//prints $
    ((Currency)us).notation // prints -
```
- There are 2 rules related to return types:

1. If return type of overridden method is of primitive type, then overriding method should use same primitive type.

2. If return type of overridden method is of reference type, then overriding method can use same reference type or its sub-type (also known as covariant return type).

```java
  Employee() {
   Employee("Mic", 22); //not allowed use this("Mic", 22);
  }
```
- How Polymorphism works ? 

```java
class Lock {

    int id = 10;
    Lock() {
    lock();
    }
    public void open() {
        System.out.println("LOCK-OPEN");
    }
    public void lock() {
    System.out.println("Lock: "+ (++id));
    }
}
 
class Padlock extends Lock {
    int id = 20;
    public void open() {
        System.out.println("PADLOCK-OPEN");
    }
    public void lock() {
    System.out.println("Lock: "+ (--id));
    }
}
 
class DigitalPadlock extends Padlock {
  public void open() {
	//super().open(); call to super must be first statement in constructor
        System.out.println("DIGITALPADLOCK-OPEN");
    }
}
Lock lock = new DigitalPadlock(); // at this point of time prints id= -1
lock.open(); //DIGITALPADLOCK-OPEN
((Padlock)lock).open();//DIGITALPADLOCK-OPEN since lock points to DigitalPadlock
``` 
-  Local variable must be initialized before use.

```java
String color;
    if (area < 7)
        color = "BLUE";
    
    System.out.println(color); // compile error.

public class Test {
    static String str = "KEEP IT "; //Line n1
    public static void main(String[] args) {
        String str = str + "SIMPLE"; //Line n2 // compile error might not be initialized. variable str is considered as a local variable shadowing class level variable.
        System.out.println(str);
    }
}
```

- Overloading with Autoboxing take effect over var argument (byte...)
  
```java
void speed(Byte val) { //Line n1
        System.out.println("DARK"); //Line n2
    } //Line n3
 
void speed(byte... vals) {
    System.out.println("LIGHT");
}

new Car().speed(byte(10)); //prints DARK
```

- Object Reference in method calls
  
```java
  public class AvoidThreats {
    public static void evaluate(Threat t) { //Line n5
        t = new Threat(); //Line n6
        t.name = "PHISHING"; //Line n7
    }
    
    public static void main(String[] args) {
        Threat obj = new Threat(); //Line n1
        obj.print(); //Line n2
        evaluate(obj); //Line n3
        obj.print(); //Line n4
    }
}
 
class Threat {
    String name = "VIRUS";
    
    public void print() {
        System.out.println(name);
    }
}
//Prints VIRUS, VIRUS
```
-- static and non static Increment operation

```java
public class Test {
    static int a = 10000;
    static {
System.out.println("s"+ a);
        a = -a--;
        System.out.println("s"+ a);
    }
    {
System.out.println("I"+ a);
        a = -a++;
        System.out.println("IP"+ a);
    }
 
    public static void main(String[] args) {
        System.out.println(a);
    }
}

System.out.println(new Test().a);

//ExceptionInInitializerError will be thrown from static block incase of any exceptions
static {
    0/0;
}
```

### Instance variable and initialization block

- Instance variable and block are initialized, only when the class is loaded meaning creating an object of class using new or FactoryMethod.

```java
    public class Test {
        Integer i = 10; //Line n1
        {
            Integer i = 2; //Line n2 // This creates the local varianle
        }
        public static void main(String[] args) { 
        System.out.println(new Test().i); //Line n3 //prints 9
        }
        { i--; } //Line n4 // at this point its 10
    }
```

### Order of execution in a class
Order of execution is:

- `static initializer block of Parent` (Super) class, in top to bottom order
- `static initializer block of Child` (Sub) class, in top to bottom order
- `instance initializer block of Parent` (Super) class, in top to bottom order
- `Statements inside the constructor of Parent` (Super) class
- `instance initializer block of Child (Sub) class`, in top to bottom order
- `Statements inside the constructor of Child (Sub) `class

- Default constructor
  
```java
class Super {
    Super(int i) {
        System.out.println(100);
    }
}
 
class Sub extends Super {
    Sub() { //cause compile error here as there is no argument constructor in Super.
        System.out.println(200);
    }
}

```

- Parent class No Argument constructor should be visible.
  
Animal class's constructor has package scope, which means it is accessible to all the classes declared in package 'a'. But Dog class is declared in package 'b' and hence `super();` statement inside Dog class's constructor causes compilation error as no-argument constructor of Animal class is not visible.

```java
//Animal.java
package a;
 
public class Animal {
    Animal() {
        System.out.print("ANIMAL-");
    }
}

//Dog.java
package d;
 
import a.Animal;
 
public class Dog extends Animal {
    public Dog() {
        System.out.print("DOG");
    }
}
```

- A constructor cannot have both super() and this()
  
    ```java
    Child(int i, int j) {
        super(i);
        this(j);
    }
    ```

- The derived class constructor always calls super()

```java
    class PenDrive {
        int capacity;
        PenDrive() {//n1
        }
        PenDrive(int capacity) {
            this.capacity = capacity;
        }
    }
    
    class OTG extends PenDrive {
        String type;
        String make; 
        OTG(int capacity, String type) {
            super(); //n2
            super.capacity = capacity; // without Line n1 and n2 cause compile error.
            this.type = type;

        }
    }
//Example-2: 
class Document {
    int pages;
    Document(int pages) {
        this.pages = pages;
    }
}
 
class Word extends Document {
    String type;
    Word(String type) {
        super(20); //default pages
        /*INSERT-1*/ this.type = type;
    }
    
    Word(int pages, String type) {
        /*INSERT-2*/this(type);
        super.pages = pages;
    }
}
  Word obj = new Word(25, "TEXT");
```   
- Inheriting super class variables
 
 <p> Variable i2 is declared protected so it can only be accessed in subclass using using inheritance but not using object reference variable. obj.i2 causes compilation error.
  class B inherits variable i2 from class A, so inside class B it can be accessed by using either this or super. Line 10 and Line 11 don't cause any compilation error.</p>

```java
public class A {
    public int i1 = 1;
    protected int i2 = 2;
}
import com.udayankhattry.ocp.A;
 
public class B extends A {
    public void print() {
        A obj = new A();
        System.out.println(obj.i1); //Line 8
        System.out.println(obj.i2); //Line 9 // compile error
        System.out.println(this.i2); //Line 10
        System.out.println(super.i2); //Line 11
    }
}
new B().println();

```