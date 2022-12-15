# *Language features*
 

| Features | Java 10 | Java 11 | Java 12 | Java 13 | Java 14 |Java 15 | Java 16 | Java 17 | Java 18 |
|---|---|---|---|---|---|---|---|---|---|
|Local Variable Type Interface-Var  |X|---|---|---|---|---|---|---|---|
|Local Variable Syntax for Lambda Param|---|X|---|---|---|---|---|---|---|
|Switch Expression|---|---|---|---|X|---|---|---|---|
|Text Blocks|---|---|---|---|---|X|---|---|---|
|Records|---|---|---|---|---|---|X|---|---|
|Pattern Matching for instanceof|---|---|---|---|---|---|X|---|---|
|Sealed classes|---|---|---|---|---|---|---|X|---|
|Pattern Matching for switch|---|---|---|---|---|---|---|---|Preview|

## Local Variable Type Interface-Var 
### Local-Varible Type Inference JDK 10

```
var con = url.openConnection();
var list  = List.of("Apple", "banana", "kiwi");
```
The use of the var keyword will be allowed within the parameters of a lambda expression. Also you can add Java annotations.

## Local Variable Syntax for Lambda Param JDK 11
`(@Nonnull var x, var y) -> x.process(y)`

Check style guide when and where to use and avoid.

[jdk-10-local-variable-type-inference](https://developer.oracle.com/learn/technical-articles/jdk-10-local-variable-type-inference)
[Style guide](https://openjdk.org/projects/amber/guides/lvti-style-guide)

## Switch Expressions JDK 14

```java

return switch(day) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY -> 7;
    case THURSDAY, SATURDAY -> 8;
    case WEDNESDAY -> 9;
}
```

## Text Blocks JDK 15

```java
var html="""Retweets: %s like %s """.formatted(t.getRetweetCount((), t.getLikeCount());
```
new method formatted added in stream works like String.format but much readable.

## Record Classed JDK 16


`record Point(int x, int y) {}`

-Record class is a final class that serves as a tranparent career for data the data are set through the constructors
- Cons, getter, toString are automatically are available. There is no setter since the fields are set through constructor.

## Pattern Matching for instance of JDK 16

```java

if (obj instance of String s) {
    // use s
}


```

### Sealed Types (classes and interfaces) JDK 17

Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them.

1. Defining a sealed class
   
   ```java
   public sealed class Shape
    permits Circle, Square, Rectangle {
} ```

[sealed-classes-and-interfaces](https://docs.oracle.com/en/java/javase/16/language/sealed-classes-and-interfaces.html)

### Pattern matching for switch - After

### Pattern matching for switch - Guarded Pattern.

### Helpful NullPointerExceptions JDK 14

To identify which variable in the below line is coming as *NULL*
`a.i = b.i`

Tools:
- JLink to create a pre-build Java application and/or a runtime image.
-Java Dependency Analyzer
- java Package(jpackage) JDK 16 A command line tool for packaging selfcontained Java applications(jlink)
- java shell jshell JDK 16
  
Launch singlefile sourcecode progrmas JDK 11

java HelloWorld.java

## Flight Recorder JDK 11
- To check the performance


## Library
## Collection Factores JDK 9

-- Creating immutable collection
`Set<String> set  = Stream.of(1, 2, 3)`

- Foreign Function and Memory API
- Deserialization Filtering
- JVM Impact
