package exam03retake02;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalatonStormTest {

    BalatonStorm balatonStorm;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource("jdbc:mariadb://localhost:3306/storm?useUnicode=true");
            dataSource.setUser("storm");
            dataSource.setPassword("storm");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Datasource exception", sqle);
        }
        balatonStorm = new BalatonStorm(dataSource);

        Flyway flyway = Flyway.configure().locations("db/migration/balatonstorm").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void testGetStationsInStorm() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(BalatonStormTest.class.getResourceAsStream("storm.json")))) {
            assertEquals(List.of("Ábrahámhegy", "Balatonfüred", "Balatonszárszó"), balatonStorm.getStationsInStorm(reader));
        }
    }
}