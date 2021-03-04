package db_covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

public class ZipCodeDao {
    private final MariaDbDataSource dataSource;

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

    public void createTableAndUploadData() {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            createTableByConnection(conn);

            if (getNumberOfRows(conn) < 2) {
                updateZipCodes(conn);
            }
            conn.commit();

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not create zip_codes table ", sqle);
        }
    }

    private void createTableByConnection(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS `zip_codes` (" +
                    "  `city_id` bigint(20) NOT NULL AUTO_INCREMENT, " +
                    "  `zip_code` smallint(6) NOT NULL, " +
                    "  `city` varchar(20) COLLATE utf8_hungarian_ci NOT NULL, " +
                    "  `city_part` varchar(20) COLLATE utf8_hungarian_ci DEFAULT NULL, " +
                    "  PRIMARY KEY (`city_id`))");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not create zip_codes table ", sqle);
        }
    }

    private long getNumberOfRows(Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT city_id FROM zip_codes")) {

            rs.afterLast();
            return rs.getRow();

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not query zip_codes table ", sqle);
        }
    }

    private void updateZipCodes(Connection conn) {
        try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO zip_codes(zip_code, city, city_part) VALUES(?,?,?)")) {
            loadFileToPrepareStatement(conn, pstmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not insert into zip_codes table ", sqle);
        }
    }

    private void loadFileToPrepareStatement(Connection conn, PreparedStatement pstmt) throws SQLException {
        try (BufferedReader br = Files.newBufferedReader(Path.of("iranyitoszamok-varosok-2021.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 2) {
                    pstmt.setLong(1, Integer.parseInt(data[0]));
                    pstmt.setString(2, data[1]);
                    pstmt.setString(3, "");
                    pstmt.executeUpdate();
                }
                if (data.length == 3) {
                    pstmt.setLong(1, Integer.parseInt(data[0]));
                    pstmt.setString(2, data[1]);
                    pstmt.setString(3, data[2]);
                    pstmt.executeUpdate();
                }
            }
        } catch (IOException ioe) {
            conn.rollback();
            throw new IllegalStateException("Can not insert zip codes from file ", ioe);
        }
    }
}
