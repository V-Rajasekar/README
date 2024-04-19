# 08 Stream

## filter, transform and process data


```java
   Stream<StringBuilder> stream = Stream.of(); // returns a blank stream of Stream<StringBuilder>
        stream.map(s -> s.reverse()) // reverse in StringBuilder
                .forEach(System.out::println); //compile nothing printed

    Stream.of() // created a Stream<Object>
            .map(s -> s.reverse()) // compile error as no reverse in Object
            .forEach(System.out::println);

 //Peek is an intermediate operation, so nothing is printed.
     Stream.of(true, false, true)
            .map(b -> b.toString()
            .toUpperCase())
            .peek(System.out::println);     

      Stream.of(true, false, true)
            .map(b -> b.toString().toUpperCase())
            .peek(System.out::println)
            .count(); // nothing printed,   If result of count() can directly be computed from the stream source, then the implementation may choose to not execute the stream pipeline.  
       Stream.of(true, false, true).count(); // prints 3        

       map.stream().count();// compile error since map is not a Collection    
```
### working with map in stream

```
For example, below code prints all the key value pairs available in the map:

map.entrySet()
	.stream()
	.forEach(x -> System.out.println(x.getKey() + ":" + x.getValue()));


Below code prints all the keys of the map:

map.keySet()
	.stream()
	.forEach(System.out::println);


Below code prints all the values of the map:

map.values()
	.stream()
	.forEach(System.out::println);
```

### peek operation

```java
List<Employee> employees = Arrays.asList(new Employee("Jack", 10000),
            new Employee("Lucy", 12000));
        employees.stream()
            .peek(e -> e.setSalary(e.getSalary() + 1000))
            .forEach(System.out::println);
  //Prints  {Jack, 11000.0} {Lucy, 13000.0}        

```
### flatMap
stream is not of Stream<String> type rather it is of Stream<String[]> type.

flatMap method combines all the non-empty streams and returns an instance of Stream<String> containing the individual elements from non-empty stream.
```java
String [] arr1 = {"Virat", "Rohit", "Shikhar", "Dhoni"};
        String [] arr2 = {"Bumrah", "Pandya", "Sami"};
        String [] arr3 = {};
 
        Stream<String[]> stream = Stream.of(arr1, arr2, arr3);
        stream.flatMap(s -> Arrays.stream(s))
                .sorted()
                .forEach(s -> System.out.print(s + " "));
```

### UnaryOperator and Function 

```java
//Option-1: UnaryOperator<Character> operator = c -> (char) (c.charValue() + 1); 
//Option-2: Function<Character, Character> operator = x -> (char)(x+1);
var vowels = List.of('A', 'E', 'I', 'O', 'U');
        vowels.stream().map(x -> operator.apply(x)).forEach(System.out::print); //Line n1
```
### anyMatch, allMatch, noneMatch

- boolean anyMatch(Predicate<? super T>) Return false if Stream is empty and true if any match
- boolean allMatch(Predicate<? super T>) Return true if stream is empty and all match
- boolean noneMatch(Predicate<? super T>) Returns true if stream is empty and none match

```java
Stream<Integer> stream = Stream.iterate(1, i -> i + 1); // creates a infiniteStream
        System.out.println(stream.anyMatch(i -> i > 1)); //But here when 2 > 1 returns true immediately.
```

### Optional

```java
import java.util.Optional;
Optional<Integer> optInt = Optional.of(null); //L1 throws NPE

//It returns an Optional describing the given non-null value.
//If null argument is passed to of method, then NullPointerException is thrown at runtime.
Optional<Integer> optInt = Optional.ofNullable(null);
System.out.println(optInt.orElse(-1)); //Line n2; //prints -1

 Optional<Integer> optional = Optional.ofNullable(null);
        System.out.println(optional); //prints Optional.empty
  Optional<Integer> optional = Stream.of(10).findFirst(); // prints Optional[10]       
```

### Optional.or

- Optional.or returns the Optional with non empty value or the Optional functional
  
```java
   var names = List.of("John", "william", "Claire", "HOPE", "Clark", "Hunter", "Kirk");
 
        search(names, "jack")
            .or(() -> search(names, "Jon"))
            .or(() -> search(names, "hope"))
            .or(() -> search(names, "Clark"))
            .stream()
            .forEach(System.out::print); // prints HOPE

    var numbers = List.of(11, 22, 7, 23, 82, 9);
        System.out.println(search1(numbers, 43) //Returns an empty Optional
            .or(() -> search2(numbers)) // Returns an empty Optional
            .stream() // emptyStream as there is no value
            .count());// Gives 0          
```

