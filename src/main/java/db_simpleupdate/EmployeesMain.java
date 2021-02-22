package db_simpleupdate;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;

public class EmployeesMain {

    public static void main(String[] args) {
//DataSource peldanyositas
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }

//insert Connection es PreparedStatement
        for (int i = 0; i < 100; i++) {
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement stmt =
                         conn.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)")) {
                stmt.setString(1, "John Doe");
                stmt.executeUpdate();
            } catch (SQLException se) {
                throw new IllegalStateException("Can not insert!", se);
            }
        }
//select Connection, PreparedStatement es ResultSet
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT emp_name FROM employees WHERE id = ?")) {

            stmt.setLong(1, 1L);
            stmt.setFetchSize(10);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("emp_name");
                    System.out.println(name);
                } else {
                    throw new IllegalStateException("Does not exist id ");
                }

            } catch (SQLException se) {
                throw new IllegalStateException("Can not query", se);
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Can not query", se);
        }

    }
}

