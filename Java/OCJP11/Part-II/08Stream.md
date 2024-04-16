
Stream.of() returns blank stream. As Type of stream is not specified, stream is of 'Stream<Object>', each element of the stream is considered to be of 'Object' type.

map method in this case accepts `Function<? super Object, ? extends R>`.

There is no 'reverse()' method in Object class and hence lambda expression causes compilation failure.

```java
  Stream.of()
            .map(s -> s.reverse())
            .forEach(System.out::println);

   To resolve:
 Stream<StringBuilder> streamBuilder =   Stream.of()
            .map(s -> s.reverse())
            .forEach(System.out::println);    

```
## Peek for intermediate lookup and manipulate element
```java
 Stream.of(true, false, true)
            .map(b -> b.toString().toUpperCase())
            .peek(System.out::println)
            .count();

 List<Employee> employees = Arrays.asList(new Employee("Jack", 10000),
            new Employee("Lucy", 12000));
        employees.stream()
            .peek(e -> e.setSalary(e.getSalary() + 1000))
            .forEach(System.out::println); //prints [{"Jack",11000.0},{"Lucy",13000.0}].           
```


peek(Consumer) is an intermediate function.

Streams are lazily evaluated, which means for finite streams, if terminal operations such as: forEach, toArray, reduce, collect, sum, min, max, average etc. are not present, the given stream pipeline is not evaluated and hence peek() method doesn't print anything on to the console.

count() is a terminal method, which returns the count of elements in this stream.

If result of count() can directly be computed from the stream source, then the implementation may choose to not execute the stream pipeline.

## Using Stream in Map

```java
For example, below code prints all the key value pairs available in the map:

//map.stream() .... There is no stream() in map
map.entrySet()
	.stream()
	.forEach(x -> System.out.println(x.getKey() + ":" + x.getValue()));


//Below code prints all the keys of the map:

map.keySet()
	.stream()
	.forEach(System.out::println);


//Below code prints all the values of the map:

map.values()
	.stream()
	.forEach(System.out::println);
```

## Stream.flatMap
- Prints the name in asc order.
```java
 String [] arr1 = {"Virat", "Rohit", "Shikhar", "Dhoni"};
        String [] arr2 = {"Bumrah", "Pandya", "Sami"};
        String [] arr3 = {};
 
        Stream<String[]> stream = Stream.of(arr1, arr2, arr3);
        stream.flatMap(s -> Arrays.stream(s))
                .sorted()
                .forEach(s -> System.out.print(s + " "));
```

## Stream.flatMapToInt

```java
 Stream<String> stream = Stream.of("ocp");
        stream.flatMapToInt(s -> s.chars()) //s.chars() returns IntStream
                .forEach(i -> System.out.print((char)i));
```

## UnaryOperator and Function

//Print BFJPV using 
```java
  var vowels = List.of('A', 'E', 'I', 'O', 'U');
        vowels.stream().map(x -> operator.apply(x)).forEach(System.out::print); //Line n1

  Unaryoperator<Character> operator = c -> (char)(c.charValue() + 1);
  Function<Character, Character> func = x -> (char) (x + 1);    

```

## Method reference in lambda expressions

- 'new Rope.RedRopeFilter()::filter' is an example of "Reference to an Instance Method of a Particular Object". Equivalent lambda expression is: `(Rope r) -> new Rope.RedRopeFilter().filter(r)`. 
- If 'filter(Rope)' is declared as static, then to achieve same output, you will have to change the method reference syntax to: `filter(Rope.RedRopeFilter::filter)`.
  
```java
    class Rope {
        static class RedRopeFilter {
            boolean filter(Rope rope) {
                return rope.color.equalsIgnoreCase("Red");
            }
        }
    }
    var list = List.of(new Rope(5, "red"),
                            new Rope(10, "Red"), new Rope(7, "RED"),
                            new Rope(10, "green"), new Rope(7, "Blue"));

    list.stream().filter(new Rope.RedRopeFilter()::filter).forEach(System.out::println); //Line n1    
```

## Streams.anyMatch vs allMatch and nonMatch 

- If Stream is empty any returns true, allMatch and nonMatch returns false.
<p>
boolean anyMatch(Predicate<? super T>) : Returns true if any of the stream element matches the given Predicate. If stream is empty, it returns false and predicate is not evaluated. 

boolean allMatch(Predicate<? super T>) : Returns true if all the stream elements match the given Predicate. If stream is empty, it returns true and predicate is not evaluated. 

boolean noneMatch(Predicate<? super T>) : Returns true if none of the stream element matches the given Predicate. If stream is empty, it returns true and predicate is not evaluated. 
</p>

## Infinite Stream

```java
 //Stream<Integer> stream = Stream.iterate(1, i >= 5, i -> i + 1);
 Stream<Integer> stream = Stream.iterate(1, i -> i + 1); // creates an infinite loop
        System.out.println(stream.anyMatch(i -> i > 1)); //prints true Stream ends as soon as 2 > 1
```