Optional optional = Optional.empty();

And the statements:

1. System.out.println(optional.get()); // method throws NoSuchElementException

2. System.out.println(optional.orElse(new RuntimeException())); // Prints RuntimeException

3. System.out.println(optional.orElseGet(() -> new RuntimeException())); // Prints RuntimeException

4. System.out.println(optional.orElseThrow()); // No such element

5. optional.ifPresentOrElse(System.out::print, () -> {throw new RuntimeException();}); //throws

### Stream.generate() and intermediate operators

- Stream.generate creates infinitely stream
- sorted is an intermediate looks for all the element in the Stream

```java
 Stream<Double> stream = Stream.generate(() -> Double.valueOf("1.0")); // created infinitely stream of 1.0
        System.out.println(stream.sorted().findFirst()); // nothing prints and the pgm runs infinitely
```

- `Stream stream = Stream.of()` creates an empty stream.
- `stream.findFirst();` => returns an empty Optional. 

```java
 var stream = Stream.of("JAVA", new String("JAVA"));
        stream.distinct()
            .findAny()
            .stream()
            .forEach(System.out::println); // prints JAVA
  List<String> list = Arrays.asList("A", "A", "b", "B", "c", "c");
        list.stream()
            .distinct() //cases matter like equals
            .forEach(System.out::print); // A, b, B, c           
```

```java
 Stream<String> stream = Stream.of("d", "a", "mm", "bb", "zzz", "www");
        Comparator<String> lengthComp = (s1, s2) -> s1.length() - s2.length();
        stream.sorted(lengthComp).forEach(System.out::println);

         stream.sorted(lengthComp.thenComparing(String::compareTo))
         .forEach(System.out::println); //prints a, d, bb, mm, www, zzz

//----------
    private static boolean isDirection(int ch) {
    switch(ch) {
        case 'N':
        case 'E':
        case 'W':
        case 'S':
            return true;
    }
    return false;
    }
    String str = "North East West South";
    str.chars() // returns IntStream
        .filter(Test::isDirection)
        .forEach(c -> System.out.print((char)c)); // prints NEWS
```

### IntStream

```java
  IntStream.range(1, 10) //10 excludes
            .forEach(System.out::print); // 1..9
IntStream.range(1, 10).count();// 0
IntStream.range(10,1) //=> Returns an empty stream as start > end, this means stream doesn't have any elements. That is why count() returns 0.
IntStream.range(-10, -10) // returns empty stream.
IntStream.rangeClosed(-10, -10) => returns a stream containing just 1 element, which is -10.
```

- IntStream.range(int start, int end) => start is inclusive and end is exclusive. If start >= end, then empty stream is returned. 
- IntStream.rangeClosed(int start, int end) => Both start and end are inclusive. If start > end, then empty stream is returned.

```java
IntStream.range(1, 6)
        .map(i -> "*".repeat(i)) // compile error as map returns String instead of int
        .forEach(System.out::println);
```

## Terminal operators and stream after use

<p>forEach, count, toArray, reduce, collect, findFirst, findAny, anyMatch, allMatch, sum, min, max, average etc. are considered as terminal operations.

Once the terminal operation is complete, all the elements of the stream are considered as used. Any attempt to use the stream again causes IllegalStateException.</p>

```java
  IntStream stream = "OCP".chars();
        stream.forEach(c -> System.out.print((char)c));
        System.out.println(stream.count());// IllegalStateException
```

## Optional and OptionalVariant(Int,Long,Double) methods

- Only 3 primitive variants available: OptionalDouble, OptionalInt and OptionalLong.

### Optional<T>:

- static <T> Optional<T>    empty()
- static <T> Optional<T>    of​(T value)
- static <T> Optional<T>    ofNullable​(T value) **
- T     get()
- T     orElse​(T other)
- T     orElseGet​(Supplier<? extends T> supplier)
- T     orElseThrow()
- <X extends Throwable> T orElseThrow​(Supplier<? extends X> exceptionSupplier)
- void  ifPresent​(Consumer<? super T> action)
- void  ifPresentOrElse​(Consumer<? super T> action, Runnable emptyAction)
- boolean   isEmpty()
- boolean   isPresent()
- Stream<T> stream()
- Optional<T> or​(Supplier<? extends Optional<? extends T>> supplier) **
- Optional<T> filter​(Predicate<? super T> predicate) **
- <U> Optional<U> map​(Function<? super T,​? extends U> mapper) **
- <U> Optional<U> flatMap​(Function<? super T,​? extends Optional<? extends U>> mapper) **

