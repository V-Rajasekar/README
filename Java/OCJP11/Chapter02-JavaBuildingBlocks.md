# Chapter 2 Java Building Blocks
- Creating Objects
   * Creating objects can be done with `new` keyword and `static` methods like 
    ```java
    Chicken chicker = new Chicken(); 
    Integer num = Integer.ValueOf("12");
    ```
## Following Order of Initialization
- Fields and instance initializer blocks are run in the order in which they appear in the file.
- The constructor runs after all fields and instance initializer blocks have run.
- Order matter you can't refer to a variable before it has been defined.
```java
public class Egg {
   public Egg() {
      number = 5;
   }
   public static void main(String[] args) {
      Egg egg = new Egg();
      System.out.println(egg.number);
   }
   private int number = 3;
   { number = 4; }
 }
  //output of number is 5. 
```
- **Fields and blocks are run first in order,finally the constructor** setting number to 3 and then 4. Then the constructor runs, setting number to 5

## Understanding Data Types
#### Primitive types
- `String` is not a primitive
- All of the numeric types are signed in Java. This means that they reserve one of their bits to cover a negative range. For example, byte ranges from -128 to 127
- Diff b/w `short` and `char` is short is signed, where its range acrosss the positive and negative integers. And `char` is unsigned. `char` can hold a higher positive numeric value than short, but can't hold negative numbers.
- Compiler allows short and `char` to be used interchangeably in some cases
  ```java
  short bird = 'd'; // Prints 100
  char mammal = (short)83; // Prints S
  ```
-  Java allows you to specify digits in several other formats:
 * `Octal (digits 0–7)`, which uses the number 0 as a prefix—for example, 017
 * `Hexadecimal (digits 0–9 and letters A–F/a–f)`, which uses 0x or 0X as a prefix—for example, 0xFF, 0xff, 0XFf. Hexadecimal is case insensitive so all of these examples mean the same value.   
 * `Binary (digits 0–1)`, which uses the number 0 followed by b or B as a prefix—for example, 0b10, 0B10  
- `long max = 3123456789;`  // DOES NOT COMPILE, but with `L(recommended)/l` in the value end compiles.  

|Keyword|	Type	            |Example|
|----|-----|----|
|boolean|true or false	                |true|
|byte	|8-bit integral value	        |123|
|short	|16-bit integral value	        |123|
|int	|32-bit integral value	        |123|
|long	|64-bit integral value	        |123L|
|float	|32-bit floating-point value	|123.45f|
|double	|64-bit floating-point value	|123.456|
|char	|16-bit Unicode value	        |'a'|

#### Literals and the Underscore Character
```java
  double notAtStart = _1000.00;          // DOES NOT COMPILE
double notAtEnd = 1000.00_;            // DOES NOT COMPILE
double notByDecimal = 1000_.00;        // DOES NOT COMPILE
double annoyingButLegal = 1_00_0.0_0;  // Ugly, but compiles
double reallyUgly = 1__________2;      // Also compiles
```
#### Identifying Identifiers
- Identifiers must begin with a letter, a $ symbol, or a _ symbol.
- Identifiers can include numbers but not start with them.
- A single _ is not allowed.
#### Reserver word
```
abstract	assert	boolean	break	byte
case	catch	char	class	const*
continue	default	do	double	else
enum	extends	false**	final	finally
float	for	goto*	if	implements
import	instanceof	int	interface	long
native	new	null**	package	private
protected	public	return	short	static
strictfp	super	switch	synchronized	this
throw	throws	transient	true**	try
void	volatile	while	_ (underscore)	
```
#### CamelCase and SnakeCase 
- Method and variable names are written in camelCase with the first letter being lowercase
- Constant static final values are often written in snake_case, such as THIS_IS_A_CONSTANT. In addition, enum values tend to be written with snake_case, as in Color.RED, Color.DARK_GRAY
#### Declaring Multiple Variables
- Multiple variable are allowed to be declared and intialized in the same line, provided they all belong to the same type.
```java
void sandFence() {
   String s1, s2;
   String s3 = "yes", s4 = "no";
    int i1, i2, i3 = 0; // 3 declared but only one i3 is initialized with 0
}

4: boolean b1, b2;// valid
5: String s1 = "1", s2; // Valid
6: double d1, double d2; //invalid
7: int i1; int i2; //valid
8: int i3; i4; //invalid
```
#### Initializing Variables
- Local variables do not have a default value and must be initialized before use.
```java
 public void findAnswer(boolean check) {
   int answer;
   int otherAnswer;
   int onlyOneBranch;
   if (check) {
      onlyOneBranch = 1;
      answer = 1;
   } else {
      answer = 2;
   }
   System.out.println(answer);
   System.out.println(onlyOneBranch); // DOES NOT COMPILE
}
```
#### Passing Constructor and Method Parameters
constructor parameters or method parameters are like local variables,  that have been initialized before the method is called, by the caller.
```java
public void findAnswer(boolean check) {}
public void checkAnswer() {
   boolean value;
   findAnswer(value);  // DOES NOT COMPILE
}
```
#### Instance and class variables
- Instance and class variables do not require you to initialize them. As soon as you declare these variables, they are given a default value  (e.g) char `'\u0000'(NUL)`

