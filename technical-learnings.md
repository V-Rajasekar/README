- [Implementing the Resilence4j](#implementing-the-resilence4j)
- [Running spring boot application with profile](#running-spring-boot-application-with-profile)
- [Java Timestamp](#java-timestamp)
- [CRON Expression](#cron-expression)
- [Query to kill Ideal connections](#query-to-kill-ideal-connections)
- [Loading resource files in spring boot test](#loading-resource-files-in-spring-boot-test)
- [Logging](#logging)
- [Utility code to scrap selected lines](#utility-code-to-scrap-selected-lines)
- [How to use optimistic locking?](#how-to-use-optimistic-locking)
- [CouchBase Resources](#couchbase-resources)
- [Publish Kafka messages via Tools for Apacke Kafka](#publish-kafka-messages-via-tools-for-apacke-kafka)
- [SQL Fundamentals](#sql-fundamentals)
- [Useful resources](#useful-resources)
  

## Implementing the Resilence4j 

|Title| Reference|
|---|---|
|Resilience 4j Implementation|`https://github.com/bring/ph-oem-consignment-consumer-v1/pull/104/files`|
|Application log level change|curl 'http://localhost:9091/actuator/loggers/org.springframework' -i -X POST -H 'Content-type: application/json' -d '{"configuredLevel":"debug"}'|
| provide more fine-grain details on the general health of application|management.endpoint.health.show-details=always|
|provide access to other actuator endpoints in your Spring Boot projects|management.endpoints.web.exposure.include=health,metrics,* |
|Which interface do you implement to create custom health indicators?|By implementing the HealthIndicator class and adding the @Component annotation, Spring Boot will pick this up a runtime and add it to the standard actuator/health endpoint.|
|Debug JPA QUERY|  
```
logging:
  level:
    org.hibernate:
        SQL: DEBUG
        type.descriptor.sql: trace
        orm.jdbc.bind: trace
```       
## Running spring boot application with profile 
Go to the Application run configuration set the following environment variable here local is the profile names.
`SPRING_PROFILES_ACTIVE=local`

## Java Timestamp

![image](https://user-images.githubusercontent.com/75798528/233641077-f259628a-f9fe-41cf-b314-17d20c588c41.png)

```java
//Changing offsetDateTime(CET) to OffsetDateTime(UTC) 
OffsetDateTime expectedDateTime = OffsetDateTime.parse("2021-02-08T00:25:18+01:00");
        OffsetDateTime expectedDateTimeInUTC =
                expectedDateTime.toZonedDateTime().toInstant().atOffset(ZoneOffset.UTC);
//Changing SQLTimestamp to OffsetDateTime in UTC
java.sql.TimeStamp timeStampSource =  Timestamp.valueOf(LocalDateTime.now());
timestampSource.toInstant().atOffset(ZoneOffset.UTC);
//XML Gregorian to OffsetDateTime in UTC
xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toInstant().atOffset(ZoneOffset.UTC)

import java.time.ZonedDateTime;
//Gives the ZonedDateTime gives datetime with Offset+ZonedId.
ZonedDateTime currentZoneDateTime = ZonedDateTime.now();
currentZoneDateTime ==> 2023-04-26T13:52:20.666555+05:30[Asia/Calcutta]

System.out.println("the current zone is "+currentZoneDateTime.getZone());
the current zone is Asia/Calcutta

ZoneId oslo = ZoneId.of("Europe/Oslo");
europeZoneId ==> Europe/Oslo
ZonedDateTime osloZone =  currentZoneDateTime.withZoneSameInstant(oslo);
osloZone ==> 2023-04-26T10:22:20.666555+02:00[Europe/Oslo]

import java.time.format.*;
DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
format ==> Value(DayOfMonth,2)'-'Value(MonthOfYear,2)'-'Valu ... ':'Value(SecondOfMinute,2)
osloZone.format(format);
$11 ==> "26-04-2023 10:22:20"

## Gregorian calendar
//Creating Gregorian calendar instance  
import javax.xml.datatype.*;
DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString());
$14 ==> 2023-04-26

DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDateTime.now().toString());
$15 ==> 2023-04-26T14:08:41.649196

DatatypeFactory.newInstance().newXMLGregorianCalendar(OffsetDateTime.now().toString());
$16 ==> 2023-04-26T14:10:02.203479200+05:30


```
## CRON Expression

The order of the six fields in Azure is: `{second} {minute} {hour} {day} {month} {day of the week}.`
For an example, a CRON `0 */5 * * * *`
Special character "*" every value, `1,3` in the day of the week field means just Mondays(day 1) and Wednesdays (dy 3), '10-12' hours range [10,11,12], "*/10" increment of every 10 mins   

## Query to kill Ideal connections
```sql
SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE pid <> pg_backend_pid() AND state in ('idle');
```
## Loading resource files in spring boot test
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
```java
 protected String loadInputMessageTextFile(String fileName) throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        File resource = resourceLoader.getResource("classpath:data/" + fileName).getFile();
        return new String(Files.readAllBytes(resource.toPath()), StandardCharsets.UTF_8);
    }
```
## Logging 
[Logback structured logging](https://www.innoq.com/en/blog/2019/05/structured-logging/)

## Utility code to scrap selected lines

```java
/**
* Utility method to do selective line and print only the repo name 
* var s = "bring/ph-oem-eve-synthetic-event-producer-batch-v1 · service/build.gradle"; 
**/
 static void writeToConsoleWithNewBuffer(Path src) throws IOException {
        Set<String> repos = new TreeSet<>();
              try (var reader = Files.newBufferedReader(src, StandardCharsets.UTF_8)) {
                
                String s;
                while ((s = reader.readLine()) != null) {
                    if (s.startsWith("bring/")) {
                        repos.add(s.split(" ", 2)[0]);
                    }
               }
               for (String repos2 : repos) {
                System.out.println(repos2);
               }
        }
    }
```
## How to use optimistic locking?

[optimistic-locking-version-property-jpa-hibernate-sample](https://github.com/V-Rajasekar/bax-interview-assignment-master)

## CouchBase Resources

- https://docs.couchbase.com/java-sdk/current/hello-world/start-using-sdk.html
- https://www.youtube.com/watch?v=MrgNH2Zt6mQ
- https://www.youtube.com/watch?v=u8Q07O7aePU
- https://docs.couchbase.com/java-sdk/3.5/howtos/kv-operations.html#document-expiration
- https://github.com/couchbase/docs-sdk-java/blob/da7167f6b77c4e3a8f3998bab558976520711c6b/modules/howtos/examples/KvOperations.java#L196-L197
  
## Publish Kafka messages via Tools for Apacke Kafka
- [Tools for Apacke Kafka ](https://marketplace.visualstudio.com/items?itemName=jeppeandersen.vscode-kafka)
- Create a file kafka-producer.kafka and copy past the below content to publish messages to a topic.
```yml

PRODUCER todo-topic-message
topic: todos-topic
key: BuyMilk
{ "name" : "Buy milk", "completed" : false }
```
## SQL Fundamentals
- [SQL Fundamentals notes and Slides](https://github.com/thomasnield/oreilly_sql_fundamentals_for_data/tree/master/notes_and_slides)

## Architecture performance scaling

![image](https://github.com/user-attachments/assets/ab1e63e3-2f53-4c8e-88cc-23eba1f2749b)

Scalability

What is Vertical Scaling? 
- Adding more resources (CPU, RAM, storage) to a single server
- Improves the capacity of a single machine
- Example: Uprading a server from 16 GB RAM to 64 GB  Ram

Pros
- Simple to implement and manage
- No changes required to the application architecture.
- Suitable for monolithic applications.
Cons
- Limited by hardware capacity.
- Single point of failure.
- Downtime may be required for upgrades.

When to use
- Suitable for smaller systems or monolithic applications.
- When simplicity and quick upgrades are required.

What is Horizontal Scaling?
- Adding more servers or nodes to distribute the workload.
- Increase the system's capacity by scaling out.
- Example: Adding more servers to a load-balance cluster

Pros
 - Better fault tolerance and redundancy.
 - Virtually unlimited scalability
 - No downtime during scaling
Cons
 - More complex to implement and manage.
 - Requires changes to application architecture(e.g, stateless design)
 - Higher operationsl costs due to multiple servers.
When to use
 - Ideal for large-scale, distributed systems.
 - When high availability, fault tolerance, and scalability are crticial.

### Rate Limiting
![Screenshot 2025-06-12 at 10 55 14](https://github.com/user-attachments/assets/95881f7a-332c-422d-adaf-cc26f7269b80)


## Useful resources
- [linux-file-permissions-explained](https://www.redhat.com/en/blog/linux-file-permissions-explained)
