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
