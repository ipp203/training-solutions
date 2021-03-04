package db_covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

class CitizensDaoTest {
    private MariaDbDataSource dataSource;

    @BeforeEach
    void init() {
        try {
            dataSource = new MariaDbDataSource("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot create datasource", e);
        }
        Flyway flyway = Flyway.configure().locations("db_covid/db/migration").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

    }

    @Test
    void saveCitizen() {
        CitizensDao citizensDao = new CitizensDao(dataSource);
        citizensDao.saveCitizen(new Citizen("John Doe", "aaa@aaa.aa", 34, "3600", "000000000"));

        Citizen result = citizensDao.getCitizenBySsn("000000000").get();

        assertEquals("John Doe", result.getName());

    }

    @Test
    void saveCitizens() throws IOException {

        CitizensDao citizensDao = new CitizensDao(dataSource);
        CitizenService cr = new CitizenService(dataSource);

        cr.importCitizens(Files.newBufferedReader(Path.of("citizens.csv")));

        List<Citizen> result = citizensDao.getCitizens();

        assertEquals(cr.getCitizenList().size(), result.size());


    }
}