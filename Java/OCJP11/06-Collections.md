# 06 Collections

## List methods
-  Addition of elements in ArrayList should be continuous. If you are using add(index, Element) method to add items to the list, then index should be continuous, you simply can't skip any index.
-  
### List<E> subList(int fromIndex, int toIndex)
- `List<E> subList(int fromIndex, int toIndex)` It returns a view of the portion of this list between the specified fromIndex and toIndex. The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list and vice-versa.

```java
 List<String> list = new ArrayList<>();
        list.add("P");
        list.add("O");
        list.add("T");
 
 List list = new ArrayList<Integer>(); //This legal Its considered as List<Object>

//In generics syntax, Parameterized types are not polymorphic 
List<Animal> list = new ArrayList<Dog>();// Compilation error

 List<String> subList = list.subList(1, 2); //Line n1
 subList.set(0, "E"); //Line n2
 //list become PET
```
### list.remove(Object):boolean and list.remove(index):removedElement
- remove(Object) method removes the first occurrence of matching object and equals(Object) method decides whether 2 objects are equal or not. 
- If the equals method is overloaded (e.g) `equals(Person)` then the remove method has no effect on list.
- list.remove(Object) method returns boolean result but list.remove(int index) returns the removed item from the list

### list.add(index, E), list.addAll(1, list2), list.set(index,Element)

```java

list1 --> [A, D], 

list2 --> [B, C], 

//list.addAll
list1.addAll(1, list2); is almost equal to list1.addAll(1, [B, C]); => Inserts B at index 1, C takes index 2 and D is moved to index 3. list1 --> [A, B, C, D]

//list.add
list.add(0, "Array"); means list --> [Array],   

list.add(0, "List"); means insert "List" to 0th index and shift "Array" to right. So after this operation, list --> [List, Array]. In the console, [List, Array] is printed.

//list.set
list.set(0, "CAN"); means replace the current element at index 0 with the passed element "CAN". So after this operation, list --> [CAN].

//list.replaceAll
List<Integer> list = Arrays.asList(0,2,4,6,8);
list.replaceAll(i -> i + 1); // [1, 3, 5, 7, 9]

List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
 list.removeIf(i -> i % 2 == 1); // [2, 4, 6, 8]

list.add(1, "RED") // Index should start with 0  Exception java.lang.IndexOutOfBoundsException: Index: 1,
list.add(2, "ORANGE"); 
//---- 
list.add(0, 'V');
list.add('T');
list.add(1, 'E');
list.add(3, 'O'); 
//prints list=[VETO]

List list = new ArrayList<String>(); // consider it as <Object> raw type
list.add(1); //as a member of the raw type java.util.List
list.add("2");
list.forEach(System.out::print);// prints 12
```

### list.clear(), boolean:list.remove()

```java
//list.clear
 list.clear() removes all the elements from the list.

//list.remove
 boolean:list.remove('O'); // converts to ASCII character value int and search based on index

// <E>:remove(int), boolean:remove(object)
//remove(int) returns the deleted member of the list.
//remove(Object) returns true if deletion was successful otherwise false

var list = new ArrayList<>();
 list.add(null);
 list.add(null);

 list.remove(0) // null
 list.remove(null) // true
```

### list.clone

 ArrayList<Counter> cloned = (ArrayList<Counter>) original.clone(); => original.clone() creates a new array list object [suppose at memory location 45BA12] and then copies the contents of the ArrayList object stored at [15EE00]. So, cloned contains memory address of the same Counter object.

 Any changes you do on containing object of the cloned (mutable) object affectes the original, incase of immutable object they are unaffected check the case 2

```java 
//Case:1 Mutable Object(Counter)
class Counter {
       int count; // stored in heap
}
 ArrayList<Counter> original = new ArrayList<>(); //Line n1
        original.add(new Counter(10)); //Line n2 original = [10]
        
 ArrayList<Counter> cloned = (ArrayList<Counter>) original.clone();
 cloned.get(0).count = 5;

 //After cloned and counter update original = [5]
 //Case:2 Immutable Object(Integer)
  ArrayList<Integer> original = new ArrayList<>(); //Line n1
        original.add(10); //Line n2
        
        ArrayList<Integer> cloned = (ArrayList<Integer>) original.clone();
        Integer i1 = cloned.get(0);
        ++i1; // Integer are immutable, so creates a new object in HEAP.
        
        System.out.println(cloned); // prints [10]

```

