package db_covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizenServiceTest {

    Citizen johnDoe = new Citizen("John Doe",
            "johndoe@freemail.hu",
            44,
            "3600",
            "00000000");

    private MariaDbDataSource dataSource;

    @BeforeEach
    void init() {
        try {
            dataSource = new MariaDbDataSource("jdbc:mariadb://localhost:3306/covid?useUniCode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not create datasource", sqle);
        }
    }

    @Test
    void testImportCitizens() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("citizens.csv"));
        CitizenService citizens = new CitizenService(dataSource);
        List<Citizen> result = citizens.importCitizens(reader);

        assertEquals(5892, citizens.getCitizenList().size());
        assertEquals(0, result.size());

    }


}