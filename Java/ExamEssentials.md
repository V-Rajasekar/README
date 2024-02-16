# Exam Essentials
- [Exam Essentials](#exam-essentials)
  - [Assignment operations](#assignment-operations)
  - [Lamdas and Functional Interfaces](#lamdas-and-functional-interfaces)
    - [Function(T, R)-\> R:apply(T)](#functiont-r--rapplyt)
    - [Lambda expressions](#lambda-expressions)
  - [Formatting Number, Currency, DecimalFormat](#formatting-number-currency-decimalformat)
  - [Annotations](#annotations)
  - [Path.resolve](#pathresolve)
  - [JDBC](#jdbc)
  - [Resource Bundle](#resource-bundle)

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
NationalDay _en_US
NationalDay _en
NationalDay
Notice the class names are case-sensitive, hence NationalDay_FR isn't part of the bundle.