# 09 Java IO API

## Java I/O API: Read and write file data
- Console instance is got by` System.console();`
- Methods:
  - `char [] readPassword() {...}`
  - `char [] readPassword(String fmtString, Object... args) {...}`
  - format(), printf(),
  - writer():PrintWriter class associated with this console, which has a printf(String format, Object ... args) method
  - reader():Reader object associated with this console.which has read() method reads the single character (as an int value)
  -
```java
import java.io.*;

  System.setOut(new PrintStream("C:\\err.log"));
  System.out.println("ONE"); //writes ONE

    var console = System.console();
    if(console != null) {
        console.format("%d %<x", 10);
    }
    //prints 10 a (%d -decimal,  %<x is Hexa Decimal) console.printf is same as format.

 System.out.format("A%nB%nC");// prints ABC in separate line
   System.out.printf("%2$d + %1$d", 10, 20, 30); // prints 20 + 10


  var console = System.console();
        var name = console.readLine("What's your name? "); // console can be null if OS doesn't have a console
        System.out.printf("You entered: %s", name);
```

### console read and write pgm

```java

import java.io.IOException;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) throws IOException {
        var console = System.console();
         //console.writer returns a Writer Object associated with the console its return instance is a Console
        console.writer().printf("Enter a number between 1 and 7: "); //Line n1
        //console.reader returns a Reader Object associated with the console its return instance is a Console
         var num = Integer.parseInt("" + (char)console.reader().read()); //Line n2
        var flag = IntStream.rangeClosed(1, 7).anyMatch(i -> i == num);
        if(flag)
            console.printf("*".repeat(num)); //Line n3
        else
            console.writer().format("INVALID"); //Line n4
    }
}
// FYI, if user input is 11 and you want to read it as 11, then replace Line n2 with:
  var num = Integer.parseInt(console.readLine());
```

## Java I/O API Read and write file data

- createNewFile() is for creating new file but not directory.
- createNewDirectory() and createNewDirectories() are not available in java.io.File class. instead its
  * `mkdir()` creating just 1 directory provided the abstract path is present 'F:\A\B\C', for mkdir() to create directory, 'F:\A\B\' path must exist.
  * `mkdirs()` creates all the directories (if not available), specified in the given abstract path and returns true.
- System.getProperty("file.separator")  OR File.separator.Gives \ on windows
- System.getProperty("path.separator")  OR File.separator
- File class has below 2 methods:
  * public File getParentFile() {...}
  * public String getParent() {...}

```java
 //mkdir, mkdirsm delete usage
  var dirs = new File("F:\\A\\B\\C");
  System.out.println(dirs.mkdirs()); // true
  var dir = new File("F:\\A");
  System.out.println(dir.mkdir()); // false as A is already present
  System.out.println(dir.delete()); // false a A has child elements.

  var dirs = new File("F:\\A\\B");
  File parentFile = dirs.getParentFile(); ///Its F:\A
  String parent = parentFile.getParent(); // Prints F:\
```

### File methods sample pgm

- Program to delete all PDF file from a directory and its sub directory.

```java
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        deleteFiles(new File("F:\\Test"), ".pdf");
    }

    public static void deleteFiles(File dir, String extension) throws IOException {
        var list = dir.listFiles();
        if (list != null && list.length > 0) {
            for (var file : list) {
                if (file.isDirectory()) {
                    deleteFiles(file, extension);
                } else if (file.getName().endsWith(extension)) {
                    file.delete();
                }
            }
        }
    }
}
```
### I/O streams types and their samples

```java
import java.io.*;

//DataOutputStream and DataInputStream
var file = new File("F:\\temp.dat");
 var os = new DataOutputStream(new FileOutputStream(file));
var is = new DataInputStream((new FileInputStream(file)))

os.writeChars("JAVA");
is.readChar(); //returns a single char

//BufferedWriter and FileWriter
 try(var writer = new BufferedWriter(new FileWriter("F:\\test.txt"))) {
    writer.newLine();
 } finally {
  writer.close(); // cause runtime exception as writer is already closed.
 }

//BufferReader
   try(var br = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.print("Enter any number between 1 and 10: ");
            var num = br.read();// reads single char
            // var s = br.readLine();// to read user input
   }

// How many physical file created
  var file = new File("F:\\f1.txt"); // No physical file created, just creates Java obj
  var fileWriter = new FileWriter("F:\\f2.txt"); // creates physical file
  var fileWriter = new FileWriter("F:\\dir\\f2.txt"); // Throws IOException as 'dir' is a folder, which doesn't exist. This constructor can't create folders/directories.
  var printWriter = new PrintWriter("F:\\f3.txt");// creates physical file

 //PrintWriter
  try(var pw = new PrintWriter("F:\\test.txt"))
        {
            pw.close();
            pw.write(1); // no issue  nothing printed after execution
        } catch(IOException e) {
            System.out.println("IOException");
        }
```

