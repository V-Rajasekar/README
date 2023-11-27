# Chapter 20  NIO.2

- [Chapter 20  NIO.2](#chapter-20--nio2)
    - [Overview](#overview)
    - [Introducing Path](#introducing-path)
      - [ABSOLUTE VS. RELATIVE PATHS](#absolute-vs-relative-paths)
      - [Obtaining A Path with a URI class](#obtaining-a-path-with-a-uri-class)
    - [Obtaining a Path from the _java.io.File_ Class](#obtaining-a-path-from-the-javaiofile-class)
    - [Applying Path Symbols](#applying-path-symbols)
    - [Interacting With Paths](#interacting-with-paths)
    - [Creating a New Path with subpath()](#creating-a-new-path-with-subpath)
    - [Accessing Path Elements with getFileName(), getParent(), and getRoot()](#accessing-path-elements-with-getfilename-getparent-and-getroot)
    - [Checking Path Type with isAbsolute() and toAbsolutePath()](#checking-path-type-with-isabsolute-and-toabsolutepath)
      - [Joining Paths with resolve()](#joining-paths-with-resolve)
      - [Deriving a Path with relativize()](#deriving-a-path-with-relativize)
    - [Cleaning Up a Path with normalize()](#cleaning-up-a-path-with-normalize)
    - [Retrieving the File System Path with _toRealPath()_](#retrieving-the-file-system-path-with-torealpath)
    - [Reviewing Path Methods](#reviewing-path-methods)
    - [Operating on Files and Directories](#operating-on-files-and-directories)
      - [Files.exists(Path)](#filesexistspath)
      - [Files.isSameFile(Path p1, Path p2)](#filesissamefilepath-p1-path-p2)
      - [Making directories with createDirectory() and createDirectories()](#making-directories-with-createdirectory-and-createdirectories)
      - [Copying Files with copy()](#copying-files-with-copy)
      - [Copying and Replacing Files](#copying-and-replacing-files)
      - [Copying Files with I/O Streams](#copying-files-with-io-streams)
      - [Copying Files into a Directory](#copying-files-into-a-directory)
      - [Moving or Renaming Paths with move()](#moving-or-renaming-paths-with-move)
      - [Deleting a File with delete() and deleteIfExists()](#deleting-a-file-with-delete-and-deleteifexists)
      - [Reading and Writing Data with newBufferedReader() and newBufferedWriter()](#reading-and-writing-data-with-newbufferedreader-and-newbufferedwriter)
      - [Reviewing Files Methods](#reviewing-files-methods)
      - [Managing File Attributes](#managing-file-attributes)
      - [Checking File Accessibility](#checking-file-accessibility)
      - [Applying Functional Programming](#applying-functional-programming)
      - [Performing Deep copy using the Files.list](#performing-deep-copy-using-the-fileslist)
    - [Traversing a Directory Tree](#traversing-a-directory-tree)
      - [Depth search with walk()](#depth-search-with-walk)
      - [Searching a Directory with find()](#searching-a-directory-with-find)
      - [Reading aFile with lines()](#reading-afile-with-lines)
    - [Comparing Legacy java.io.File and NIO.2 Methods](#comparing-legacy-javaiofile-and-nio2-methods)
    - [Exam essentials.](#exam-essentials)


### Overview
<p>“I/O,” we presented the java.io API and discussed how to use it to interact with files and streams. In this chapter, we focus on the java.nio version 2 API, or NIO.2 for short, to interact with files. NIO.2 is an acronym that stands for the second version of the Non‐blocking Input/Output API, and it is sometimes referred to as the “New I/O.”</p>

### Introducing Path
- `java.nio.file.Path` interface. A Path instance represents a hierarchical path on the storage system to a file or directory
- Obtaining a Path with the Path Interface
```java
    Path path1 = Path.of("pandas/cuddly.png");
    Path path2 = Path.of("c:\\zooinfo\\November\\employees.txt");
    Path path3 = Path.get("/home/zoodirectory"); // Path.get is the older method
```
- The Path.of() method also includes a varargs to pass additional path elements. The values will be combined and automatically separated by the operating system–dependent file separator
  * `Path path1 = Path.of("pandas", "cuddly.png");`
  * `Path path2 = Path.of("c:", "zooinfo", "November", "employees.txt");`

#### ABSOLUTE VS. RELATIVE PATHS
* If a path starts with a `forward slash ( /), it is absolute`, with / as the root directory. Examples: /bird/parrot.png, Also it is absolute, with the drive letter as the root directory. Examples: c:/bird/parrot.png
* Otherwise, it is a relative path. Examples: bird/parrot.png

#### Obtaining A Path with a URI class
The `java.net .URI` class is used to create URI values.

```java
// URI Constructor
public URI(String str) throws URISyntaxException
```

- Conversions method to and from `Path` and `URI` objects
```java
// URI to Path, using Path factory method
public static Path of(URI uri)
 
// URI to Path, using Paths factory method
public static Path get(URI uri)
 
// Path to URI, using Path instance method
public URI toURI()

URI a = new URI("file://icecream.txt");
Path b = Path.of(a);
Path c = Paths.get(a);
URI d = b.toUri();
```
<p>Some of these examples may actually throw an  IllegalArgumentException at runtime, as some systems require URIs to be absolute. The URI class does have an isAbsolute() method, although this refers to whether the URI has a schema, not the file location.</p>

- A URI can be used for a web page or FTP connection.

  ```java
   Path path5 = Paths.get(new URI("http://www.wiley.com"));
   Path path6 = Paths.get(new URI("ftp://username:secret@ftp.example.com"));
  ```

- Obtaining a Path from the FileSystem Class
- The FileSystems class does give us the freedom to connect to a remote file system, where in Path is for the local
```java
// FileSystems factory method
public static FileSystem getDefault()
Path path1 = FileSystems.getDefault().getPath("pandas/cuddly.png");
Path path2 = FileSystems.getDefault()
   .getPath("c:\\zooinfo\\November\\employees.txt");

//Remote
 FileSystem fileSystem = FileSystems.getFileSystem(
      new URI("http://www.selikoff.net"));
   Path path = fileSystem.getPath("duck.txt");   
```

### Obtaining a Path from the _java.io.File_ Class

```java
// Path to File, using Path instance method
public default File toFile()
 
// File to Path, using java.io.File instance method
public Path toPath()

File file = new File("husky.png");
Path path = file.toPath();
File backToFile = path.toFile();
```

### Applying Path Symbols
- `.`|A reference to the current directory
- `..`|A reference to the parent of the current directory
```java
Path path = Paths.get("schedule.xml");
boolean exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
```
- The `Files.exists()` simply checks whether a file exists. If the parameter is a symbolic link, though, then the method checks whether the target of the symbolic link exists instead of the default behaviour that the symbolic link exists.
 * Using Files.exists() prevents the IOException

### Interacting With Paths
- `java.nio.file.Path` provides a rich plethora of methods and classes that operate on Path
 than one available in `java.io` API. Just like `String` values, `Path` instances are immutable.

 ```java
 Path p = Path.of("whale");
p.resolve("krill"); // Lost since Path is immutable.
System.out.println(p);  // whale
 ```
-  Viewing the Path: 

```java
public String toString() //Returns a String representation of the entire path
 
public int getNameCount() //
 
public Path getName(int index) // Retrieve the no of elements in the path and a reference.

Path path = Paths.get("/land/hippo/harry.happy");
System.out.println("The Path Name is: " + path);
for(int i=0; i<path.getNameCount(); i++) {
   System.out.println("   Element " + i + " is: " + path.getName(i));
}

//outputs
The Path Name is: /land/hippo/harry.happy
   Element 0 is: land
   Element 1 is: hippo
   Element 2 is: harry.happy
```
- getName and getNameCount doesn't consider the root element, so if the path is `/` then calling Path.of("/").getName(0) // throws IllegalArgumentException

### Creating a New Path with subpath()
 - `public Path subpath(int beginIndex, int endIndex)` the references are inclusion of the begining index and exclusion of the ending index.
 - `Paths.get("/mammal/omnivore/raccoon.image").subpath(1,2)` -> omnivore
 - Like getNameCount() and getName(), subpath() with invalid index throws IllegalArgumentException.
```java
var q = p.subpath(0, 4); // IllegalArgumentException
var x = p.subpath(1, 1); // IllegalArgumentException
```
### Accessing Path Elements with getFileName(), getParent(), and getRoot()
- `public Path getFileName()` returns the Path element of the current file or directory
- `public Path getParent()`  returns the full path of the containing directory. Returns null if  operated on the root path or a relative path.
- `public Path getRoot()` returns root element of the file within the file system, or null if the path is a relative path.

```java

public void printPathInformation(Path path) {
   System.out.println("Filename is: " + path.getFileName());
   System.out.println("   Root is: " + path.getRoot());
   Path currentParent = path;
   while((currentParent = currentParent.getParent()) != null) {
      System.out.println("   Current parent is: " + currentParent);
   }
}

printPathInformation(Path.of("zoo"));
printPathInformation(Path.of("/zoo/armadillo/shells.txt"));
printPathInformation(Path.of("./armadillo/../shells.txt"));
```

```java
Filename is: zoo
   Root is: null
 
Filename is: shells.txt
   Root is: /
   Current parent is: /zoo/armadillo
   Current parent is: /zoo
   Current parent is: /
 
Filename is: shells.txt
   Root is: null
   Current parent is: ./armadillo/..
   Current parent is: ./armadillo
   Current parent is: .
```

### Checking Path Type with isAbsolute() and toAbsolutePath()

```java
public boolean isAbsolute()
 
public Path toAbsolutePath() // converts a relative Path object to an absolute Path.
```
- When the `toAbsolutePath()` is called it selectes the current working directory from System.getProperty("user.dir");

```java
var path2 = Paths.get("birds/condor.txt");
System.out.println("Path2 is Absolute? " + path2.isAbsolute());
System.out.println("Absolute Path2 " + path2.toAbsolutePath());
//output 
Path2 is Absolute? false
Absolute Path2 /home/work/birds/condor.txt
```

#### Joining Paths with resolve()
- `public Path resolve(Path other)`
- `public Path resolve(String other)`

* resolve() method passing relative path concat the paths.
```java
 Path path1 = Path.of("/cats/../panther");
Path path2 = Path.of("food");
System.out.println(path1.resolve(path2)); ///cats/../panther/food
```
* resolve() method passing absolute path returns the absolute path
```java
Path path3 = Path.of("/turkey/food");
System.out.println(path3.resolve("/tiger/cage")); // /tiger/cage
```
#### Deriving a Path with relativize()
- `public Path relativize()` The Path interface includes a method for constructing the relative path from one Path to another
```java
var path1 = Path.of("fish.txt");
var path2 = Path.of("friendly/birds.txt");
System.out.println(path1.relativize(path2)); // ../friendly/birds.txt
System.out.println(path2.relativize(path1)); // ../../fish.txt
```
* For example, to get to fish.txt from friendly/birds.txt, you need to go up two levels (the file itself counts as one level) and then select fish.txt.
* If both path values are relative, then the relativize() method computes the paths as if they are in the same current working directory. 
* Alternatively, if both path values are absolute, then the method computes the relative path from one absolute location to another, regardless of the current working directory.

```java
Path path3 = Paths.get("E:\\habitat");
Path path4 = Paths.get("E:\\sanctuary\\raven\\poe.txt");
//Navigating from Path3 to Path4
System.out.println(path3.relativize(path4));// ..\sanctuary\raven\poe.txt
System.out.println(path4.relativize(path3)); // ..\..\..\habitat
```

- relativize() method throws IllegalArgumentException if the paths(absolute, relative) are mixed
- Incase of absolute path both the root path should be the same.
```java
Path path3 = Paths.get("c:\\primate\\chimpanzee");
Path path4 = Paths.get("d:\\storage\\bananas.txt");
path3.relativize(path4); // IllegalArgumentException
```
### Cleaning Up a Path with normalize()
- `public Path normalize()` method used to remove the unnecessary redundancies in a path.
- Also allow use to compare equivalent paths. Consider the following examples.

```java
var p1 = Path.of("./armadillo/../shells.txt");
System.out.println(p1.normalize()); // shells.txt
 
var p2 = Path.of("/cats/../panther/food");
System.out.println(p2.normalize()); // /panther/food
 
var p3 = Path.of("../../fish.txt");
System.out.println(p3.normalize()); // ../../fish.txt 

var p1 = Paths.get("/pony/../weather.txt");
var p2 = Paths.get("/weather.txt");
System.out.println(p1.equals(p2));                         // false
System.out.println(p1.normalize().equals(p2.normalize())); // true
```
### Retrieving the File System Path with _toRealPath()_
- This method is similar to normalize(), in that it eliminates any redundant path symbols. It is also similar to toAbsolutePath(), in that it will join the path with the current working directory if the path is relative.
- Unlike those two methods, though, toRealPath() will throw an exception if the path does not exist.
- `public Path toRealPath(LinkOption… options) throws IOException`
```java
System.out.println(Paths.get("/zebra/food.txt").toRealPath());
System.out.println(Paths.get(".././food.txt").toRealPath());
//output /horse/food.txt
```

### Reviewing Path Methods

|                         |                   |
-------------------------- | -------------------|
|Path of(String, String…)||  Path getParent()  
|URI toURI()|            |  Path getRoot()
|File toFile()|            |  boolean isAbsolute()
|String toString()|      |  Path toAbsolutePath()
|int getNameCount()|      |  Path relativize()
|Path getName(int)|      |  Path resolve(Path)
|Path subpath(int, int)|   |  Path normalize()
|Path getFileName()|      |  Path toRealPath(LinkOption…)


### Operating on Files and Directories
#### Files.exists(Path)
Checking for Existence with exists() public static boolean exists(Path path, LinkOption… options)

```java
var b1 = Files.exists(Paths.get("/ostrich/feathers.png"));
System.out.println("Path " + (b1 ? "Exists" : "Missing"));
 
var b2 = Files.exists(Paths.get("/ostrich"));
System.out.println("Path " + (b2 ? "Exists" : "Missing"));
```
#### Files.isSameFile(Path p1, Path p2)
- Take two Path parameter and returns true if they are same, it also applicable for symbolic link(i.e) real path = symbolic link: true
- throws IOException if the path is not found
- It can also be used to check two Directories are same.
- Return immediately true if the two path objects are equals, without checking whether the file exits.
```java
public static boolean isSameFile​(Path path, Path path2)
   throws IOException
```

#### Making directories with createDirectory() and createDirectories()
-  It creates the target directory along with any nonexistent parent directories leading up to the path. If all of the directories already exist, createDirectories() will simply complete without doing anything.
```java
public static Path createDirectory​(Path dir,
   FileAttribute<?>… attrs) throws IOException
 
public static Path createDirectories​(Path dir,
   FileAttribute<?>… attrs) throws IOException
```
#### Copying Files with copy()
- NIO.2 Files class provides a method for copying files and directories within the file system.
-
```java
 public static Path copy​(Path source, Path target,
   CopyOption… options) throws IOException 
```
#### Copying and Replacing Files
- By default, `if the target already exists, the copy() method will throw an exception`. You can change this behavior by providing the StandardCopyOption enum value REPLACE_EXISTING to the method. 
```java
Files.copy(Paths.get("book.txt"), Paths.get("movie.txt"),
   StandardCopyOption.REPLACE_EXISTING);
```
#### Copying Files with I/O Streams
- Convenient method to quickly read/write data from/to disk.

```java
public static long copy​(InputStream in, Path target,
   CopyOption… options) throws IOException
 
public static long copy​(Path source, OutputStream out)
   throws IOException
//examples
try (var is = new FileInputStream("source-data.txt")) {
   // Write stream data to a file
   Files.copy(is, Paths.get("/mammals/wolf.txt"));
}
 
Files.copy(Paths.get("/fish/clown.xsl"), System.out);   
```
#### Copying Files into a Directory
- Following method trying to create a new file named `/enclosure` its not trying to create a new file at `/enclosure/food.txt`. It throws runtime if the path /enclosure already exists.

```java
var file = Paths.get("food.txt");
var directory = Paths.get("/enclosure");
Files.copy(file, directory);

//If you want the same file name then 
var directory = Paths.get("/enclosure/food.txt");
//or better approach use 
var directory = Paths.get("/enclosure").resolve(file.getFileName());

```
#### Moving or Renaming Paths with move()
- move(Path source, Path target)
```java
//renames the zoo directory to a zoo‐new directory,
Path renameDir = Files.move(Path.of("c:\\zoo"), Path.of("c:\\zoo-new"));
//moves the addresses.txt file from the directory user to the directory zoo‐new, and it renames it to addresses2.txt.
Files.move(Path.of("c:\\user\\addresses.txt"),
   Path.of("c:\\zoo-new\\addresses2.txt"));
```
- Note: 
* copy(), amd move() requires `REPLACING_EXISTING` to overwrite the target if it exists, else it will throw an exception.
* copy(), move() will not put a file in a directory if the source is a file and the target is a directory. Instead, it will create a new file with the name of the directory.
- Performing an Atomic Move
  * Any process monitoring the file system never sees an incomplete or partially written file. If the file system does not support this feature, an AtomicMoveNotSupportedException will be thrown.
  * It will likely throw an exception if passed to a copy() method.
#### Deleting a File with delete() and deleteIfExists()
- Both of these methods throw an exception if operated on a nonempty directory.
```java
public static void delete​(Path path) throws IOException
public static boolean deleteIfExists​(Path path) throws IOException
// Returns true if delete successful else false.
```
#### Reading and Writing Data with newBufferedReader() and newBufferedWriter()

- NIO.2 includes two convenient methods for working with I/O streams.

```java
public static BufferedReader newBufferedReader​(Path path)
   throws IOException
 
public static BufferedWriter newBufferedWriter​(Path path,
   OpenOption… options) throws IOException

//Buffer reader reading the content from the file and writing in the console
var path = Path.of("/animals/gopher.txt");
try (var reader = Files.newBufferedReader(path)) {
   String currentLine = null;
   while((currentLine = reader.readLine()) != null)
      System.out.println(currentLine);
}

//Buffer writing two lines in a new file
var list = new ArrayList<String>();
list.add("Smokey");
list.add("Yogi");
 
var path = Path.of("/animals/bear.txt");
try (var writer = Files.newBufferedWriter(path)) {
   for(var line : list) {
      writer.write(line);
      writer.newLine();
   }
}
```
- Reading allLines at once
  * The entire file is read using readAllLines(), and the result is stored in memory at once. 
```java
var path = Path.of("/animals/gopher.txt");
final List<String> lines = Files.readAllLines(path);
lines.forEach(System.out::println);
```
#### Reviewing Files Methods
|||
|----|----|
|boolean exists(Path,LinkOption…)|Path move(Path, Path,CopyOption…)
|boolean isSameFile(Path, Path)|void delete(Path)
Path createDirectory(Path,FileAttribute<?>…)|boolean deleteIfExists(Path)
|Path createDirectories(Path,FileAttribute<?>…)|BufferedReadernewBufferedReader(Path)
|Path copy(Path, Path,CopyOption…)|BufferedWriter newBufferedWriter(
Path, OpenOption…)
|long copy(InputStream, Path,CopyOption…)|List<String> readAllLines(Path)
|long copy(Path, OutputStream)|

- _**Note**_ All of these methods except exists() declare `IOException`.

#### Managing File Attributes
- A file attribute is data about a file within the system, such as its size and visibility, that is not part of the file contents.

```java
- Methods to determine a Path
//Returns true if is a dir or a Symbolic link to a directory, otherwise false
public static boolean isDirectory​(Path path, LinkOption… options)
 
//Returns true for Symbolic link pointing to regardless of file or directory 
public static boolean isSymbolicLink​(Path path)
 
public static boolean isRegularFile​(Path path, LinkOption… options) // Returns true for a Symbolic link points to a regular file.
```

#### Checking File Accessibility
```java
//Hidden files can't be viewed when listing the contents of a directory.
public static boolean isHidden​(Path path) throws IOException
 
public static boolean isReadable(Path path)
 
public static boolean isWritable(Path path)
 
public static boolean isExecutable(Path path)
```
- Reading File Size with _size()_
-  `public static long size​(Path path) throws IOException`
 * `System.out.print(Files.size(Paths.get("/zoo/animals.txt")));`
- File Changes with _getLastModifiedTime()_
 * `public static FileTime getLastModifiedTime​(Path path, LinkOption… options) throws IOException`
 * Method to print the last modified value for a file as an epoch value:
  
  ```java
      final Path path = Paths.get("/rabbit/food.jpg");
      System.out.println(Files.getLastModifiedTime(path).toMillis());
  ```
 - Improving Attribute Access
 * The `Files` class includes the following method to read attributes(read-only)
   ```java
   public static <A extends BasicFileAttributes> A readAttributes(
      Path path,
      Class<A> type,
      LinkOption… options) throws IOException
   ```
   ```java
   var path = Paths.get("/turtles/sea.txt");
   BasicFileAttributes data = Files.readAttributes(path,
      BasicFileAttributes.class);
   
   System.out.println("Is a directory? " + data.isDirectory());
   System.out.println("Is a regular file? " + data.isRegularFile());
   System.out.println("Is a symbolic link? " + data.isSymbolicLink());
   System.out.println("Size (in bytes): " + data.size());
   System.out.println("Last modified: " + data.lastModifiedTime());
   ```
- Modifying Attributes with getFileAttributeView()
  ```java
  public static <V extends FileAttributeView> V getFileAttributeView​(
   Path path,
   Class<V> type,
   LinkOption… options)
   
   // Read file attributes
   var path = Paths.get("/turtles/sea.txt");
   BasicFileAttributeView view = Files.getFileAttributeView(path,
      BasicFileAttributeView.class);
   BasicFileAttributes attributes = view.readAttributes();
   
   // Modify file last modified time
   FileTime lastModifiedTime = FileTime.fromMillis(
      attributes.lastModifiedTime().toMillis() + 10_000);
   view.setTimes(lastModifiedTime, null, null);

   // BasicFileAttributeView instance method
  public void setTimes(FileTime lastModifiedTime,
   FileTime lastAccessTime, FileTime createTime)
  ``` 
#### Applying Functional Programming
- Listing the Directory Contents
  * The Files.list() is similar to the java.io.File method listFiles(), except that it returns a Stream<Path> rather than a File[]. Since streams use lazy evaluation, this means the method will load each path element as needed, rather than the entire directory at once.
```java
public static Stream<Path> list​(Path dir) throws IOException

try (Stream<Path> s = Files.list(Path.of("/home"))) {
   s.forEach(System.out::println);
}
```
####  Performing Deep copy using the Files.list
 * Files.copy() method and showed that it only performed a shallow copy of a directory. We can use Files.list to loop throw if its a directory do copy recursively.
 * JVM will not follow symbolic links when using this stream method.means when a symbolic link is present in the loop its just ignored.
 ```java
   public void copyPath(Path source, Path target) {
      try {
         Files.copy(source, target);
         if(Files.isDirectory(source))
            try (Stream<Path> s = Files.list(source)) {// Stream objects are placed inside a try with resources, so that the stream is closed properly after processed.
               s.forEach(p -> copyPath(p, 
                  target.resolve(p.getFileName())));
            }
      } catch(IOException e) {
         // Handle exception
      }
   }
 ```
### Traversing a Directory Tree
 - `Traversing` a directory, also referred to as walking a directory tree, is the process by which you start with a parent directory and iterate over all of its descendants until some condition is met or there are no more elements over which to iterate
 - DON'T USE DIRECTORYSTREAM AND FILEVISITOR
- Selecting a Search Strategy
 * Two common strategy for search 1. Depth-First search and 2. Breadh First Search.
 * Depth First search: Java includes a search depth that is used to limit how many level(or hops) from the root the search is allowed to go.
 * A breadth‐first search starts at the root and processes all elements of each particular depth, before proceeding to the next depth level. 
 *  The results are ordered by depth, with all nodes at depth 1 read before all nodes at depth 2, and so on. While a breadth‐first tends to be balanced and predictable, it also requires more memory since a list of visited nodes must be maintained.
 * `NIO.2 Streams API` methods use depth‐first searching with a depth limit, which can be optionally changed.

#### Depth search with walk()

```java
public static Stream<Path> walk​(Path start,
   FileVisitOption… options) throws IOException
 
public static Stream<Path> walk​(Path start, int maxDepth,
   FileVisitOption… options) throws IOException
```
- **Note**: default maximum depth of Integer.MAX_VALUE

```java
// method walks a directory tree and returns the total size of all the files in the directory:
private long getSize(Path p) {
   try {
      return  Files.size(p);
   } catch (IOException e) {
      // Handle exception
   }
   return 0L;
}
 
public long getPathSize(Path source) throws IOException {
   try (var s = Files.walk(source)) {
      return s.parallel()
            .filter(p -> !Files.isDirectory(p))
            .mapToLong(this::getSize)
            .sum();
   }
}
var size = getPathSize(Path.of("/fox/data"));
System.out.format("Total Size: %.2f megabytes", (size/1000000.0));
//Total Directory Tree Size: 15.30 megabytes
```
- Applying a Depth Limit
-   `try (var s = Files.walk(source, 5)) {}` limit=0 set the current path and limit >= 1 to get non zero value.

- Avoiding Circular Paths
  * The `walk()` method is different in that it does not follow symbolic links by default and requires the `FOLLOW_LINKS` option to be enabled.
  ```java
   try (var s = Files.walk(source, 
          FileVisitOption.FOLLOW_LINKS)) {
  ```
  * When traversing a directory tree, your program needs to be careful of symbolic links if enabled. For example, if our process comes across a symbolic link that points to the root directory of the file system, then every file in the system would be searched!
  * Be aware that when the FOLLOW_LINKS option is used, the walk() method will track all of the paths it has visited, throwing a FileSystemLoopException if a path is visited twice.
#### Searching a Directory with find()
- Generic syntax
```java
public static Stream<Path> find​(Path start,
   int maxDepth,
   BiPredicate<Path,​BasicFileAttributes> matcher,
   FileVisitOption… options) throws IOException
```
-  NIO.2 automatically retrieves the basic file information for you, allowing you to write complex lambda expressions that have direct access to this object.
   ```java
   //searches a directory tree and prints all .java files with a size of at least 1,000 bytes, using a depth limit of 10
      Path path = Paths.get("/bigcats");
      long minSize = 1_000;
      try (var s = Files.find(path, 10, 
         (p, a) -> a.isRegularFile()
            && p.toString().endsWith(".java")
            && a.size() > minSize)) {
      s.forEach(System.out::println);
      }
   ```
 #### Reading aFile with lines()
  -   Files.readAllLines() and commented that using it to read a very large file could result in an OutOfMemoryError problem. Luckily, NIO.2 solves this problem with a Stream API method.
  -   Only a small portion of the file is stored in memory at any given time.
   ```java
   Path path = Paths.get("/fish/sharks.log");
   try (var s = Files.lines(path)) {
      s.filter(f -> f.startsWith("WARN:"))
         .map(f -> f.substring(5))
         .forEach(System.out::println);
   }
   //Prints only warning message with out WARN:
   ```
- Difference between readAllLines vs lines
  Reads the entire file into memory and performs a print operation on the result. lines lazily processes each line and prints it as it it read.
  memory storage is less in lines option
 - The readAllLines() method returns a List, not a Stream, so the filter() method is not available.

### Comparing Legacy java.io.File and NIO.2 Methods
Legacy I/O File method|NIO.2 method
--------- | -------------------
file.delete()|Files.delete(path)
file.exists()|Files.exists(path)
file.getAbsolutePath()|path.toAbsolutePath()
file.getName()|path.getFileName()
file.getParent()|path.getParent()
file.isDirectory()|Files.isDirectory(path)
file.isFile()|Files.isRegularFile(path)
file.lastModified()|Files.getLastModifiedTime(path)
file.length()|Files.size(path)
file.listFiles()|Files.list(path)
file.mkdir()|Files.createDirectory(path)
file.mkdirs()|Files.createDirectories(path)
file.renameTo(otherFile)|Files.move(path,otherPath)
 | **java.nio.file**
 | Files
 | static long copy()
 | static Path createDirectories()
 | static Path createDirectory()
 | static Path createFle()
 | static void delete()
 | static boolean deleteExists()
 | static boolean exists()
 | static boolean isDirectory()
 | static boolean is Regular Fle static Stream-String>Ines()
 | static Stream-Path> ist() public static Path move()
 | static byte[] readAlBytes()
 | static List<String> readALines()
 | static String readString()
 | static Stream-Path walk()
 | static Path write()
 | static Path writeString()





- NIO.2 is more powerful API than the legacy `java.io.File` class. It has support for symbolic links, setting file system-specific attributes.

### Exam essentials.
- How to create Path Objects ? 
  An NIO.2 Path instance is an immutable object that is commonly created from the factory method Paths.get() or Path.of(). It can also be created from FileSystem, java.net .URI, or java.io.File instances. The Path interface includes many instance methods for reading and manipulating the abstract path value.
-  NIO.2 methods to eliminate redundant or unnecessary path symbols.
-  Most of the methods defined on Path do not declare any checked exceptions and do not require the path to exist within the file system, with the exception of toRealPath()
-  The NIO.2 Files helper class methods to check whether a file exists, copy/move a file, create a directory, or delete a directory. Most of these methods declare IOException, since the path may not exist, and take a variety of varargs options.
-  Manage file attributes. The NIO.2 Files class methods for reading single file attributes, such as its size or whether it is a directory, a symbolic link, hidden, etc
   * Reading all attributes in a single call.An attribute type is used to support operating system–specific views. Finally, NIO.2 supports updatable views for modified select attributes
- Functional prograaming: NIO2 includes Stream API for The Files.list() method iterates over the contents of a single directory, while the Files.walk() method lazily traverses a directory tree in a depth‐first manner. The Files.find() method also traverses a directory but requires a filter to be applied. Both Files.walk() and Files.find() support a search depth limit. Both methods will also throw an exception if they are directed to follow symbolic links and detect a cycle.
- Difference between readAllLines() and lines()
