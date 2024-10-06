# Reactive Programming
- [Reactive Programming](#reactive-programming)
  - [Reactive App Architecture.](#reactive-app-architecture)
  - [Reactive Streams](#reactive-streams)
  - [Reactive Success Scenario](#reactive-success-scenario)
  - [Reactive failure Scenario.](#reactive-failure-scenario)
  - [Project Reactor](#project-reactor)
  - [To learn how to write reactive programming](#to-learn-how-to-write-reactive-programming)
  - [Reactor type](#reactor-type)
  - [Functional Programming in Modern Java](#functional-programming-in-modern-java)
    - [Imperative code vs Functional code](#imperative-code-vs-functional-code)
    - [Creating Reactor type](#creating-reactor-type)
    - [consuming Reactor type](#consuming-reactor-type)
    - [Testing Reactive type using reactor-test library](#testing-reactive-type-using-reactor-test-library)
    - [Reactive stream event](#reactive-stream-event)
  - [Transforming Data](#transforming-data)
    - [filter(condition)](#filtercondition)
    - [flatMap()](#flatmap)
    - [flatMapMany() in Mono (Mono to Many transformation)](#flatmapmany-in-mono-mono-to-many-transformation)
    - [transform()](#transform)
    - [defaultIfEmpty() or switchIfEmpty()](#defaultifempty-or-switchifempty)
  - [Introduction to combining reactive stream](#introduction-to-combining-reactive-stream)
    - [**concat() and concatWith()**](#concat-and-concatwith)
    - [merge() \& mergeWith()](#merge--mergewith)
    - [mergeSequential()](#mergesequential)
    - [zip() and zipWith()](#zip-and-zipwith)

What is Reactive programming? 
- Reactive programming is a new programming paradigm. 
- Asyn and non blocking
- Data flows as event/messaging stream
- Functional Style codes
- BackPressure On Data Streams.
- Push-pull based data flow model request(2) -> onNext()
```
1. App makes a call to DB and immediately the calling thread is 
removed to do useful work.
2. Another thread send from the app to the DB behind the scene
3. Once the query execution and the result set are available
the data are send in stream in a sub sequenonNext()...
4. Once returned all data onComplete() is called.  
```

When to use reactive programing? 
- Use Reactive programming when there is need to build and 
support high load with the available resources.
- App that needs to support 400 TPS

## Reactive App Architecture. 
- Handle request using non blocking style.
  - Netty is a non blocking Server uses Event Loop Model. Instead of 
  single thread/request.
- Using Project Reactor for writing non-blocking programming
- Spring WebFlux uses the Netty and Project Reactor for building
 non-blocking or reactive APIs.
## Reactive Streams 
- It's a specification written by engineers from Lightblend, NetFlix, VmWare(Pivotal)
- Four Interfaces
  - Publisher
  - Subscriber
  - Subscription
  - Processor

**Publisher**

```kotlin
public interface Publisher<T> {
    public void subscribe(Subscriber<? super T> s);
}
Publisher represents the DataSource
• Database
• RemoteService etc.,
```


**Subscriber**
```
public interface Subscriber<T> {

    public void onSubscribe(Subscription s);
    public void onNext(T t);
    public void onError(Throwable t);
  
    public void onComplete();
}
```
**Subscription**
```kotlin
public interface Subscription {
    public void request(long n);
public void cancel();
}
Subscription is the one which connects the app and 
```
**Processor**
Not really used in the day to day cases.
```java
public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {
}
```
• Processor extends Subscriber and Publisher
• Processor can behave as a Subscriber and Publisher
• Not really used this on a day to day basis

## Reactive Success Scenario
![img.png](ReactiveSuccess.png)

## Reactive failure Scenario. 
![img.png](ReactiveFailures.png)
- Exceptions are treated like the data
- The Reactive Stream is dead when an exception is
  thrown
What is the limitation of Restful API/Spring MVC ?
- Thread pool size of Embedded tomcat in Spring MVC’s is 200
- We can increase the thread pool size based on certain limitations. 
- Thread is expensive and can take up to 1 MB of heap space.
- More threads means more memory consumptions and less space for actual processing

what is NonBlocking or Reactive RestFul API ?
- A Non-Blocking or Reactive RestFul API has the behavior of providing end to
end non-blocking communication between the client and service
- Thread involved in handling the httprequest and httpresponse is not blocked at all

## Project Reactor
- Project Reactor is a reactive library that implement Reactive Stream Specifications(Publisher, Subscriber, 
  Subscribe..)
- Spring WebFlux uses Project Reactor by default

## To learn how to write reactive programming
**Flux & Mono**
- Flux and Mono is a reactive type that impl Ractive Streams specification
- Flux and Mono is part of the **reactor-core** module.
- Flux is a reactive type to represent a list 0 to N elements.
- Mono is a reactive type to represent  0 to 1 element.
- 

- [Project Reactor Reference Guide](https://projectreactor.io/docs/core/release/reference/)
    - covers Mono and Flux creation
    - Reactive library interfaces(publisher, subscriber, subscription, processor)
- [Project Reactor Learning Materials](https://projectreactor.io/learn)
    - Get Started with Reactive Programming in Spring
    - Get Reactive with Project Reactor and Spring 5

## Reactor type
- [Flux](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html)
- [Mono](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html)


## Functional Programming in Modern Java

### Imperative code vs Functional code

| Imperative                                                                                | Functional                                                              |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| Focuses on how to perform the task, uses loops and conditions, and manages state directly | Focus on what to perform, uses pure functions, and avoid changing state |
| Tough to write concurrent programming due to mutability                                   | Easier to write concurrent programming due to immutability              |

```java
     List<String> names = List.of("alex", "ben", "chole", "adam");

        Set<String> result = names.stream()
                                  .filter(name -> name.length() > 3)
                                  .map(String::toUpperCase)
                                  .collect(Collectors.toSet());
```


### Creating Reactor type

- `Flux.fromIterable(List<T>)`
- `Flux.just()`
- `Mono.just(T)`
  
### consuming Reactor type

- `Flux.subscribe(T -> T)`
- `Mono.subscribe(T -> T)`

```java
import reactor.core.publisher.Flux; 
import reactor.core.publisher.Mono;

 public class FluxAndMonoGeneratorService {

  public Flux<String> namesFlux() {
    return Flux.fromIterable(List.of("Alex", "Ben", "Charlie"));
  }

  public Mono<String> nameMono() {
    return Mono.just("alex");
  }

  public static void main(String[] args) {
    FluxAndMonoGeneratorService obj = new FluxAndMonoGeneratorService();
    obj.subscribe(name -> System.out.println("Name is" + name));

    obj.nameMono().subscribe(name -> {
      System.out.println("Mono Name is" + name);
    })
  }
 }
 ```

### Testing Reactive type using reactor-test library

- Use A StepVerifier provides a declarative way of creating a verifiable script for an async Publisher sequence,
by expressing expectations about the events that will happen upon subscription.

 ```java

  //Test method to verify the names are returned in the order expected, expected count and finally onComplete event is triggered.

  @Test
  void namesFlux() {
    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
    //create function invokes the subscribe call
      StepVerifier.create(fluxAndMonoGeneratorService.nameFlux())
      //        .expectNext("Alex", "Ben", "Charlie");
      .expectNextCount(3)
      .verifyComplete();
  }
```

### Reactive stream event 

- To See the reactive stream events happening between the publisher and subscriber use log. In this case 
  Flux.Iterable.1 produces: onSubscribe(), request(unbounded), onNext(alex), onNext(ben), onComplete()

  ```java
   public Flux<String> namesFlux() {
    return Flux.fromIterable(List.of("Alex", "Ben")).log();
  }
  ```

## Transforming Data

- **Reactive stream are immutable** meaning after creating the Reactive stream using Flux any following data transforming operation doesn't affect the source after the operation it creates a new Flux
- filter(<Lambda expression>) 
- `map()`: tranform from one form to another form  1-1 (T to V)
- `flatMap`: tranform 1-N (T to *),  Async in nature so (order is not preserved). Useful to flatten the obj that contains another Mono/Flux
- `concatMap`: Work Similar to flatMap. ConcatMap operator preserves the ordering sequence of the reactor streams. But it take more time compared to the flatMap
- `flatMapSequential`. Fill fulls the drawbacks of flatMap and concatMap (i.e) (order is preserved with no execution 
  time lag).

> When you have a need to transform Mono to Mono then use flatMap, If Mono to Flux then use flatMapMany

### filter(condition)

```java
    public Mono<String> namesMono_map_filter(int StringLength) {
      return  Mono.just("alex")
                .map(String::toUpperCase)
                .filter(x -> x.length() > StringLength);

    }

      @Test
    public void namesMono_map_filter() {
        var monoFilter = new MonoFilter();
        StepVerifier.create(monoFilter.namesMono_map_filter(3))
                    .expectNext("ALEX")
                    .verifyComplete();
    }

    @Test
    public void namesMono_map_filter_Empty() {
        var monoFilter = new MonoFilter();
        StepVerifier.create(monoFilter.namesMono_map_filter(5))
                    .expectNextCount(0)
                    .verifyComplete();
    }
```


### flatMap()

- Use it when the transformation returns a Reactive Type (Flux or Mono)
- Returns a `Flux<Type>`


- flatMap in Mono
  - Use it when the transformation returns a Mono
  - Returns a Mono<T>
  - Use flatMap if the transformation involves making a REST API call or any kind.
  of functionality that can be done async.
 
  ```java
    public Mono<List<String>> nameMono_flatMap(String name) {
        return Mono.just(name)
                .map(String::toUpperCase)
                .flatMap(this::splitStringMono).log();
    }
    
    Mono<List<String>> splitStringMono(String value) {
      var charArray = value.split("");
      return Mono.just(List.of(charArray));
    }

    @Test
    void nameMono_flatMap() {
       var call = testObj.nameMono_flatMap("Alex")
       StepVerifier.create(call)
                   .expectNext(List.of("A", "L", "E", "X"))// Returning Mono<List<String>>
                   .verifyComplete(); 
    }
  ```  

### flatMapMany() in Mono (Mono to Many transformation)

  - **When Mono transformation returns a Flux type then use flatMapMany()**
  
  ```java
    public Flux<String> nameMono_flatMapMany(String name) {
        return Mono.just(name)
                .map(String::toUpperCase)
                .flatMapMany(this::splitStringWithDelay).log(); //Flux <of A, L, E, X>
    }

      void nameMono_flatMapMany() {
        Flux<String> input = fluxAndMonoGeneratorService.nameMono_flatMapMany("alex");
        StepVerifier.create(input).expectNext("A","L","E","X") // Returning Flux<String>
                .verifyComplete();
    }

  ```

### transform()

- Used to transform from one type to another type.
- Nothing fancy here moving the common functionality to a Functional interface and used it across the project

- Accept **Function Functional interface**
  - Function Functional interface got released as part of Java 8
  - Input publisher - (Mono or Flux)
  - Output publisher - (Mono or Flux)
- Useful in common functionality across the project.  
You extract the common functionality here filterMap and assign it to a Function variable like the below one and use transform with the function variable. 

  ```java
      public Flux<String> nameFlux_transform() {
      //Creating a function functional interface
        Function<Flux<String>, Flux<String>> filterMap = name -> name.filter(s -> s.length() > 3)
                .map(String::toUpperCase);
      
        return Flux.fromIterable(List.of("Alex", "Ben", "Charlie"))
                .transform(filterMap)
                .log();
    }
  ```
     
### defaultIfEmpty() or switchIfEmpty()

- It is not mandatory for a datasource to emit data all the time
- Use defaultIfEmpty() or switchIfEmpty() operator when no data emit and want to provide default values.

- defaultIfEmpty() accepts the actual type string "default"

```java   
 
         Flux<String> fluxNames = Flux.fromIterable(List.of("Alex", "Ben", "Chole"))
                .filter(s -> s.length() > 6)
                .map(String::toUpperCase) // Returns empty at this pt.
                .defaultIfEmpty("default") 
                .log(); 
      //Output default removing defaultIfEmpty will throw error          
```

- switchIfEmpty()
- Returning the Flux 
```java   
   //Creating a function functional interface
        Function<Flux<String>, Flux<String>> fluxFunction = name -> 
                name.filter(s -> s.length() > length)
                .map(String::toUpperCase);

        Flux<String> defaultFlux = Flux.just("default").transform(fluxFunction);
        //"D", "E", "F", "A", "U", "L", "T"

        return Flux.fromIterable(List.of("Alex", "Ben", "Charlie"))
                .transform(fluxFunction)
                .switchIfEmpty(defaultFlux)
                .log(); 
```
## Introduction to combining reactive stream

why `Combining Flux & Mono` ?

### **concat() and concatWith()**

- Used to combine two reactive stream in to one.


- Concatenation of Reactive Streams happens in a sequence
    - First one is subscribed first and completes
    - Second one is subscribed after that and then completes
- **Flux.concat(flux1, flux2)** - static method and available (only) in Flux
- **mono1.concatWith(mono2)** - Instance method in Flux and Mono
- concatWith in mono returns the flux
- Both of these operators works similarly.

```java
  var flux1 = Flux.just("A", "B", "C")
  var flux2 = Flux.just("D", "E");
  //Returns A, B, C, D, E
  Flux.concat(flux1, flux2);
  flux1.concatWith(flux2); //Using the instance method

  var mono1 = Mono.just("A")
  var mono2 = Mono.just("D");
  //Returns A, B, C, D, E
  //Returns Flux.       
  Flux<String> alphas = mono1.concatWith(mono2);
```

### merge() & mergeWith()

- Used to combine two publisher(Mono, Flux) together
  - _Flux.merge(Flux1, Flux2)_ is  a static method in Flux
  - _mono1.mergeWith(mono2)_ is an instance method in Flux and Mono
  
```
Difference between concat and merge?
 - concat() subscribes to the Publishers in a sequence.
 - merge() both the publishers are subscribed at the same time. Publishers are 
   subscribed eagerly and the merge happens in an interleaved fashion.
```

  ```java
     public static final Flux<String> explore_merge() {
        Flux<String> flux1 = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(100));

        Flux<String> flux2 = Flux.just("D", "E", "F").delayElements(Duration.ofMillis(125));
        return Flux.merge(flux1, flux2).log();
        //Using flux instance mergeWith
        // return flux1.mergeWith(flux2);
    }
    //As you can see both the publisher are sub
      StepVerifier.create(explore_merge())
                    .expectNext("A", "D", "B", "E", "C", "F")
                    .verifyComplete();

      public static final Flux<String> explore_mergeWith_mono() {
        Mono<String> mono1 = Mono.just("A");

        Mono<String> mono2 = Mono.just("B");
        return mono1.mergeWith(mono2);
    }
  // test
        StepVerifier.create(explore_mergeWith_mono())
                    .expectNext("A", "B")
                    .verifyComplete();
    
    

  ```

### mergeSequential()

- Used to combine two publisher(Mono or Flux) together
- Static method in Flux Flux.mergeSequential(flux1, flux2)
- Even though the publishers and subscribed eagerly the merge happens in a sequence.

```java
    Flux<String> explore_mergeSequentially() {
        Flux<String> flux1 = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(100));

        Flux<String> flux2 = Flux.just("D", "E", "F").delayElements(Duration.ofMillis(125));
        return Flux.mergeSequential(flux1, flux2).log();
    }

    @Test
    void testExplore_mergeSequentially() {
        StepVerifier.create(explore_mergeSequentially())
                    .expectNext("A", "B","C","D",  "E",  "F")
                    .verifyComplete();
    }

```

### zip() and zipWith()

- Zip `Flux.zip():Flux`
  
    - static method that's part of the Flox
    - Can be used to merge up-to 2 to 8 Publishers(Flux or Mono) in to one

- ZipWith `mono1.zipWith(mono2):Mono`
    - This is an instance method that's part of the Flux and Mono
    - Used to merge two Publishers(_mono/flux_) in to one.
    - Publishers are subscribed eagerly
    - Waits for all the publishers involved in the transformation to emit one element.
    - Continues until one publisher sends an OnComplete event.

 
```java

  Flux<String> fluxa = Flux.just("A", "B", "C");
  Flux<String> fluxb = Flux.just("D", "E", "F");
  return Flux.zip(fluxa, fluxb, (first, second) -> first + second); // AD, BE, CF

// Zips three publishers together in this example.
  Flux<String> fluxa = Flux.just("A", "B", "C");
  Flux<String> fluxb = Flux.just("D", "E", "F");
  Flux<String> fluxn = Flux.just("1", "2", "3");
  return Flux.zip(fluxa, fluxb, fluxn).map(t4 -> t4.getT1() + t4.getT2() + t4.getT3()); // AD1, BE2, CF3
// Zip Mono returns Mono
  Mono<String> monoa = Mono.just("A");
  Mono<String> monob = Mono.just("D");
  return monoa.zipWith(monob).map(t1-> t1.getT1() + t1.getT2()); // AD
```
>Note: ZipWith on Mono returns Mono unlike other operators like concatWith and MergeWith which returns Flux 

