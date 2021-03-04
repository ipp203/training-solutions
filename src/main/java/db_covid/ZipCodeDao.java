package db_covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZipCodeDao {
    MariaDbDataSource dataSource;

    public ZipCodeDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getCityByZipCode(String zipCode) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT `city`, `city_part` FROM zip_codes WHERE `zip_code`=?")) {

            pstmt.setString(1, zipCode);
            return getCity(pstmt);

        } catch (SQLException e) {
            throw new IllegalStateException("Can not connect to database", e);
        }
    }

    private String getCity(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                return rs.getString("city") + ", " + rs.getString("city_part");
            } else {
                throw new IllegalStateException("Zip code not exists");
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Can not search zip code", e);
        }
    }
}
