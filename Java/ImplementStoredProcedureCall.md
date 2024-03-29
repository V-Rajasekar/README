## Following is the sample class of creating tables, entry, procedure types(no param, IN, OUT, INOUT param) and calling then in Java

```java
package procedures;

import java.sql.*;

public class SetupHsqlDatabase {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:hsqldb:file:zoo";
       // Class.forName("org.hsqldb.jdbc.JDBCDriver");
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            run(conn, "DROP PROCEDURE read_e_names IF EXISTS");
            run(conn, "DROP PROCEDURE read_names_by_letter IF EXISTS");
            run(conn, "DROP PROCEDURE magic_number IF EXISTS");
            run(conn, "DROP PROCEDURE double_number IF EXISTS");
            run(conn, "DROP TABLE names IF EXISTS");
            run(conn, "DROP TABLE exhibits IF EXISTS");

            run(conn, "CREATE TABLE exhibits ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "num_acres DECIMAL(4,1))");

            run(conn, "CREATE TABLE names ("
                    + "id INTEGER PRIMARY KEY, "
                    + "species_id integer REFERENCES exhibits (id), "
                    + "name VARCHAR(255))");

            run(conn, "INSERT INTO exhibits VALUES (1, 'African Elephant', 7.5)");
            run(conn, "INSERT INTO exhibits VALUES (2, 'Zebra', 1.2)");

            run(conn, "INSERT INTO names VALUES (1, 1, 'Elsa')");
            run(conn, "INSERT INTO names VALUES (2, 2, 'Zelda')");
            run(conn, "INSERT INTO names VALUES (3, 1, 'Ester')");
            run(conn, "INSERT INTO names VALUES (4, 1, 'Eddie')");
            run(conn, "INSERT INTO names VALUES (5, 2, 'Zoe')");

            String noParams = "CREATE PROCEDURE read_e_names() "
                    + "READS SQL DATA DYNAMIC RESULT SETS 1 "
                    + "BEGIN ATOMIC "
                    + "DECLARE result CURSOR WITH RETURN FOR SELECT * FROM names; "
                    + "OPEN result; "
                    + "END";

            String inParam = "CREATE PROCEDURE read_names_by_letter(IN prefix VARCHAR(10)) "
                    + "READS SQL DATA DYNAMIC RESULT SETS 1 "
                    + "BEGIN ATOMIC "
                    + "DECLARE result CURSOR WITH RETURN FOR " +
                    " SELECT * FROM names WHERE name LIKE CONCAT(prefix, '%'); "
                    + "OPEN result; "
                    + "END";

            String inOutParam = "CREATE PROCEDURE double_number(INOUT num INT) READS SQL DATA\n" +
                    "  DYNAMIC RESULT SETS 1 " +
                    "  BEGIN ATOMIC " +
                    "  SET num = num * 2; " +
                    "  END";

            String outParam = "CREATE PROCEDURE magic_number(OUT num INT) READS SQL DATA\n" +
                    "  BEGIN ATOMIC " +
                    "  SET num = 42;" +
                    "  END";

            int run = run(conn, noParams);
            System.out.println("No param query run"+ run);
            run(conn, inParam);
            run(conn, outParam);
            run(conn, inOutParam);

            executeProcedureCallInParam(conn, "{call read_names_by_letter(?)}");
            executeProcedureCallOutParam(conn, "{?= call magic_number(?)}");
            executeProcedureCallInOutParam(conn, "{call double_number(?)}");
            executeProcedureCall(conn, "{call read_e_names()}");
            printCount(conn, "SELECT count(*) FROM names");
        }
    }

    private static void executeProcedureCallInParam(Connection conn, String sql) {
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString("prefix", "Z%");
            try (ResultSet rs = cs.executeQuery()) {
                System.out.println("PrepareCall(IN) response: ");
                while (rs.next()) {
                    System.out.println("" + rs.getString(3));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    private static void executeProcedureCallOutParam(Connection conn, String sql) {
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.registerOutParameter(1, Types.INTEGER);
             cs.execute();
            System.out.println("PrepareCall(OUT) response: " + cs.getInt("Num"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    private static void executeProcedureCallInOutParam(Connection conn, String sql) {
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, 8);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            System.out.println("PrepareCall(INOUT) response: " + cs.getInt("Num"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    private static int run(Connection conn, String sql) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
           return ps.executeUpdate();
        }
    }

    static void executeProcedureCall(Connection conn, String sql) {
         sql = "{call read_e_names()}";
        try (CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            System.out.println("PrepareCall(No param), All Names:");
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printCount(Connection conn, String sql) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            rs.next();
            //Option2: ps.execute() returning single value, note rs.next()
            //is important to move the cursor point
          /*
            boolean result = ps.execute();
            ResultSet rs = ps.getResultSet();
            rs.next();*/
            System.out.println("PrepareStatement Total names: "+ rs.getInt(1));
        }
    }
}


```
Response:  
```
PrepareCall(IN) response: 
Zelda
Zoe
PrepareCall(OUT) response: 42
PrepareCall(INOUT) response: 16
PrepareCall(No param), All Names:
Elsa
Zelda
Ester
Eddie
Zoe
PrepareStatement Total names: 5
```
