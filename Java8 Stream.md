
## Java 8 Stream

#### What is Java Stream ?
Java 8 streams are a framework inthe Java class library that provides several 
key benefits to programs, e.g.

- Manipulate flows of data declaratively via function composition
- Enable transparent parallelization without the need to write any multi-threaded code
- A stream is a pipeline of aggregate operations that process a sequence of elements (aka, “values” or “data”)

#### How to create a Stream ?
A stream is create via factory methods. There are many factory methods to create few mentioned below

- collection.stream()
- collection.parallelStream() Pattern.compile(…).splitAsStream()
- Stream.of(value1,… ,valueN)
- Arrays.stream(array)
- Arrays.stream(array, start, end)

#### what it does ?
Streams enhance flexibility by forming a “processing pipeline” that chains multiple aggregate operations together
- Each aggregation operation in the pipeline can filter and/or transform the stream
1. Starts with a source of data
2. Processes data through a pipeline of intermediate operations that each map an input stream to an output stream (e.g) intermediate operations `filter(), map() & flatMap()`
3. Finishes with a terminal operation that yields a non-stream result
` forEach(), collect(), reduce()`



```Java
import java.util.stream.Stream;
import static java.lang.Character.toLowerCase;
public class StreamTest {
  
  public String capitalize(String str) {
     if(str.length() == 0) 
       return "";
     else 
       return str.substring(0,1).toUpperCase()
        .concat(str.substring(1)).toLowerCase();
  }

    public void testStream() {
     Stream.of("balu", "hortans", "harish", "hamelton","lartese", "Hobbit")
    .filter( s ->  toLowerCase(s.charAt(0)) == 'h')
    .map(this::capitalize)
    .sorted()
    .forEach(System.out::println);
}

}

StreamTest streamTest = new StreamTest();
 streamTest.testStream();


```

    hamelton
    harish
    hobbit
    hortans
    

#### OverView Aggreation Operations 
|Operation | Description |Syntax
| :--- | --- | :--- |
| Map | Applies the mapper function to every element of the input stream & returnsan output stream consisting of the results |Stream map(Function<...> mapper )|
|filter| Tests the given predicate against each element of the input stream & returns an output stream consisting only of the elements that match the predicate |Stream filter(Predicate<...> predicate )|
|collect|This terminal operation uses a collector to perform reduction on the elements of its input stream & returns the results of the reduction |R collect(Collector<…>collector)|

### Overview of common stream aggregate operation
- List collect(toList())            creates a list of elements
- Stream limit(long maxSize) & Optional findFirst() 

#### Map, Collectors.joining


```Java
/*package whatever //do not write package name here */

import java.io.*;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Actor {
    private String name;
    
    public  Actor(String name){this.name = name;}
    public String getName() {
        return name;
    }
}
class Movie {
    private String name;
    private Actor actor;
    
    public Movie (String name, String actorName) {
        this.name = name;
        this.actor = new Actor(actorName);    
    }
    
    public Actor getActor(){return actor;}
}

Movie nayakan = new Movie("Nayakan", "Kamal Hasaan");
Movie basha = new Movie("Basha", "Rajinikanth");
Movie bahubali = new Movie("Bahubali", "Prabhas");
Movie thalapathi = new Movie("Thalapathi", "Rajinikanth");

Stream <Movie> movieStream = Stream.of(nayakan, basha, bahubali, thalapathi);
   List<Actor> actors = movieStream.map(movie -> new Actor(movie.getActor().getName()))
    .collect(Collectors.toList()); 
actors.forEach(actor -> System.out.println(actor.getName()));

Stream <Movie> movieStream = Stream.of(nayakan, basha, bahubali, thalapathi);
   String actors = movieStream.map(movie -> movie.getActor().getName())
    .collect(Collectors.joining(",")); 
System.out.println(actors);

```

    Kamal Hasaan
    Rajinikanth
    Prabhas
    Rajinikanth
    Kamal Hasaan,Rajinikanth,Prabhas,Rajinikanth
    

#### FlatMap, Collectors.summingDouble, Collectors.groupingBy, Collectors.partitioningBy


```Java

import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;

class Developer {
    private String name;
    private String deptName;
    private Double salary;
    private Set<String> languages;
    private String grade;
    
    public Developer (String name, String deptName, Double salary, Set<String> languages) {
        this.name = name;
        this.deptName = deptName;
        this.salary = salary;
        this.languages = languages;
        
    }
    
    public String getDeptName() {return deptName;}
    
    public Double getSalary(){return salary;}
    
    public Set<String> getLanguages() { return languages;}
    
    public String getGrade() { return grade; }
    
    public String toString() {
        return name;
    }
}


	    Set<String> rajLanguages = Stream.of("Java", "Python", "Scala").collect(Collectors.toSet());
	Developer rajasekar = new Developer("Rajasekar", "IT solution", new Double(564000), rajLanguages);
	
		
	    Set<String> mugunthanLanguages = Stream.of("Java").collect(Collectors.toSet());
	Developer mugunthan = new Developer("Mugunthan", "Payment", new Double(560000), mugunthanLanguages);
	
		
	    Set<String> tejaLanguages = Stream.of("Java", "Angular", "Bash").collect(Collectors.toSet());
	    
	    
	Developer teja = new Developer("Teja", "Payment", new Double(464000), tejaLanguages);
	    System.out.println("List of developers programming language:");
       Stream.of(rajasekar, mugunthan, teja)
                      .flatMap(developer -> developer.getLanguages().stream())
                      .collect(Collectors.toSet())
                      .forEach(System.out::println); 
    // Collectors.groupingBy                 
                      
            Map<String, List<Developer>> developersByDept = Stream.of(rajasekar, mugunthan, teja)
                      .collect(Collectors.groupingBy(Developer:: getDeptName));
            System.out.println("DevelopersByDept: "+ developersByDept);          
   
   //Collectors.summing         
            Map<String, Double> totalSalaryByDept = Stream.of(rajasekar, mugunthan, teja)
                      .collect(
                          Collectors.groupingBy(Developer:: getDeptName,
                          Collectors.summingDouble(Developer::getSalary)));
            System.out.println("TotalSalaryOfPaymentDept: "+ totalSalaryByDept.get("Payment"));                    
  // Collectors.partitioningBy          
            Map<Boolean, List<Developer>> partitionDeveloperBasedOnSal = 
                    Stream.of(rajasekar, mugunthan, teja)
                          .collect(Collectors.partitioningBy(d ->d.getSalary() > 500000 ));
            System.out.println("DevelopersBySalary > 500000: "+ partitionDeveloperBasedOnSal);                        
  
```

    List of developers programming language:
    Java
    Scala
    Bash
    Angular
    Python
    DevelopersByDept: {Payment=[Mugunthan, Teja], IT solution=[Rajasekar]}
    TotalSalaryOfPaymentDept: 1024000.0
    DevelopersBySalary > 500000: {false=[Teja], true=[Rajasekar, Mugunthan]}
    

Resources 
- [Java8 SimpleSearch using Stream, Filter, Map e.t.c](https://github.com/douglascraigschmidt/LiveLessons/tree/master/SimpleSearchStream/src/main/java/search)
- [Java 8 Stream Overview](https://www.ibm.com/developerworks/java/library/j-java-streams-1-brian-goetz/index.html)


```Java

```
