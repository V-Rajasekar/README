# 08 Stream

## filter, transform and process data

## 
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

### Optional

```java
import java.util.Optional;
//Optional<Integer> optInt = Optional.of(null); L1 throws NPE
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
###

## Stream methods

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