- [Chapter21-JDBC](#chapter21-jdbc)
    - [Introduction to Relation Database](#introduction-to-relation-database)
    - [Writing Basic SQL Statements](#writing-basic-sql-statements)
    - [Introducing the Interfaces of JDBC](#introducing-the-interfaces-of-jdbc)
    - [Connecting to a Database](#connecting-to-a-database)
    - [Getting a Database Connection](#getting-a-database-connection)
    - [Prepared Statement](#prepared-statement)
    - [Working with a _PreparedStatement_](#working-with-a-preparedstatement)
      - [Creating a _PreparedStatement_](#creating-a-preparedstatement)
      - [Executing a _PreparedStatement_ executeUpdate() for CUD](#executing-a-preparedstatement-executeupdate-for-cud)
      - [Reading Data with executeQuery()](#reading-data-with-executequery)
    - [Processing reading or update using _execute()_](#processing-reading-or-update-using-execute)
      - [Review execute method](#review-execute-method)
      - [Working with parameters](#working-with-parameters)
      - [Reading data from ResultSet](#reading-data-from-resultset)
      - [Getting Data for a Column](#getting-data-for-a-column)
      - [Using Bind Variables](#using-bind-variables)
      - [Calling a CallableStatement](#calling-a-callablestatement)
      - [Calling a Procedure:](#calling-a-procedure)
      - [Closing Database Resources](#closing-database-resources)
    - [Review Questions](#review-questions)

# Chapter21-JDBC
### Introduction to Relation Database
- JDBC stands for Java Database Connectivity.
- _Java Database Connectivity Language (JDBC)_: Accesses data as rows and columns. JDBC is the API covered in this chapter.
- _Java Persistence API (JPA):_ Accesses data through Java objects using a concept called object‐relational mapping (ORM).
- A relational database is accessed through Structured Query Language (SQL). SQL is a programming language used to interact with database records.
-  _NoSQL database_ are databases that store their data in a format other than tables, such as key/value, document stores, and graph-based databases.
### Writing Basic SQL Statements
- CRUD operation in database are performed using 4 SQL keywords INSERT, SELECT, UPDATE, DELETE.

```SQL
INSERT INTO exhibits
VALUES (3, 'Asian Elephant', 7.5);

SELECT COUNT(*), SUM(num_acres) 
FROM exhibits;

UPDATE exhibits 
SET num_acres = num_acres + .5 
WHERE name = 'Asian Elephant';

DELETE FROM exhibits
WHERE name = 'Asian Elephant';
```

### Introducing the Interfaces of JDBC
- Five key interfaces of JDBC. The interfaces are declared in the JDK. they are available in package `java.sql`
- `Driver`: Establishes a connection to the database
- `Connection`: Sends commands to a database
- `PreparedStatement`: Executes a SQL query
- `CallableStatement`: Executes commands stored in the database
- `ResultSet`: Reads results of a query

**Note:** The implementation of this interface are there in the driver jar. For an example derby, MySQL, PostgresSQL driver jar will have there own implementation for all this interface.   

### Connecting to a Database
- Building a JDBC URL
   
               Protocol Subprotocol 

   *              jdbc:postgres://localhost:5432/zoo 3
* Other examples              

    ```sql
     jdbc:postgresql://localhost/zoo
     jdbc:oracle:thin:@123.123.123.123:1521:zoo
     jdbc:mysql://localhost:3306
     jdbc:mysql://localhost:3306/zoo?profileSQL=true
    ```

### Getting a Database Connection
- Two ways to get database connection: `DriverManager` or `DataSource`
- Donot use driverManager incode rather use DataSource has it has more features like pool connections or store the database connection information outside the application.
- DriverManager is a class in JDK, use factory pattern(static method) to get the connection.  `Connection conn = DriverManager.getConnection("jdbc:derby:zoo");`
- Exception in thread "main" java.sql.SQLException: No suitable driver found for jdbc:derby:zoo is thrown when the driver jar is not on the classpath.
- Another implementation with credentials passed to the connection call.
```java
Connection con = DriverManager.getConnection(
         "jdbc:postgresql://localhost:5432/ocp-book",
         "username",
         "Password20182");
```
### Prepared Statement
- `java.sql.PreparedStatement` is a precompiled SQL statement. It is used to execute all SQL operations. It can executed multiple times by passing different parameter to the substitute questions marks in the statement.
- The prepared statement is automatically closed if declared within the try-with-resource-statment.
- Executing parameterized queries with prepared statement prevents the SQL injection attacks.  
  
### Working with a _PreparedStatement_
- Class hierarchy of Statement
 * PreparedStatement and CallableStatement are the sub interface of Statement.
```
                Statement
                    |
       |------------  ----------------- |      
  PreparedStatement     CallableStatement     
```  
 *  A `PreparedStatement` allows you to set the values of bind variables. A `CallableStatement` also allows you to set `IN, OUT, and INOUT` parameters.
 * Difference b/w Statement and PreparedStatement(PS) is PS takes parameter, and statement doesn't take it. Prepare Statement is prefered over statement for the following reasons.
  - **Performance**: `PreparedStatement` figures out a  plan to run the SQL well and remembers it. Future reusability
  - **Security**: SQL injection is prevented
  - **Readability**: No string concatenation in building a query string with lots of param

 #### Creating a _PreparedStatement_
 - Default PreparedStatement declaration
```java
    try (PreparedStatement ps = conn.prepareStatement(
   "SELECT * FROM exhibits")) {
   // work with ps
}

try (var ps = conn.prepareStatement()) { // DOES NOT COMPILE since SQL is not supplied.
}
```
- There are overloaded signatures that allow you to specify a ResultSet type and concurrency mode

#### Executing a _PreparedStatement_ executeUpdate() for CUD
`executeUpdate()` typically used to execute the prepared statement of insert, update, and delete. These methods returns the number of rows that were inserted, deleted, or changed.
```java
try (var ps = conn.prepareStatement(insertSql/updateSql/deleteSql)) {
    int result = ps.executeUpdate();
    System.out.println(result); // 1
 }
```
#### Reading Data with executeQuery()
- Prepare statement, executeStatement using executeQuery which return resultset
```java
30: var sql = "SELECT * FROM exhibits";
31: try (var ps = conn.prepareStatement(sql);
32:    ResultSet rs = ps.executeQuery() ) {
33:
34:    // work with rs
35: }
```
### Processing reading or update using _execute()_
- execute():boolean works both on the select and DML(IUD)operation  true means resultset is present so operate on the resultSet 
```java
boolean isResultSet = ps.execute();
if (isResultSet) {
   try (ResultSet rs = ps.getResultSet()) {
      System.out.println("ran a query");
   }
} else {
   int result = ps.getUpdateCount();
   System.out.println("ran an update");
}
```
- When wrong method is used for a SQL select statement (e.g)  executeUpdate() on select then throws following error message   
  `Statement.executeQuery() cannot be called with a statement that returns a row count.`

#### Review execute method

| Method	         |Return type|	What is returned for SELECT| What is returned for DELETE/INSERT/UPDATE|
|----|----|----|----|
| ps.execute()	     |boolean	 |true|	false |
| ps.executeQuery()	 |ResultSet	 |The rows and columns returned	|n/a|
| ps.executeUpdate() |int	     |n/a | Number of rows added/changed/removed|

#### Working with parameters
```java
    14: public static void register(Connection conn, int key, 
    15:    int type, String name) throws SQLException {
    16:
    17:    String sql = "INSERT INTO names VALUES(?, ?, ?)";
    18:
    19:    try (PreparedStatement ps = conn.prepareStatement(sql)) {
    20:       ps.setInt(1, key);
    21:       ps.setString(3, name); //missing the set of parameter no 3, compiles amd get a SQLException
    22:       ps.setInt(2, type);
    23:       ps.executeUpdate(); //ps.executeUpdate(sql);  // INCORRECT passing sql in executeUpdate
    24:    }
    25: }
```
| Method    |name	|Parameter Java type	|Example database type|
|----|-----|-----|-----|
| setBoolean	    | Boolean	|BOOLEAN|
| setDouble	        | Double	|DOUBLE|
| setInt	        | Int	    |INTEGER|
| setLong	        | Long	|BIGINT|
| setObject	        | Object	|Any type |
| setString	        | String	|CHAR, VARCHAR |
- Note:- setObject() method works with any Java type. On passing primitive it will autobox to its wrapper type.

- Updating Multiple times
   *  we set all three parameters when adding Ester, but only two for Elias. The PreparedStatement is smart enough to remember the parameters that were already set and retain them.
 ```java
  var sql = "INSERT INTO names VALUES(?, ?, ?)";
 
try (var ps = conn.prepareStatement(sql)) {
 
   ps.setInt(1, 20);
   ps.setInt(2, 1);
   ps.setString(3, "Ester");
   ps.executeUpdate();
  
   ps.setInt(1, 21);
   ps.setString(3, "Elias");
   ps.executeUpdate();
}
 ```
#### Reading data from ResultSet 
```java

20: String sql = "SELECT id, name FROM exhibits";
21: Map<Integer, String> idToNameMap = new HashMap<>();
22:
23: try (var ps = conn.prepareStatement(sql);
24:    ResultSet rs = ps.executeQuery()) {
25:
26:    while (rs.next()) {
27:       int id = rs.getInt("id");
28:       String name = rs.getString("name");
29:       idToNameMap.put(id, name);
30:    }
31:    System.out.println(idToNameMap);
32: }
//outputs: {1=African Elephant, 2=Zebra}
```
- You can use index instead of supplying the column name while fetching (e.g) rs.getInt("id") -> rs.getInt(1)
- Try to read a column value 
  * Throws SQLException if the column name or index does not exists
  ```java
    var sql = "SELECT count(*) AS count FROM exhibits";
    
    try (var ps = conn.prepareStatement(sql);
    var rs = ps.executeQuery()) {
    
    if (rs.next()) {
        var count = rs.getInt("total");
        System.out.println(count);
    }
    }

    var sql = "SELECT count(*) FROM exhibits";
 
    try (var ps = conn.prepareStatement(sql);
    var rs = ps.executeQuery()) {
     // missing rs.next() the cursor is still point before the first row.   
    rs.getInt(1); // SQLException

     if (rs.next())
      rs.getInt(0); // SQLException, since column index begins with 1 
    }
  ```
- Always use an if statement or while loop when calling rs.next().
- Column indexes begin with 1.

#### Getting Data for a Column
- all primitive type(boolean, int, long, double, float, byte), Object and String have corresponding getter methods to get the data from the resultSet.
- `getObject()` to get any type of data. `Object idField = rs.getObject("id"); int id = (Integer) idField`;

#### Using Bind Variables  
- Use nested try with resources to bind variable. 
- we create the PreparedStatement on line 32. Then we set the bind variable on line 33. It is only after these are both done that we have a nested try‐with‐resources on line 35 to create the ResultSet. 
- While updating/fetching data using prepared statement, we can set NULL values to a column using the setNull() method
  * `ps.setNull(int index, int sqlType)` (e.g) ps.setNull(1, java.sql.Types.INTEGER);
  *  * ps.setNull(int index, int sqlType, String sql_name) - sql_name custom types like STRUCT, REF and ARRAY type code this is optional.
  
```java
30: var sql = "SELECT id FROM exhibits WHERE name = ?";
31:
32: try (var ps = conn.prepareStatement(sql)) {
33:    ps.setString(1, "Zebra");
34: 
35:    try (var rs = ps.executeQuery()) {
36:       while (rs.next()) {
37:          int id = rs.getInt("id");
38:          System.out.println(id);
39:       }
40:    }
41: }
```
#### Calling a CallableStatement
- A stored procedure is code that is compiled in advance and stored in the database.
- Stored procedures are commonly written in a database‐specific variant of SQL, which varies among database software providers.
- Stored procedure reduces network round-trips. However, they are database-specific and introduce complexity of maintaining your app.
- Sample Stored procedures

| Name	                 | Parameter  name  |Parameter type  |Description |
| -----------             |   -----------    |------     |----------|
| read_e_names()	        |  n/a	            |n/a	      |Returns all rows in the names table that have a name beginning with an E |
| read_names_by_letter()  | prefix	         |IN	      |Returns all rows in the names table that have a name beginning with the specified parameter |
| magic_number()	        |  Num	            |OUT	      |Returns the number 42 |
| double_number()	        |  Num	            |INOUT	   |Multiplies the parameter by two and returns that number |

#### Calling a Procedure:
- Procedure call without param
```java
12: String sql = "{call read_e_names()}";
13: try (CallableStatement cs = conn.prepareCall(sql);
14:    ResultSet rs = cs.executeQuery()) {
15:
16:    while (rs.next()) {
17:       System.out.println(rs.getString(3));
18:    }
19: }
```
- Passing an IN Parameter
```java
25: var sql = "{call read_names_by_letter(?)}";
26: try (var cs = conn.prepareCall(sql)) {
27:    cs.setString("prefix", "Z"); // other way (parameter index) cs.setString(1, "Z");
28:
29:    try (var rs = cs.executeQuery()) {
30:       while (rs.next()) {
31:          System.out.println(rs.getString(3));
32:       }
33:    }
34: }
```
- Returning an OUT Parameter
  * Line 40  ?= added for denoating the stored procedure returns output,its optional
  * Line 42 registering the `OUT` Parameter
  * Line 43 using `execute()` and not `executeQuery()` since we are not returning a resultSet
  * Line 44 retrieve the value
```java
40: var sql = "{?= call magic_number(?) }";
41: try (var cs = conn.prepareCall(sql)) {
42:    cs.registerOutParameter(1, Types.INTEGER);
43:    cs.execute();
44:    System.out.println(cs.getInt("num"));
45: }
```
- Working with an **_INOUT_** Parameter
  - An **INOUT** param act as both an IN parameter and OUT parameter.
   50: var sql = "{call double_number(?)}";  
   51: try (var cs = conn.prepareCall(sql)) {  
   52:    cs.**setInt**(1, 8);  
   53:    cs.**registerOutParameter**(1, Types.INTEGER);  
   54:    cs.**execute**();  
   55:    System.out.println(cs.getInt("num"));  
   56: }  

- **Run queries using a** _CallableStatement_. When using a `CallableStatement`, the SQL looks like { call my_proc(?)}. If you are returning a value, `{?= call my_proc(?)}` is also permitted. You must set any parameter values before executing the query. Additionally, you must call `registerOutParameter`() for any `OUT` or `INOUT` parameters.

 #### Closing Database Resources
 - “NIO.2,” it is important to close resources when you are finished with them. This is true for JDBC as well. JDBC resources, such as a Connection, are expensive to create. Not closing them creates a resource leak that will eventually slow down your program.
 - The resources need to be closed in a specific order. The ResultSet is closed first, followed by the PreparedStatement (or CallableStatement) and then the Connection.
-  Closing a `Connection` automatically closes the `Statement` and ResultSet objects. Closing a Statement automatically closes the `ResultSet` object.
-   Also, running another SQL statement closes the previous `ResultSet` object from that `Statement`.
 * Always create the connection and prepare statement and execute the query in try-with resource block. If they are outside and anyexception prior to the try-with resource block cause a potential resource leaks.

```java
 var sql = "SELECT not_a_column FROM names";
   var url = "jdbc:derby:zoo";
   try (var conn = DriverManager.getConnection(url);
      var ps = conn.prepareStatement(sql);
      var rs = ps.executeQuery()) {
 
      while (rs.next())
         System.out.println(rs.getString(1));
   } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getSQLState());
      System.out.println(e.getErrorCode());

   }
```
### Review Questions
1. B, D The concrete DriverManager is part of the JDK, and not in driver jar. interfaces or classes are in a database-specific JAR file is Driver and PrepareStatement implementation.
2. B, C, E, F The require parts in JDBC URL are string jdbc, vendor/product name(postgres) vendor-specific string. IPAddress and port are optional jdbc:derby/zoo
3. A
4. B, ~~C~~, D, ~~F~~ When setting parameters on a PreparedStatement, there are only options that take an index, and not named parameters.`ps.setString(1, "snow"); ps.setString(1, "snow");` this is valid as its sets first and then overrides.
5. B `var conn = new Connection(url, userName, password);` A Connection is created using a static method on DriverManager, and not using a constructor.
6. B
7. A, E, B
8. C
9. A, B A stored procedure that takes one IN parameter. must contain ?, and the call statement surrounded by {} (e.g) `var sql = { call learn(?)};` , then `IN` parameter set with index based or IN parameter name `prefix`  `cs.setString("prefix", "Z");` or  `cs.setString(1, "Z");` 
10. ~~B~~ Runtime exception SQLException is thrown, Since this code uses `executeQuery(sql)` in Statement, it fails at runtime.
   ```java
    var sql = "SELECT toy FROM enrichment WHERE animal = ?";
     try (var ps = conn.prepareStatement(sql)) {
        ps.setString(1, "bat");
 
        try (var rs = ps.executeQuery(sql)) {
           while (rs.next())
              System.out.println(rs.getString(1));
        }
     }
   ```
11. ~~E~~ The table food has five rows and this SQL statement updates all of them. What is the result of this code?
    - JDBC code throws a SQLException, which is a checked exception. The code does not handle or declare this exception, and therefore it doesn't compile. Since the code doesn't compile, option D is correct. If the exception were handled or declared, the answer would be 5
```java
    //
     public static void main(String[] args) {
        var sql = "UPDATE food SET amount = amount + 1";
        try (var conn = DriverManager.getConnection("jdbc:derby:zoo");
           var ps = conn.prepareStatement(sql)) {
 
           var result = ps.executeUpdate();
           System.out.println(result);
        }
     }
```

12.  D JDBC resources should be closed in the reverse order from that in which they were opened. ResultSet, CallableStatement, Connection
    
13.  C when the resultSet is zero then rs.next will return false.
14.  B,  F Type case is must (String s = (String) rs.getObject(1))
15.  C
16.  E
17.  ~~C ~~ carless ness
18. ~~ B~~  **Before accessing data from a ResultSet, the cursor needs to be positioned.**
19.  B, C
  
   ```java
   var sql = "UPDATE habitat WHERE environment = ?";
     try (var ps = conn.prepareCall(sql)) {
 
         ________
 
        ps.executeUpdate();
     }
   ```
* This code should call prepareStatement() instead of prepareCall() since it not executing a stored procedure. Since we are using var, it does compile. Java will happily create a CallableStatement for you. Since this compile safety is lost, the code will not cause issues until runtime
20. ~~C~~ Since the code calls registerOutParameter(), we know the stored procedure cannot use an IN parameter. Further, there is no setInt(), so it cannot be an INOUT parameter either. Therefore, the stored procedure must use an OUT parameter,
    which stored procedure parameter(IN/OUT/INOUT) should be used here ? 
    ```java
      var sql = "{call transform(?)}";
      try (var cs = conn.prepareCall(sql)) {
        cs.registerOutParameter(1, Types.INTEGER);
        cs.execute();
        System.out.println(cs.getInt(1));
      }
    ```
21. C The prepareStatement() method requires SQL be passed in. Since this parameter is omitted, line 27 does not compile, Line 30 also does not compile as the method should be getInt().
     ```java
     25: String url = "jdbc:derby:zoo";
     26: try (var conn = DriverManager.getConnection(url);
     27:    var ps = conn.prepareStatement();
     28:    var rs = ps.executeQuery("SELECT * FROM swings")) {
     29:    while (rs.next()) {
     30:       System.out.println(rs.getInteger(1));
     31:    }
     32: }
     ```