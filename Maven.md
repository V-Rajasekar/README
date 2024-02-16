# Maven
- [Maven](#maven)
  - [What is maven?](#what-is-maven)
  - [Maven works on the core concepts](#maven-works-on-the-core-concepts)
  - [Super POM](#super-pom)
  - [Parent POM and dependencyManagement](#parent-pom-and-dependencymanagement)
  - [Maven archetype](#maven-archetype)
  - [Maven Plugins](#maven-plugins)
  - [Maven Build Life Cycle](#maven-build-life-cycle)
  - [Maven Repositories](#maven-repositories)
  - [External dependencies in pom.xml](#external-dependencies-in-pomxml)
  - [Dependencies declaration with range](#dependencies-declaration-with-range)
  - [Maven scope](#maven-scope)
  - [Maven build profiles](#maven-build-profiles)
  - [Create Maven Quick start project](#create-maven-quick-start-project)
  - [Maven plugins](#maven-plugins-1)
  - [some popularly used plugins](#some-popularly-used-plugins)
    - [Parallel Test execution](#parallel-test-execution)
    - [Skipping Test](#skipping-test)
  - [Integrating with jenkins](#integrating-with-jenkins)

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

## Maven Plugins

A Maven Plugin comprises of 1...* goals.
A goal is a unit of work. It is to execute a specific task and perform certain operations for the project.
A custom actions can be included in the build process with the help of Maven Plugins.

```yml
 archetype:generate <pluginId>:<goalId>
```

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

## Create Maven Quick start project

Run below command to create a project.
`mvn archetype:generate` to search a template query the filter like webapp

`mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4`

Single command to create a maven war project interactionMode set to false, since the artifactId, groupId are already given.
`mvn archetype:generate -DgroupId=com.fresco.play -DartifactId=First-WebApp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false`

creating the war file with cmd `mvn war:war` to compile and create `mvn compile war:war`

## Maven plugins

There are two types of plugins

Build Plugin - Used while executing the build. They are included in `<build>` element of the POM.

Reporting Plugin - Used while generating the site. They are included in `<Reporting>` element of the POM.

Some of the frequently used Maven Plugins:

- `clean` - To clear target after the build.
- `compiler` - To compile the Java source code.
- `jar` - To generate Java jar file.
- `war` - To generate Java war file.
- `surefire` - To run Junit test and generate a report.

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

## Integrating with jenkins

Installed Jenkin using Docker

Jenkins is a popular open-source automation server that can help you with continuous integration and delivery of your software projects. To install Jenkins with Docker and mount a volume for /var/jenkins_home, you can follow these steps:

Install Docker on your host machine if you haven’t already. You can find the instructions for your operating system here.

1. Pull the official Jenkins image from Docker Hub by running this command in your terminal: `docker pull jenkins/jenkins:lts`
2. Create a Docker volume to store your Jenkins data by running this command: `docker volume create jenkins_home`
3. Run a Jenkins container using the image and volume you created by running this command: `docker run -d -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home --name jenkins jenkins/jenkins:lts`
4. Access your Jenkins instance by opening your browser and navigating to `http://localhost:8080`. You will be prompted to unlock Jenkins using an initial password that you can find in the logs of your container. You can view the logs by running this command: `docker logs jenkins`
5. Follow the post-installation setup wizard to customize Jenkins with plugins and create the first administrator user.