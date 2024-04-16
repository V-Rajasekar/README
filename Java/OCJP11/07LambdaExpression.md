 no lambda expression can be passed directly to println method.
 Or you can typecast lambda expression to target type. e.g. following works:

System.out.println((Operator<String>)(String s1, String s2) -> s1 + s2);
System.out.println((Operator<String>)(s1, s2) -> s1 + s2);
System.out.println((Operator<String>)(s1, s2) -> { return s1 + s2; });

```java
interface MyRunnable {
    int run(Double start, Double end);
}
 public static void startRunning(MyRunnable r) {
        System.out.println(r.run(5.8, null)); //Line n1
    }
startRunning((var d1, var d2) -> Double.valueOf(d1 + (d2 == null ? 0.0 : d2)).intValue());

```

//Compilation error, literals and constants are not allowed as lambda parameters.
Operator opr = (15, 25) -> Calculator.add(15, 25);

//

```java
// Allowed: Test::cube
//(x, y, z) -> Test::cube(x, y, z)✗  Compilation error, when method reference syntax is used, then method parameters and not used.
public class Test {
    private static int cube(int i, int j, int k) {
        return i * j * k;
    }
}
----------
 By looking at the statement, ObjectCreator<Integer> obj = Integer::valueOf; you can say that interface name should be ObjectCreator and it should be a generic interface. so option 1 below is invalid.
 ObjectCreator<Integer> obj = Integer::valueOf;
 1.

interface ObjectCreator {
    Integer create(String str);
}
2.

interface ObjectCreator<T> {
    T create(String str);
}
3.

interface ObjectCreator<T extends Integer> {
    T create(String str);
}
4.

interface ObjectCreator<T extends Number> {
    T create(String str);
}


class Student {
public static int compareByAge(Student s1, Student s2) {
        return s1.age - s2.age;
    }
}
----
List<Student> students = Arrays.asList(new Student("john", 25), new Student("lucy", 21), new Student("ivy", 23));
Collections.sort(students, Student::compareByAge); // sorts list in asc order by age
----
interface Creator<T> {
    T create();
}
 
class Book {
    public Book() {
        System.out.println(1);
    }
}
 Creator<Book> obj = Book::new; // Creates only a Book instance not an object, so print 1 at this point in time.
 obj.create(); //prints 1 and creates and returns a book object.
-----
interface Writer {
    void print(Object obj);
}
Writer obj = System.out::print; // creates Writer object with print method Impl
obj.print("BE HONEST");// prints BE HONEST

```

## calling non instance method using lambda expression

interface Calculation {
    void calc(int i, int j);
}

class MyClass {
    public void add(int i, int j) {
        System.out.println(i * j);
    }
}

public class Test {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        Calculation calcObj = (i, j) -> System.out.println(i * j); //Line n1
        calcObj.calc(24, 12);
    }
}
Line n1 can be replaced with obj::add;

 example of "Reference to an Instance Method of an Arbitrary Object of a Particular Type".
SomeInterface obj = (str, index) -> str.substring(index);
SomeInterface obj = String::subString;
MyInterface obj = (Student s) -> s.getMarks();
MyInterface obj = Student::getMarks;

interface Printable {
    void print(Printer p1, Printer p2);
}

class Printer {
    public static void print(Printer p1, Printer p2) {
        System.out.println(p1.toString() + "$$" + p2.toString());
    }

    public String toString() {
        return "Hello";
    }
}

Printable printObj = Printer::print;
printObj.print(new Printer(), new Printer());

It is always handy to remember the names and methods of four important built-in functional interfaces:

```java
Supplier<T> : T get();

Function<T, R> : R apply(T t);

Consumer<T> : void accept(T t);

Predicate<T> : boolean test(T t);

Note: Rest of the built-in functional interfaces are either similar to or dependent upon these four interfaces. BooleanSupplier is the only Functional interface available for boolean primitive type.
```

## BiFunction and BiPredicate

* BiPredicate<T, U> : boolean test(T t, U u);
* BiFunction<T, U, R> : R apply(T t, U u);

```java
System.out.println(predicate.test("JaVa", "Java")); // is equivalen to (s1, s2) -> s1.equalsIgnoreCase(s2);, so true
String [] arr = {"A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab"};
BiPredicate<String, String> predicate = String::startsWith;

for(String str : arr) {
    if(predicate.negate().test(str, "A"))
        System.out.println(str);
}
  //Prints all words other than starting with A , means ab, bab...



BiPredicate<String, String> predicate = String::contains;
        BiFunction<String, String, Boolean> func = (str1, str2) -> {
            return predicate.test(str1, str2) ? true : false;
        };
 System.out.println(func.apply("Tomato", "at")); //true  
```