#### Introducing var
- `var` is used only in local variables
- var can change after it is declared but the type never does. (e.g) below
```java
var apples = (short)10;
apples = (byte)5; // compiles since byte automatically promoted to short
apples = 1_000_000;  // DOES NOT COMPILE

6:    var answer;
7:     if (check) {
8:        answer = 2;
9:     } else {
10:       answer = 3;
11:    }
//This code doesn't compile since  local variable type inference(var), the compiler looks only at the line with the declaration

4: public void twoTypes() {
5:    int a, var b = 3;  // DOES NOT COMPILE
6:    var n = null;      // DOES NOT COMPILE
7:  }
var a = 2, b = 3;  // DOES NOT COMPILE

13: var n = "myData";
14: n = null;
15: var m = 4;
16: m = null;  // DOES NOT COMPILE

17: var o = (String)null;
//Since the type is provided, the compiler can apply type inference and set the type of the var to be String.

public int addition(var a, var b) {  // DOES NOT COMPILE
   return a + b;
}
```
#### Review of var Rules
We complete this section by summarizing all of the various rules for using var in your code. Here’s a quick review of the var rules:

* A var is used as a local variable in a constructor, method, or initializer block.
* A var cannot be used in constructor parameters, method parameters, instance variables, or class variables.
* A var is always initialized on the same line (or statement) where it is declared.
* The value of a var can change, but the type cannot.
* A var cannot be initialized with a null value without a type.
* A var is not permitted in a multiple-variable declaration.
* A var is a reserved type name but not a reserved word, meaning it can be used as an identifier except as a class, interface, or enum name. meaning in the reference variable name.
- `var i = null;` //INVALID NULL values is not allowed since its type can't be inferred.
- `var j = 2.2; j = 1.2F;`// VALID j is inferred as double and later assigning float value to a wider type (dobule)
- `var k, i = 0;` //INVALID var cannot be used in compund statement
- `var a=2; var b; if (a%2==0) { b= true; } else { b= false; }` //INVALID var b is not intialized
- `var list = new ArrayList<>(); list.add(1);` //VALID <> is inferred as <Object>
- `var numberList = new ArrayList<Integer>();` numberList = new LinkedList<Integer>(); //INVALID a numberList is ArrayList forst then can't change its type to LinkedList
- `var i = 100; var s = "A"+i;` //VALID 
  
#### Reviewing Scope
- _Local_ variables: In scope from declaration to end of block
- _Instance_ variables: In scope from declaration until object eligible for garbage collection
- _Class_ variables: In scope from declaration until program ends


#### Understanding Garbage Collection

- Garbage collection refers to the process of automatically freeing memory on the heap by deleting objects that are no longer reachable in your program.
- It is the JVM’s responsibility to actually perform the garbage collection.
- Java built-in method to support garbage collection `System.gc();` . It merely suggests that the JVM kick off garbage collection. The JVM may perform garbage collection at that moment, or it might choose to do later.
#### Objects vs References 
- The reference is a variable that has a name and can be used to access the contents of an object.
- An object sits on the heap and does not have a name. Therefore, you have no way to access an object except through a reference. 
- An object cannot be assigned to another object, and an object cannot be passed to a method or returned from a method. It is the object that gets garbage collected, not its reference.

### FINALIZE()
- The garbage collector`(gc)` would call the finalize() method once. `_finalize() can run zero or one times. It cannot run twice_`.
