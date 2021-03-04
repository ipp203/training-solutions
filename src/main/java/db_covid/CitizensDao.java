package db_covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class CitizensDao {

    public static final int CITIZENS_COLUMN_NUMBER = 8;
    MariaDbDataSource dataSource;

    public CitizensDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveCitizen(Citizen citizen) {

        String sqlQuery = getSqlInsertQuery(Collections.singletonList(citizen));

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlQuery)
        ) {

            setCitizenToPreparedStatement(pstmt, 1, citizen);
            pstmt.executeUpdate();

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not insert to citizens table", sqle);
        }
    }


    public void saveCitizens(List<Citizen> citizenList) {

        String sqlQuery = getSqlInsertQuery(citizenList);

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlQuery)
        ) {
            int i = 1;
            for (Citizen citizen : citizenList) {
                setCitizenToPreparedStatement(pstmt, i, citizen);
                i += CITIZENS_COLUMN_NUMBER - 1;
            }
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not insert to citizens table ", sqle);
        }
    }


    public Optional<Citizen> getCitizenBySsn(String ssn) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT citizen_id, citizen_name, email, age, zip_code, ssn, number_of_vaccination, last_vaccination FROM citizens WHERE ssn=?")
        ) {

            pstmt.setString(1, ssn);
            return getCitizenOptional(pstmt);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to database", sqle);
        }
    }

    public List<Citizen> getCitizens() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT citizen_id, citizen_name, zip_code, age, email, ssn, number_of_vaccination, last_vaccination FROM citizens");
             ResultSet rs = pstmt.executeQuery()
        ) {
            List<Citizen> result = new ArrayList<>();
            while (rs.next()) {
                result.add(new Citizen(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(5),
                        rs.getInt(4),
                        rs.getString(3),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getDate(8).toLocalDate()));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to database", sqle);
        }
    }

    public List<Citizen> getCitizenByZipCodeOrderedByAge(String zipCode, LocalDate date, int numberOfVaccination) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT citizen_id, citizen_name, zip_code, age, email, ssn, number_of_vaccination, last_vaccination " +
                             "FROM citizens " +
                             "WHERE zip_code=? && last_vaccination<? && number_of_vaccination <? " +
                             "ORDER BY age DESC, number_of_vaccination ASC, citizen_name ASC")) {
            pstmt.setString(1, zipCode);
            pstmt.setDate(2, Date.valueOf(date.minusDays(15)));
            pstmt.setLong(3, numberOfVaccination);
            return getCitizensByPreparedStatement(pstmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Nem sikerült a kapcsolódás az adatbázishoz.", sqle);
        }
    }

    private List<Citizen> getCitizensByPreparedStatement(PreparedStatement pstmt) {
        List<Citizen> result = new ArrayList<>();
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("citizen_id");
                String name = rs.getString("citizen_name");
                String zipCode = rs.getString("zip_code");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String ssn = rs.getString("ssn");
                int nov = rs.getInt("number_of_vaccination");
                LocalDate date = rs.getDate("last_vaccination").toLocalDate();
                result.add(new Citizen(id, name, email, age, zipCode, ssn, nov, date));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Nem sikerült a lekérdezés.", sqle);
        }
    }

    private String getSqlInsertQuery(List<Citizen> citizenList) {
        StringBuilder sqlQuery = new StringBuilder("INSERT INTO citizens(citizen_name, zip_code, age, email, ssn, number_of_vaccination, last_vaccination) VALUES ");
        sqlQuery.append("(?,?,?,?,?,?,?),".repeat(citizenList.size()));
        sqlQuery.deleteCharAt(sqlQuery.length() - 1);
        return sqlQuery.toString();
    }

    private void setCitizenToPreparedStatement(PreparedStatement pstmt, int paramIndex, Citizen citizen) throws SQLException {
        pstmt.setString(paramIndex++, citizen.getName());
        pstmt.setString(paramIndex++, citizen.getZipCode());
        pstmt.setLong(paramIndex++, citizen.getAge());
        pstmt.setString(paramIndex++, citizen.getEmail());
        pstmt.setString(paramIndex++, citizen.getSocialSecurityNumber());
        pstmt.setLong(paramIndex++, citizen.getNumberOfVaccination());
        if (citizen.getLastVaccination() != null) {
            pstmt.setDate(paramIndex, Date.valueOf(citizen.getLastVaccination()));
        } else {
            pstmt.setDate(paramIndex, Date.valueOf(Citizen.DEFAULT_DATE));
        }
    }

    private Optional<Citizen> getCitizenOptional(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return Optional.of(new Citizen(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getDate(8).toLocalDate()));
            } else {
                return Optional.empty();
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not select from citizens table", sqle);
        }
    }

    /////Vaccination

    public void saveVaccination(Vaccination vaccination) {

        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            saveVaccinationByConnection(vaccination, conn);
            if (vaccination.getStatus() == Vaccination.VaccinationStatus.VACCINATED) {
                updateCitizen(vaccination, conn);
            }
            conn.commit();

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to database", sqle);
        }
    }

    private void saveVaccinationByConnection(Vaccination vaccination, Connection conn) {
        try (PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO vaccinations(citizen_id, vaccination_date, status, note, vaccination_type) " +
                        "VALUES (?,?,?,?,?)")
        ) {

            pstmt.setLong(1, vaccination.getCitizenId());
            pstmt.setDate(2, Date.valueOf(vaccination.getVacDate()));
            pstmt.setString(3, vaccination.getStatus().toString());
            pstmt.setString(4, vaccination.getNote());
            pstmt.setString(5, vaccination.getType().toString());
            pstmt.executeUpdate();

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not insert to vaccinations table", sqle);
        }
    }

    private void updateCitizen(Vaccination vaccination, Connection conn) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(
                "UPDATE citizens " +
                        "SET last_vaccination=?, number_of_vaccination = number_of_vaccination + ? " +
                        "WHERE citizen_id = ?")
        ) {

            pstmt.setDate(1, Date.valueOf(vaccination.getVacDate()));
            pstmt.setLong(2, 1);
            pstmt.setLong(3, vaccination.getCitizenId());
            pstmt.executeUpdate();

        } catch (SQLException sqle) {
            conn.rollback();
            throw new IllegalStateException("Can not update on citizens table", sqle);
        }
    }

}
