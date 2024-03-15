# Exam Essentials

- [Exam Essentials](#exam-essentials)
  - [Data type:](#data-type)
  - [Assignment operations](#assignment-operations)
  - [String](#string)
    - [String concat null](#string-concat-null)
    - [String concat rule](#string-concat-rule)
    - [String join, split, StringBuilder delete](#string-join-split-stringbuilder-delete)
    - [String Builder (delete, comparision)](#string-builder-delete-comparision)
  - [var declaration:](#var-declaration)
  - [Increment operator](#increment-operator)
  - [Bitwise and Logic operator](#bitwise-and-logic-operator)
- [Loops](#loops)
  - [Lamdas and Functional Interfaces](#lamdas-and-functional-interfaces)
    - [Function(T, R)-\> R:apply(T)](#functiont-r--rapplyt)
    - [Lambda expressions](#lambda-expressions)
  - [Formatting Number, Currency, DecimalFormat](#formatting-number-currency-decimalformat)
  - [Annotations](#annotations)
  - [Path.resolve](#pathresolve)
  - [JDBC](#jdbc)
  - [Resource Bundle](#resource-bundle)
  - [Thread (Concurrency)](#thread-concurrency)
    - [ScheduledExecutor](#scheduledexecutor)
    - [java.util.concurrent.atomic.AtomicInteger/Boolean/Long](#javautilconcurrentatomicatomicintegerbooleanlong)
  - [java.util.concurrent.lock.ReentrantLock](#javautilconcurrentlockreentrantlock)
    - [java,util.concurrent.CyclicBarrier](#javautilconcurrentcyclicbarrier)

## Data type: 
- Data type conversion
  Casting is required when assigning large value to small value

```java
  float f = 12.25f
  long l = 100_00;
  l = (long)f;

 /* which primitive types are allowed here, Is var allowed ? var not allowed in compound statement. To print 3 byte out f range, short, int, long returns length 3, where as fload and double have .0 with 5 length. Its short, int, long */
  /*INSERT*/ x = 7, y = 200;
        System.out.println(String.valueOf(x + y).length()); // to print 3
```


- Java can do implict casting int to double, but not then autoboxing int -> double -> Double
```java
   m(1); // Number version 
   //Here 1 int -> Integer  Note all the numeric wrapper classes (Byte, Short, Integer, Long, Float and Double) extend from Number
   // If no is not there then Object version.
   private static void m(Object obj) {
        System.out.println("Object version");
    }
    
    private static void m(Number obj) {
        System.out.println("Number version");
    }
    
    private static void m(Double obj) {
        System.out.println("Double version");
    }
```

  

- Java Casting method call
 - add(10.0, null) // calls Double version
 - add(10.0, new Double(10.0)) // runtime ambiguous error
```java

    private static void add(double d1, double d2) {
        System.out.println("double version: " + (d1 + d2));
    }
    
    private static void add(Double d1, Double d2) {
        System.out.println("Double version: " + (d1 + d2));
    }
    
```

- byte increment statement behaviour


```java
byte var = 127;

var = var - 1: 'var - 1' results in int type and it cannot be assigned to byte type without explicit casting, hence it causes compilation error.

var = var + 1: 'var + 1' results in int type and it cannot be assigned to byte type without explicit casting, hence it causes compilation error.

Please note that implicit casting is added by the compiler for prefix, postfix and compound assignment operators.

++var: Compiler converts it to var = (byte) (var + 1) and hence it compiles successfully.

--var: Compiler converts it to var = (byte) (var - 1) and hence it compiles successfully.
```


## Assignment operations

Given:
int x = 1, y = 2, z = 3;
x += y *= z -= x;

what is the output x , y and Z ? //output 5 4 2

The assignment operator assigns the value on its right to operand on its left. Unlike all other operators in Java,
assignment operator are evaluated from right to left.

z = z - x; 2
y = y * z; 4
x = x + y; 5

## String 

### String concat null

If only one operand expression is of type String, then string conversion is performed on the other operand to produce a string at run time.

If one of the operand is null, it is converted to the string "null".

If operand is not null, then the conversion is performed as if by an invocation of the toString method of the referenced object with no arguments; but if the result of invoking the toString method is null, then the string "null" is used instead.

>Note: //If one of operand in the String concat is string then the result will be concated String.
String text = null;

```java
String text = null;
1. System.out.println(text.repeat(3)); // compile error

2. System.out.println(null + null + null); //error

3. System.out.println(null + "null" + null); // correct

4. System.out.println(text *= 3); //error

5. System.out.println(text += "null".repeat(2)); //correct nullnullnull

6. System.out.println(text + text + text); //correct

7. text += null; System.out.println((text.concat(null))); //NPE
```

- **strip()** method of String class (available since Java 11) returns a string whose value is this string, with **all leading and trailing white space removed**.
- `String contentEquals(StringBuilder)`, contentEquals().Please note that String, StringBuilder and StringBuffer classes implement CharSequence interface, hence contentEquals(CharSequence) method defined in String class cab be invoked with the argument of either String or StringBuilder or StringBuffer. 

```java
String s1 = "OcP";
String s2 = "oCP";
s1.contentEquals(s2); //false char mismatch

//String print with assignment
String fName = "Joshua";
String lName = "Bloch";
System.out.println(fName = lName); // Bloch 

### Removing leading, trailing space using
Methods: trim(), strip(),
stripLeading(), StringTrailing()
There is nothing like trimLeading(), trimTrailing()
  String text = "    BE YOURSELF!    ";  
  text.trimLeading().trimTrailing();

### String Repeat, indexOf

```java
final String str = "+";
str.repeat(2); // +++

String str = "PANIC";
StringBuilder sb = new StringBuilder("THET");
System.out.println(str.replace("N", sb)); //Line n1 PATHETIC

boolean flag1 = "Java" == "Java".replace('J', 'J'); //Line n1
boolean flag2 = "Java" == "Java".replace("J", "J"); //Line n2
System.out.println(flag1 && flag2); //false new String object is created after replace call.   

"faraway".indexOf("a", 4); => 5, 4 is the searching starting index
```

### String concat rule

<p>Rule1: Strings computed by concatenation at compile time, will be referred by String Pool during execution.
Rule 2: Compile time String concatenation happens when both of the operands are compile time constants, such as literal, final variable etc.</p>

```java
  String s1 = "1Z0-819"; //String literal
  String s2 = "1Z0-819" + ""; // string constants are from String literal adding them refer to String literal pool.
 System.out.println(s1 == s2); //true during compile time s2 = "1Z0-819" and in runtime refers the already existing String in StringPool.

  final String fName = "James";
  String lName = "Gosling";
  String name1 = fName + lName; //concatination happens in runtime, and not refer in String pool
  String name2 = fName + "Gosling"; //constant + constant literal result in string pool
  String name3 = "James" + "Gosling";//constant literal + constant literal and compile time James Gosling.
  System.out.println(name1 == name2); //false
  System.out.println(name2 == name3); // true

  final int i1 = 1;
  final Integer i2 = 1; // i2 is neither a primitive nor string type
  final String s1 = ":ONE";

  String str1 = i1 + s1;
  String str2 = i2 + s1;

  System.out.println(str1 == "1:ONE"); //true
  System.out.println(str2 == "1:ONE");//false

   String javaworld = "JavaWorld";
        String java = "Java";
        String world = "World";
        java += world; //Creates a new String object
        System.out.println(java == javaworld); //nonPool object == pool object, so false
```

### String join, split, StringBuilder delete

```java
String [] arr1 = {null, null};
System.out.println("1. " + String.join("::", arr1));// null::null   

System.out.println("4. " + String.join(".", null)); // compile time error requires non null value.
String str = "BEVERAGE";
String [] arr = str.split("E", 3);
// str.split("E", 3); returns ["B","V","RAGE"] as pattern is applied 3 - 1 = 2 times.


```

### String Builder (delete, comparision)

<p>toString() method defined in StringBuilder class doesn't use String literal rather uses the constructor of String class to create the instance of String class.</p>

```java
 StringBuilder sb = new StringBuilder("Dream BIG");
  String s1 = sb.toString();
  String s2 = sb.toString();
  
  System.out.println(s1 == s2); // false since uses 

  //To delete characters in a String use StringBuilder delete
  String strBuilder = new StringBuilder("Dream BIG").delete(5,6);// DreamBIG

  strBuilder.append(null) //compile error
 //outputs 0
  new StringBuilder("Friends are treasures")
        .delete(0, 100)
        .length();
//replace
strBuilder.replace(start, end, "replacing string");

 StringBuilder str = new StringBuilder("I love India");
  str.replace(2,6, "live"); // I live India
  str.replace(2,6, "live in");// I live in India

//

 StringBuilder sb = new StringBuilder("ELECTROTHERMAL"); //Line n1
    sb.setLength(7); //Reduces the SB length to 7
    System.out.print(sb.toString().strip()); //Line n3
    System.out.print(":"); //Line n4
    sb.setLength(14); //Line n5// extend the length to 14 with trailing spaces after 7
    System.out.println(sb.toString().strip()); //Line n6 ELECTRO:ELECTRO

```

## var declaration:

var x = "Java"; //x infers to String

var m = 10; //m infers to int

<p>Local variable Type inference is applicable only for local variables and not for instance or class variables. 
var type cannot be the target type of lambda expressions and method references.
var type cannot be used as constructor or method parameters or method return type
</p>

Below Statements are not allowed.

```shell
 private var place = "Unknown";  //Line n1
 
 public static final var DISTANCE = 200; //Line n2 

 var lambda1 = () -> System.out.println("Hello"); //Line n5
 
  public static void operate(var v1, var v2) {
        System.out.println(v1 + v2);
  }
jshell> var arr [] = new String[2];
|  Error:
|  'var' is not allowed as an element type of an array
|  var arr [] = new String[2];
```
what are the types which can replace the insert ? 
var, int, long, float and double. cannot be replaced with byte or short because int variable cannot be implicitly casted to byte or short types.
  ```java
    var m = 10; //Line n1
    var n = 20; //Line n2
    /*INSERT*/ p = m = n = 30; //Line n3
    System.out.println(m + n + p); //Line n4
  ```

## Increment operator

```java
    int i = 2;
    if (i++ == 2 && i-- == 2) { // after this condition i = 2, but after i++ condition evaluation  i = 3
        System.out.println("print: True" + i);
    } else {
        System.out.println("print: False" + i); // Prints False 2
    }


int x = 7;
boolean res = x++ == 7 && ++x == 9 || x++ == 9;
System.out.println("x = " + x);     //10
System.out.println("res = " + res); //true

Order of precedence in this case x++, ++x, ==
boolean res = (x++) == 7 && ++x == 9 || (x++) == 9; // 7==7 true & x=8 //postfix
              (x++) == 7 && (++x) == 9 || (x++) == 9; // true & true x =9 //prefix
              ((x++) == 7) && ((++x) == 9) || ((x++) == 9); //then comes == x = 10
              

 int a = 1000;
 System.out.println(-a++); //at this point its -1000(only)

 public class Test {
    public static void main(String[] args) {
        String[] arr = { "L", "I", "V", "E" }; //Line n1
        int i = -2;
 
        if (i++ == -1) { //Line n2 i=-2 (-2 = -1)
            arr[-(--i)] = "F"; //Line n3
        } else if (--i == -2) { //Line n4 i=-1 (-2 = -2)
            arr[-++i] = "O"; //Line n5 i=-2 -(++-2)-> -(-1) = i=2
        }
 
        System.out.println(String.join("", arr)); //Line n6
    }
}

```

## Bitwise and Logic operator

System.out.println(status = false || status = true | status = false);

//Bitwise inclusive OR | has highest precedence over logical or || and assignment =
For assignment operator to work, left operand must be variable but in above case, `(true | status) = false` causes compilation failure as left operand (true | status) evaluates to a boolean value and not boolean variable.

# Loops

```java
int ctr = 100;
        one: for (var i = 0; i < 10; i++) {
            two: for (var j = 0; j < 7; j++) {
                three: while (true) {
                    ctr++;
                    if (i > j) {
                        break one;
                    } else if (i == j) {
                        break two;
                    } else {
                        break three;
                    }
                }
            }
            //output 102 break from all the outer loops

 int i = 0;
        for(System.out.print(i++); i < 2; System.out.print(i++)) {
            System.out.print(i);
        }
        
```

## Lamdas and Functional Interfaces

### Function(T, R)-> R:apply(T)

```java
   public long calculate(long factor, function<Integer, Long> func) {
   return func.apply(factor);
   }

   int factor = 2;
   calculate(3, x -> factor * x); //compile error cannot convert Long to integer. Bcos the 3 is infered as Integer here when its multipled with 2 it produces int, so Java can autobox int -> Integer and not int -> Long
   //solution change the input param to Long 
   static long calculate(long factor, Function< Long, Long> func) {
   return func.apply(factor);
   }

   int factor = 6;
   System.out.println(calculate(3, x -> factor * x)); // outputs 8
```

### Lambda expressions

Lambda expressions, or lambdas, allow passing around blocks of code. The full syntax looks like this:

`(String a, String b) -> { return a.equals(b); }`

The parameter types can be omitted. When only one parameter is specified without a type the parentheses can also be omitted. The braces and return statement can be omitted for a single statement, making the short form as follows:

`a -> a.equals(b)`

 interface Secret {
     String magic(double d);
  }

  class MySecret implements Secret {
     public String magic(double d) {
        return "Poof";
     }
  }
Replacing MySecret
(e) -> { String e = ""; return "Poof"; } // compile error reusing e.
(e) -> { String f = ""; return "Poof"; } //compiles.

- var are allowed in Lambda expression, following code compiles.

```java
  public void method() {
     x((var x) -> {}, (var x, var y) -> 0);
  }
  public void x(Consumer<String> x, Comparator<Boolean> y) {
  }
```

 public void remove(List<Character> chars) {
     char end = 'z';
     // INSERT LINE HERE
     chars.removeIf(c -> {
        char start = 'a'; return start <= c && c <= end; });
  }
  Lambdas are not allowed to redeclare local var so char start and char c not allowed end =1 no, should be effective final. chars = null; compiles, but on runtime fails.

Set<String> set = Set.of("mickey", "minnie");
List<String> list = new ArrayList<>(set);
set.forEach(s -> System.out.println(s)); //prints
list.forEach(s -> System.out.println(s)); //prints

- Sorting using comparator
  c1.compareTo(c2) dues a natural sorting (i.e) ascending 1, 2, 3
  //But when you have [a, B, A, c] sort -> [A, B, a, c]

```java
import java.util.*;
List<String> cats = new ArrayList<>();
cats.add("leo");
cats.add("Olivia");
cats.sort((c1, c2) -> c1.compareTo(c2)); //[Olivia, leo]
cats.sort((c1, c2) -> -c1.compareTo(c2)); // [leo, Olivia]
```

  _______________ first = () -> Set.of(1.23); // supplier with no parameter
  _______________ second = x -> true; // Predicate with on param returning boolean

Consumer<Set<Double>>
Consumer<Set<Float>>
Predicate<Set<Double>> //Line 2
Predicate<Set<Float>> //Line 2
Supplier<Set<Double>> // Line 1
Supplier<Set<Float>>

## Formatting Number, Currency, DecimalFormat

```java
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.time.Month;
import static java.util.Locale.Category.*;
import static java.time.format.FormatStyle.SHORT;

//creating Instances 

Locale india = new Locale("hi", "IND", "INDIA");
Locale usl = Locale.US;
 //en_US
Locale canada = Locale.CANADA_FRENCH;
//fr_CA
Locale germany = Locale.GERMANY;
 //de_DE
Locale britian = Locale.UK;
// en_GB

int amount = 40_10_000;
var in = NumberFormat.getInstance(india);
var us = NumberFormat.getInstance(usl);
var ca = NumberFormat.getInstance(canada);
var gr = NumberFormat.getInstance(germany);
var uk = NumberFormat.getInstance(britian);
System.out.println ("Number Format: from " + amount + "to:");
var inc = NumberFormat.getCurrencyInstance(india);
var usc = NumberFormat.getCurrencyInstance(usl);
var cac = NumberFormat.getCurrencyInstance(canada);
var grc = NumberFormat.getCurrencyInstance(germany);
var ukc = NumberFormat.getCurrencyInstance(britian);
System.out.println("Currency Format: from " + amount + "to:");
System.out.println("India:" + inc.format(amount));
System.out.println("US: " + usc.format(amount));
System.out.println("CANADA:" + cac.format(amount));
System.out.println("UK:" + ukc.format(amount));
//Parsing numbers and currency 

String s = "40.45";
 
var en = NumberFormat.getInstance(Locale.US);
System.out.println(en.parse(s));  // 40.45
 
var fr = NumberFormat.getInstance(Locale.FRANCE);
System.out.println(fr.parse(s));  // 40 France doesn't use decimals point to separate numbers

String income = "$92,807.99";
// without passign the Locale.US default local is applied and that causes parse exception
var cf = NumberFormat.getCurrencyInstance(usl);
double value = (Double) cf.parse(income);
System.out.println(value); // 92807.99
//Decimal format 
double d = 1234567.467;
System.out.println("DecimalFormat this number using # and 0 omits: " + d);
NumberFormat f1 = new DecimalFormat("###,###,###.0");
System.out.println("Decimal Format with ###,###,###.0/ " + f1.format(d));  // 1,234,567.5
NumberFormat f2 = new DecimalFormat("000,000,000.00000");
System.out.println("Decimal Format with 000,000,000.00000/" + f2.format(d));  // 001,234,567.46700

//Localized DateTimeFormatter

public static void print(DateTimeFormatter dtf,
      LocalDateTime dateTime, Locale locale) {
   System.out.println(dtf.format(dateTime) + ", " 
      + dtf.withLocale(locale).format(dateTime));
}

 Locale.setDefault(new Locale("en", "US"));
   var italy = new Locale("it", "IT");
   var dt = LocalDateTime.of(2020, Month.OCTOBER, 20, 15, 12, 34);
 
   // 10/20/20, 20/10/20
   print(DateTimeFormatter.ofLocalizedDate(SHORT),dt,italy);

// Locale.Category.Display; Locale.Category.Format;

public static void printCurrency(Locale locale, double money) {
    System.out.println(
      NumberFormat.getCurrencyInstance().format(money) 
      + ", " + locale.getDisplayLanguage());
}
var money = 1.23;
Locale.setDefault(usl); //Default US
var spain = new Locale("es", "ES");
// Print with default locale
printCurrency(spain, money); //prints $1.23, Spanish Uses the default country en_US

// Print with default locale and selected locale display
Locale.setDefault(Category.DISPLAY, spain); 
printCurrency(spain, money); //$1.23, espa±ol

// Print with default locale and selected locale format
    Locale.setDefault(Category.FORMAT, spain);
    printCurrency(spain, money);  // 1,23 €, espaÑol
//Locale.setDefault(us) after the previous code snippet will change both locale categories to en_US
```

## Annotations

class A {}

class B extends A {}

class C extends B {}

//type of element in l1 is C or its Super B itself
List<? super B> l1 = new ArrayList<>();

// type of element in l2 is B and any of its subtype, but if add C will result compile error see the explanation.
List<? extends B> l2 = new ArrayList<>();

l1  = l2/ no its like A = C; overlap is B, but they aren't inherited
l2 = l1 // same as above.
l1.add(new A()); //only B or C
l1.add(new C());
l2.add(new C()); //  incompatible types: C cannot be converted to capture#10 of ? extends B
The reason for the compilation error is that you cannot add elements to a List<? extends B>. When you declare a list with List<? extends B>, it means the list can hold objects of a type that is a subclass of B, but the exact subtype is unknown at compile time.

The add() method of the List interface doesn't work with a wildcard (?). It can't guarantee the type safety when adding elements because the actual type could be any subtype of B, not just C. This is to ensure type safety in Java.
l2.add(new A()); //only B

## Path.resolve

Path path1 = Path.of("/cats/../panther");
Path path2 = Path.of("food");
Path path3 = Path.of("/food");
//Relative path appends the new path with preceeding old path
System.out.println(path1.resolve(path2)); // /cats/../panther/food;
//Absolute path returns /absolute new path
System.out.println(path1.resolve(path3)); // /food

Path p1 = Path.of("/a/b");
Path p2 = Path.of("/a/c");
p1.resolve(p2); // Prints /a/c

## JDBC

How to call a stored procedure?
conn.prepareCall("{call MY_PROC}");

## Resource Bundle

To select the appropriate ResourceBundle. Java will follow this order.

1. ResourceBundle class for the specified Locale (match both language and country)
2. ResourceBundle class for the specified Locale (match only language)
3. ResourceBundle class for the default Locale (match both language and country)
4. ResourceBundle class for the default Locale (match only language)
5. Use the default resource bundle if no matching locale can be found.

Since the desired locale is fr_CA and the default one is en_US, resources are sec
following order:
NationalDay_fr_CA
NationalDay_fr
NationalDay_en_US
NationalDay_en
NationalDay
Notice the class names are case-sensitive, hence NationalDay_FR isn't part of the bundle.

## Thread (Concurrency)

- package `java.util.concurrent`
- creating thread by a class implementing Runnable or extend Thread and overridding the void run{} method.
- Thread API ExecutorService and Executors

```java
 ExecutorService service = Executors.newSingleThreadExecutor(); 
  service.execute(() -> {System.out.println("Printing zoo inventory");});
  if (service != null) service.shutdown();
```

Api methods in ExecutorService

- The `isShutdown()` method returns true once the shutdown() method is called.
- The `isTerminated` method returns true only when the thread is shutdown.
- `awaitTermination​(long maxTimeout, TimeUnit unit)` method waits the specified time until all tasks have completed execution, returns earlier if the task are completed much before the maxTimeout or an interruptException is detected
- `void:execute(Runnable), Future:submit(Runnable/Callable), Future:invokeAll(Collections extends Callable)` wait for all task to complete and returns a future for each, `Future:invokeAny(task)` execute any one task and cancels all other pending tasks.

### ScheduledExecutor

```java
//creating a singleThreadScheduledExecutor
 ScheduledExecutorService service
    = Executors.newSingleThreadScheduledExecutor();
//Creating a Runnable and Callable tasks    
    Runnable task1 = () -> System.out.println("Hello Zoo");
    Callable<String> task2 = () -> "Monkey";
//Scheduling the tasks    
    ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
    ScheduledFuture<?> r2 = service.schedule(task2, 8,  TimeUnit.MINUTES);   
//Creating ExecutorService with Threaa pools
ExecutorService.newCachedThreadPool();
ExecutorService.newFixedThreadPool(int);
ScheduledExecutorService.newScheduledThreadPool(int);

```
**Review API methods of ExecutorService**

<p>The `java.util.concurrent.Callable` functional interface is similar to Runnable except that its call() method returns a value and can throw a checked exception.</p>

```java
    @FunctionalInterface public interface Callable<V> {
     V call() throws Exception;
    }
```
### java.util.concurrent.atomic.AtomicInteger/Boolean/Long
- java.util.concurrent.atomic: AtomicInteger, AtomicBoolean, AtomicLong
-  private AtomicInteger sheepCount = new AtomicInteger(0)

##  java.util.concurrent.lock.ReentrantLock

Lock lock - new ReentrantLock();
lock.lock() - Waits
lock.tryLock():boolean - trys to acquired the lock immediately and return the success status true/false
lock.unlock() - to release the lock.
 
### java,util.concurrent.CyclicBarrier
A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point. CyclicBarriers are useful in programs involving a fixed sized party of threads that must occasionally wait for each other. The barrier is called cyclic because it can be re-used after the waiting threads are released.
