package week07.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserImplTest {
    @Test
    void testCreate() {
        User user = User.of("JoDe", "John", "Doe");

        assertEquals("JoDe", user.getUsername());
        assertEquals("John Doe", user.getFullName());
    }

}