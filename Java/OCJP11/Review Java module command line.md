# Reviewing Command-Line Options
 
### Compile Non modular code <br>
```java
    javac -cp classpath -d directory //classesToCompile

    javac --class-path classpath -d directory //classesToCompile

    javac -classpath classpath -d directory //classesToCompile
```

### Run Non Modular code	
```java
        java -cp classpath package.className

        java -classpath classpath package.className

        java --class-path classpath package.className
```

### Compile a module <br>	
`javac -p moduleFolderName -d directory classesToCompileIncludingModuleInfo`

`javac --module-path moduleFolderName -d directory classesToCompileIncludingModuleInfo`

(e.g) `javac -p mods   -d feeding  feeding/zoo/animal/feeding/*.java feeding/module-info.java` <br>

**_Note:_**  -d specifies the dir to place the class files in. --module-path specifies indicates the location of any custom module files. can be omitted when there is no dependencies. module-path is like classpath --module-path is equivalent to -p.
### Run a module <br>	
`java -p moduleFolderName -m moduleName/package.className`

`java --module-path moduleFolderName --module moduleName/package.className`

(e.g) `java -p feeding -m zoo.animal.feeding/zoo.animal.feeding.Task`

**_Note:_** In these examples, we used feeding as the module path because that’s where we compiled the code

### Packaging and executing from jar

Packaging: `jar -cvf mods/zoo.animal.feeding.jar -C feeding/ .` <br>

Executing: `java -p mods -m zoo.animal.feeding/zoo.animal.feeding.Task`

_**Note:**_ We are packaging everything under the feeding directory and storing it in a JAR file named zoo.animal.feeding.jar under the mods folder. while executing java -p mods is used where mods contains the jar file.

### Describe a module	<br>
`java -p moduleFolderName -d moduleName`

`java --module-path moduleFolderName --describe-module moduleName`

`jar --file jarName --describe-module`

`jar -f jarName -d`

### List available modules <br>	
`java --module-path moduleFolderName --list-modules`

`java -p moduleFolderName --list-modules`

`java --list-modules`

### View dependencies	<br>
    
`jdeps -summary --module-path moduleFolderName jarName`

`jdeps -s --module-path moduleFolderName jarName`

### Show module resolution <br>	
`java --show-module-resolution -p moduleFolderName -m moduleName`

`java --show-module-resolution --module-path moduleFolderName --module moduleName`

### javac Options <br>
Location of JARs in a nonmodular program
  * -cp <classpath>
  * -classpath <classpath>
  * --class-path <classpath>
  * -d <dir> Directory to place generated class files
  * -p <path> Location of JARs in a modular program 
  * --module-path <path>

### java Options <br>
 * Location of JARs in a modular program:
   * -p <path>
   * --module-path <path>
 
 * Module name to run:
   * -m <name>
   * --module <name>
 
 * Describes the details of a module <br>
   * -d
   * --describe-module
    
   * --list-modules	Lists observable modules without running a program
   * --show-module-resolution	Shows modules when running program

### jar options <br>
 * -c,--create: Create a new JAR file
 * -v, --verbose: Prints details when working with JAR files
 * -f, --file: JAR filename
 * -C	Directory containing files to be used to create the JAR
 * -d, --describe-module: Describes the details of a module.

### jdeps options <br>
  * --module-path <path>:	Location of JARs in a modular program
  * -s,-summary: Summarized output