## ConcurrentModification
- Removing elements from a list using enhanced for loop cause, while loop with iterator,  java.util.ConcurrentModificationException.
- Use listIterator, and for loop with index to remove elements.
  
## Adding and removing from List with and without Autoboxing

```java
List<Integer> lst = new ArrayList<>();
lst.add(100); //autobox int -> Integer
lst.add(100);
lst.add(300);
lst.add(300);
lst.get(0) == lst.get(1) => true
lst.get(2) == lst.get(3) => false // Create lst.add(300) last occurence creates a new Object, since value is out of in range -128 to 127

lst.remove(100); //throws runtime exception autoboxing doesn't happen treated as lst.remove(index)
list.remove(Integer.valueOf(100)); // It will consider remove(Object)
```
### List<> return type

```java
class Father {}
 
class Son extends Father {}
 
class GrandSon extends Son {}
 
abstract class Super {
    abstract List<Father> get();
}
class Sub extends Super {
       List<Father> get(){};
       ArrayList<Father> get();

       //below are not valid coveriant return type is not applicable for List<type>
       List<Son> get() {return null;}
       ArrayList<Son> get() {return null;}
       List<GrandSon> get() {return null;}
       ArrayList<GrandSon> get() {return null;}
       List<Object> get() {return null;}
       ArrayList<Object> get() {return null;}
}
```
### List initialization
- Using list.add(E) create a list object and then use add method
- //shorthand `List<String> list = new ArrayList<>(){{add("Geeks");}};`
- `Arrays.asList(T...)`: Arrays.asList(...) method returns a list backed with array, so elements cannot be added to or removed from the list. But list elements can be replaced. meaning list.set(3, "value"); 
- `List.of(...)` method creates an unmodifiable list containing specified elements. Calling any mutator method on the List(add, addAll, set, remove, removeIf, removeAll, retainAll) will always cause UnsupportedOperationException to be thrown.

### List classes
- `Set\HashSet` to avoid duplicate both equals and hashCode has to be implemented in Class
- TreeSet requires you to provide either Comparable or Comparator. If you don't provide Comparator explicitly, then for natural ordering your class should implement Comparable interface. Class cast Exception is thrown at runtime when adding element 
 
 ```java
  Set<Student> students = new TreeSet<>(Student::compareByName);
  Class Student {
   public static int compareByName(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
  }
  ```
 - Character and all wrapper classes implement Comparable interface, hence Characters are sorted in ascending order. Uppercase characters appears before lowercase characters.
  ```java
   Set<Character> set = new TreeSet<>(Arrays.asList('a','b','c','A','a','c'));
        set.stream().forEach(System.out::print); // Aabc
  ```      
 - TreeSet cannot contain null values. Hence, 'new TreeSet<>(Arrays.asList(null,null,null));' throws NullPointerException.
 - HashSet cares about uniqueness and allows 1 null value. new HashSet<>(Arrays.asList(null,null,null)); size is 1
 - List can contain null values
 - Treeset ceiling,floor, higher, lower
 
 ```java 
  new TreeSet<>(Arrays.asList("red", "green", "blue", "gray")); => [blue, gray, green, red]. 
       set.ceiling("gray") => Returns the least value greater than or equal to the given value, 'gray'. 
       set.floor("gray") => Returns the greatest value less than or equal to the given value, 'gray'. 
       set.higher("gray") => Returns the least value strictly greater than the given value, 'green'. 
       set.lower("gray") => Returns the greatest value strictly less than the given value, 'blue'. 
 ```  

### set.of

 - `set.of(e1, e2)` - Creates an unmodifyable collection, throws NPE if the element contains `null` .
 -  Set<String> set = Set.of("A", "E", "I", "I", null, "O", "U"); These create an unmodifiable set containing specified elements. These methods throw NullPointerException if an element is null or IllegalArgumentException, if the elements are duplicates at runtime.
 -  set.add(O), set.remove(Character.of('I')) throws UnsupportedOperationException at runtime.