### Resource leakage

- To avoid resource leak, either use try-with-resources statement or provide try-finally block.
- If statements before `bos.close();` throw any exception, then `bos.close();` will not execute and this will result in resource leak.

```java
//no try finally or try with resource can cause resource leakage.
   var bos = new BufferedOutputStream(
            new FileOutputStream("F:\\file.tmp"));
        bos.write(2);
        bos.close();
```

### Copy content exactly
- Case 1: orig.png is less than 500K byte then remaining byte is 0
- Case 2: origin.png > 500k, say 700k then 1st invocation 500k written 2nd invocation 200K replace the first 200k and leaving 300k, basically data corrupted.
```java
  try (var fis = new FileInputStream("F:\\orig.png");
             var fos = new FileOutputStream("F:\\copy.png")) {
            int res;
            var arr = new byte[500000]; //Line 10
            while((res = fis.read(arr)) != -1){ //Line 11
                fos.write(arr); //Line 12
            }
  } finally {}
//solution
        //void write​(byte[] b, int off, int len)        Writes len bytes from the specified byte array starting at offset off to this file output stream.
 fos.write(arr, 0, res);
```

## Java I/O:Serialization

- java.io.Serializable is a marker interface and hence classes which implement this interface are not required to implement any methods for serialization to work.
- Only 4 methods are used to serialize/de-serialize objects: Object readObject(ObjectInputStream ois), void writeObject(ObjectOutputStream oos), Object writeReplace() & Object readResolve().
- To write and read object a class must implement either Serializable or Externalizable, other wise throws runtime Exception.
- State of transient and static fields are not persisted.
- While de-serializing, transient fields are initialized to default values (null for reference type and respective Zeros for primitive types) and static fields refer to current value. (e.g) If a static counter is increment after writing to the object, while reading the object counter = 0, and then the subsequent increment are added and curr value is presented.
- When deserializing the object of the class must implement serializable and all his parent class must either implement serializable or default constructor, other wise Runtime exception is thrown.

```java
class Person {
    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Student extends Person implements Serializable {
    private String course;

    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var stud = new Student("Aafia", 24, "Chemistry");
        try (var oos = new ObjectOutputStream(new FileOutputStream(("F:\\stud.ser")));
             var ois = new ObjectInputStream(new FileInputStream("F:\\stud.ser")))
        {
            oos.writeObject(stud);

            var s = (Student) ois.readObject();
            System.out.printf("%s, %d, %s", s.getName(), s.getAge(), s.getCourse()); //prints null, 0, Chemistry
        }
    }
}
```
- Note: Person class has no-argument constructor. So while de-serialization, name and age are initialized to their default values: null and 0 respectively. course refers to "Chemistry" as it belongs to Serializable class, Student.

### ObjectOutputStream and ObjectInputStream

- **ObjectStreamField[] must be declared with private static final, other RuntimeException is thrown.**
-

```java
import java.io.*;

class Product implements Serializable {
    int i = 100;
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("name", String.class),
        new ObjectStreamField("geners", String[].class)
    };

    private void writeObject(ObjectOutputStream s) throws IOException {
        ObjectOutputStream.PutField fields = s.putFields();
        fields.put("name", "BOOK");
        fields.put("geners", new String [] {"Fiction", "Mystery", "Thriller"});

        s.writeFields();
    }

    private void readObject(ObjectInputStream s)
                    throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s.readFields();
        System.out.println(fields.get("name", "NOVELS"));
        System.out.println(((String[])fields.get("geners", new String[]{"F", "M", "T"}))[1]);
    }
}

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var product = new Product();
        try (var oos = new ObjectOutputStream(new FileOutputStream(("J:\\product.ser")));
             var ois = new ObjectInputStream(new FileInputStream("J:\\product.ser")))
        {
            oos.writeObject(product);

            var s = (Product)ois.readObject();
            System.out.println(s.i);
        }
    }
}
//prints BOOK MYSTERY 0
```
### Writing Option (runtime exception)

```java
  var optional = Optional.of(List.of("O", "N"));
        try (var oos = new ObjectOutputStream(new FileOutputStream(("F:\\data.ser")))) {
                   oos.writeObject(optional);// Runtime exception as optional doesn't impl Serializable
        }
```

### Primitive and wrapper class implementing Serializable.

```java
class Store implements Serializable {
    int i;
    Double d;
    String s;
    StringBuilder sb;
    Object object = new Object() {
      public String toString() {
          return "OBJECT";
      }
    };
    List<String> colors = new ArrayList<>(List.of("R", "G", "B"));
```
<p>
Number (super class of Double) implements Serializable.

String, StringBuilder and ArrayList also implement Serializable but Object class doesn't implement Serializable.

