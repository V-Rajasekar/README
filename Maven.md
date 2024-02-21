# Maven
- [Maven](#maven)
  - [What is maven?](#what-is-maven)
  - [Maven works on the core concepts](#maven-works-on-the-core-concepts)
  - [Super POM](#super-pom)
  - [Parent POM and dependencyManagement](#parent-pom-and-dependencymanagement)
  - [Maven archetype](#maven-archetype)
  - [Maven Build Life Cycle](#maven-build-life-cycle)
  - [Maven Repositories](#maven-repositories)
  - [External dependencies in pom.xml](#external-dependencies-in-pomxml)
  - [Dependencies declaration with range](#dependencies-declaration-with-range)
  - [Maven scope](#maven-scope)
  - [Maven build profiles](#maven-build-profiles)
    - [Application profiles](#application-profiles)
  - [Create Maven Quick start project](#create-maven-quick-start-project)
  - [Maven plugins](#maven-plugins)
  - [some popularly used plugins](#some-popularly-used-plugins)
    - [Parallel Test execution](#parallel-test-execution)
    - [Skipping Test](#skipping-test)
  - [Integrating with Sonar](#integrating-with-sonar)
  - [Integrating with jenkins](#integrating-with-jenkins)
  - [Repository manager (Nexus)](#repository-manager-nexus)
    - [How to use local repository manager](#how-to-use-local-repository-manager)
  - [Plugins](#plugins)
    - [Creating custome plugin](#creating-custome-plugin)
  - [Properties](#properties)
    - [Different properties](#different-properties)
    - [How to see all available properties](#how-to-see-all-available-properties)
    - [project properties](#project-properties)
    - [System and Java properties](#system-and-java-properties)

## What is maven?

Maven is a build automation tool  to compile, build, test and package your application to an executable
arch jar.

## Maven works on the core concepts

POM Project Object Model: Its a XML represenation of the project where all the dependencies, and configuration details are stored.
Its build process composed of many build life cycle, and each cycle can contain one more phase and each phase can contain one or more goals.
Downloads dependencies from local, central or remote repository.
Build plugin add custom actions to be done during the build process  

## Super POM

Super POM: Super POM is a view-only POM to see the entire attributes of all the dependencies spanning across multiple POMs. By default, all POMs will inherit Super POM settings. However, these settings can be overridden if necessary.

`mvn help:effective-pom` cmd to view the super pom.

## Parent POM and dependencyManagement
In a multimodule project a parent pom is created with maven coordinates like below with the packaging type as pom.

```xml
	<groupId>com.bharath.product</groupId>
	<artifactId>productparent</artifactId>
	<version>1.0</version>
	<packaging>pom</packaging>
	<name>productparent</name>
```

DependencyManagment and Plugin Management helps with consistency with the dependency version and plugin version used across the project or at organization level.
- Not just the plugin, but the configurations can be put in common place
- But we still have to mention the dependency, and plugin, but the version and configuration not required.

```xml
<!-- under project root-->
  <dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>junit</groupId>
				<artifactId>junit</artifactId>
				<version>4.4</version>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<pluginManagement>
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.2</version>
					<configuration>
						<source>1.8</source>
						<target>1.8</target>
					</configuration>
				</plugin>
			</plugins>
		</pluginManagement>
  </build>
```


## Maven archetype

 Maven has many build-in archetype and it can be used to create the Project Folder using  `mvn archetype:generate`
 GroupId,artifactId and version combination are used to identify an artifact uniqly.

## Maven Build Life Cycle

Maven comes with a default life cycle. The practice for building and distributing a project (artifact) is defined comprehensibly in the build life cycle.

Build life cycle constitutes different build phases.

Each build phase has its own build goals. See below the different build phases when mvn install is called and each phase will have their own plugins and goals. It is the goals which does the job.

**Maven runs all the life cycle phases before the phase that is being executed**

```html

   phases                goals
 -------------         ------------- 
 process-resources   resources:resources
      \                     \
   compile            compiler:compiler
      \                      \
     test             surefire:test
       \                      \
   packages                 jar:jar
```

when running the mvn command you can use the phases or the plugins with goals (e.g) mvn surefire:test will run all the goals prior to this goal associated with it.

A goal is a unit of work in the build process.

Maven has three built-in build lifecycles:

- default - supports project deployment (compiling and packaging)
- clean - supports project cleaning (removal of previous jar files, temp files, source files etc.)
- site - supports project's site documentation.

Following are the default phases of each build life cycle:

- validate - checks if the project is correct and all information is available.
- compile - compiles the source code in binary artifacts.
- test - executes the tests.
- package - takes the compiled code and packages it as, a war or jar or an ear file.
- integration-test - takes the packaged result and executes additional tests required for packaging.
- verify - checks if the package is valid.
- install - installs the result of the package phase into the local Maven repository.
- deploy - deploys the package to a target, i.e. a remote repository.

The correct flow of the build cycle is `validate->compile->test->package->verify->install->deploy`

Some phases have goals bound to them by default. All relevant goals associated with a phase are executed during this process.

A goal is relevant for a phase if the Maven plug-in or the pom binds this goal to the corresponding life cycle phase.

For example - By running the command compiler:compile, Maven gets the goal of compiling application sources done by using the parameters specified in POM.xml.  
![Alt text](image.png)
## Maven Repositories

- A local repository refers to the repository on a developer's computer.
- A central repository is the one that Maven community provides.
- A remote repository could be one on the web server from where the dependencies can be downloaded.

mvn dependency:copy-dependencies - downloads all the dependencies from maven central repo and downloads to local and build target.
mvn dependency:tree view the dependencies and its transtive dependencies.
<optional>true</optional> tells maven not to download this dependencies, when downloading other tramstive dependencies
<https://search.maven.org/> official maven repository.

## External dependencies in pom.xml

At times, the jar files to be added as project dependency might reside outside the Maven repository. These can also be added as an external dependency in POM.xml file. Very important is scope=system.

<dependency>
  <groupId>mydependency</groupId>
  <artifactId>mydependency</artifactId>
  <scope>system</scope>
  <version>1.0</version>
  <systemPath>${basedir}\war\WEB-INF\lib\frescoplay-gems.jar</systemPath>
</dependency>

## Dependencies declaration with range

Dependencies Version as Greater than Range
Dependency Range for JUnit will be specified as: JUnit > 3.8
We can define using Exclusive quantifiers boundary, denoted as (, ]
<dependency>
    <groupId>junit</groupId>
     <artifactId>junit</artifactId>
     <version>(3.8,]</version>
     <scope>test</scope>
</dependency>
Dependency Range for Junit will be specified as: JUnit 3.8 to JUnit 4.0
<dependency>
       <groupId>junit</groupId>
    <artifactId>junit</artifactId>
       <version>[3.8,4.0)</version>
       <scope>test</scope>
</dependency>
What does the dependency range [2.0.7, 2.0.9) mean? 2.0.7,2.0.8
Inclusive quantifiers boundary range is defined as[,3.8] <=3.8

## Maven scope
There are 6 scope values you can provide: `compile, runtime, provided, test, system, and import`.
Below is scope and in they are used in maven build cycle where its used.
- compile (default) -> build, test, run
- provide -> test, run and not required to be exported in package(war, jar). (e.g) servlet-api dependencies
- runtime -> test, and run
- test -> compile and run tests (Junit) not required for source files
- system libraries which are not pulled from the maven repo, and not provided by the web container then we use the system scope those externalDependence jar files can be mentioned using 
- <systemPath> ${basedir}\war\WEB-INF\lib\ext\Dependency.jar
import -> pom based project


## Maven build profiles

There are three types of profiles

- Global profile View Effective POM to see the global profile configurations
- Local profile resides in D:\apache-maven-3.9.6\conf\settings.xml
- User defined profile resides in C:\Users\Raj\.m2\settings.xml

### Application profiles
For Application **portability** between the environments dev, test and production maven profiles are used. Based on the requested profile the maven pick up the configurations and apply before running the application

```html
src/main/profiles
    dev
      application.properties
    test
     application.properties
    prod     
     application.properties
```

Building the project with the profile > `mvn install -Pprod` //-P profile followed by profile name.

## Create Maven Quick start project

Run below command to create a project.
`mvn archetype:generate` to search a template query the filter like webapp

`mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4`

Single command to create a maven war project interactionMode set to false, since the artifactId, groupId are already given.
`mvn archetype:generate -DgroupId=com.fresco.play -DartifactId=First-WebApp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false`

creating the war file with cmd `mvn war:war` to compile and create `mvn compile war:war`

## Maven plugins

A Maven Plugin comprises of 1...* goals.
A goal is a unit of work. It is to execute a specific task and perform certain operations for the project.
A custom actions can be included in the build process with the help of Maven Plugins.

```yml
 archetype:generate <pluginId>:<goalId>
```

There are two types of plugins

Build Plugin - Used while executing the build. They are included in `<build>` element of the POM.

Reporting Plugin - Used while generating the site. They are included in `<Reporting>` element of the POM.

Some of the frequently used Maven Plugins:

- `clean` - To clear target after the build.
- `compiler` - To compile the Java source code.
- `jar` - To generate Java jar file.
- `war` - To generate Java war file.
- `surefire` - To run Junit test and generate a report.
- `jacoco-maven-plugin` - To prepare and generate code coverage report.

## some popularly used plugins

- `exec-maven-plugin` mvn exec:java
- `maven-compiler-plugin` plugin to compile source code with defined java versions
- `maven-surefire-plugin`  used for generating unit test reports for your project. `mvn surefire-report:report`
_Note:_ using the appropriate Junit dependency with the maven-surefire-plugin enables different execution mechanism 
Junit 4.7.x - parallel and below in sequential.

```xml
  <plugin>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.3</version>
    <configuration>
      <source>1.8</source>
      <target>1.8</target>
    </configuration>
  </plugin>
  <!-- mvn exec:java runs the app without building the jar-->
  <plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>1.2.1</version>
    <configuration>
      <mainClass>com.fresco.play.App</mainClass>
    </configuration>
  </plugin>
  <plugin>
    <groupId>org.jacoco</groupId>
      <artifactId>jacoco-maven-plugin</artifactId>
      <version>0.8.11</version>
      <executions>
          <execution>
              <goals>
                  <goal>prepare-agent</goal>
              </goals>
          </execution>
          <execution>
              <id>generateReport</id>
              <phase>test</phase>
              <goals>
                  <goal>report</goal>
              </goals>
          </execution>
      </executions>
  </plugin>
```

### Parallel Test execution

- Use this plugin config to run parallel method execution from version Junit 4.7
  
```xml
 <plugin>
        <groupId>org.apache.maven.plugins</groupId>
       <artifactId>maven-surefire-plugin</artifactId>
       <version>2.20</version>
      <configuration>
            <parallel>methods</parallel>
            <threadCount>10</threadCount>
     </configuration>
  </plugin>
```

- Plugin to generate the report

```xml
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-report-plugin</artifactId>
    <version>3.0.0-M5</version>
  </plugin>
```  
  

### Skipping Test

To skip the test in command line use mvn install -DskipTests same can be achieved by configuring the `<skipTests>true</skipTests>` in maven-surefire-plugin

To skip the compilation mvn install -Dmaven.test.skip=true configuring in maven-surefire-plugin will also achieve the same  <skipTests>${skipTests}</skipTests>

mvn clean test -fn surefire-report:report 

-Dsurefire.junit4.upgradecheck

## Integrating with Sonar

1. Download sonar community edition from https://www.sonarsource.com/
2. run \bin\windows-x86-64/sonar.bat soon you will sonar running in http://localhost:9000
3. Configure the maven settings.xml
   a) Add plugin group in pluginGroups section
     
      ```xml
      <pluginGroups>
          <pluginGroup>org.sonarsource.scanner.maven</pluginGroup>
      </pluginGroups>
    ```
   
   b) Add sonar profile
    
    ```xml
      <profile>
        <id>sonar</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
                <!-- Optional URL to server. Default value is http://localhost:9000 -->
                <sonar.host.url>
                  http://localhost:9000
                </sonar.host.url>
            </properties>
      </profile> 
    ```
    c) Generate Sonar token: Go to Sonar link Security->Users(select admin user)->Tokens
4. Generating sonar report by running `mvn clean verify sonar:sonar -Dsonar.login=$SONAR_TOKEN`
 
## Integrating with jenkins

 
Installed Jenkin using Docker

Jenkins is a popular open-source automation server that can help you with continuous integration and delivery of your software projects. To install Jenkins with Docker and mount a volume for /var/jenkins_home, you can follow these steps:

Install Docker on your host machine if you haven’t already. You can find the instructions for your operating system here.

1. Pull the official Jenkins image from Docker Hub by running this command in your terminal: `docker pull jenkins/jenkins:lts`
2. Create a Docker volume to store your Jenkins data by running this command: `docker volume create jenkins_home`
3. Run a Jenkins container using the image and volume you created by running this command: `docker run -d -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home --name jenkins jenkins/jenkins:lts`
4. Access your Jenkins instance by opening your browser and navigating to `http://localhost:8080`. You will be prompted to unlock Jenkins using an initial password that you can find in the logs of your container. You can view the logs by running this command: `docker logs jenkins`
5. Follow the post-installation setup wizard to customize Jenkins with plugins and create the first administrator user.

## Repository manager (Nexus)

You can create your own repository manager in local by using Nexus. Here we follow the steps to setup one

1. Download and run nexus container: `docker run -d -p 8081:8081 --name nexus sonatype/nexus3`
2. Get the admin password by logging into the system `docker exec -it nexus /bin/bash`, then followed by the file storing the password `cat /nexus-data/admin.password`
3. Login to http://localhost:8081

There are three types of repositories

- `proxy` it acts a proxy to maven central, pulls the dependencies from central repository and cache it
- `hosted`  repository for your local artifacts
- `group` this is a group of repositores. you can group multiple repositories in a single group.(e.g) `http://localhost:8081/repository/maven-public/` this is a single URL to maven-release, maven-snapshot, maven-central

### How to use local repository manager

`mvn deploy`  deploy plugin is primarily used during the deploy phase, to add your artifact(s) to a remote repository for sharing with other developers and projects. This is usually done in an integration or release environment. It can also be used to deploy a particular artifact. As a repository contains more than the artifacts (POMs, the metadata, MD5 and SHA1 hash files...), deploying means not only copying the artifacts, but making sure all this information is correctly updated.

The maven deploy plugins for the following configuration your project `pom.xml` and `settings.xml` ensure the repository id in the pom.xml and settings.xml are the same.

```xml
  <!-- pom.xml-->
  <!-- download the dependencies from the central repo to local repo manager(Nexus)-->
    <repositories>
        <repository>
            <id>maven-group</id>
            <url>http://localhost:8081/repository/nexus-group/</url>
        </repository>
    </repositories>
    <!-- Deploy your artifacts to the local repositories-->
    <distributionManagement>
        <snapshotRepository>
            <id>nexus-snapshots</id>
            <url>http://localhost:8081/repository/maven-snapshots/</url>
        </snapshotRepository>
        <repository>
            <id>nexus-releases</id>
            <url>http://localhost:8081/repository/maven-releases/</url>
        </repository>
    </distributionManagement>

      <!-- settings.xml-->
    <servers>
      <server>
        <id>nexus-snapshots</id>
        <username>admin</username>
        <password>admin123</password>
      </server>
      <server>
        <id>nexus-releases</id>
        <username>admin</username>
        <password>admin123</password>
      </server>
    </servers>
    <mirrors>
      <mirror>
        <id>central</id>
        <name>central</name>
        <url>http://localhost:8081/repository/nexus-group/</url>
        <mirrorOf>central</mirrorOf>
      </mirror>
    </mirrors>
```
## Plugins

Maven is lightweigh and it uses the plugins to do compile, test, verify and deploy the project. Some predefined plugins are compile, test, deploy, jar, war. [Maven Plugins](#maven-plugins)

### Creating custome plugin

1. `mvn archetype:generate` filter with name `maven-archetype-plugin` choose  `org.apache.maven.archetypes:maven-archetype-plugin`

2. Fill project artifact details

  ``` 
    Define value for property 'groupId': com.raj
    Define value for property 'artifactId': projectinfo-maven-plugin
    Define value for property 'version' 1.0-SNAPSHOT: : 1.0.0-SNAPSHOT
    Define value for property 'package' com.raj: :
  ```

3. Add following dependencies and plugin in pom.xml

```xml
<dependencies>
	<dependency>
		<groupId>org.apache.maven</groupId>
		<artifactId>maven-plugin-api</artifactId>
		<version>${maven-plugin-api.version}</version>
	</dependency>
	<dependency>
		<groupId>org.apache.maven.plugin-tools</groupId>
		<artifactId>maven-plugin-annotations</artifactId>
		<version>${maven-plugin-annotations.version}</version>
		<scope>provided</scope>
	</dependency>
	<dependency>
		<groupId>org.apache.maven</groupId>
		<artifactId>maven-project</artifactId>
		<version>${maven-project.version}</version>
	</dependency>
</dependencies>
<build>
	<pluginManagement>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-plugin-plugin</artifactId>
				<version>${maven-plugin-plugin.version}</version>
			</plugin>
		</plugins>
	</pluginManagement>
</build>
<properties>
	<maven-plugin-api.version>3.6.2</maven-plugin-api.version>
	<maven-plugin-annotations.version>3.6.0</maven-plugin-annotations.version>
	<maven-project.version>2.2.1</maven-project.version>
	<maven-plugin-plugin.version>3.6.4</maven-plugin-plugin.version>
	<maven.compiler.source>16</maven.compiler.source>
	<maven.compiler.target>16</maven.compiler.target>
	<java.version>16</java.version>
</properties>
```

- Implement Mojo class
- All Plugin Mojo class should extend AbstractMojo and override the execution method. 
- the mojo name is the plugin artifact name, you can specify the defaultPhase when to call this plugin in Compile, test, deploy...
- when unexpected exception happens throw MojoExecutionException is thrown.
- when build error happens throw MojoFailureException.

```java
@Mojo(name = "info-renderer", defaultPhase = LifecyclePhase.COMPILE)
public class ProjectInfoMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject proj;

    //passing custom properties
    @Parameter(property = "scope")
    String scope;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        //get access to maven log and logging
        getLog().info("Mojo are cool!");
        getLog().info("Project Name: " + proj.getName()+ " Artifact Id: " + proj.getArtifact()) ;
         List<Dependency> dependencies = proj.getDependencies();
         dependencies.forEach(d -> getLog().info(d.toString()));

        System.out.println("Print dependencies in scope:"+ scope);
        dependencies.stream().filter(d -> d.getScope() != null && d.getScope().equalsIgnoreCase(scope))
                .forEach(d ->  getLog().info(d.toString()));

    }
}
```

- Verify the plugin
  
  ```bash
    mvn clean install
    mvn com.raj:projectinfo-renderer:info-renderer
     #shortcut cmd it works when this plugin is added in the settings.xml under pluginGroups section
    mvn projectinfo:info-renderer  
  ```

  //outputs Mojo are cool!
- Using the plugin in other project
  - Use the custom plugin in other project by adding the plugin to the build, plugin segment.

```xml
<plugin>
  <groupId>com.raj</groupId>
  <artifactId>projectinfo-maven-plugin</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <executions>
    <execution>
      <goals>
        <goal>info-renderer</goal>
      </goals>
    </execution>
  </executions>
  <configuration>
    <scope>test</scope>
  </configuration>
</plugin>
```
## Properties

Maven allows us to declare and use properties in our pom.xml, Instead of hard coding a particular value. This will help us create portable builds based on a particular environment.

There are also some implicit properties that are available for every project, starting with the project details.

We can access the build directories like the source directories and output directories under the target folder.

We can access the Java system properties and also we can add our own custom properties and access them anywhere in our Pom.xml

### Different properties
Following are the different properties which can be accessed in pom.xml

```html
Project     properties project.*
Build       properties project.build.*
Java System properties os.name
customer    properties my.prop.*
```

### How to see all available properties
- Add the `maven-antrun-plugin`
Run `mvn validate` prints all the available properties in build console.
```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-antrun-plugin</artifactId>
  <version>1.7</version>
  <executions>
    <execution>
      <phase>validate</phase>
      <goals>
        <goal>run</goal>
      </goals>
      <configuration>
        <tasks>
          <echoproperties />
        </tasks>
      </configuration>
    </execution>
  </executions>
</plugin>
```

### project properties
The project properties are available through an implicit object called Project. and they can refered like ${project.artifactId}
various properties can be refered like Project -> project.*, Build directories -> project.build.*, Java System prop -> os.name, 
Custome properties -> my.prop.

project is  the instance of type `org.apache.maven.model.Model`

### System and Java properties

- [List of Java system properties](https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html)
- some of them: os.name, file.separator, java.home, java.class.path


Along with build management maven also provides which of the following for a project? Dependency management
Using which of the following does maven achieve reuse ? Plugins
Which of the following represents the type of maven project we want to create ? archetypeArtifactId
Which maven goal can be used to create a maven project from the command line? archetype:generate
Which of the following is not a maven coordinate element in the pom.xml? dependency, correct ones are groupId, artifactId, version, packaging.
Which maven plugin do we use when we create a maven project? archetype
Maven runs all the life cycle phases before the phase that is being executed? True
Which of the following parameters should be used to skip tests from the command line? -DskipTests
Maven can download the dependencies transitively? True
Which of the following scope can be used to tell maven that we do not need a dependency to be packaged in to a war that will be deployed to a container which will already have that jar/dependecy? Provided
The name of the final project artifact like jar or war is derived from which of the following in pom.xml ?  Project Coordinates(groupId, and artifactId)
The folder structure in which maven places the jars or wars in a repository is derived from the projects artifactId? false
What is the archtypeld to create a maven java web project ? maven-archetype-webapp
What is the xml element inside parent pom.ml which we define all the child modules? modules
Which of the following is not a direct child element of the profile element? resources others as direct child are id, build, properties
In a multi module maven project the packaging in the parent project pom will be? pom
This scope indicates that the dependency is not required for compilation, but is for execution ? runtime
When we use which of the following scopes we provide a path to the dependency on that  machine instead of pulling it from a maven repository? System
Which of the following is achieved through maven profiles? portability
Which of the following option can be used with a maven command to use/activate a profile? -p
Which of the following feature of spring boot uses pom.xml? Spring starters
When we use the traditional spring approach everything is automatically configured for us and the version ? false. Its in spring-boot
Which of the following staters is added as a dependency to the pom.xml when we create a simple Spring Boot Project ? spring-boot-starter
Where does the version information for the dependencies in a spring boot projects pom.xml come from? spring-boot-starter-parent
The @SpringBootApplication annotation encapsulates which of the following annotations ? `@ComponentScan, @SpringBootConfiguration,  @EnableAutoConfig`