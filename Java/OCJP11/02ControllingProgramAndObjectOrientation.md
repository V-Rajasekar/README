### Class block execution

If a class contains, constructor, instance initializer block and static initializer block and constructor is invoked, then the execution order is:

static initializer block, instance initializer block and then constructor.

### Inner Classes:

1. Inner class declaration

- Inner class be in a class, or method. Allowed modifiers are public, final and abstract
- Regular inner class cannot define anything static(block, method), except static final variables

class Outer {
    class Inner {
        // Static initializer blocks, and static method are not allowed within inner classes.
    }
}

1. Inner Class Reference:
class Outer {
    class Inner {
        // Inner class definition
    }
}

class Test {
    Outer.Inner innerObject = new Outer().new Inner();
    // Correct syntax for referencing inner class.
}

3. Variable Shadowing and Resolution:
class Outer {
    private int var = 10;
    private String name = "NOW OR NEVER";
    class Inner {
        private int var = 20;
        void printVar() {
            System.out.println(this.name); //Will throw compile error as there is no name in Inner
             System.out.println(name);
            System.out.println(var); // Prints inner class variable.
            System.out.println(Outer.this.var); // Prints outer class variable.
        }
    }
}

#### Method local inner class

1. Method-local inner classes cannot be defined using explicit access modifiers (public, protected and private) but non-access modifiers: final and abstract can be used with method-local inner class.

2. Method local inner class can access only final or effectively final local variables or parameter of the enclosing block.

class Inner is method local inner class and it is accessing parameter variable x.

Starting with JDK 8, a method local inner class can access local variables and parameters of the enclosing block that are final or effectively final.

```java
class Outer {
    public void print(int x) {
        class Inner { // only default, abstract and final allowed here
            public void getX() {
                System.out.println(++x); // compile error
            }
        }
        Inner inner = new Inner();
        inner.getX();
    }
}

class Outer {
    public static void sayHello() {}
    static {
        class Inner {
           {
            sout("Hello");
           }
           Inner() {
            sout("Hello");
           }
        }
        new Inner();
    }
}
Constructor and Instance block are allowed in static block local inner class

//

 obj.Log(); //prints LET IT BE
```

### Anonymous inner class

```java

class Logger {
    public void log() {
        System.out.println("GO FOR IT");
    }
}
 public static void main(String[] args) {
        Logger obj = new Logger() { //Logger, Object will not work, if var yes
            public void Log() {
                System.out.println("LET IT BE");
            }
        };
        obj.Log(); //Compilation error as there is no method Log() in Logger
    }

```

### For Loop

<p>
Basic/Regular for loop has following form:

for ( [ForInit] ; [Expression] ; [ForUpdate] ) {...}

[ForInit] can be local variable initialization or the following expressions:

Assignment

PreIncrementExpression

PreDecrementExpression

PostIncrementExpression

PostDecrementExpression

MethodInvocation

ClassInstanceCreationExpression



[ForUpdate] can be following expressions:

Assignment

PreIncrementExpression

PreDecrementExpression

PostIncrementExpression

PostDecrementExpression

MethodInvocation

ClassInstanceCreationExpression

The [Expression] must have type boolean or Boolean, or a compile-time error occurs. If [Expression] is left blank, it evaluates to true.

All the expressions can be left blank; **for(;;) is a valid for loop and it is an infinite loop** as [Expression] is blank and evaluates to true. The program results out of memory run time exception.

String.join(delimiter, character/stringSequence);
String.join(".", "A", "B", "C"); returns "A.B.C"

String.join("+", new String[]{"1", "2", "3"}); returns "1+2+3"

String.join("-", "HELLO"); returns "HELLO"
String.join(null, "HELLO"); returns "HELLO" // NPE
String.join("-", null); // compile time error ambiguous
String str = null;
String.join("-", str); returns "null";
</p>

```java
 int i = 0;
        String res = null;
        for(String [] s = {"A", "B", "C", "D"};;res = String.join(".", s)) { //Line n1
            if(i++ == 0)
                continue;
            else
                break;
        }
        System.out.println(res); //Line n2
```

### Logical break and continue:

```java
    var i = 1;
        var j = 5;
        var k = 0;
        A: while(true) {
            i++;
            B: while(true) {
                j--;
                C: while(true) {
                    k += i + j;
                    if(i == j)
                        break A;
                    else if (i > j)
                        continue A;
                    else 
                        continue B;
                }
            }
        }
        System.out.println(k);
```

### Garbage Collection:
1. Eligibility for Garbage Collection:
class Test {
    void method() {
        Object obj = new Object();
        // Object created here is eligible for garbage collection once method() exits.
    }
}