Instance variable object refers to an instance of un-named sub class of Object class, which means to an instance of anonymous inner class, which is not Serializable.  Any non implementing Serializable classes when trying to do deserializable cause RuntimeException.
</p>

## java.nio.file API:Path & Paths

### Path & Paths

- toRealPath() returns the path of an existing file. It returns the path after normalizing. Can throw IOException (checked) exception.
- toAbsolutePath() method doesn't care if given path elements are physically available or not. It just returns the absolute path.
- Paths.get("Book.java"); represents a relative path. This means relative to current directory. Suppose the current directory is "C:\classes" then calling `var file = Paths.get("Book.java")`, file.toAbsolutePath()-> c:\classes\Book.java
- path.subpath(int beginIndex, int endIndex) throws IllegalArgumentException if 'beginIndex >= No. of path elements', 'endIndex > No. of path elements' and 'endIndex <= beginIndex'.
- Path.normalize() It removes all the redundant name elements, and the method doesn't make any changes to the Path object referred by reference variable 'path'.
- toPath() method of File class returns a Path object.
- path1.relativize(path2) both the path should be of same type. Either relative or absolute.
- 
    
```java
//Paths.get and file.toAbsolutePath and file.toRealPath
 import java.nio.file.Paths;
  var file = Paths.get("F:\\A\\.\\B\\C\\D\\..\\Book.java");
  sout(file.toAbsolutePath()); // Prints 'F:\A\B\C\Book.java' exists on the file system, hence no exception.
try {
 sout(file.toRealPath()); // Prints 'F:\A\B\C\Book.java' exists on the file system, hence no exception.
 } catch (IOException exception) {
 }
 //file.resolve and file.resolveSibiling
    var file1 = Paths.get("F:\\A\\B\\C");
    var file2 = Paths.get("Book.java");
    System.out.println(file1.resolve(file2)); //'F:\A\B\C\Book.java'.
    //Parent path of file1 is 'F:\A\B\' and hence
    System.out.println(file1.resolveSibling(file2)); // 'F:\A\B\Book.java'.
    
    var file1 = Paths.get("F:\\A\\B");
    var file2 = Paths.get("F:\\A\\B\\C\\Book.java");
    //Both refer to  Path object referring to 'F:\A\B\C\Book.java'
    System.out.println(file1.resolve(file2).equals(file1.resolveSibling(file2))); //true
 //path.subpath
    var path = Paths.get("F:\\A\\B\\C\\Book.java");
    System.out.println(path.subpath(1,4));  //inclusive=1, exclusive=4 B\C\Book.java
   // Root folder or drive is not considered in count and indexing. In the given path A is at 0th index
    System.out.println(path.subpath(1,5)); \\IllegalArgumentException
  
    var size1 = Files.size(path);
    var file = new File("F:\\A\\B\\C\\Book.java");
    var size2 = file.length();
    System.out.println(size1 == size2); // true

    var path = Paths.get("F:\\A");
    System.out.println(path.getRoot().equals(path.getParent())); //true

 //Path normalize
     var path = Paths.get("F:\\A\\.\\B\\C\\D\\..\\Book.java");
        path.normalize(); //returns a new path
        System.out.println(path); // 'F:\A\.\B\C\D\..\Book.java' 

 //Path equal false compares the content without normalizing
  var file1 = new File("F:\\A\\B\\D\\..\\C\\Book.java");
        var file2 = new File("F:\\A\\B\\.\\.\\C\\Book.java"); // Paths are different
        System.out.println(file1.toPath().equals(file2.toPath())); // false     
 //path.relativize
   var path1 = Paths.get("F:\\A\\B\\C");
        var path2 = Paths.get("F:\\A");
        System.out.println(path1.relativize(path2)); // ..\..
        System.out.println(path2.relativize(path1)); // B\C      

  var path1 = Paths.get("F:", "Other", "Logs");
        var path2 = Paths.get("..", "..", "Shortcut", "Child.lnk", "Message.txt");
 
        var path3 = path1.resolve(path2).normalize();
        var path4 = path1.resolveSibling(path2).normalize();
 
        System.out.println(path3.equals(path4));//true

        //path3 = path1.resolve(path2) --> [F:\Other\Logs\..\..\Shortcut\Child.lnk\Message.txt]. 
        //After normalize: F:\Shortcut\Child.lnk\Message.txt
        //path4 = path1.resolveSibling(path2) [F:\Other\..\..\Shortcut\Child.lnk\Message.txt].      
        //After normalize: F:\Shortcut\Child.lnk\Message.txt
      'Path["A\\..\\B\\.."]'.normalize()   --> "" (emptyPath) -> getNameCount() retuens 1
        ./.././../../. => ../../.. nameCount is 3 path.getName(0) returns .. length is 2 
```