### OptionalInt:

- static OptionalInt    empty()
- static OptionalInt    of​(int value)
- int   getAsInt()
- int   orElse​(int other)
- int   orElseGet​(IntSupplier supplier)
- int   orElseThrow()
- <X extends Throwable> int orElseThrow​(Supplier<? extends X> exceptionSupplier)
- void  ifPresent​(IntConsumer action)
- void  ifPresentOrElse​(IntConsumer action, Runnable emptyAction)
- boolean   isEmpty()
- boolean   isPresent()
- IntStream stream()

>Note: [`ofNullable, or, filter, map, flatMap` methods are not available in primitive type]. Similarly we have OptionalLong and OptionalDouble having respective primitive type long and double.

## LongStream
  
```java
  LongStream.iterate(0, i -> i + 2)
            .limit(4)
            .forEach(System.out::print); //prints 0246

LongStream.rangeClosed(51,75) //=> [51,52,53,...,75]. Both start and end are inclusive. 
```

## java.util.stream.Stream interface and Primitive interface (IntStream, LongStream and DoubleStream)

### Generic Stream interface

- Methods which returns Optional<T> type in generic Stream interface: 

1. Optional<T> max(Comparator<? super T> comparator); Retuens the maximum element in the Stream
2. Optional<T> min(Comparator<? super T> comparator); 
3. Optional<T> reduce(BinaryOperator<T> accumulator); 
4. Optional<T> findAny();
5. Optional<T> findFirst();
   
- **Generic interface doesn't have sum(), average() and summaryStatistics.**
  
  ```java
  Stream<Double> stream = Stream.of(9.8, 2.3, -3.0);
        System.out.println(stream.min()); // compile error as there is no min method in Generic interface
   // use stream.min(Double::compareTo) to find the min  -3.0
  ```
### Primitive Stream

- Primitive Stream interfaces (IntStream, LongStream & DoubleStream) has methods min(), max(), sum(), average() and summaryStatistics(). 
- average() method of all the 3 primitive streams (IntStream, LongStream & DoubleStream) return an instance of OptionalDouble. OptionalDouble has getAsDouble() method 
  
```java
 public static int salaryCompare(double d1, double d2) {
        return Double.valueOf(d2).compareTo(d1);
    }
 
emp => [{"Aurora", 10000.0}, {"Naomi", 12000.0}, {"Hailey", 7000.0}]. 
    emp.map(e -> e.getSalary()) => [10000.0, 12000.0, 7000.0]. 
    max(Employee::salaryCompare) => Optional[7000]. //max returns the maximum element in the Stream see 7000.0 is the last and max in the Stream

 Stream<Integer> stream = Arrays.asList(1,2,3,4,5).stream();
        System.out.println(stream.mapToInt(i -> i) // retuens IntStream
            .average()
            .getAsInt()); // compile error as its .getAsDouble()    

  LongStream stream = LongStream.empty();
        System.out.println(stream.average()); // OptionalDouble.empty

/* The 3 summary statistics classes override toString() method to print the data about count, sum, min, average and max.
 All the 3 summary statistics classes have methods to extract specific stat as well: getCount(), getSum(), getMin*(), getMax() and getAverage().*/

 
 IntStream stream = IntStream.rangeClosed(1, 20)
                                .filter(i -> i % 2 == 0);
        System.out.println(stream.summaryStatistics());     

//reduce 
### reduce method

<p>
Stream<T> interface has below 3 overloaded reduce methods:

- Optional<T>   reduce​(BinaryOperator<T> accumulator)
- T    reduce​(T identity, BinaryOperator<T> accumulator)
- <U> U    reduce​(U identity, BiFunction<U,​? super T,​U> accumulator, BinaryOperator<U> combiner)
</p>
int res = 1;
        IntStream stream = IntStream.rangeClosed(1, 5);
        stream.reduce(1, (i, j) -> i * j); //prints 120

 Stream<Double> stream = Arrays.asList(1.8, 2.2, 3.5).stream();
        // System.out.println(stream.reduce(0, (d1, d2) -> d1 + d2)); compile error since int inplace of Double
        System.out.println(stream.reduce(0.0,(d1, d2) -> d1 + d2)); 
        System.out.println(stream.reduce(0.0, Double::sum);
        System.out.println(stream.reduce((d1, d2) -> d1 + d2)); //Optional[7.5]
  // reduction with BiFunction
   var list = List.of(false, Boolean.valueOf(null), Boolean.valueOf("1"), Boolean.valueOf("0"));
        BinaryOperator<Boolean> operator = (b1, b2) -> b1 || b2;
        System.out.println(list.stream().reduce(false, operator)); // prints false. if the identity is true or one of the value in list is true then prints true

 Function<CryptoCurrency, Integer> extractor = curr -> curr.getUnit();
        UnaryOperator<Integer> operator = i -> i % 100;
        int val = Stream.of(new CryptoCurrency("DOGE", 8921),
                    new CryptoCurrency("ETH", 99), new CryptoCurrency("LTC", 17689))
                    .map(extractor.andThen(operator))
                    .reduce(0, (a, b) -> a + b); // 209
```

