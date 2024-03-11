# Chapter 4 Making Decisions
- [Chapter 4 Making Decisions](#chapter-4-making-decisions)
    - [Switch statement](#switch-statement)
      - [Acceptable Case Values:](#acceptable-case-values)
  - [If loop](#if-loop)
  - [For loop](#for-loop)
  - [The for-each Loop](#the-for-each-loop)
    - [Nested for Loop(2 dimensional array iteration)](#nested-for-loop2-dimensional-array-iteration)
  - [Adding Optional Labels](#adding-optional-labels)
    - [Break from Loops](#break-from-loops)
    - [The continue Statement.](#the-continue-statement)
  - [Review Questions](#review-questions)

### Switch statement
- Switch allowed data types `int, byte, short, char`,and their corresponsing wrapper classes, `String`, `enum` and `var`
- Leaving out the break statement, flow will continue to the next processing `case` or `default` block automatically.
- Incase of String expression, the comparision is case sensitive.
```java
switch(variableToTest) {
    case consExpression1: // May contain 0 or more case branches.
     break; // Optional break
    case consExpression2:
      break;
     case consExpression3, consExpression4 :
      break;  
     case consEXpression5: case consExpression6: 
    default: //Optional Default that may appear anywhere with Switch
      <statment>;   
}
```
- Order of default and case statement
 * the code will jump to the default block and then execute all of the proceeding case statements in order until it finds a break statement or finishes the switch statement
```java
var dayOfWeek = 5;
switch(dayOfWeek) {
   case 0:
      System.out.println("Sunday");
   default:
      System.out.println("Weekday");
   case 6:
      System.out.println("Saturday");
   break;
}
prints: 
 Weekday
 Saturday
```
- what if `var dayOfWeek = 6;` ? then the output is `Saturday`
- what if `var dayOfWeek = 0;` ? then all three statements is executed
  

#### Acceptable Case Values:
- The values in each case statement must be` compile-time constant values` of the same data type as the switch value. This means you can use only literals, `enum constants`, or `final constant variables` of the same data type.
- you can’t have a case statement value that requires executing a method at runtime, even if that method always returns the same value
 ```java
  final int getCookies() { return 4; }
void feedAnimals(final int fruits) {
   final String mangoe = "Mangoes";
   final int bananas = 1;
   int apples = 2;
   int numberOfAnimals = 3;
   final int cookies = getCookies();
   switch (numberOfAnimals) {
      case bananas:
      case apples:  // DOES NOT COMPILES, since apples is not final
      case getCookies():  // DOES NOT COMPILE
      case cookies :  // DOES NOT COMPILE
      case fruits : //DOES NOT COMPILE despite fruits being final, as it is not constant as it is passed to the function.
      case 3 * 5 :
      case mangoe: 
   }
}
 ```
 - Numeric Promotion and Casting
  
```java
short size = 4;
final int small = 15;
final int big = 1_000_000;
switch(size) {
   case small:
   case 1+2 :
   case big:  // DOES NOT COMPILE Too big to fit in short without casting
}
```
## If loop
- if statement with curl braces around the body is (optional), but good to have it.
 ```java
   int w = 2;
   boolean flag = false;
   if (true)
      w++;
      flag = true;
   System.out.println("w"+ 2);  
   System.out.println("flag:" + flag);
 ```

   
## For loop

```java
for(int i = 0; i < 5; i++) {
   System.out.print(i + " ");
}
//Prints 0 1 2 3 4 //here of the increment is ++i its the same output

int i,j;
for ( i = j = 0; ; ++i, j--) {
    if (i - j > 10) {
        break;
    }
}
  System.out.println(i + " " + j);
//Prints 6-6
//Printing elements in reverse
  for (var counter = 4; counter >= 0; counter--) {
   System.out.print(counter + " ");
}
//Prints 43210
```
- Working with for loops 

```java
1. Creating an Infinite Loop
for( ; ; )
   System.out.println("Hello World");

2. Adding Multiple Terms to the for Statement
int x = 0;
for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
   System.out.print(y + " "); }
System.out.print(x + " ");

3. Redeclaring a Variable in the Initialization Block

int x = 0;
for(int x = 4; x < 5; x++) {   // DOES NOT COMPILE
   System.out.print(x + " ");
}
//Below compiles
int x = 0;
for(x = 0; x < 5; x++) {
   System.out.print(x + " ");
}

4. Using Incompatible Data Types in the Initialization Block

int x = 0;
for(long y = 0, int z = 4; x < 5; x++) {  // DOES NOT COMPILE
   System.out.print(y + " ");
}
5. Using Loop Variables Outside the Loop

for(long y = 0, x = 4; x < 5 && y < 10; x++, y++) {
   System.out.print(y + " ");
}
System.out.print(x);  // DOES NOT COMPILE
```
## The for-each Loop
```java
List<String> values = new ArrayList<String>();
values.add("Lisa");
values.add("Kevin");
values.add("Roger");
 
for (var value : values) {
   System.out.print(value + ", ");
}
//Lisa, Kevin, Roger, 

//Using Iterable on List<Integer>
Integer[] numsArr = new Integer[]{1, 2, 3, 4, 5};
List<Integer> nums = List.of(numsArr);
for (Iterator<Integer> iter = nums.iterator(); iter.hasNext();) {
       System.out.print(iter.next() + ",");
}

```
### Nested for Loop(2 dimensional array iteration)

```java
String [][] fancyColors = new String[][] {{"black", "blue", "viloet"},
                                        {"red", "peace", "orange"}};

String [][] fancyColors = new String[][] {{"black", "blue", "viloet"},
                                        {"red", "peace", "orange"}};
for (int row = 0; row < 2; row++) {
   for (int column = 0; column < 3; column++) {
      System.out.print(" " + fancyColors[row][column] + "\t");
   } 
   System.out.println();	
}

int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
 
for(int[] mySimpleArray : myComplexArray) {
   for(int i=0; i<mySimpleArray.length; i++) {
      System.out.print(mySimpleArray[i]+"\t");
   }
   System.out.println();
}
//outputs following result.
5       2       1       3
3       9       8       9
5       7       12      7
```
## Adding Optional Labels
- A label is an optional pointer to the head of a statement that allows the application flow to jump to it or break from it. It is a single identifier that is proceeded by a colon (:)

```java
//Below Labels added for readability purpose
int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
 
OUTER_LOOP:  for(int[] mySimpleArray : myComplexArray) {
   INNER_LOOP:  for(int i=0; i<mySimpleArray.length; i++) {
      System.out.print(mySimpleArray[i]+"\t");
   }
   System.out.println();
}
```
### Break from Loops

```java

  for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= 5; j++) {
         if (i == 3 && j == 3) {
            break; // breaks only from the nearest loop not from the entire nested loop(outerloop)
         }
         System.out.print("*");
      }
      System.out.println();
   }
   /*
      *****
      *****
      **
      *****
      *****
   */

  OL: for (int i = 1; i <= 5; i++) {
      IL: for (int j = 1; j <= 5; j++) {
         if (i == 3 && j == 3) {
            break OL;
         }
         System.out.print("*");
      }
      System.out.println();
   }

//Find the (x, y) value and break out of the entire lookp when the searched element found in a 2 dimenational array.
public class FindInMatrix {
   public static void main(String[] args) {
      int[][] list = {{1,13},{5,2},{2,2}};
      int searchValue = 2;
      int positionX = -1;
      int positionY = -1;
 
      PARENT_LOOP: for(int i=0; i<list.length; i++) {
         for(int j=0; j<list[i].length; j++) {
            if(list[i][j]==searchValue) {
               positionX = i;
               positionY = j;
               break PARENT_LOOP;
            }
         }
      }
      if(positionX==-1 || positionY==-1) {
         System.out.println("Value "+searchValue+" not found");
      } else {
         System.out.println("Value "+searchValue+" found at: " +
            "("+positionX+","+positionY+")");
      }
   }
}
//Value 2 found at: (1, 1)
```
### The continue Statement.
- Advanced loop control with the continue statement, a statement that causes flow to finish the execution of the current loop
  
```java
1: public class CleaningSchedule {
2:    public static void main(String[] args) {
3:       CLEANING: for(char stables = 'a'; stables<='d'; stables++) {
4:          for(int leopard = 1; leopard<4; leopard++) {
5:             if(stables=='b' || leopard==2) {
6:                continue CLEANING;
7:             }
8:             System.out.println("Cleaning: "+stables+","+leopard);
9: } } } }

Cleaning: a,1
Cleaning: c,1
Cleaning: d,1
Removing Line 6: prints for a..c and 1..3
```
* Unreachable Code :  `break, continue, and return` that you should be aware of is that any code placed immediately after them in the same block is considered unreachable and will not compile 
* Switch doesn't allow continue statement only `break` and optional `labels` are allowed all other branching statements while, do while, for allows labels, break, and continue 

## Review Questions
1. `switch` statements allow which data types ? byte, short, int, char and their corresponding wrapper class. Also String, enum and var.
2. 4 
3. 3 (10, 10, 14)
4. 1, 5, 6
5. 2, 4, 5
6. Which statements, when inserted independently into the following blank, will cause the code to print 2 at runtime? (Choose all that apply.) break, continue on BUNNY, RABBIT Ans: Code compiler error.
     int count = 0;
  BUNNY: for(int row = 1; row <=3; row++)
     RABBIT: for(int col = 0; col <3 ; col++) {
        if((col + row) % 2 == 0)
          ____________________;
        count++;
     }
  System.out.println(count);
7. How many line of code contais errors ? Ans: 2
   ```java
    private DayOfWeek getWeekDay(int day, final int thursday) {
     int otherDay = day;
     int Sunday = 0;
     switch(otherDay) { 
        default:
        case 1: continue; // continue not allowed
        case thursday: return DayOfWeek.THURSDAY;
        case 2: break;
        case Sunday: return DayOfWeek.SUNDAY; 
        case DayOfWeek.MONDAY: return DayOfWeek.MONDAY; //type mismatch enum in place of int
     }
     return DayOfWeek.FRIDAY;
  }
   ```
  8. what is the result of the following code snippet ? Ans 11
   ```java
   3: int sing = 8, squawk = 2, notes = 0;
   4: while(sing > squawk) { 3
   5:    sing--;
   6:    squawk += 2;
   7:    notes += sing + squawk;
   8: }
   9: System.out.println(notes);

      //  int sing = 8, squawk = 2, notes = 0;
      //  sing | squawk | notes

      //  7        4       11
      //  6        6       23
      //  5        8       36
      //  4        10      50
      //  3        12      65
   ```
 9. what is the output of the result ? 11
   
```java
   int result = 15, meters = 10;
   boolean keepGoing = true;

   do {
      meters--;
      System.out.println("meters:"+ meters); //9,8
      if (meters == 8)
            keepGoing = false;
      result -= 2;
   } while (keepGoing);
   System.out.println(result);
```


 10.  what is the data type of the var variables in the below snippet code ?
```java
for(var penguin : new int[2])
System.out.println(penguin); // int

var ostrich = new Character[3];
for(var emu : ostrich)
System.out.println(emu); // Character

List parrots = new ArrayList();
for(var macaw  : parrots)
System.out.println(macaw); // Object
```
11. What is the output of this programming ?
    - Compile error in case 'B': 'C' line replacing to case: 'B', 'C': will return great good
```java
     final char a = 'A', e = 'E';
  char grade = 'B';
  switch (grade) {
     default:
     case a:
     case 'B': 'C': System.out.print("great ");
     case 'D': System.out.print("good "); break;
     case e:
     case 'F': System.out.print("not good ");
  }
```
12. Ways of printing the following in reverse order
    char[] wolf = {'W', 'e', 'b', 'b', 'y'};
    int q = wolf.length;
    ```java
      for( ; ; ) {
         System.out.print(wolf[--q]);
         if(q==0) break;
      }

         for(int m=wolf.length-1; m>=0; --m)
      System.out.print(wolf[m]);

      int x = wolf.length-1; 
      for(int j=0; x>=0 && j==0; x--)
      System.out.print(wolf[x]);

    final int r = wolf.length;
  for(int w = r-1; r>-1; w = r-1)
     System.out.print(wolf[w]); //prints y infinite since the w=r-1 is never incremented r initiallized outside the loop.
    ```
13. What distinct numbers are printed when the following method is executed? (Choose all that apply.)
```java
 private void countAttendees() {
     int participants = 4, animals = 2, performers = -1;
   
     while((participants = participants+1) < 10) {}
     do {} while (animals++ <= 1);
     for( ; performers<2; performers+=2) {}
   
     System.out.println(participants); // 10
     System.out.println(animals); // 3
     System.out.println(performers);//3
  }
```
14. What is the output of the following code snippet?
//Compile error at while (snake <=5>) snake unidentifed reference since snake scope inside do. If outside of the do loop then 1 2 3 4 5 -5.0
```java
 double iguana = 0;

 do {
     int snake = 1;
    System.out.print(snake++ + " ");
    iguana--;
 } while (snake <= 5);
 System.out.println(iguana);
 15. Which statements, when inserted into the following blanks, allow the code to compile and run without entering an infinite loop? (Choose all that apply.)      Ans: 1
```java
  4:  int height = 1;
  5:  L1: while(height++ <10) {
  6:     long humidity = 12;
  7:     L2: do {
  8:        if(humidity-- % 12 == 0) ________________;
  9:        int temperature = 30;
  10:       L3: for( ; ; ) {
  11:          temperature++;
  12:          if(temperature>50) _________________;
  13:       }
  14:    } while (humidity > 4);
  15: }
```   
1. break L2 on line 8; continue L2 on line 12
2. continue on line 8; continue on line 12
3. break L3 on line 8; break L1 on line 12
4. continue L2 on line 8; continue L3 on line 12
5. continue L2 on line 8; continue L2 on line 12
6. None of the above, as the code contains a compiler error.

16. what is the output of the following code ? Ans 3
 ```java
  var tailFeathers = 3;
    final var one = 1;
  switch (tailFeathers) {
     default: case 2: System.out.print(5 + " ");
     case one: System.out.print(3 + " ");
     case 3: case 4:  System.out.print(3 + " ");
    
  }
  ---
  //output 5 3
   switch (tailFeathers) {
     default: case 2: System.out.print(5 + " ");
     case one: System.out.print(3 + " ");
     case 3: case 4:  System.out.print(3 + " ");
    
  }
 ```

  