### path.normalize

<p>
According to Javadoc of normalize method:

1. It removes all the redundant name elements.

2. "." represents current directory in Windows/Linux environment, hence it is considered redundant.

3. ".." represents parent directory in Windows/Linux environment. If a ".." is preceded by a non-".." name, then both names are considered redundant. </p>
   
```java
var path = Paths.get("F:", "user", "..", "udayan..");
path.normalize() // F:\udayan..
var path = Paths.get("A", "..", "B", "..").normalize(); // returns emptyPath
var path = Paths.get(".", "..", ".", "..", "..", ".").normalize(); // ../../..
path.getNameCount(); // 3
path.getName(0).toString().length();// 2
var path = Paths.get("F:", "..", ".", "..").normalize(); // Path[F:\\]
path.getNameCount(); // 0
```

## java.nio.file.API:Files

### Important methods

- Files.isDirectory(path)
- Files.getAttribute(path, "isDirectory") others: "creationTime"
- Files.readAttributes(path, "*").get("creationTime")
- Files.readAttributes(path, BasicFileAttributes.class).creationTime()
- Files.createDirectories(Paths.get("F:\\x\\y\\z")) creates all the directory
- Files.createDirectory(Paths.get("F:\\x\\y\\z")) creates the farthest directory element but all parents must exist.
- Files.isSameFile(Path path1, Path path2)  returns true if both the paths locate the same physical file.
- Files.isSameFile(Path path1, Path path2) returns true if both the paths locate the same physical file.
- 
```java
//creating a file under F:\A\B\File.txt
var path = Paths.get("F:", "A", "B", "File.txt");
Files.createDirectories(path.getParent());
Files.createFile(path);

var src = Paths.get("F:\\A\\B\\C\\Book.java");
var tgt = Paths.get("F:\\A\\B");
Files.copy(src, tgt); //java.nio.file.FileAlreadyExistsException is thrown at runtime. 
var tgt = Paths.get("F:\\A\\C\\");
Files.copy(src, tgt); //
```

### java.nio.file.Files  

[nio-files Docs](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html)

### Iterating Path

- On Path reference using iterator, forEach, for, for with getNameCount, and getName
- Given methods doesn't need actual path to physically exist and hence no exception is thrown at Runtime.

```java
    var path = Paths.get("F:\\A\\B\\C\\Book.java");
    System.out.printf("%d, %s, %s", path.getNameCount(), path.getFileName(), path.getName(2));
    //prints 3, C, C

    for(var p : path) {
        System.out.println(p);
    }

    for(var i = 0; i < path.getNameCount(); i++) {
        System.out.println(path.getName(i));
    }

    var iterator = path.iterator();
    while(iterator.hasNext()) {
        System.out.println(iterator.next());
    }

    path.forEach(System.out::println);
```

### Files.move

```java
Files.move(Path source, Path target, CopyOption... options) method throws following exceptions- 

[Copied from the Javadoc]

1. UnsupportedOperationException - if the array contains a copy option that is not supported

2. FileAlreadyExistsException - if the target file exists but cannot be replaced because the REPLACE_EXISTING option is not specified (optional specific exception)

3. DirectoryNotEmptyException - the REPLACE_EXISTING option is specified but the file cannot be replaced because it is a non-empty directory (optional specific exception)

4. AtomicMoveNotSupportedException - if the options array contains the ATOMIC_MOVE option but the file cannot be moved as an atomic file system operation.

5. IOException - if an I/O error occurs

6. SecurityException - In the case of the default provider, and a security manager is installed, the checkWrite method is invoked to check write access to both the source and target file.

```

### Files.read

```java
 var src = Paths.get("F:\\A\\B\\Book.java");
        try(var reader = Files.newBufferedReader(src))
        {
            String str = null;
            while((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        }
//Compile, execute and print in console
```

### Files.write

```java
   new File("C:\\Test\\t1.txt"); //Line n1
    new FileWriter("C:\\Test\\t2.txt"); //Line n2
    new PrintWriter("C:\\Test\\t3.txt"); //Line n3
    new BufferedWriter(new FileWriter(new File("C:\\Test\\t4.txt"))); //Line n4
    Files.newBufferedWriter(Paths.get("C:", "Test", "t5.txt")); //Line n5
    Files.newBufferedWriter(Paths.get("C:", "Test", "t6.txt"), StandardOpenOption.CREATE); //Line n6
    Files.newBufferedWriter(Paths.get("C:", "Test", "t7.txt"), StandardOpenOption.CREATE_NEW); //Line n7
    Files.newBufferedWriter(Paths.get("C:", "Test", "t8.txt"), StandardOpenOption.WRITE); //Line n8
 
 //Line n1 and n8 no physical file is created
 //Line n2..n7 creates physical file.
```