## Set.CopyOf()
 
  <p>According to the Javadoc of equals(Object) method of Set interface, it compares the specified object with this set for equality. Returns true if the specified object is also a set, the two sets have the same size, and every member of the specified set is contained in this set (or equivalently, every member of this set is contained in the specified set). Order doesn't matter</p>

  ```java
       var list = List.of("A", "E", "I", "O", "U"); //Line n1
       var set1 = Set.copyOf(list); //Line n2

       var map = Map.of(1, "U", 2, "O", 3, "I", 4, "E", 5, "A"); //Line n3
       var set2 = Set.copyOf(map.values()); //Line n4

       System.out.println(set1.equals(set2)); //Line n5 true
       //------

        var sb1 = new StringBuilder("A");
        var sb2 = new StringBuilder("B");
        var set1 = Set.of(sb1, sb2); //Line n1
        var set2 = Set.copyOf(set1); //Line n2
        System.out.println((set1 == set2) + ":" + set1.equals(set2)); //Line n3 true:true

       var set1 = Set.of(new StringBuilder("GOD"), new StringBuilder("IS"), new StringBuilder("GREAT"));
       var set2 = Set.of(new StringBuilder("GOD"), new StringBuilder("IS"), new StringBuilder("GREAT"));
       System.out.println((set1 == set2) + ":" + set1.equals(set2)); // false:false
   ```

### Map

- `HashMap` allows one null key and null value, and non-null keys with null values in multiple.
- TreeMap doesn't allow null key. NPE at runtime.
- TreeMap is the sorted map on the basis on natural ordering of keys (if comparator is not provided). 
- enum TrafficLight is used as a key for TreeMap. The natural order for enum elements is the sequence in which they are defined.
  
```java
enum TrafficLight {
    RED, YELLOW, GREEN
}
Map<TrafficLight, String> map = new TreeMap<>();
map.put(TrafficLight.GREEN, "GO");
map.put(TrafficLight.RED, "STOP");
map.put(TrafficLight.YELLOW, "READY TO STOP");

for(String msg : map.values()) {
System.out.println(msg);
}
//STOP READY TO STOP GO
```

### NavigableMap

TreeMap is sorted map based on the natural ordering of keys. So, map has entries: {11=Sri Nagar, 25=Pune, 32=Mumbai, 39=Chennai}. 

- headMap(K toKey, boolean inclusive) => returns the map till toKey, if inclusive is true. Hence the output is: {11=Sri Nagar, 25=Pune}. 

- tailMap(K toKey, boolean inclusive) =>  Returns a view of the portion of this map whose keys are greater than (or equal to, if 'inclusive' is true) fromKey. output: `{25=Pune, 32=Mumbai, 39=Chennai}` </b>
- //Map.Entry<K,V> firstEntry(); => Returns a key-value mapping associated with the least key in this map. </b>
System.out.println(map.firstEntry()); //11=Sri Nagar </b>
- //Map.Entry<K,V> lastEntry(); => Returns a key-value mapping associated with the greatest key in this map. 
System.out.println(map.lastEntry()); //39=Chennai </b>
- //NavigableMap<K,V> descendingMap(); => Returns a reverse order view of the mappings contained in this map. 
System.out.println(map.descendingMap()); //{39=Chennai, 32=Mumbai, 25=Pune, 11=Sri Nagar} 
- //K floorKey(K key); => Returns the greatest key less than or equal to the given key. 
System.out.println(map.floorKey(30)); //25 </b>
- //K ceilingKey(K key); => Returns the least key greater than or equal to the given key. 
System.out.println(map.ceilingKey(30)); //32 </b>

```java
NavigableMap<Integer, String> map = new TreeMap<>();
map.put(25, "Pune");
map.put(32, "Mumbai");
map.put(11, "Sri Nagar");
map.put(39, "Chennai");
//{11=Sri Nagar, 25=Pune, 32=Mumbai, 39=Chennai}
System.out.println(map.headMap(25, true)); //{11=Sri Nagar, 25=Pune}
System.out.println(map.tailMap(25, true)); //{25=Pune, 32=Mumbai, 39=Chennai}
System.out.println(map.headMap(25)); //{11=Sri Nagar}
System.out.println(map.tailMap(25)); //{25=Pune, 32=Mumbai, 39=Chennai}
```

