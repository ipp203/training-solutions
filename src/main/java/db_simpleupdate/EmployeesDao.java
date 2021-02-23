package db_simpleupdate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {
    DataSource dataSource;

    public EmployeesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long createEmployee(String name) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();

            return getIdByStatement(stmt);

        } catch (SQLException se) {
            throw new IllegalStateException("Can not insert!", se);
        }
    }

    private long getIdByStatement(PreparedStatement stmt) {
        try (
                ResultSet rs = stmt.getGeneratedKeys()
        ) {
            if (rs.next()) {
                return rs.getLong("id");
            }
            throw new IllegalStateException("Can not get id");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get id", sqle);
        }
    }

    public List<String> listEmployeeNames() {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT emp_name FROM employees");
                ResultSet rs = pstmt.executeQuery()
        ) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                names.add(rs.getString("emp_name"));
            }
            return names;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not select employees", sqle);
        }
    }

    public String findEmployeeNameById(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT emp_name FROM employees WHERE id = ?")) {

            stmt.setLong(1, id);
            stmt.setFetchSize(10);
            return selectNameByPreparedStatement(stmt);

        } catch (SQLException se) {
            throw new IllegalStateException("Can not query", se);
        }
    }

    private String selectNameByPreparedStatement(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("emp_name");
                return name;
            }
            throw new IllegalStateException("Id Not exists");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not query", se);
        }
    }

}
