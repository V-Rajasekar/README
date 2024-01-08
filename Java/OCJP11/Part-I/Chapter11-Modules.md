# Chapter 11 Modules

 - A Java Platform Module System was (JPMS) was introduced in Java 9
 - It includes the following
    * A format for module JAR files
    * Partitioning of the JDK into modules
    * Additional command-line options for Java tools
 - What it solved ? 
   - Modules solve this problem by acting as a fifth level of access control. They can expose packages within the modular JAR to specific other packages. This stronger form of encapsulation really does create internal packages. 
 - Creating and Running a Modular Program
   1.  Simple java class
    ```java
    package zoo.animal.feeding;
    
    public class Task {
      public static void main(String... args) {
          System.out.println("All fed!");
      }
    }
    ```
   2. Create a module-info.java
    ```java
      module zoo.animal.feeding {
      }
    ```
* The module-info file must be in the root directory of your module. Regular Java classes should be in packages.
* The module-info file must use the keyword module instead of class, interface, or enum.
* The module name follows the naming rules for package names. It often includes periods (.) in its name. Regular class and package names are not allowed to have dashes (-). Module names follow the same rule.

### Compiling Our First Module

```shell
javac --module-path mods
   -d feeding
   feeding/zoo/animal/feeding/*.java
   feeding/module-info.java

-- other valid ways
javac -p mods
   -d feeding
   feeding/zoo/animal/feeding/*.java
   feeding/*.java
 
javac -p mods
   -d feeding
   feeding/zoo/animal/feeding/*.java
   feeding/module-info.java
 
javac -p mods
   -d feeding
   feeding/zoo/animal/feeding/Task.java
   feeding/module-info.java
 
javac -p mods
   -d feeding
   feeding/zoo/animal/feeding/Task.java
   feeding/*.java
```
 -d specifies the dir to place the class files in. 
 --module-path specifies indicates the location of any custom module files. can be omitted when there is no dependencies. module-path is like classpath
 --module-path is equivalent to -p.

### Running Out First Module
  
  ```bash
        location of module          ModuleName  Package name Ocp is Class name
  java --module-path out --module com.jenkov.mymodule/com.jenkov.mymodule.Main
  ```
  The --module-path argument points to the root directory where all the compiled modules are located.The --module argument tells what module + main class to run. INotice how the module name and main class name are separated by a slash (/) character.

- For the above example.
  
  `java --module-path feeding   --module zoo.animal.feeding/zoo.animal.feeding.Task`

  --shorter version
  `java -p feeding -m zoo.animal.feeding/zoo.animal.feeding.Task `
 

  In these examples,   `feeding` is the output directory where the compiled class file and module-info.class is present. This will change once we package the module and run that.

### Packaging Our First Module

`jar -cvf mods/zoo.animal.feeding.jar -C feeding/ .`
- _Note:_ We are packaging everything under the feeding directory and storing it in a JAR file named zoo.animal.feeding.jar under the mods folder.     

- After packing lets run the java from the jar

`java -p mods -m zoo.animal.feeding/zoo.animal.feeding.Task`

- Updating our examples for Multiple Modules
 - Exporting zoo.animal.feeding as this will be required in other modules
  
  ```java
      module zoo.animal.feeding {
      exports zoo.animal.feeding;
    }
  ```
  - Recompiling and packaging 

```console

  javac -p mods 
   -d feeding
   feeding/zoo/animal/feeding/*.java
   feeding/module-info.java
 
jar -cvf mods/zoo.animal.feeding.jar -C feeding/ .
```

- Creating a `Care` Module
  The module contains two basic packages and classes in addition to the module-info.java file: </br>
  ```java

    // HippoBirthday.java
  package zoo.animal.care.details;
  import zoo.animal.feeding.*;
  public class HippoBirthday {
    private Task task;
  }
  
  // Diet.java
  package zoo.animal.care.medical;
  public class Diet { }
  ```
  - Next the module-info.java files 
    ```java
    1: module zoo.animal.care {
    2:    exports zoo.animal.care.medical;
    3:    requires zoo.animal.feeding;
    4: }
    ```

  * Compile and package the module: 
    - _**Note**_ ORDER MATTERS! if module-info.java is specified first compiler complains no package found with the name zoo.animal.care.*
    ```js
    javac -p mods -d care
   care/zoo/animal/care/details/*.java
   care/zoo/animal/care/medical/*.java
   care/module-info.java
    ```

    Packing: `jar -cvf mods/zoo.animal.care.jar -C care/ .`
    
- _module-info_ file
  * Keywords used in the module-info files are: exports, requires, provides, uses, and opens.

- Transitive dependency version of modules.
  Here with the help of _requires transitive_ you can get ride of the dashed lines, by declaring transtive dependencies in care, talks
