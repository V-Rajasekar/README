# Java API
- These are some important API packages to remember
  - [try-with-resources](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)
  - `java.time`
    * Period  "P1Y2M3D"         -- Period.of(1, 2, 3)
    * Duration "PT2H46M40S"   Duration.of(10000, ChronoUnit.SECONDS);
    * ChronoUnit - Enum in java.time.temporal
    * [Duration-between](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html#between-java.time.temporal.Temporal-java.time.temporal.Temporal-)
  - `java.util.function`
    * BiConsumer<T, U>, BiFunction<T, U, R>, BiPredicate<T,U>, BinaryOperator<T>, 
    * IntBinaryOperator, IntConsumer, IntFunction<R>, IntPredicatem IntSupplier, InToDoubleFunction, IntToLongFunction, IntUnaryOperator, ToIntFunction<T>,ToIntBiFunction<T>
    * Simillary Like Int we have for Long, Double in this same package.
 - `java.nio.file`
   * `PathMatcher` FileSystems.getDefault().getPathMatcher("glob.**.{xml,json}");  
   * `FileSystems` `getPathMatcher's` Returns a PathMatcher that performs match operations on the String representation of Path objects by interpreting a given pattern. The syntaxAndPattern parameter identifies the syntax and the pattern and takes the form: syntax:pattern [getPathMatcher](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileSystem.html#getPathMatcher-java.lang.String-)
   * [StandardOpenOption](https://docs.oracle.com/javase/8/docs/api/java/nio/file/StandardOpenOption.html)
     * An Enum Constants for CREATE, APPEND, CREATE_NEW,DELETE_ON_CLOSE, DSYNC(only content), SYNC(content, metadata),  READ, SPARSE, TRUNCATE_EXISTING, WRITE.
  * [Files-Read-Attribute](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#getAttribute-java.nio.file.Path-java.lang.String-java.nio.file.LinkOption...-)
  - `java.util.concurrent`
  * [Executors.newFixedThreadPool](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executors.)html#newFixedThreadPool-int-
  * [Executors](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executors.html)
  * [submit](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html#submit-java.util.concurrent.Callable-
  
    * <T> Future<T>	submit(Callable<T> task)
     Submits a value-returning task for execution and returns a Future representing the pending results of the task.
    * Future<?>	submit(Runnable task)
     Submits a Runnable task for execution and returns a Future representing that task.
    * <T> Future<T>	submit(Runnable task, T result)
    Submits a Runnable task for execution and returns a Future representing that task.

  * [Callable](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Callable.html)
  * [Executor->execute(Runnable)](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executor.html#execute-java.lang.Runnable-)
  * [ReadWriteLock](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/ReadWriteLock.html)
```java
public static void main(String[] args) throws InterruptedException, ExecutionException {

    ExecutorService threadPool = Executors.newFixedThreadPool(2);
    Future<String> asyncResult = threadPool.submit(
        new Callable<String>() {
            public String call() throws InterruptedException {
            Thread.sleep(1000);
            return "Hello world!";
        }
    });
    while (!asyncResult.isDone()) {
    Thread.sleep(200);
    }
    System.out.println(asyncResult.get());
    threadPool.shutdown();
}
```
- `java.util.stream` [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
* [IntStream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html)
* [Stream.Collector](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#collect-java.util.stream.Collector-)
* [partitioningBy](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#partitioningBy-java.util.function.Predicate-)

```java
    Given the following code fragment:
    IntStream stream = IntStream.range(1, 5);//second argument exclusive
    Stream<Integer> numbers = stream.boxed():
    Object object = numbers.collect(Collectors.partitioningBy(x-> x* 4> 10));
    System.out.println(object);// {false=[1,2], true={3,4}}

   Domain: Other
Given the code fragment:
Arrays.asList(1, 2, 3)
.stream()
.peek(System.out::print)
.allMatch(number -> number < 2);
What is the result? 12
```
- `java.util`
* [ResourceBundle](https://docs.oracle.com/javase/8/docs/api/java/util/ResourceBundle.html#getBundle-java.lang.String-java.util.Locale-)   
* [Locale](https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html)
* []()
* Converting to decimal 0b111+0_111+0x111 ? = 353