# Spring Boot - API
## Securing Apps.
Spring Security can be broadly classified as

- Authentication
- Authorization

Spring Security architecture distinguishes both authentication and authorization.    

### Authentication

The interface defined for Authentication is `Authentication Manager`. This is a single method Interface.

```
    public interface AuthenticationManager {
    Authentication authenticate(Authentication authentication)
        throws AuthenticationException;
    }
```

### Securing Microservices
Below are the few techniques for securing Microservices.

- HTTP Basic - Client is authenticated with User Names and Password. UserName and password are sent to the service for authentication using base 64 encoding. Samle template `Authorization: Basic QWxhZGRghsgdhsVuIHNlc2FtZQ==`
  * HTTP Digest technique is also similar to Basic Authentication.
  * User ID and password are sent as a checksum of username and password.
  * Both HTTP Basic and Digest technique are weak in terms of providing a secured one.
- X509 SSL Certificates - Authentication with a certificate for a secured protocol.
  * You need to use SSL/TLS encryption techniques to overcome the security challenge.
  * SSL/TLS encryption prevents man in the middle attacks.
- OAuth - This technique is used to authorize applications to access information without giving them passwords.
- OAuth 2.0 is a protocol by which users will be allowed to access the resources through third-party services exposed by Facebook, Google, Microsoft, etc.
- OAuth 2.0 uses SSL to ensure that the data is highly secured.
- These services expose partial data and keep the users' details protected.

### Building a Basic Authentication
Step: 1 Add security dependencies in `pom.xml`   

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-test</artifactId>
    <scope>test</scope>
</dependency>
```
Step 2: Adding `AuthenticationEntryPoint` class   
```java
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
      throws IOException, ServletException {
        response.addHeader("LoginUser", "Basic " +getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authEx.getMessage());
    }
	@Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("springboot");
        super.afterPropertiesSet();
   }
}
```
Step 3: Add a 'SpringSecurityConfig' config class to configure authorization.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.anyRequest().authenticated()
				.and().httpBasic()
				.authenticationEntryPoint(authEntryPoint);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("username").password("password").roles("USER");
	}
}
```
## Consuming REST Services
Spring provides REST template methods to consume REST services 

```java
GET 
getForObject(java.lang.String, java.lang.Class<T>, java.lang.Object...)
getForEntity(java.lang.String, java.lang.Class<T>, java.lang.Object...) 
POST
postForLocation(java.lang.String, java.lang.Object, java.lang.Object...)
postForObject(java.lang.String, java.lang.Object, java.lang.Class<T>, java.lang.Object...)
DELETE
delete(java.lang.String, java.lang.Object...)
HEAD
headForHeaders(java.lang.String, java.lang.Object...)
Any Request type
exchange(java.lang.String, org.springframework.http.HttpMethod, org.springframework.http.HttpEntity<?>, java.lang.Class<T>, java.lang.Object...)
execute(java.lang.String, org.springframework.http.HttpMethod, org.springframework.web.client.RequestCallback, org.springframework.web.client.ResponseExtractor<T>, java.lang.Object...)
```
### Building REST service consumer 

```xml
<!-- Adding dependencies for retrieving response entity as a JSON object. -->
<dependency>
		<groupId>org.json</groupId>
		<artifactId>json</artifactId>
</dependency>
```

```java

@SpringBootApplication
public class RestBooksApi {
	static RestTemplate restTemplate;
	
	public RestBooksApi(){
		restTemplate = new RestTemplate();
	}
	
	public static void main(String[] args)  {
		SpringApplication.run(RestBooksApi.class, args);
		try {
			JSONObject books=getEntity();
		System.out.println(books);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * get entity
	 * @throws JSONException 
	 */
	public static JSONObject getEntity() throws Exception{
		JSONObject books = new JSONObject();
		String getUrl = "https://www.googleapis.com/books/v1/volumes?q=isbn:0747532699";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Map> bookList = restTemplate.exchange(getUrl, HttpMethod.GET, entity, Map.class);
		if (bookList.getStatusCode() == HttpStatus.OK) {
			books = new JSONObject(bookList.getBody());
		}
        return books;
	}

}

```

## Testing Spring Boot Apps
### Data Repository - Unit Testing
You need to add @DataJpaTestannotation with which you can inject TestEntityManager bean.

Here is a sample class.

```java
@RunWith(SpringRunner.class)
@DataJpaTest
public class HospitalRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Test
    public void testFindById() {
        entityManager.persist(new Hospital(1003,"Vcare Hospital","Mumbai",3.1));
        Hospital hosp = hospitalRepository.findOne(1003);
        assertEquals("Vcare Hospital", hosp.getName());
   }
}
```
### MVC Controller - Unit Testing 

```java
@SpringBootTest
@RunWith(SpringRunner.class)
public class HospitalControllerTest {
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;
    @Before
    public void setup() {
    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
	@Test
	public void retrievetest_ok() throws Exception {
		 mockMvc.perform(get("/test/hospitals/1000" )).andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1000))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test Hospital"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rating").value(3.8))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Chennai"));
	}
```

### Integration Testing 
```java
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment)
public class CreateClientIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void createClient() {
        ResponseEntity<Client> responseEntity =
            restTemplate.postForEntity("/test/hospitals", new Hospital(1,"Test hospital","Chennai",3.9), Hospital.class);
        Hospital hosp = responseEntity.getBody();
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Test hospital", hosp.getName());
    }
}
```
### Spring Boot - Logging
By default, Spring Boot uses `Logback` to logging.Any starter added to the project comes with `spring-boot-starter-loggging` configured by default.  

Any configuration on Logback logging has to be done in `application.yml`

Few Configurations:-    
- logging.level.: This is used to set the log level.
- logging.file  : This is used to add a logging file name where you want your logs to be added.
- logging.path  : This property is used to configure the log file path. Spring boot adds a default file spring.log
- logging.pattern.console: This property is used to define logging pattern in the console.
- logging.pattern.file: This property is used to add logging pattern to a file.
- logging.pattern.level: This property is used to define the format to render log level. The default value is %5p.

#### Spring Boot - Template Engines
Template Engines helps us to consume static templates in your application.   
Below is the list of template engines that can be used with Spring Boot application.
- `Thymeleaf`: `spring-boot-starter-thymeleaf` add in pom.xml
- `Groovy`: `spring-boot-starter-groovy-templates` add in pom.xml to generate Spring MVC views.
- `FreeMarker` `spring-boot-starter-freemarker` add in pom.xml

### Spring Boot - Caching 
Spring Boot enables auto-configuration for Caching.
```java
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component;
@Component
public class RatingService {
   @Cacheable("premium")
    public int computePremium(int rate) {
        // ...
    }
}
```
- List of cache providers supported by Spring Boot.
Generic, JCache (JSR-107) (EhCache 3, Hazelcast, Infinispan, etc.), EhCache 2.x, Hazelcast

Infinispan, Couchbase, Redis, Caffeine, Guava (deprecated), Simple

### Messaging

Spring Framework offers `JMSTemplate` to async messaging with JMS API.

You can also auto-configure `RabbitTemplate` and `RabbitMQ` using Spring Boot Auto Configuration feature.

Spring Boot also has features for `STOMP messaging`.

### Spring Initializr

The Quickest and Easiest way to bootstrap your application is by using [Spring Initializr](http://start.spring.io/).

### Spring Batch

Spring Batch is a `lightweight` framework that can quickly run scheduled jobs.

This framework also provides additional features such as logging, transaction management, job statistics, etc.

Spring Batch jobs can be `easily scaled up` by executing job steps in parallel as well as multiple threads in parallel.
