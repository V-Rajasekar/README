- [Implementing the Resilence4j](#implementing-the-resilence4j)
- [Running spring boot application with profile](#running-spring-boot-application-with-profile)
- [Java Timestamp](#java-timestamp)
- [CRON Expression](#cron-expression)
- [Query to kill Ideal connections](#query-to-kill-ideal-connections)
- [Loading resource files in spring boot test](#loading-resource-files-in-spring-boot-test)
- [Logging](#logging)
- [Utility code to scrap selected lines](#utility-code-to-scrap-selected-lines)

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