#### Map.of(k1,v1)

These create an unmodifiable map containing specified keys and values.

These methods throw NullPointerException - if any key or value is null or IllegalArgumentException - if the keys are duplicates

//max limit params
`Map.of()`
`Map.of(K k1, V v1)`
 ....</br>
  ...</br>
`Map.of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10);`

Please note interfaces List and Set contain 12 overloaded of methods each, whereas interface Map contains 11 overloaded of methods. Varargs version is not available in Map interface.

- `Map.ofEntries​(Map.Entry<? extends K,​? extends V>... entries)` 

To provide more than 10 key-value pairs use, Map.ofEntries​(Map.Entry<? extends K,​? extends V>... entries) method.

```java
var map1 = Map.of("1", "2", "3", "4"); //{1=2, 3=4}
var map2 = Map.ofEntries(Map.entry("3", "4"), Map.entry("1", "2")); //{1=2, 3=4}
var list1 = List.of("1", "2", "3", "4");
var list2 = List.of("4", "3", "2", "1");
System.out.println(map1.equals(map2) + ":" + list1.equals(list2)); //true: false
```
Explanation: Variable 'map1' refers to Map object containing 2 key-value pairs. Variable 'map2' refers to different Map object containing same 2 key-value pairs.

<p>
map1.equals(map2): According to the Javadoc of equals(Object) method of Map interface, it compares the specified object with this map for equality. Returns true if the given object is also a map and the two maps represent the same mappings.

list1.equals(list2):
(Two elements e1 and e2 are equal if Objects.equals(e1, e2).) In other words, two lists are defined to be equal if they contain the **same elements in the same order**.

set1.equals(set2):

According to the Javadoc of equals(Object) method of Set interface, it compares the specified object with this set for equality. Returns true if the specified object is also a set, the two sets have the same size, and every member of the specified set is contained in this set (or equivalently, every member of this set is contained in the specified set). Order doesn't matter
 </p>

 ### Collections List/Set/Map.of method comparision
 
 | Collections                      | Desc                                                                                                                                         |
 | -------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
 | List.of(E)                       | 12 Overloaded methods - List.of(), </br>List.of(E e1),</br> List.of(E e1, E e2)</br>...List.of(E e1, ... E e10),</br> List.of(E... elements) |
 | Set.of(E)  12 Overloaded methods | - Duplicate not allowed                                                                                                                      |
 | Map.of(E)                        | 11 overloaded methods from Map.of(), Map.of(K k1, V v1).. Map.of(K k1, V v1 .. K k10, V v10)                                                 |
 - Duplicate not allowed
 - NPE if any key or value is NULL
 - To provide more than 10 key-value pairs use, Map.ofEntries​(Map.Entry<? extends K,​? extends V>... entries) method|

 ### Collections List/Set/Map.equals method comparision

 | Collections      | Desc                                             |
 | ---------------- | ------------------------------------------------ |
 | lst1.equal(lst2) | If the elements are equals and in the same order |
 |                  |

## Deque

- ArrayDeque cannot store null
- deque.add(100); // method invokes addLast(E) method
- deque.remove(); => Removes the head of the Queue
- deque.remove(); on a empty list => throws Runtime Exception
- pop(); removes the HEAD element from the queue
- peek(); get the HEAD element
- push(); pushes to the HEAD of the queue meaning to the first position.

