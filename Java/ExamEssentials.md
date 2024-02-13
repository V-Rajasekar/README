# Exam Essentials

## Lamdas and Functional Interfaces

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