![Alt text](transtive-dependency-module.png)

```java
module zoo.animal.care {
   exports zoo.animal.care.medical;
   requires transitive zoo.animal.feeding;
}

module zoo.animal.talks {
   exports zoo.animal.talks.content to zoo.staff;
   exports zoo.animal.talks.media;
   exports zoo.animal.talks.schedule;

   // no longer needed requires zoo.animal.feeding;
   // no longer needed requires zoo.animal.care;
   requires transitive zoo.animal.care;
}

module zoo.staff {
   // no longer needed requires zoo.animal.feeding;
   // no longer needed requires zoo.animal.care;
   requires zoo.animal.talks;
}
```

- _**Duplicate requires Statements**_
* Java doesn't allow you to repat the same module in a requires clause.
```java
module bad.module {
   requires zoo.animal.talks;
   requires transitive zoo.animal.talks;
}
```
- **provides, uses, and opens**
 <p> The provides keyword specifies that a class provides an implementation of a service. </p>

  `provides zoo.staff.ZooApi with zoo.staff.ZooImpl`<br>

 <p> The uses keyword specifies that a module is relying on a service. To code it, you supply the API you want to call:</p>

  `uses zoo.staff.ZooApi`

<p>The `uses` keyword specifies that a module is relying on a service. To code it, you supply the API you want to call:

Java allows callers to inspect and call code at runtime with a technique called reflection. This is a powerful approach that allows calling code that might not be available at compile time. 

Since reflection can be dangerous, the module system requires developers to explicitly allow reflection in the module-info if they want calling modules to be allowed to use it. Here are two examples:
</p>

```java
opens zoo.animal.talks.schedule; // Allows any module using this one to use reflection.
opens zoo.animal.talks.media to zoo.staff; //Gives privilege to the zoo.staff package.
```
- Discovering Modules
  * **The java Command**
    The java command has three module-related options. 1) One describes a module, 2) another lists the available modules, and 3) the third shows the module resolution logic.<br>

  * Describing a Module
  Each prints information about the module.<br>

  option-1:  `java -p mods -d zoo.animal.feeding`  <br>

  option-2:  `java -p mods --describe-module zoo.animal.feeding` <br>

  It might print something like these 
  
```java
  zoo.animal.feeding file:///absolutePath/mods/zoo.animal.feeding.jar
  exports zoo.animal.feeding
  requires java.base mandated
```  
- _Note:_ The java.base module is special. It is automatically added as a dependency to all modules. This module has frequently used packages like java.util. That’s what the mandated is about.

- More about describing modules

- The contents of module-info in zoo.animal.care  
 ```java
  module zoo.animal.care {
   exports zoo.animal.care.medical to zoo.staff;
   requires transitive zoo.animal.feeding;
}
//output
java -p mods -d zoo.animal.care
 
1. zoo.animal.care file:///absolutePath/mods/zoo.animal.care.jar
2. requires zoo.animal.feeding transitive
3. requires java.base mandated
4. qualified exports zoo.animal.care.medical to zoo.staff
contains zoo.animal.care.details

1. absolute path of the module file.
2, 3: requires lines as care is dependened on feeding module as its declared transitive, any module requires care, by default they inherit the feeding
4. The contains means that there is a package in the module that is not exported at all.
 ```
- **Listing Available**
  * `java -p mods --list-modules` list the build-in modules plus + four in our zoo system.
- **Showing Module Resolution**

```java
  java --show-module-resolution
   -p feeding
   -m zoo.animal.feeding/zoo.animal.feeding.Task
```
- The jar Command
  Like java command jar command can describe a module.

```java
  jar -f mods/zoo.animal.feeding.jar -d
  jar --file mods/zoo.animal.feeding.jar --describe-module
```
### The jdeps Command
  <p>The jdeps gives information about dependencies within a module. Unlike describing a module, it looks at the code in addition to the module-info file. This tells you what dependencies are actually used rather than simply declared.</p>

```java
jdeps -s mods/zoo.animal.feeding.jar
 
jdeps -summary mods/zoo.animal.feeding.jar
//Both outputs zoo.animal.feeding -> java.base
jdeps --jdk-internals  mods/zoo.animal.feeding.jar
```
- Note: Without -s/-summary you get the detailed dependencies
- --jdk-internals option lists any classes your using that call an internal API along with which API.
[Jdeps](https://docs.oracle.com/en/java/javase/11/tools/jdeps.html#GUID-A543FEBE-908A-49BF-996C-39499367ADB4)
- **The jmod Command**
   JMOD files are recommended only when you have native libraries or something that can’t go inside a JAR file. This is unlikely to affect you in the real world.<br>

