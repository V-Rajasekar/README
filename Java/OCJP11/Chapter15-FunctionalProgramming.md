# Chapter15- Functional Programming
- [Chapter15- Functional Programming](#chapter15--functional-programming)
    - [Supplier](#supplier)
    - [Consumer](#consumer)
    - [BiConsumer](#biconsumer)
    - [Predicate and BiPredicate](#predicate-and-bipredicate)
    - [Function and BiFunction](#function-and-bifunction)
    - [Custom Functional Interface](#custom-functional-interface)
    - [Implementing UnaryOperator and BinaryOperator](#implementing-unaryoperator-and-binaryoperator)
    - [Convenience Methods on Functional Interfaces.](#convenience-methods-on-functional-interfaces)
      - [Predicate(and(), negate())](#predicateand-negate)
      - [Consumer (andThen)](#consumer-andthen)
      - [Function compose(Function)](#function-composefunction)
      - [Returning an _Optional_](#returning-an-optional)
      - [Optional.OfNullable(value)](#optionalofnullablevalue)
    - [Using Streams](#using-streams)
      - [Creating Finite Streams](#creating-finite-streams)
      - [Creating Infinite Streams](#creating-infinite-streams)
      - [Terminal stream operations](#terminal-stream-operations)
    - [Common Intermediate Operations](#common-intermediate-operations)
    - [Putting Together the Pipeline](#putting-together-the-pipeline)
    - [Working with Primitive Streams](#working-with-primitive-streams)
      - [Common primitive stream methods](#common-primitive-stream-methods)
      - [Mapping Streams](#mapping-streams)
      - [Using FlatMap()](#using-flatmap)
      - [Using Optional with Primitive Streams](#using-optional-with-primitive-streams)
      - [Optional types for primitives](#optional-types-for-primitives)
    - [Working with Advanced Stream Pipeline Concepts](#working-with-advanced-stream-pipeline-concepts)
    - [Collection Results](#collection-results)
      - [Collectors.joining](#collectorsjoining)
      - [Collectors.averagingInt](#collectorsaveragingint)
      - [Collectors.toCollection(TreeSet::new)](#collectorstocollectiontreesetnew)
      - [Collecting into Maps](#collecting-into-maps)
      - [Collectors.groupingBy](#collectorsgroupingby)
      - [Collectors.partitioningBy](#collectorspartitioningby)
      - [Collectors.mapping](#collectorsmapping)


Functional interface|	Return type	|Method name	| of parameters|Example|
---------|----------|---------|---------|-------|
Supplier<T>	          |  T	       | get()	        |0        |LocalDate::now;
Consumer<T>	          |  void	   | accept(T)	    |1 (T)    |System.out:println
BiConsumer<T, U>	  |  void	   | accept(T,U)	|2 (T, U) |map::put
Predicate<T>	      |  boolean   | test(T)	    |1 (T)    |String::isEmpty
BiPredicate<T, U>	  |  boolean   | test(T,U)	    |2 (T, U) |String::startsWith
Function<T, R>		  |  R         | apply(T)	    |1 (T)    |String::concat
BiFunction<T, U, R>	  |  R	       | apply(T,U)	    |2 (T, U) |String::length
UnaryOperator<T>	  |  T	       | apply(T)	    |1 (T)    |String::toUpperCase
BinaryOperator<T>	  |  T	       | apply(T,T)	    |2 (T, T) |String::concat

- An Optional<T> can be empty or store a value. You can check whether it contains a value with isPresent() and get() the value inside. 
- You can return a different value with `orElse(T t)` or throw an exception with `orElseThrow()`.
- There are even three methods that take functional interfaces as parameters: 
  * `ifPresent(Consumer c), orElseGet(Supplier s), and orElseThrow(Supplier s)`. There are three optional types
- For primitives: OptionalDouble, OptionalInt, and OptionalLong. These have the methods getAsDouble(), getAsInt(), and getAsLong(), respectively. 
  
### Supplier

```java
 Supplier<LocalDate> s1 = LocalDate::now;
 LocalDate d1 = s1.get();

Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
ArrayList<String> a1 = s3.get();
System.out.println(a1);

System.out.println(s3); 
//prints `functionalinterface.BuiltIns$$Lambda$1/0x0000000800066840@4909b8da`
```
 <p>Our test class is named BuiltIns, and it is in a package that we created named functionalinterface. Then comes $$, which means that the class doesn't exist in a class file on the file system. It exists only in memory</p>

### Consumer

```java
Consumer<String> c1 = System.out::println;
c1.accept("Annie");
```

### BiConsumer
```java
var map = new HashMap<String, Integer>();
BiConsumer<String, Integer> b1 = map::put;
BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
b1.accept("chicken", 7);
System.out.println(map);
```

### Predicate and BiPredicate
```java
Predicate<String> p1 = String::isEmpty;
System.out.println(p1.test(""));  // true
```
- BiPredicate
  
```java
BiPredicate<String, String> b1 = String::startsWith;
 System.out.println(b1.test("chicken", "chick"));  // true
```

### Function and BiFunction
Function<String, Integer> f1 = String::length;
System.out.println(f1.apply("cluck")); // 5

BiFunction<String, String, String> b1 = String::concat;
System.out.println(b1.apply("baby ", "chick")); // baby chick

### Custom Functional Interface
Java's built‐in interfaces are meant to facilitate the most common functional interfaces that you'll need. It is by no means an exhaustive list
```java
@FunctionalInterface
    interface TriFunction<T,U,V,R> {
       R apply(T t, U u, V v);
    }
```
### Implementing UnaryOperator and BinaryOperator
- In the Javadoc, you'll notice that these methods are actually inherited from the Function/ BiFunction superclass. The generic declarations on the subclass are what force the type to be the same.

```java
UnaryOperator<String> u1 = String::toUpperCase;
System.out.println(u1.apply("chirp"));  // CHIRP
```
We don't need to specify the return type in the generics because UnaryOperator requires it to be the same as the parameter

```java
BinaryOperator<String> b1 = String::concat;
System.out.println(b1.apply("baby ", "chick")); // baby chick
```
<p>Notice that this does the same thing as the BiFunction example. The code is more succinct, which shows the importance of using the correct functional interface. It's nice to have one generic type specified instead of three.</p>

### Convenience Methods on Functional Interfaces.

Functional interface | MethodName | Method param
---------|----------|---------
 Predicate | and(),  or() | Predicate
 Predicate | negate() | ---
 Consumer | andThen() | Consumer  
 Function | andThen() , compose() | Function

#### Predicate(and(), negate())
Predicate<String> egg = s -> s.contains("egg");
Predicate<String> brown = s -> s.contains("brown");

//Get me only brown eggs 
Predicate<String> brownEggs = egg.and(brown);
//Get me eggs other than brown
Predicate<String> otherEggs = egg.and(brown.negate());

#### Consumer (andThen)

```java
Consumer<String> c1 = x -> System.out.print("1: " + x);
Consumer<String> c2 = x -> System.out.print(",2: " + x);
 
Consumer<String> combined = c1.andThen(c2);
combined.accept("Annie");              // 1: Annie,2: Annie
```
#### Function compose(Function)

```java
Function<Integer, Integer> before = x -> x + 1;
Function<Integer, Integer> after = x -> x * 2;
 
Function<Integer, Integer> combined = after.compose(before);
System.out.println(combined.apply(3));   // 8
```

#### Returning an _Optional_

```java
 Optional<Double> opt = average(90, 100);
 if (opt.isPresent())
    System.out.println(opt.get()); // 95.0
//Without isPresent() check. 
 Optional<Double> opt = average();
 System.out.println(opt.get()); // java.util.NoSuchElementException: No value present
```

#### Optional.OfNullable(value)
<p>When creating an Optional, it is common to want to use empty() when the value is null
you can do this like `Optional o = (value == null) ? Optional.empty() : Optional.of(value);`. Java provides a factory method to do the same thing</p>

- static method to create o = empty if the value is NULL.
* `Optional o = Optional.ofNullable(value);`
- Optional instance methods
  * get():T (throws NoSuchElement when optional isEmpty) 
  * ifPresent(Consumer)
  * isPresent():boolean
  * orElse(T other) if Optional is empty return other 
  * orElseGet(Supplier) if Optional is empty returns result of calling `Supplier`
  * orElseThrow() Return value(Exception)
  * orElseThrow(Supplier s) Throws exception created by calling `Supplier`

```java
30: Optional<Double> opt = average();
31: System.out.println(opt.orElseThrow(
32:    () -> new IllegalStateException()));

System.out.println(opt.orElseGet(
   () -> new IllegalStateException())); // DOES NOT COMPILE Since this supplier returns an exception, the type does not match.
```
- Advantages of Optional
* There wasn't a clear way to express that null might be a special value. By contrast, returning an Optional is a clear statement in the API that there might not be a value in there.
*  you can use a functional programming style with ifPresent() and the other methods rather than needing an if statement.

### Using Streams

#### Creating Finite Streams
```java
11: Stream<String> empty = Stream.empty();          // count = 0
12: Stream<Integer> singleElement = Stream.of(1);   // count = 1
13: Stream<Integer> fromArray = Stream.of(1, 2, 3); // count

14: var list = List.of("a", "b", "c");
15: Stream<String> fromList = list.stream();
16: Stream<String> fromListParallel = list.parallelStream();
```
#### Creating Infinite Streams
```java
17: Stream<Double> randoms = Stream.generate(Math::random);
18: Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
```

Method	                	        |Finite or inFinite?	|Notes
|------|------|-----|
Stream.empty()		                |Finite	|Creates Stream with zero elements
Stream.of(varargs)		            |Finite	|Creates Stream with elements listed
coll.stream()		                |Finite	|Creates Stream from a Collection
coll.parallelStream()		        |Finite	|Creates Stream from a Collection where the stream can run in parallel
Stream.generate(supplier)	In	    |Finite	|Creates Stream by calling the Supplier for each element upon request
Stream.iterate(seed,unaryOperator)	|InFinite	|Creates Stream by using the seed for the first element and then calling the UnaryOperator for each subsequent element upon request
Stream.iterate(seed,predicate, unaryOperator)		    |Finite or inFinite|Creates Stream by using the seed for the first element and then calling the UnaryOperator for each subsequent element upon request. Stops if the Predicate returns false

#### Terminal stream operations
Method	     |What happens for infinite streams	|Return value	|Reduction
|------|--------|-------|-------|
count()	     |Does not terminate	            |long	        |Yes
min()        |Does not terminate	            |Optional<T>	|Yes
max()	     |Does not terminate	            |Optional<T>	|Yes
findAny()    |Terminates	                    |Optional<T>	|No
findFirst()	 |Terminates	                    |Optional<T>	|No
allMatch()|
anyMatch()|
noneMatch()	 |Sometimes terminates	            |boolean	    |No
forEach()	 |Does not terminate	            |void	        |No
reduce()	 |Does not terminate	            |Varies	        |Yes
collect()	 |Does not terminate	            |Varies	        |Yes

- min()
```java
Stream<String> s = Stream.of("monkey", "ape", "bonobo");
Optional<String> min = s.min((s1, s2) -> s1.length()-s2.length());
min.ifPresent(System.out::println); // ape
```
- findAny() and findFirst()
The findAny() and findFirst() methods return an element of the stream unless the stream is empty. If the stream is empty, they return an empty Optional.
- anyMatch(), allMatch(), noneMatch(), anyMatch()
```java
  var list = List.of("monkey", "2", "chimp");
Stream<String> infinite = Stream.generate(() -> "chimp");
Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
 
System.out.println(list.stream().anyMatch(pred));  // true
System.out.println(list.stream().allMatch(pred));  // false
System.out.println(list.stream().noneMatch(pred)); // false
System.out.println(infinite.anyMatch(pred));       // true
```
- for loop on a stream.
```java
Stream<String> s = Stream.of("Monkey", "Gorilla", "Bonobo");
s.forEach(System.out::print); // MonkeyGorillaBonobo

Stream<Integer> s = Stream.of(1, 2, 3);
for (Integer i  : s) {} // DOES NOT COMPILE for-each not applicable to expression type  required: array or java.lang.Iterable
solution: for (Integer i  : s.toList()) {}
|   
```

- `reduce()`
<p>The reduce() method combines a stream into a single object.  Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value if any.<br>
what is an associative accumulation function ? 
Here total+currentElement is the accumulation function, which basically add the currentElement to the total  in the pipeline process it reduces the element to a single element.</p>

```java
double sumReduced = randomIntegerList
                    .stream()
                    .reduce((total, currentElement) -> total + currentElement)
                    .orElse(-1);
```

The three method signatures are these:
```java
//T reduce(T identity, BinaryOperator<T> accumulator)
Stream<Integer> stream = Stream.of(3, 5, 6);
System.out.println(stream.reduce(1, (a, b) -> a*b));  // 90
System.out.println(stream.reduce(2, (a, b) -> a*b));  // 180

//Optional<T> reduce(BinaryOperator<T> accumulator). It returns Optional.empty() when the stream is empty.
BinaryOperator<Integer> op = (a, b) -> a * b;
Stream<Integer> threeElements = Stream.of(3, 5, 6);
threeElements.reduce(op).ifPresent(System.out::println); // 90

/*<U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
* The first parameter ( 0) is the value for the initializer. If we had an empty stream, this would be the answer.
*/
Stream<String> stream = Stream.of("w", "o", "l", "f!");
int length = stream.reduce(0, (i, s) -> i+s.length(), (a, b) -> a+b);
System.out.println(length); // 5
```
- **collect()**
  
 * The collect() method is a special type of reduction called a mutable reduction.
 * The method signatures are: 
   * `<R> R collect(Supplier<R> supplier,  BiConsumer<R, ? super T> accumulator,  BiConsumer<R, R> combiner)`
   * `<R,A> R collect(Collector<? super T, A,R> collector)`
    ```java
        Stream<String> stream = Stream.of("w", "o", "l", "f");

        TreeSet<String> set = stream.collect(
        TreeSet::new, 
        TreeSet::add,
        TreeSet::addAll);

        System.out.println(set); // [f, l, o, w]

        TreeSet<String> set = 
        stream.collect(Collectors.toCollection(TreeSet::new));// set --> [f, l, o, w]
    ```
### Common Intermediate Operations

   * `filter()` method returns a Stream with elements that match a given expression.
   * The `distinct()` method returns a stream with duplicate values removed. 
    `Stream.of("duck", "duck", "duck", "goose").distinct().forEach(System.out::println)`
   *  The `limit() and skip()` methods can make a Stream smaller<br>
  
      ```java
        Stream<Integer> s = Stream.iterate(1, n -> n + 1);
        s.skip(5)
        .limit(2)
        .forEach(System.out::print); // 67
      ```
   * `map()` method on streams is for transforming data. 
   * The `flatMap()` method takes each element in the stream and makes any elements it contains top‐level elements in a single stream.<br>
   This gets all of the animals into the same level along with getting rid of the empty list.<br>
    
      ```java
        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);

        animals.flatMap(m -> m.stream())
          .forEach(System.out::println);
      ```

  * The `sorted()` method returns a stream with the elements sorted. 
  
      ```java
        Stream<String> s = Stream.of("brown-", "bear-");
        s.sorted()
        .forEach(System.out::print); // bear-brown-

        Stream<String> s = Stream.of("brown bear-", "grizzly-");
        s.sorted(Comparator.reverseOrder())
        .forEach(System.out::print); // grizzly-brown bear-

        s.sorted(Comparator::reverseOrder); // DOES NOT COMPILE
        /*The Comparator interface implements one method that takes two String parameters and returns an int. However, Comparator::reverseOrder doesn't do that. It is a reference to a function that takes zero parameters and returns a Comparator. This is not compatible with the interface*/
      ```

  * `peek()` method is our final intermediate operation. It is useful for debugging because it allows us to perform a stream operation without actually changing the stream.
 
      ```java
        var stream = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream.filter(s -> s.startsWith("g"))
        .peek(System.out::println).count();              // grizzly
        System.out.println(count); 
      ```  
  <p>that peek() looks only at the first element when working with a Queue. In a stream, peek() looks at each element that goes through that part of the stream pipeline. It's like having a worker take notes on how a particular step of the process is doing.</p>

### Putting Together the Pipeline 

```java
    // This one hangs as well until we kill the program.
    Stream.generate(() -> "Olaf Lazisson") // Creates a infinite stream
  .filter(n -> n.length() == 4) // filter doesn't satisfy
  .limit(2)
  .sorted()
  .forEach(System.out::println);

  //This works 
    var infinite = Stream.iterate(1, x -> x + 1);
    infinite.limit(5)
      .filter(x -> x % 2 == 1)
      .forEach(System.out::print); // 135

    var infinite = Stream.iterate(1, x -> x + 1);
    infinite.filter(x -> x % 2 == 1)
    .peek(System.out::print)
    .limit(5)
    .forEach(System.out::print);    

    //The answer is 1133557799. Since filter() is before peek(), we see only the odd number
```
### Working with Primitive Streams
- Creating Primitive Streams
  * `IntStream`: Used for the primitive types int, short, byte, and char
  * `LongStream`: Used for the primitive type long
  * `DoubleStream`: Used for the primitive types double and float

#### Common primitive stream methods
- OptionalDouble:average():	 The arithmetic mean of the elements. Always return OptionalDouble irrespective of the stream type.
- OptionalInt:max():The maximum element of the stream. the min and max returns the corresponding Optional type of the stream if its Long OptionalLong and OptionalDouble.
- sum():int, sum():long - returns the primitive type depending on the type of the stream. 

```java
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.*;
IntSummaryStatistics intStats = IntStream.range(1, 10).summaryStatistics();
LongSummaryStatistics longStats = LongStream.rangeClosed(1, 10).summaryStatistics();
 DoubleSummaryStatistics doubleStats = 
                DoubleStream.iterate(1.0, s -> s < 10.0, s -> s + 1)
                        .summaryStatistics();
        System.out.println(doubleStats);
        System.out.println("--- Reduction operations ----");
        System.out.println("Max = " + IntStream.range(1, 10).max());
        System.out.println("Min = " + LongStream.range(100, 1000).min());
        System.out.println("Average = " + DoubleStream.iterate(
                1.0, s -> s < 10.0, s -> s + 1).average());
        System.out.println("Sum = " + IntStream.iterate(
                5, s -> s < 100, s -> s + 5).sum());
 
  output 
  ------
  intStats ==> IntSummaryStatistics{count=9, sum=45, min=1, average=5.000000, max=9}
  longStats ==> LongSummaryStatistics{count=10, sum=55, min=1, average=5.500000, max=10}
  doubleStats ==> DoubleSummaryStatistics{count=9, sum=45.000000, m ... ge=5.000000, max=9.000000}
  DoubleSummaryStatistics{count=9, sum=45.000000, min=1.000000, average=5.000000, max=9.000000}
  --- Reduction operations ----
  Max = OptionalInt[9]
  Min = OptionalLong[100]
  Average = OptionalDouble[5.0]
  Sum = 950
```

#### Mapping Streams
 * Another way to create a primitive stream is by mapping from another stream type

Source 	 stream class   |  To create Stream |  To create IntStream	  |To create DoubleStream	|To create LongStream
-----------  |-----------  |-----------  |-----------  |-----------  |
Stream<T>	  |  map()	    | mapToDouble()	|mapToInt()	|mapToLong()
DoubleStream |	 mapToObj() |	map()	        |mapToInt()	|mapToLong()
IntStream	  |  mapToObj() |	mapToDouble()	|map()	    |mapToLong()
LongStream	  |  mapToObj() |	mapToDouble()	|mapToInt()	|map()

#### Using FlatMap()

```java
var integerList = new ArrayList<Integer>();
IntStream ints = integerList.stream()
.flatMapToInt(x -> IntStream.of(x));
DoubleStream doubles = integerList.stream()
.flatMapToDouble(x -> DoubleStream.of(x));
LongStream longs = integerList.stream()
.flatMapToLong(x -> LongStream.of(x));
```
- Creating map
```java
 private static Stream<Integer> mapping(IntStream stream) {
   return stream.mapToObj(x -> x);
}
 
private static Stream<Integer> boxing(IntStream stream) {
  return stream.boxed();
}
```

#### Using Optional with Primitive Streams

```java
var stream = IntStream.rangeClosed(1,10);
OptionalDouble optional = stream.average();
optional.ifPresent(System.out::println);                  // 5.5
System.out.println(optional.getAsDouble());               // 5.5
System.out.println(optional.orElseGet(() -> Double.NaN)); // 5.5
```

#### Optional types for primitives
                


---------|OptionalDouble|OptionalInt|OptionalLong
---------|---------|----------|---------
 Getting as a primitive	        |getAsDouble()	|  getAsInt()	    |getAsLong()
orElseGet() parameter type	    |DoubleSupplier	|IntSupplier	    |LongSupplier
Return type of max() and min()	|OptionalDouble	|OptionalInt	    |OptionalLong
Return type of sum()	          |double	        |int	            |long
Return type of average()	      |OptionalDouble	|OptionalDouble	  |OptionalDouble

- Summarizing Statistics

```java
private static int max(IntStream ints) {
   OptionalInt optional = ints.max();
   return optional.orElseThrow(RuntimeException::new);
}
```

```java
IntSummaryStatistics intStats = IntStream.range(1, 10).summaryStatistics();
intStats ==> IntSummaryStatistics{count=9, sum=45, min=1, average=5.000000, max=9}
```
<p>
- Smallest number (minimum): getMin()
- Largest number (maximum): getMax()
- Average: getAverage()
- Sum: getSum()
- Number of values: getCount()
</p>

### Working with Advanced Stream Pipeline Concepts

- Calculates the average for our three core primitive types	
  * averagingDouble(ToDoubleFunction f):Double
  * averagingInt(ToIntFunction f):Double
  * averagingLong(ToLongFunction f):Double
- Creates a map grouping by the specified function with the optional map type supplier and optional downstream collector	
`groupingBy(Function f, Supplier s, Collector dc):Map<K, List<T>>`
- Creates a single String using cs as a delimiter between elements if one is specified
* `joining(CharSequence cs):String`
- Finds the largest/smallest elements
  * `maxBy(Comparator c), minBy(Comparator c): Optional<T>`
- Adds another level of collectors
  * `mapping(Function f, Collector dc):Collector`
- Creates a map grouping by the specified predicate with the optional further downstream collector
  * `partitioningBy(Predicate p), partitioningBy(Predicate p, Collector dc):Map<Boolean, List<T>>`
- Calculates average, min, max, and so on 
  * summarizingDouble(ToDoubleFunction f):DoubleSummaryStatistics   
  * summarizingInt(ToIntFunction f):IntSummaryStatistics 
  * summarizingLong(ToLongFunction f):LongSummaryStatistics
- Calculates the sum for our three core primitive types
  * summingDouble(ToDoubleFunction f):Double
  * summingInt(ToIntFunction f):Int
  * summingLong(ToLongFunction f):Long
- Creates a Collection of the specified type
  * toCollection(Supplier s): Collection
- Creates a `map` using functions to map the keys, values, an optional merge function, and an optional map type supplier
  * toMap(Function k, Function v)
  * toMap(Function k, Function v, BinaryOperator m)
  * toMap(Function k, Function v, BinaryOperator m, Supplier s)
- Linking streams to the underlying Data
```java
25: var cats = new ArrayList<String>();
26: cats.add("Annie");
27: cats.add("Ripley");
28: var stream = cats.stream();
29: cats.add("KC");
30: System.out.println(stream.count()); // 3
``` 
- Chaining Optionals
```java
//Method prints only 3 digit characters. Incase the optional is empty then map, and filter passes the empty to the ifPresent() seein the empty Option it doesn't call the Consumer paramater.
private static void threeDigit(Optional<Integer> optional) {
   optional.map(n -> "" + n)            // part 1
      .filter(s -> s.length() == 3)     // part 2
      .ifPresent(System.out::println);  // part 3
}
```
suppose that we wanted to get an Optional<Integer> representing the length of the String contained in another Optional
`Optional<Integer> result = optional.map(String::length);`

### Collection Results

#### Collectors.joining

```java
var ohMy = Stream.of("lions", "tigers", "bears");
String result = ohMy.collect(Collectors.joining(", "));
System.out.println(result); // lions, tigers, bears
```

#### Collectors.averagingInt
- Calculates the average for our three core primitive types Return value is `Double`
* averagingDouble(ToDoubleFunction f)
* averagingInt(ToIntFunction f)
* averagingLong(ToLongFunction f)	

```java
var ohMy = Stream.of("lions", "tigers", "bears");
Double result = ohMy.collect(Collectors.averagingInt(String::length));
System.out.println(result); // 5.333333333333333
```

#### Collectors.toCollection(TreeSet::new)
- if we don't care which implementation of Set then we could have written `Collectors.toSet()`
```java
 var ohMy = Stream.of("lions", "tigers", "bears", "leopard");
TreeSet<String> result = ohMy
   .filter(s -> s.startsWith("l"))
   .collect(Collectors.toCollection(TreeSet::new));
System.out.println(result); // [leopard, lions]
```
- other Collectors methods are groupingBy(), mapping(), partitioningBy(), and toMap().

#### Collecting into Maps
<p> Creates a map using functions to map the keys, values, an optional merge function, and an optional map type supplier
1. toMap(Function k, Function v)
2. toMap(Function k, Function v, BinaryOperator m)
3. toMap(Function k, Function v, BinaryOperator m, Supplier s)
Sample for 3, with optional Binary operator, and supplier.</p>

```java
var ohMy = Stream.of("lions", "tigers", "bears");
Map<String, Integer> map = ohMy.collect(
   Collectors.toMap(s -> s, String::length));
System.out.println(map); // {lions=5, bears=5, tigers=6}
```



```java
var ohMy = Stream.of("lions", "tigers", "bears");
TreeMap<Integer, String> map = ohMy.collect(Collectors.toMap(
   String::length, 
   k -> k, 
   (s1, s2) -> s1 + "," + s2,
   TreeMap::new));
System.out.println(map); //         // {5=lions,bears, 6=tigers}
System.out.println(map.getClass()); // class java.util.TreeMap
```
#### Collectors.groupingBy
-`groupingBy(Function f, Supplier s, Collector dc):Map<K, List<T>>`
<p>Creates a map grouping by the specified function with the optional map type supplier and optional downstream collector</p>
- Grouping animals name by there length and collecting in a set

```java
var ohMy = Stream.of("lions", "tigers", "bears");
Map<Integer, Set<String>> map = ohMy.collect(
   Collectors.groupingBy(
      String::length, 
      Collectors.toSet()));
System.out.println(map);    // {5=[lions, bears], 6=[tigers]}

//Change the type of Map returned through yet another parameter.
var ohMy = Stream.of("lions", "tigers", "bears");
TreeMap<Integer, Set<String>> map = ohMy.collect(
   Collectors.groupingBy(
      String::length, 
      TreeMap::new, 
      Collectors.toSet()));
System.out.println(map); // {5=[lions, bears], 6=[tigers]}
```
#### Collectors.partitioningBy
- Partitioning is a special case of grouping. With partitioning, there are only two possible groups—true and false. Partitioning is like splitting a list into two parts.
```java
var ohMy = Stream.of("lions", "tigers", "bears");
Map<Boolean, List<String>> map = ohMy.collect(
  Collectors.partitioningBy(s -> s.length() <= 5));
System.out.println(map);    // {false=[tigers], true=[lions, bears]}

//As with groupingBy(), we can change the type of List to something else here List -> Set, but unlike groupingBy we can't change the Map
var ohMy = Stream.of("lions", "tigers", "bears");
Map<Boolean, Set<String>> map = ohMy.collect(
   Collectors.partitioningBy(
      s -> s.length() <= 7, 
      Collectors.toSet()));
System.out.println(map);    // {false=[], true=[lions, tigers, bears]}
```
```java
var ohMy = Stream.of("lions", "tigers", "bears");
Map<Integer, Long> map = ohMy.collect(
   Collectors.groupingBy(
      String::length, 
      Collectors.counting()));
System.out.println(map);    // {5=2, 6=1}
```
####  Collectors.mapping
```java
var ohMy = Stream.of("lions", "tigers", "bears");
Map<Integer, Optional<Character>> map = ohMy.collect(
   Collectors.groupingBy(
      String::length,
      Collectors.mapping(
         s -> s.charAt(0), 
         Collectors.minBy((a, b) -> a -b))));
System.out.println(map);    // {5=Optional[b], 6=Optional[t]}
```
