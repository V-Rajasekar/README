# Implementing the Resilence4j 

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
# Running spring boot application with profile 
Go to the Application run configuration set the following environment variable here local is the profile names.
`SPRING_PROFILES_ACTIVE=local`

# Java Timestamp

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


```


