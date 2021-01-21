package week12.d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientsTest {
    Clients clients;

    @BeforeEach
    void addClient() {
        clients = new Clients();
        clients.addClient("John Doe", "1234");
        clients.addClient("Jane Doe", "2345");
        clients.addClient("John Die", "3456");
        clients.addClient("Jane Die", "4567");
        clients.addClient("Jack Doe", "5678");
    }

    @Test
    void findByRegNumber() {
        Client result = clients.findByRegNumber("2345");
        assertEquals("Jane Doe", result.getName());
    }

    @Test
    void findByName() {
        List<Client> result = clients.findByName("Die");
        assertEquals(2, result.size());
    }
}