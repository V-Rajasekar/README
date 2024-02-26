# 14. Chapter Generics and Collections
- [14. Chapter Generics and Collections](#14-chapter-generics-and-collections)
    - [Method references:](#method-references)
    - [Wrapper classes.](#wrapper-classes)
    - [Wrapper methods](#wrapper-methods)
    - [Wrapper class and NULL](#wrapper-class-and-null)
    - [Using the Diamond Operator](#using-the-diamond-operator)
    - [Collections:](#collections)
    - [Comparing _Set_ Implementations](#comparing-set-implementations)
    - [Using the Queue Interface](#using-the-queue-interface)
  - [Using the **_Map_** Interface](#using-the-map-interface)
- [Map methods](#map-methods)
    - [Iterating map using _forEach_](#iterating-map-using-foreach)
    - [Comparision of collections](#comparision-of-collections)
    - [Sorting Data](#sorting-data)
      - [Creating a Comparable class](#creating-a-comparable-class)
    - [Comparing Data with a Comparator](#comparing-data-with-a-comparator)
      - [Comparing using multiple fields](#comparing-using-multiple-fields)
      - [Helper static methods](#helper-static-methods)
      - [Helper default methods for building a Comparator](#helper-default-methods-for-building-a-comparator)
    - [Sorting and Searching](#sorting-and-searching)
    - [Generics](#generics)
    - [Naming conventions for Generics](#naming-conventions-for-generics)
    - [Generic Interfaces](#generic-interfaces)
    - [Restrictions on Generic Classes](#restrictions-on-generic-classes)
    - [Generic Methods](#generic-methods)
    - [Generic class bounded and Type Erasure](#generic-class-bounded-and-type-erasure)
    - [Erasure of Generic Methods ( to Object)](#erasure-of-generic-methods--to-object)
    - [Generic Wild Cards](#generic-wild-cards)
    - [Unbounded Wildcards](#unbounded-wildcards)
      - [Lower-Bounded WildCards](#lower-bounded-wildcards)
      - [Combining Generic Declarations](#combining-generic-declarations)
      - [Generics with upperbounds (T extends  \& )](#generics-with-upperbounds-t-extends---)
      - [Create and Use Generic Methods](#create-and-use-generic-methods)
  - [Review Questions](#review-questions)

### Method references:
A method reference and a lambda behave the same way at runtime. You can pretend the compiler turns your method references into lambdas for you.
(e.g)

```java
@FunctionalInterface
public interface LearnToSpeak {
   void speak(String sound);
}
LearnToSpeak learner = s -> System.out.println(s);
shortversion: LearnToSpeak learner = System.out::println;
```
<p>
Remember that :: is like a lambda, and it is used for deferred execution with a functional interface.

There are four formats for method references:

* Static methods
* Instance methods on a particular instance
* Instance methods on a parameter to be determined at runtime
* Constructors
</p>

- Calling Static Methods 
  * `Consumer<List<Integer>> methodRef = Collections::sort;`
  * Here java is inferring informatn from the context. In this case we have a consumer which takes only one parameter, so it calls the correct sort overloaded method with one parameter
- Calling Instance Methods on a Particular Object
  * The String class has a startsWith() method which takes one parameter and return a boolean, conveniently like a predicate. It can be used in a list to filter.
  ```java
  var str = "abc";
  Predicate<String> lambda = s -> str.startsWith(s);
  ```

  * A method reference doesn't have to take any parameters. In this example, we use a Supplier, which takes zero parameters and returns a value:
 ```java
   var random = new Random();
   Supplier<Integer> methodRef = random::nextInt;
 ```
- Calling Instance Methods on a Parameter
  -  `23: Predicate<String> methodRef = String::isEmpty;` It looks like a static method, but it isn't. Instead, Java knows that isEmpty() is an instance method that does not take any parameters. Java uses the parameter supplied at runtime as the instance on which the method is called.
  -  `26: BiPredicate<String, String> methodRef = String::startsWith;` calling instance method with two parameter through method reference.
- Calling Constructors
  -   ` Supplier<List<String>> methodRef = ArrayList::new;`
  -   `Function<Integer, List<String>> methodRef = ArrayList::new;`  in this example java takes the integer for constructing a array list.
|Type	|Before colon	|After colon	|Example|
|---|---|---|---|
|Static methods	|Class name	|Method name|	Collections::sort|
|Instance methods on a particular object	Instance variable name	|Method name	|str::startsWith|
|Instance methods on a parameter|	Class name	|Method name|String::isEmpty|
|Constructor	|Class name	|new	|ArrayList::new|

- When method reference can be used
  * Is it possible to use Method reference on line 15, answers is not as it take a parameter it has to be dcl "_the long way_".
```java
1: Collection<String> set = new HashSet<>();
12: set.add("Wand");
13: set.add("");
14: set.add("Assistant");
15: set.removeIf(s -> s.startsWith("A"));
16: set.removeIf(String::isEmpty); // s -> s.isEmpty()
17: System.out.println(set);       // [Wand]

```

### Wrapper classes.
- All primitive data type except the boolean and character extends Number. 
- Autoboxing happens when a primitive type is assigned to its Wrapper class and unboxing is the oppsite.
- Default value of all wrapper classes is NULL. `Boolean isFlagged; //null`
### Wrapper methods
   * `valueOf(int):Integer` creating a wrapper class, @Deprecated new Integer(int); 
   * `intValue():int` returns primitive value from its wrapper class Integer.
   * `static int Character.compare(char x, char y)` (e.g)` Integer.compare(10,5) => 1, Integer.compare(5,10) => -1`
   * int `booleanWrapper.compareTo(Boolean b)` null parameter results NPE. 0=equals, 1= if wrapper value > param value otherwise -1. for boolean 1 wrapper is true and param is false otherwise -1. For character postive value of the wrapper value > param value otherwise negative number -n.
   * int parseInteger(String s)
   * Integer valueOf(String s) note: Character wrapper does NOT support a parameter type String for valueOfMethod(e.g) Float fwrapper = Integer.valueOf("100"); Integer.valueOf('a') returns the integer value of a -> 97.
   * Boolean.valueOf(null) => false where as Float.valueOf(null) return NPE. Integr.valueOf(1000_00) this is a valid value, but throws NumberFormatException.
   * Integer.valueOf(1).equals(Short.valueOf(1)) => false, since the types are different.
   * static method to compare the wrapper values Character.compare('a', '\u0061') = 0  Character.compare('A', 'a') = -32, Boolean.compare(false, true) => -1.
   * Wrapper to primitive. Integer.parserInt("100") = return int 100
   *  Integer.getInteger("10") returns Integer 10
   *  You can also get the system property values using getBoolean,  getInteger
 ```java
      System.setProperty("app.debugFlag", "TRUE");
    System.setProperty(Boolean.getBoolean("app.debugFlag"));
 ```
   * `instanceof` operator is one example where autoboxing doesn't occur.
    ```java
        short i = 10;
        short j = 20;
        short result = i + j; //Compile error can't assing int to short

        short s = Short.valueOf("10");
        if (s instanceof Short) { // Compile error Autoboxing will not happen
                System.out.println("Its short");
        }
    ```
    - An array of a primitive data type will not get autoboxed to an array of the corresponding wrapper.
### Wrapper class and NULL
```java
15: var heights = new ArrayList<Integer>();
16: heights.add(null);
17: int h = heights.get(0); // NullPointerException
```
<p>While null values aren't particularly useful for numeric calculations, they are quite useful in data‐based services. For example, if you are storing a user's location data using (latitude, longitude), it would be a bad idea to store a missing point as (0,0) since that refers to an actual location off the cost of Africa where the user could theoretically be. </p>

### Using the Diamond Operator
```java
Map<String,Integer> map = new HashMap<>();
Map<Long,List<Integer>> mapOfLists = new HashMap<>();

//Doesn'r compile 
Map<> map = new HashMap<String, Integer>();  // DOES NOT COMPILE
class InvalidUse {
   void use(List<> data) {}                  // DOES NOT COMPILE
}

//
var list = new ArrayList<Integer>(); // Creates an array of Integer
var list = new ArrayList<>(); // Creates an array of objects

```
### Collections: 
- Factory methods to create a list: 
  * Arrays.asList(varargs): Returns fixed size list backed by an array. Only replace run without error, Add or remove fails
  * List.of(varargs) Returns immutable list, so  Add, replace,removed not allowed
  * List.copyOf(collection)`.  Returns immutable list with copy of original collection's values. Add, replace,removed not allowed
- Other methods
```java
List<Integer> numbers = Arrays.asList(1, 2, 3);
numbers.replaceAll(x -> x*2);
System.out.println(numbers);   // [2, 4, 6]
```
### Comparing _Set_ Implementations
- HashSet adding and check element in a set both have constant time. Doesn't maintain the order
- Treeset elements are stored in sorted tree structure. `Adding and checking whether an element exists take a longer than with a HashSet.`
- The elements in Treeset are stored in the natural sorting order.
- Creating immutable set using `Set.of('z','o','o'); Set.copyOf(letters);`
### Using the Queue Interface
A queue when elements are added and removed in a specific order. Queues are typically used for sorting elements prior to processing them.
- Working with Queue Methods
  
Method | Description | Throws exception on failure
---------|----------|---------
` boolean add(E e)` | Adds an element to the back of the queue and returns true or throws an exception | Yes
 `E element() `| Returns next element or throws an exception if empty queue | Yes
` boolean offer(E e) `| Adds an element to the back of the queue and returns whether successful | No
`E remove()`|Removes and return the head of the queue or throws an exception if empty queue|Yes
`E pop()`|Removes and return the head of the queue  or throws an exception if empty queue|Yes
` E poll()`|Removes and returns that element or returns null if empty queue|No
` E peek()`|Returns top most element or returns null if empty queue| No


```java
12: Queue<Integer> queue = new LinkedList<>();
13: System.out.println(queue.offer(10)); // true
14: System.out.println(queue.offer(4));  // true
14: System.out.println(queue.add(2));  // true
15: System.out.println(queue.peek());    // 10 Returns top head
16: System.out.println(queue.poll());    // 10 Removes and return
17: System.out.println(queue.pop());    // 4 Removes and return
    System.out.println(queue.remove());    // 2 Removed
18: System.out.println(queue.peek());    // null
System.out.println(queue.remove()); // Throws NoSuchElement exception
System.out.println(pop.remove());// Throws NoSuchElement exception
```
Line 12, 13 Add elements to the end of the queue.

## Using the **_Map_** Interface
- `Map.of("key1", "value1", "key2", "value2");` below is the better version of it 
- `Map.of("key1", "value1", "key2"); // INCORRECT failes in run time`
```java
Map.ofEntries(
   Map.entry("key1", "value1"),
   Map.entry("key1", "value1"));
```
- Map.copyOf(map) works just like the List and Set interface copyOf() methods.
# Map methods
- `void clear()` Removes all keys and values from the map.
- containsKey(Object key) , constainsValue(Object value):boolean
- Set<Map.Entry<K,V>> entrySet() Returns a Set of Key/Value pairs
- `void forEach(BiConsumer(K key, V value))` Loops through each key/vlue pair.
- `V getOrDefault(Object key, V defaultValue)` Returns the value mapped by the key or the default value if none is mapped.
- ` V putIfAbsent(K key, V value)`	Adds value if key not present and returns null. Otherwise, returns existing value.
- `Collection<V> values()`	Returns Collection of all values.
### Iterating map using _forEach_
```java
  Map<Integer, Character> map = new HashMap<>();
  map.put(1, 'a');
  map.put(2, 'b');
  map.put(3, 'c');
  map.forEach((k, v) -> System.out.println(v));

  map.values().forEach(System.out::println);
//Another way of going through the key and value in a Map
  map.entrySet().forEach(e -> 
   System.out.println(e.getKey() + e.getValue()));

```
- _ replace()_ and _replaceAll()_

```java
21: Map<Integer, Integer> map = new HashMap<>();
22: map.put(1, 2);
23: map.put(2, 4);
24: Integer original = map.replace(2, 10); // 4
25: System.out.println(map);    // {1=2, 2=10}
26: map.replaceAll((k, v) -> k + v);
27: System.out.println(map);    // {1=3, 2=12}
```
- putIfAbsent()
  
  ```java
    Map<String, String> favorites = new HashMap<>();
    favorites.put("Jenny", "Bus Tour");
    favorites.put("Tom", null);
    favorites.putIfAbsent("Jenny", "Tram");
    favorites.putIfAbsent("Sam", "Tram");
    favorites.putIfAbsent("Tom", "Tram");
    System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
  ```

- Map merger(R, )
If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value. Otherwise, replaces the associated value with the results of the given remapping function, or removes if the result is null. This method may be of use when combining multiple mapped values for a key. For example, to either create or append a String msg to a value mapping:
 
default V merge​(K key, V value, BiFunction<? super V,​? super V,​? extends V> remappingFunction)


```java

Map<String, String> map = new LinkedHashMap<>();
   BinaryOperator<String> operator = (s1, s2)-> null;
   map.put("John", "Teacher");
   map.merge("John", "Doctor", operator);
   map.merge("Jane", "Doctor", operator);
   System.out.println(map); //[Jane, Doctor]

var map1 = new HashMap<Integer, Integer>();
  map1.put(1, 10);
  map1.put(2, 20);
  map1.put(3, null);
  map1.put(4, 200);
  map1.merge(1, 3, (a,b) -> a + b);
  map1.merge(2, 10, (a, b)-> null);
  map1.merge(3, 3, (a,b) -> a + b);
  map1.merge(4, 100, (a,b) -> a + b);
  map1.merge(5, 400, (a,b) -> a + b); 
  System.out.println(map);
//Result: map ==> {1=13, 3=3, 4=300, 5=400}
```

```java

BiFunction<String, String, String> mapper = (v1, v2)
    -> v1.length()> v2.length() ? v1: v2;

Map<String, String> favorites = new HashMap<>();
favorites.put("Jenny", "Bus Tour");
favorites.put("Tom", "Tram");
favorites.put("Sam", null);
String jenny = favorites
.merge("Jenny", "Skyride", mapper);
String tom = favorites
.merge("Tom", "Skyride", mapper);
String sam = favorites.merge("Sam", "Boat ride", mapper);
System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
System.out.println(jenny);     // Bus Tour
System.out.println(tom);       // Skyride
System.out.println(sam);       // Skyride
  
 //merge() is what happens when the mapping function is called and returns null. The key is removed from the map when this happens:  
BiFunction<String, String, String> mapper1 = (v1, v2) -> null;
Map<String, String> favorites1 = new HashMap<>();
favorites1.put("Jenny", "Bus Tour");
favorites1.put("Tom", "Bus Tour");
 
favorites1.merge("Jenny", "Skyride", mapper1);
favorites1.merge("Sam", "Skyride", mapper1);
System.out.println(favorites1); 
```

### Comparision of collections
- Only TreeSet and TreeMap are sorted, they call compareTo while add the elements.
- HashSet and HashMap are the only collections used hashCode to store and retrieve elements
- Only Set doesn't allow duplicates.
- ORDER: List is order by index, Queue (retrieved in defined order), add/remove in specific order applicable only to queue.
- Old collections `Vector, Hashtable, Stack` If you don't need concurrency.

### Sorting Data
- For numerics it is numeric order
- For String its according to Unicode character mapping.
- Incase of numeric and string then numbers before letters
- Uppercase letters sort before lowercase letter.  
- `void Collections.sort(collectionObj)` many a times we use this to sort 
- Other two sorting mechanism through comparable interface and Comparator class
#### Creating a Comparable class

```java
public interface Comparable<T> {
   int compareTo(T o);
}

public class Duck implements Comparable<Duck> {
  private String name;
  private int weight;
   public Duck(String name) {
      this.name = name;
   }

   public Duck(String name, int weight) {
      this.name = name;
      this.weight = weight;
   }
 @Override  
 public int compareTo(Duck d) {
  if (d == null)
     throw new IllegalArgumentException("Invalid value passed");
   if (this.name == null && d.name == null)
         return 0;
   else if (this.name == null) return -1;
   else if (d.name == null) return 1;
   else return name.compareTo(d.name); // sorts ascendingly by name
 }
}

Collections.sort(ducks); //sort by name.
```
### Comparing Data with a Comparator
The Comparator interface consists of a single method.
```java
   public interface Comparator<T> {
      int compare(T 01, T02);
   }
```
* The compare method compares its two arguments, returning a negative integer, 0, or a positive integer depending on whether the first argument is less than, equal to, or greater than the second.
* As Comparator is a functional interface (has only one abstract method to implement), the comparator can be defined using a lambda expression.  
* `Comparator.comparing`  is a static interface method that creates a Comparator given a lambda expression or method reference.  
* Using a lambda expression : `Comparator<Duck> byWeight = (d1, d2) -> d1.getWeight()-d2.getWeight();`
* shorter version Comparator<Duck> byWeight = `Comparator.comparing(Duck::getWeight);`
```java
 Comparator<Duck> byWeight = new Comparator<Duck>() {
          public int compare(Duck d1, Duck d2) {
             return d1.getWeight()-d2.getWeight();
          }
       };

    Duck d1 = new Duck("Quack", 7);
    Duck d2 = new Duck("Puddles", 10);
    List ducks = List.of(d1, d2);
    Collections.sort(ducks); //[Puddles, Quack]  
    Collections.sort(ducks, byWeight); // [Quack, Puddles]
```

Difference	|Comparable	|Comparator
---------|----------|---------
Package name	            |java.lang	|java.util
Interface must be 
implemented by class comparing?	|Yes	|No
Method name in interface	|compareTo()|	compare()
Number of parameters	    |1	        |  2
Common to declare using   |No	        |Yes
a lambda	      

#### Comparing using multiple fields
```java
Comparator<Squirrel> c = Comparator.comparing(Squirrel::getSpecies)
   .thenComparingInt(Squirrel::getWeight);
```
<p>This time, we chain the methods. First, we create a comparator on species ascending. 
Then, if there is a tie, we sort by weight</p>

`var c = Comparator.comparing(Squirrel::getSpecies).reversed();` // sorting descending order of species.
#### Helper static methods
 * `Comparing(function)` Compare by the results of a function that returns any Object (or object autoboxed into an Object).
 * `comparingDouble(function)` Compare by the results of a function that returns a `double`. similar methods are ComparinInt, ComparingLong.
 * `naturalOrder()`	Sort using the order specified by the Comparable implementation on the object itself.
 * `reverseOrder()` Sort using the reverse of the order specified by the Comparable implementation on the object itself.
#### Helper default methods for building a Comparator
* `reversed()`	Reverse the order of the chained Comparator.
* `thenComparing(function)	`If the previous Comparator returns 0, use this comparator that returns an Object or can be autoboxed into one.
* `thenComparingDouble(function)	`If the previous Comparator returns 0, use this comparator that returns a double. Otherwise, return the   value from the previous Comparator.
* Other `thenComparingInt(function), thenComparingLong(function)`

### Sorting and Searching 
```java
static class Rabbit{ int id; }
Collections.sort(rabbits); //DOES NOT COMPILE, since Rabbit class doesn't implement comparable interface. 
```
- To resolve you can pass a comparator object reference
- Collections.sort(rabbits,  (r1, r2) -> r1.id - r2.id);
- The binarySearch() method requires a sorted List.
```java
11: List<Integer> list = Arrays.asList(6,9,1,8);
12: Collections.sort(list); // [1, 6, 8, 9]
13: System.out.println(Collections.binarySearch(list, 6)); // 1
14: System.out.println(Collections.binarySearch(list, 3)); // -2
```
- _Note:_  The number 3 would need to be inserted at index 1 (after the number 1 but before the number 6). Negating that gives us −1, and subtracting 1 gives us −2.
- What is the answer ? 
```java
3: var names = Arrays.asList("Fluffy", "Hoppy");
4: Comparator<String> c = Comparator.reverseOrder();
5: var index = Collections.binarySearch(names, "Hoppy", c);
6: System.out.println(index);
```
- Answers is -1: . Line 3 creates a list, [Fluffy, Hoppy]. This list happens to be sorted in ascending order. Line 4 creates a Comparator that reverses the natural order. Line 5 requests a binary search in descending order. Since the list is in ascending order, we don't meet the precondition for doing a search.
- Treeset must implement Comparable interface as it add elements based on the sorting logic.
```java
5:  Set<Duck> ducks = new TreeSet<>();
6:        ducks.add(new Duck("Puddles"));
7:
8:        Set<Rabbit> rabbits = new TreeSet<>();
9:        rabbits.add(new Rabbit());  // ClassCastException class Duck cannot be cast to class java.lang.Comparable 
// Just like searching and sorting, you can tell collections that require sorting that you want to use a specific Comparator
8: Set<Rabbit> rabbits = new TreeSet<>((r1, r2) -> r1.id-r2.id);
9: rabbits.add(new Rabbit());
```
### Generics

Generic class or generic method would then contain atleast one type `to-be-specified-later`. Introduced in Java 5.0
- A minimum a generic class `public class GenericContainer<T> {}`
  <p>"T" is a type parameter, used as a placeholder for the type that will get assigned at runtime.</p>
```java
  // Declaring a generic class
class GenericallyTypedClass<T> {

    // Declaring an instance variable using type parameter
    T currentObj;

    // Constructor allows passing an object to the Generic class
    // using the type parameter T
    GenericallyTypedClass(T t) {
        this.currentObj = t;
        printType();
    }

    // instance method
    public void printType() {
        System.out.println("Instance variable type is T but compile" +
                " time type = " + this.currentObj.getClass().getName());
    }
}

        // Declare type argument <StringBuilder> on left side of assignment,
        // use <> diamond operator on right side
        GenericallyTypedClass<StringBuilder> generic2 =
                new GenericallyTypedClass<>(new StringBuilder("hello"));

        // Declare a LVTI (var), and specify type argument on right side of
        // assignment using  <Integer>
        var generic3 = new GenericallyTypedClass<Integer>(10);

```

###  Naming conventions for Generics
* E for an element
* K for a map key
* V for a map value
* N for a number
* T for a generic data type
* S, U, V, and so forth for multiple generic types

- Generic classes aren't limited to having a single type parameter. This class shows two generic parameters.
```java
public class SizeLimitedCrate<T, U> {
   private T contents;
   private U sizeLimit;
   public SizeLimitedCrate(T contents, U sizeLimit) {
      this.contents = contents;
      this.sizeLimit = sizeLimit;
   }
}

Elephant elephant = new Elephant();
Integer numPounds = 15_000;
SizeLimitedCrate<Elephant, Integer> c1 
   = new SizeLimiteCrate<>(elephant, numPounds);
```
### Generic Interfaces
```java
public interface Shippable<T> {
   void ship(T t);
}
 //The following concrete class says that it deals only with robots. 
class ShippableRobotCrate implements Shippable<Robot> {
   public void ship(Robot t) { }
}
```

### Restrictions on Generic Classes
1. Generic class can't extend Throwable, Exception, Error  
```java
class GenericClass<T> extends Throwable {}
class GenericClass<T> extends Exception {}
```
2. Creating a static variable as a generic type parameter: This is not allowed because the type is linked to the instance of the class.
3. Calling a constructor: Writing new T() is not allowed because at runtime it would be new Object().
4. Creating an array of that generic type: This one is the most annoying, but it makes sense because you'd be creating an array of Object values.
5. Calling instanceof: This is not allowed because at runtime List<Integer> and List<String> look the same to Java thanks to type erasure.

### Generic Methods
- [Generic methods](https://docs.oracle.com/javase/tutorial/extra/generics/methods.html)
- A sample Generic type declaration below, usable in real time in the above link.
```java
1: public class Crate<T> {
//This is Generic method the T here has no bound to the Type param in the class Crate.
2:    public <T> T tricky(T t) { 
3:       return t;
4:    }
  
     public static <T> T gettricky(T t) {//This is Satic Generic method.
        return t;
    }

5: }

10: public static String createName() {
11:    Crate<Robot> crate = new Crate<>();
12:    return crate.tricky("bot");
13: }
```
- On line 1, T is Robot because that is what gets referenced when constructing a Crate. On line 2, T is String
- To make it clear you can also replace Line 12: `crate.<String>tricky("bot");`
  
```java
2: public class More {
3:    public static <T> void sink(T t) { }
4:    public static <T> T identity(T t) { return t; }
5:    public static T noGood(T t) { return t; } // DOES NOT COMPILE bcos Generic is not allowed in class Type Param
6: }
```
- A complete example of Generic used in class and in instance method, static method
  
   ```java
      //A Generic Class
      class GenericClassType<T> {

            public T instanceMethod(T t) {
               return t;
            }

            //Generic method type:instance
            public <U>U instanceGenericMethod(U u) {
               return u;
            }

            public <U> void instanceGenericVoidMethod(U u) {
               
            }

            //Generic method type:static
            public static <T> T  something(T t) {
            return t;
            }

            //Uncommenting show error: Cannot make a static reference to a non-static Type T
            /*public static  T  somethingError(T t) {
            return t;
            }*/
         }
   ```
### Generic class bounded and Type Erasure

```java

// Generic class: upper bound of Comparable Interface
class GenericInterfaceBound<T extends Comparable> {

    public void doSomething(T t1, T t2) {

        // Comparable's methods are available to any object of type T
        int comparison = t1.compareTo(t2);
        if (comparison > 0) {
            System.out.println(t2 + " is behind " + t1);
        } else {
            System.out.println(t2 + " is ahead of " + t1);
        }
    }
}
  // Instances of generic class bounded by Comparable
        GenericInterfaceBound<LocalDate> i1 =
                new GenericInterfaceBound<>();
        i1.doSomething(LocalDate.now(),
                LocalDate.of(2019, Month.SEPTEMBER, 29));

        GenericInterfaceBound<Float> i2 = new GenericInterfaceBound<>();
        i2.doSomething(12.34f, 12.345f);
```
### Erasure of Generic Methods (<T> to Object) 
- The java compiler applies type erasure to replace all type parameters in generic types
  with their bounds or Object if the type parameters are unbounded meaning `T`. Here in the below code it prints `f(Object o) called` inspite of String value is passed due to the erasure.
```java
static void f(Object o) {
   sout ("f(Object o) called");
}

static void f(String o) {
   sout ("f(String o) called");
}
static <T> void g(T t) {
   f(t);
}
Test call: g("123");
```
### Generic Wild Cards

- Bounded wildcards solve this by restricting what types can be used in a wildcard. A bounded parameter type is a generic type that specifies a bound for the generic.
- A wildcard generic type is an unknown generic type represented with a question mark (?). You can use generic wildcards in three ways
  
Type of bound |Syntax | Example
---------|----------|---------
 Unbounded wildcard | `?` | List<?> a = new ArrayList<String>();
 Wildcard with an upper bound | `? extends type `| List<? extends Exception> a = new ArrayList<RuntimeException>();
 Wildcard with a lower bound | `? super type` | List<? super Exception> a = new ArrayList<Object>();

- Unbounded wildcard List<?> is not same as List<Object>. you can't assign a List of Integer to List<Object>, but for List<?> allowed.
- Upper bounded Wildcard List<? extends Number> can be interpereted as Number is allowed and any type that extends Number". It allows the code to used the methods in the bounded type.
- Lower bounded  <? Super Exception> means Exception and its superclass throwable and Object are allowed.
  
### Unbounded Wildcards
- An unbounded wildcard represents any data type. You use ? when you want to specify that any type is okay with you
```java
ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT COMPILE
List<? extends Number> list = new ArrayList<Integer>();// This works
```
- Finally, let's look at the impact of var. Do you think these two statements are equivalent?
<p> They are not. There are two key differences. First, x1 is of type List, while x2 is of type ArrayList. Additionally, we can only assign x2 to a List<Object>.</p>

```java
List<?> x1 = new ArrayList<>(); //List of any
var x2 = new ArrayList<>(); // List<Object>
```


#### Lower-Bounded WildCards
- The problem is that we want to pass a List<String> and a List<Object> to the same method.
 * It will work for the lower-bounded wild cards `addSound(List<? super String> list)`
 * for all the other types compile error will be resulted for Unbounded `addSound(List<?> list)` and  Upperbounded `addSound(List<? extends Object> list)` method doesn't compile bcos generics are immutable you can't modify.
 * Last one you can't pass List<String> to List<Object> for addSound(Strings). 

```java
   List<String> strings = new ArrayList<>();
   strings.add("tweet");

   List<Object> objects = new ArrayList<Object>(strings);
   addSound(strings); //Doesn't compile for void addSound(List<Object> list);
   addSound(objects);

   private static void addSound(List<? super String> list) { // Compiles and works
      list.add("quack");
   }

    private static void addSound(List<?> list) { //Doesn't compile
      list.add("quack");
   }

   private static void addSound(List<? extends Object> list) { //Doesn't compile
      list.add("quack");
   }

   private static void addSound(List<Object> list) {
      list.add("quack");
   }

```
#### Combining Generic Declarations
- Exercise 
```java
class A {}
class B extends A {}
class C extends B {}

6: List<?> list1 = new ArrayList<A>(); //creates an ArrayList that can hold instances of class A. It is stored in a variable with an unbounded wildcard.
7: List<? extends A> list2 = new ArrayList<A>();// You can have ArrayList<A>, ArrayList<B>, or ArrayList<C>
8: List<? super A> list3 = new ArrayList<A>(); //This time its lower bound It can have only A.

9:  List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
10: List<? super B> list5 = new ArrayList<A>();
11: List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE  you can't add any elements to that ArrayList.

```


#### Generics with upperbounds (T extends <super class> & <interface>)
- An example using both a class and two interfaces is shown below. Here Number is a class which should preceed first before the other interfaces.
// Generic class: upper bound of Comparable Interface

```java
class GenericMixedBounded<T extends Number & Comparable & Serializable> {
    public void doSomething(T t1, T t2) {

        // Comparable's methods are available to any object of type T
        int comparison = t1.compareTo(t2);
        if (comparison > 0) {
            System.out.println(t2 + " is behind " + t1);
        } else {
            System.out.println(t2 + " is ahead of " + t1);
        }
    }
}

        // Instances of generic class bounded (only) by Comparable same class as above.
        GenericInterfaceBound<LocalDate> i1 =
                new GenericInterfaceBound<>();
        i1.doSomething(LocalDate.now(),
                LocalDate.of(2019, Month.SEPTEMBER, 29));

        GenericMixedBounded<Float> i2 = new GenericMixedBounded<>();
        i2.doSomething(12.34f, 12.345f);
```
#### Create and Use Generic Methods
- `<T> T getValue(T t) {return t;}` where <T> represents the "TypeParameters"
- An example with modifiers 
 * `public <T> void doSomething(T t) {}`
 * To invoke a generic method, you can pass the type in the following way, using the type argument declared in angle brackets <>, immediately prior to the method name as the example below demonstrates:
  `myObject.<String>doSomething("hello");`

- Some examples: 

```java
//Normal generics.  It uses a method‐specific type parameter, T. It takes a parameter of List<T>, or some subclass of T, and it returns a single object of that T type. (e.g) It cane be List<String>, List<Number>
<T> T first(List<? extends T> list) {
   return list.get(0);
}

//You know what type it is supposed to return. You don't get to specify this as a wildcard.
<T> <? extends T> second(List<? extends T> list) { // DOES NOT COMPILE
   return list.get(0);
}
//Within the scope of the method, B can represent class A, B, or C, because all extend the A class. Since B no longer refers to the B class in the method, you can't instantiate it.
<B extends A> B third(List<B> list) {
   return new B(); // DOES NOT COMPILE
}
// A normal use of generics. You can pass the types List<B>, List<A>, or List<Object>.
void fourth(List<? super B> list) {}
//does not compile because it tries to mix a method‐specific type parameter with a wildcard. A wildcard must have a ? in it.
<X> void fifth(List<X super B> list) { // DOES NOT COMPILE
}
  ```

  ## Review Questions
  1. A, B, E(Read the question properly only one choice)/B
  2. D~~, E~~ (Dealing with Key and pair, so only TreeMap and no TreeSet)
  3. E
      ```java
      12: List<?> q = List.of("mouse", "parrot"); // Creates a List<Object>
      13: var v = List.of("mouse", "parrot");
      14:
      15: q.removeIf(String::isEmpty); // Do not compiles since they call String
      16: q.removeIf(s -> s.length() == 4); 
      17: v.removeIf(String::isEmpty); // Do not compiles since they call String
      18: v.removeIf(s -> s.length() == 4);
      ```
  4. what is the result od the following stmt ? 
   ```java
      var greetings = new LinkedList<String>();
      greetings.offer("hello"); 
      greetings.offer("hi");
      greetings.offer("ola");
      greetings.pop();// Removing the firstElement
      greetings.peek(); //looking at the firstElement in the list/queue.
      while (greetings.peek() != null)
      System.out.print(greetings.pop()); //hi,Ola
      
   ```
  5.  D, F
   Which of these statements compile? (Choose all that apply.)
```java
   //Incompitable to make it work HashSet<? extends Number> hs2 = new HashSet<Integer>();.
   HashSet<Number> hs = new HashSet<Integer>(); 
   HashSet<? super ClassCastException> set = new HashSet<Exception>(); //Compiles
   List<> list = new ArrayList<String>();//Diamond operator allowed only in the right hand side.
   List<Object> values = new HashSet<Object>();//Incompatiable types Set and List
   List<Object> objects = new ArrayList<? extends Object>();//Upper bound are not allowed when instantiating
   Map<String, ? extends Number> hm = new HashMap<String, Integer>(); //Compiles bocs UpperBounds are on the correct side.
```
  6.  B
  ```java
  1:  public class Hello<T> {
  2:     T t;
  3:     public Hello(T t) { this.t = t; }
  4:     public String toString() { return t.toString(); }
  5:     private <T> void println(T message) {
  6:        System.out.print(t + "-" + message);
  7:     }
  8:     public static void main(String[] args) {
  9:        new Hello<String>("hi").println(1);
  10:       new Hello("hola").println(true);
  11:    } }
   //Result: hi‐1hola‐true
  ```
  7. A, D (careless, missed option A)
  8. B, ~~D~~, F (Looks the question and answer for more details )//Required Review
  9.  A, B, C / Review collection API methods Map used put
  10. <p> E // Abb aab 123 The array is sorted using MyComparator, which sorts the elements in reverse alphabetical order in a case-insensitive fashion. Normally, numbers sort before letters. This code reverses that by calling the compareTo() method on b instead of a. </p>
```java
     3:  public class MyComparator implements Comparator<String> {
  4:     public int compare(String a, String b) {
  5:        return b.toLowerCase().compareTo(a.toLowerCase());
  6:     }
  7:     public static void main(String[] args) {
  8:        String[] values = { "123", "Abb", "aab" };
  9:        Arrays.sort(values, new MyComparator());
  10:       for (var s: values)
  11:          System.out.print(s + " ");
  12:    }
  13: }
```
  11. A
  12. A
  13. B, E
  14. ~~E~~ <p>//Result [88, 55] [55, 88]:The t1 object doesn't specify a Comparator, so it uses the Comparable object's compareTo() method. This sorts by the text instance variable. The t2 object did specify a Comparator when calling the constructor, so it uses the compare() method, which sorts by the int </p>
  ```java
    public class Sorted 
  4:     implements Comparable<Sorted>, Comparator<Sorted> {
  5:
  6:     private int num;
  7:     private String text;
  8: 
  9:     // Assume getters/setters/constructors provided
  10:  
  11:    public String toString() { return "" + num; }
  12:    public int compareTo(Sorted s) { 
  13:       return text.compareTo(s.text); 
  14:    }
  15:    public int compare(Sorted s1, Sorted s2) { 
  16:       return s1.num - s2.num; 
  17:    }
  18:    public static void main(String[] args) {
  19:       var s1 = new Sorted(88, "a");
  20:       var s2 = new Sorted(55, "b");
  21:       var t1 = new TreeSet<Sorted>();
  22:       t1.add(s1); t1.add(s2);
  23:       var t2 = new TreeSet<Sorted>(s1);
  24:       t2.add(s1); t2.add(s2);
  25:       System.out.println(t1 + " " + t2);
  26:    } }
  ```
  15. A
  16. B, D, F
  17. ~~A,~~ B, ~~C~~, D Careless 
  18. F <p>Y is both a class and a type parameter. This means that within the class Z, when we refer to Y, it uses the type parameter. All of the choices that mention class Y are incorrect because it no longer means the class Y.</p>
   ```java
   class W {}
  class X extends W {}
  class Y extends X {}
  class Z<Y> {
  // INSERT CODE HERE
  }
  which of the following lines can be inserted ? 
   W w1 = new W();
   W w2 = new X();
   W w3 = new Y();
   Y y1 = new W();
   Y y2 = new X();
   Y y1 = new Y();
   ```
   
   19.  A, D Queue has only the remove by object method, so Java does autobox there. Since the number 1 is not in the list, Java does not remove anything for the Queue. Ans: If we fill in the blank with Queue, the output is [10, 12].If we fill in the blank with List, the output is [10]. Line 6 Remove element on List index 1.
    ```java
      3: ______________<Integer> q = new LinkedList<>();
      4: q.add(10);
      5: q.add(12);
      6: q.remove(1);
      7: System.out.print(q);

    ```
   20.  D. This code compiles its not generic issue infact map method doesn't have contains it only has containsKey, containsValue.
     ```java
         4: Map m = new HashMap();
         5: m.put(123, "456");
         6: m.put("abc", "def");
         7: System.out.println(m.contains("123"));
     ```
   21.  E
   22.  A
   23.  B, C, D, E
   24.  B, F
   25.  F