### Transform

```java
 //transforming Stream(String) -> TreeSet(sorting)
import java.util.stream.Collectors;
   Stream<String> stream = Stream.of("mars", "pluto", "sun",
            "earth", "mars", "pluto");
        Set<String> set = stream.collect(Collectors.toCollection(/*insertline*/));
        System.out.println(set);
     
 //TreeSet::new, Collectors.toSet();, Collectors.toList     
 //List of languages sorted.
   List<String> uniqueLang = stream.sorted().collect(Collectors.toList());  

 Person p1 = new Person(1010, "Sean");
        Person p2 = new Person(2843, "Rob");
        Person p3 = new Person(1111, "Lucy");
 
        Stream<Person> stream = Stream.of(p1, p2, p3);
        Map<Integer, Person> map = stream.collect(/*INSERT*/);
        System.out.println(map.size());

/* 1. `Collectors.toMap(p -> p.id, Function.identity())`</br> 
2. `Collectors.toMap(p -> p.id, p -> p)` are exactly same, as `Function.identity()` is same as lambda expression `p -> p`.</br>
3. Collectors.toCollection(TreeMap::new) causes compilation error as TreeMap doesn't extend from Collection interface.</br>*/

var a = DoubleStream.iterate(Double.valueOf(1.0), i -> i <= 3.0, i -> i + 1);
        var b = a.mapToObj(i -> "" + i) //Mapper function accepts double and converts it to String
                        .collect(Collectors.joining(", ")); //1.0,2.0,3.0

  String str = Stream.of("an", "and", "after", "or", "before")
            .takeWhile(s -> s.length() < 4)
            .collect(Collectors.joining(", ")); // an, and                        

  String str = Stream.of("a", "an", "and", "alas", "after")
            .dropWhile(s -> s.length() > 4)
            .collect(Collectors.joining(", ")); // prints all with , separated.

  Stream.of(List.of('A', 'N', 'T'), List.of('A', 'Q', 'U', 'A'))
            .filter(Predicate.not(l -> l.size() > 3))
            .flatMap(l -> l.stream())
            .collect(Collectors.toList())
            .forEach(System.out::print); //prints ANT           
``` 

### partitioningBy, groupingBy

```java
 Certification c1 = new Certification("S001", "OCA", 87);
        Certification c2 = new Certification("S002", "OCA", 82);
        Certification c3 = new Certification("S001", "OCP", 79);
        Certification c4 = new Certification("S002", "OCP", 89);
        Certification c5 = new Certification("S003", "OCA", 60);
        Certification c6 = new Certification("S004", "OCA", 88);
 
        Stream<Certification> stream = Stream.of(c1, c2, c3, c4, c5, c6);
        Map<Boolean, List<Certification>> map =
            stream.collect(Collectors.partitioningBy(s -> s.getTest().equals("OCA")));
        System.out.println(map.get(true)); //prints true, OCA record

        Stream<Certification> stream = Stream.of(c1, c2, c3, c4, c5, c6);
        Map<Boolean, List<Certification>> map =
            stream.collect(Collectors.groupingBy(Certification::getTest));
        System.out.println(map.get("OCP")); // prints OCP records
```
## Parallel Streams

All streams in Java implements BaseStream interface and this interface has parallel() and sequential() methods. Hence all streams can either be parallel or sequential.

performance of parallel stream is **not always** better than the sequential stream. Parallel streams internally use fork/join framework only, so there is always an overhead of splitting the tasks and joining the results.   

Parallel streams improves performance for streams with large number of elements, easily splittable into independent operations and computations are complex.

