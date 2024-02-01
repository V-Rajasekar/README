# code problems

## NumberFormat

```java
    import java.text.NumberFormat;
    double d = 1234567.890;
    import java.text.DecimalFormat;
    NumberFormat f2 = new DecimalFormat("$000,000,000.00000");
    f2.format(d); //"$001,234,567.89000"
```

## Executor Service

```java
ExecutorService service = Executors.newFixedThreadPool (3);
Callable‹String> task1 = () -> "Task completed";
Callable<String> task = 0) -> 1
throw new RuntimeException();
Callable‹String > task3 = () -> 1
Thread. sleep (10000);
return null;
var result = service.invokeAl1(List.of(task1, task2, task3));
System.out.println(result.get(0) •get());
service. shutdown);
```

<p> What happens when the ExecutorService.invokeAll method is called?
    The invokeAll method invokes all of the Callable objects in the collection passed as it's parameter. As per the Java SE
    API Specification, the invokeAll method executes the given tasks, returning a list of futures holding their status and
    results when all are complete. Future.isDone is true for each element of the returned list. Note that a completed task
    could have terminated either normally or by throwing an exception.
    In the above code fragment, taskl and task complete without delay, however task will be delayed for at least 10
    seconds as the Thread.sleep method is invoked for 10,000 ms.
    • Hence, we can see that despite taskl being completed almost immediately, its result can only be retrieved only
    after all tasks are done. As "Task completed" is printed only after task is also complete, option B is correct
</p>
