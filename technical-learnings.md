# Implementing the Resilence4j 

|Title| Reference|
|---|---|
|Resilience 4j Implementation|`https://github.com/bring/ph-oem-consignment-consumer-v1/pull/104/files`|
|Application log level change|curl 'http://localhost:9091/actuator/loggers/org.springframework' -i -X POST -H 'Content-type: application/json' -d '{"configuredLevel":"debug"}'|
| provide more fine-grain details on the general health of application|management.endpoint.health.show-details=always|
|provide access to other actuator endpoints in your Spring Boot projects|management.endpoints.web.exposure.include=health,metrics,* |
|Which interface do you implement to create custom health indicators?|By implementing the HealthIndicator class and adding the @Component annotation, Spring Boot will pick this up a runtime and add it to the standard actuator/health endpoint.|