- java.util.Collection interface has default stream() to return sequential() stream for the executing collection
- java.util.stream.Stream class has parallel(), sequential() to convert a stream to parallel and sequential
- isParallel() method of Stream class returns true for parallel Stream.
  
   `List.of("A", "E", "I", "O", "U").stream().parallel() or  List.of("A", "E", "I", "O", "U").parallelStream()`
```java
  IntStream.rangeClosed(1, 10)
            .parallel()
            .forEach(System.out::println); // prints 1..10 in random       

  IntStream.rangeClosed(1, 10)
            .parallel()
            .forEachOrdered(System.out::println); // prints 1..10 in asc order

//base stream is IntStream with sequential order(it has encounter order) regardless of sequential or parallel findFirst() return 51
     int res = IntStream.rangeClosed(1, 1000)
                    .parallel()
                    .filter( i -> i > 50).findFirst().getAsInt(); // prints 51      

    var list2 = List.of(List.of('N', 'A'), List.of('M', 'O'));
     list2.parallelStream()
            .flatMap(i -> i.stream()) //list2 => [{'N', 'A','M', 'O'}]
            .findFirst() //Optional[N]
            .stream() //Optional class has Stream method => Stream<Character>['N']
            .forEach(System.out::print);    //prints N      

```

### reduce(identity, U BinaryOperation<U,T>)

<p> The reduce() method in Java 8 is a terminal operation that takes a binary operator function as an argument and returns a single value as the result of the reduction operation. The binary operator function is applied to each element in the stream, and the result of each application is passed to the next application as the first argument.</p> 

```java

Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        // Calculate the sum of all the elements in the stream
        int sum = stream.reduce(0, (a, b) -> a + b); // prints 15

       List<Book> books = new ArrayList<>();
        books.add(new Book("9781976704031", 9.99));
        books.add(new Book("9781976704032", 15.99));
 
        Book b = books.stream().reduce(new Book("9781976704033", 0.0), (b1, b2) -> {
            b1.price = b1.price + b2.price;
            return new Book(b1.isbn, b1.price);
        });
 
        books.add(b);
        books.parallelStream().reduce((x, y) -> x.price > y.price ? x : y)
            .ifPresent(System.out::println); //prints Book[9781976704033:25.98].

//1. 1. The identity value must be an identity for the combiner function. This means that for all u, combiner(identity, u) is equal to u.

//   As u is of String type, let's say u = "X", combiner("", "X") = "X". Hence, u is equal to combiner("", "X"). First rule is obeyed.                  

//2. To get consistent output, accumulator must be associative and stateless. concat is associative as (s1.concat(s2)).concat(s3) equals to s1.concat(s2.concat(s3)). Given method reference syntax is stateless as well.
    var s2 = List.of("A", "E", "I", "O", "U").parallelStream()
            .reduce("_", String::concat);// s2 may refer to "_A_E_I_O_U" or "_AE_I_OU" or "_AEIOU". So output cannot be predicted.

        var str2 = List.of("S", "P", "O", "R", "T").parallelStream()
            .reduce("", String::concat); // str2 is predictable its always SPORT

      var str2 = Stream.iterate(1, k -> k <= 10, i -> i + 1)
            .parallel()
            .reduce("", (i, s) -> i + s, (s1, s2) -> s1 + s2); // without parallel also same output. 

       var stream = Stream.of("J", "A", "V", "A");
        var text = stream.parallel().
            reduce(String::concat)
            .get(); //prints JAVA (consistantly)            
```

<p>
var list = List.of("S", "P", "I", "R", "I", "T");
And below statements all prints SPIRIT:
1. list.forEach(System.out::print);

2. list.stream().forEach(System.out::print);

3. list.stream().map(Function.identity()).forEach(System.out::print);
 `Function.identity()` is same as `t -> t` (which returns the passed value). In fact, this in redundant map call. forEach(System.out::print) method prints SPIRIT on to the console.
1. list.parallelStream().forEachOrdered(System.out::print);

2. System.out.println(list.stream().collect(Collectors.joining()));
</p>

### groupingBy
- Collectors.groupingByConcurrent(...) returns a concurrent and unordered Collector whereas, Collectors.groupingBy(...) returns a non-concurrent and ordered (based on encounter order) Collector
- 
```java
var stream = Stream.of("SON", "WIFE", "MOTHER", "FATHER", "UNCLE", "DAUGHTER");
        var map = stream.parallel()
                    .collect(Collectors.groupingByConcurrent(s -> s.length() > 4));

sout(map.get(false)).size(); // 2
```