## Function

Function<char [], String> obj = String::new; //Line n1
    String s = obj.apply(new char[] {'j', 'a', 'v', 'a'}); //Line n2 // Prints java

Function<Integer, Integer> f = x -> x + 10;
Function<Integer, Integer> g = y -> y * y;

Function<Integer, Integer> fog = g.compose(f); //Line n1
System.out.println(fog.apply(10));  // prints 400
g.compose(f) means first apply the f function and then the g. It can be replaced as f.andThen(g)

* `ToIntFunction<T>` has method: int applyAsInt(T value);
* interface UnaryOperator<T> extends Function<T, T>, so its apply function has the signature: T apply(T).
  Methods:
  default <V> Function<V, T> compose(Function<? super V, ? extends T> before) {...}
  default <V> Function<T, V> andThen(Function<? super T, ? extends V> after) {...}
 **compose and andThen methods doesn't change the object, on which these methods are invoked, rather creates a new Function<T, T> object.**
* interface BinaryOperator<T> extends Function<T, T, T>, so its apply function has the signature: T apply(T, T).

```java
BinaryOperator<List<String>> operator = BinaryOperator.minBy((s1, s2) -> s1.size() - s2.size()); //Line n1
if we pass two lists (l1= ["A"], l2= ["A", "B"]) operator.apply(l1, l2) -> [A]  
```

## DoubleFunction & DoubleUnaryOperator


`DoubleFunction<DoubleUnaryOperator> func = m -> n -> m + n; //Line n1
System.out.println(func.apply(11).applyAsDouble(24)); //Line n2 prints 35.0`

## LongFunction & LongUnaryOperator
  LongFunction<LongUnaryOperator> func = a -> b -> b - a; //Line n1
        System.out.println(calc(func.apply(100), 50)); //Line n2 //prints -50

```java
  UnaryOperator<String> opr = s -> s.toString().toUpperCase(); //Line n1
        System.out.println(opr.apply(new StringBuilder("Hello"))); //Line n2 compile error
//Here UnaryOperator<String> is used and hence apply method have to ve String apply(String)

java.util.function.Predicate<String> predicate = s -> true; can be replaced by `s -> {return true;}```
```

 - Predicate is a generic interface but raw type is also allowed. Type of the variable in lambda expression is inferred by the generic type of Predicate<T> interface. 

 String [] arr = {"*", "**", "***", "****", "*****", "******"};
        Predicate<String> pr1 = s -> s.length() < 4;
        //Predicate pr1 = s -> s.length() < 4; cause compile error consider Predicate<Object> as length is not there in Object class compile error
private static void print(String [] arr, Predicate<String> predicate) {
        for(String str : arr) {
            if(predicate.test(str)) {
                System.out.println(str);
            }
        }
    }        

- Consumer
Consumer<Integer> consumer = System.out::print;
Integer i = 5;
consumer.andThen(consumer).accept(i++); //Line n1 value passed in the argument of accept method is passed to both the consumer objects, so prints 55
 
static int count = 1;
Consumer<Integer> add = i -> Counter.count += i;
Consumer<Integer> print = System.out::println;
add.andThen(print).accept(10); //Line n1 add.accept(10)-> 11, second consumer prints 10


 StringConsumer consumer = new StringConsumer() {
    @Override
    public void accept(String s) {
        System.out.println(s.toLowerCase());
    }
};
List<String> list = Arrays.asList("Dr", "Mr", "Miss", "Mrs");
list.forEach(consumer); // prints dr, mr, miss, mrs

 NavigableMap<Integer, String> map = new TreeMap<>();
        BiConsumer<Integer, String> consumer = map::putIfAbsent; // Put if the value is NULL {1=ONE, 2=two}
        consumer.accept(1, null);
        consumer.accept(2, "two");
        consumer.accept(1, "ONE");
        consumer.accept(2, "TWO");

//Line n1 compile error due to ambigous call
  System.out.println(create(new char[]{'o', 'u', 't'}, String::new).length()); //Line n1
  
   private static String create(char [] c, Function<char[], String> func) { //Line n2
        return func.apply(c);
    }
 
    private static String create(char [] c, Supplier<String> supplier) { //Line n3
        return supplier.get();
    }
//removeIf
`removeIf(Predicate<? super E> filter)` <p>method was added as a default method in Collection<E> interface in JDK 8 and it removes all the elements of this collection that satisfy the given predicate.</p>

```java
 List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder("AAA")); //Line n1
 list.removeIf(sb -> sb.equals(new StringBuilder("AAA"))); //Line n4
 System.out.println(list); //prints []
 Note: same code throws runtime exception on List.of(E1, E2);
```


Question: 69
