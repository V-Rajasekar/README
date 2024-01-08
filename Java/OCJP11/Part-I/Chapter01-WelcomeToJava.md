
## 1. Welcome to Java

### Major components of Java
- .java, .class files
- The `javac` program generates instructions in a special format that the `java` command can run called `bytecode`. Then java launches the _Java Virtual Machine (JVM)_ before running the code. The JVM knows how to run bytecode on the actual machine it is on
- In Java 11, the JRE is no longer available as a stand-alone download or a subdirectory of the JDK. People can use the full JDK when running a Java program.
### Identifying benefits of Java
- **Object Oriented** Java is an `object-oriented language`, which means all code is defined in classes, and most of those classes can be instantiated into objects. Java is not fully functional programming language, but allows functional programming with a class.
- **Encapsulation** Java supports access modifiers to protect data from unintended access and modification
- **Platform Independent** Java is an interpreted language that gets compiled to bytecode. A key benefit is that Java code gets compiled once rather than needing to be recompiled for different operating systems. “write once, run everywhere.”
- **Robust** One of the major advantages of Java over C++ is that it `prevents memory leaks`. `Java manages memory on its own` and does `garbage collection` automatically.
- **Secure** Java code runs inside the JVM. This creates a sandbox that makes it hard for Java code to do evil things to the computer it is running on
- **Multithreaded** Java is designed to allow multiple pieces of code to run at the same time.
- **Backward Compatibility** The Java language architects pay careful attention to making sure old programs will work with later versions of Java.

#### Understanding the Java Class Structure
- Class are the basic building blocks. Object is a runtime instance of a class in memory.

### Java Classes vs. Files
1. Java does not require that the class be public. If you do have a public class, it needs to match the filename.
```java
1: class Animal {
2:    String name;
3: }
------------
1: public class Animal {
2:    private String name;
3: }
4: class Animal2 {
5: }
```


- Checking your version of Java

```java
  javac -version
  java -version
```
- main() method
  The main() method’s parameter list, represented as an array of java.lang.String objects. In practice, you can write any of the following: you can use any variable name not necessarily args as the parameter name.

```java
String[] args
String args[]
String... args;

javac Zoo.java
java Zoo "San Diego" Zoo// While passing value to param, enclose with "" or spaced values
```

### Running a Program in One Line

`java SingleFileZoo.java Cleveland`
instead of 2 steps like `javac SingleFileZoo.java Cleveland` and then `java SingleFileZoo Cleveland`.

|Full command	          |Single-file source-code command|
|----|----|
|javac HelloWorld.java  |java HelloWorld||
|java HelloWorld.java   ||
|Produces a class file	Fully in memory|
|For any program |	For programs with one file|
|Can import code in any available Java library |	Can only import code that came with the JDK|

### Import libraries 
- Including so many classes slows down your program execution, but it doesn’t. The compiler figures out what’s actually needed.
- Some imports that don't works
```java
import java.nio.*;         // NO GOOD - a wildcard only matches
                          // class names, not "file.Files"

import java.nio.*.*;       // NO GOOD - you can only have one wildcard
                          // and it must be at the end

import java.nio.file.Paths.*; // NO GOOD - you cannot import methods
                            // only class names
```

### Using an Alternate Directory
By default, the **javac** command places the compiled classes in the same directory as the source code. It also provides an option to place the class files into a different directory. The -d option specifies this target directory

`javac -d classes packagea/ClassA.java packageb/ClassB.java`

All three available options to execute a java class

```java
  java -cp classes packageb.ClassB
  java -classpath classes packageb.ClassB
  java --class-path classes packageb.ClassB
```
### Compiling with JAR Files
-  This technique is useful when the class files are located elsewhere or in special JAR files.
`java -cp ".;C:\temp\someOtherLocation;c:\temp\myJar.jar" myPackage.MyClass`

### Creating a JAR File

```java
  jar -cvf myNewFile.jar . //Create a jar file in the current director
  jar --create --verbose --file myNewFile.jar . //same as above
  jar -cvf myNewFile.jar -C dir . // create jar in the requested dir path
```

### Review Questions
1. 2, 5
2. Which are included in the JDK? javac, JVM, javadoc, jar, java
3. 