```java
Deque<Integer> deque = new ArrayDeque<>();
deque.add(100); // method invokes addLast(E) method
deque.addFirst(300);
deque.addLast(400);
deque.remove(200); // method invokes removeFirst() method.
deque.remove(); => Removes the head of the Queue
chars.remove(); => on [], => No elements left to remove() and hence java.util.NoSuchElementException is thrown at runtime.
removeFirst();  => Removes the first element from the Deque. 

removeLast(); => Removes the last element from the Deque.
deque.getFirst(); => get the first element from the Deque.

Deque<Boolean> deque = new ArrayDeque<>();
deque.push(Boolean.valueOf("abc")); => [*false]. * represents HEAD of the deque.push(Boolean.valueOf("tRuE")); => [*true, false]. 
deque.push(Boolean.valueOf("tRuE")); => [*true, false]. 
deque.push(Boolean.valueOf("FALSE")); => [*false, true, false]. 
deque.push(true); => [*true, false, true, false]. 
deque.pop() => removes and returns the HEAD element, true in this case. deque => [*false, true, false]. 
deque.peek() => retrieves but doesn't remove the HEAD element, false in this case. deque => [*false, true, false]. 
deque.size() => 3
```

### Collections sorting use java.lang.Comparable and java.util.Comparator

- Comparator interface has compare(Obj1, Obj2) method
- Comparable interface has compareTo(obj)
- If you sort String in ascending order, then upper case letters appear before the lower case letters.
- ` o.age - this.age` arranges in desc

```java
class Employee implements Comparable<Employee> {
    private String name;
    private int age;

    //Method sorts the employee obj in the desc order
     @Override
    public int compareTo(Employee o) { 
        return o.age - this.age;
    }
}

class Name {
String first, last;
}
List<Name> names = Arrays.asList(new Name("Peter", "Lee"), new Name("John", "Smith"), new Name("bonita", "smith"));
//To display [bonita smith, John Smith, Peter Lee]
Collections.sort(names, o1.getFirst().toLowerCase().compareTo(o1.getFirst().toLowerCase()));
Collections.sort(names, o1.getFirst().toUpperCase().compareTo(o1.getFirst().toUpperCase()));
Collections.sort(names, o1.getFirst().toUpperCase().compareToIgnoreCase(o1.getFirst().toUpperCase()));

 String [] arr = {"**", "***", "*", "*****", "****"};
        Arrays.sort(arr, (s1, s2) -> s1.length()-s2.length()); // arranges in asc order
//Note Even though lambda expression is for the compare method of Comparator interface, but in the code name "Comparator" is not used hence import statement is not needed here.        
```

### Comparator

```java
//Method to sort the element in descending order
 Collections.sort(points, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                return o2.getX() - o1.getX();
            }
        });
```

- To sort the Point objects in ascending order of x, use: return o1.getX() - o2.getX(); 
- To sort the Point objects in descending order of x, use: return o2.getX() - o1.getX(); 

```java
 List<String> list = Arrays.asList("M", "R", "A", "P");
        Collections.sort(list, null); //[A, M, P, R]
```
- If null Comparator is passed to sort method, then elements are sorted in natural order (based on Comparable interface implementation). 
- As list is of String type and String implements Comparable, hence list elements are sorted in ascending order.

```java
    List<String> emails = Arrays.asList("udayan@outlook.com", "sachin@outlook.com", "sachin@gmail.com",
                "udayan@gmail.com");
        Collections.sort(emails, Comparator.comparing(str -> str.substring(str.indexOf("@") + 1)));
```
<p> 
gmail records should appear before outlook records. So sorting order is:


sachin@gmail.com
udayan@gmail.com
udayan@outlook.com
sachin@outlook.co

NOTE: It is not specified, what to do in case email domain is matching. So, for matching email domain, records are left at insertion order. </p>

```java
List<Person> list = Arrays.asList(
            new Person("Tom", "Riddle"),
            new Person("Tom", "Hanks"),
            new Person("Yusuf", "Pathan"));
List lst = list.stream().sorted(Comparator.comparing(Person::getFirstName).reversed())
.collect(Collectors.toList());
//lst ==> [{Yusuf, Pathan}, {Tom, Riddle}, {Tom, Hanks}]

list.stream().sorted(Comparator.comparing(Person::getFirstName).reversed()
            .thenComparing(Person::getLastName)
List lst = list.stream().sorted(Comparator.comparing(Person::getFirstName).reversed()
.thenComparing(Person::getLastName)).collect(Collectors.toList());
//lst ==> [{Yusuf, Pathan}, {Tom, Hanks}, {Tom, Riddle}]                   
```