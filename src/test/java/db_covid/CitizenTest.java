package db_covid;

import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {
    private MariaDbDataSource dataSource;

    private void init() {
        try {
            dataSource = new MariaDbDataSource("jdbc:mariadb://localhost:3306/covid?useUniCode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not create datasource", sqle);
        }
    }

    @Test
    void testIsNameValid() {
        BoolString bs = Citizen.isNameValid("John Doe");
        assertTrue(bs.getQual());
    }

    @Test
    void testIsNameValidWithNull() {
        BoolString bs = Citizen.isNameValid(null);
        assertFalse(bs.getQual());
    }

    @Test
    void testIsZipCodeValid() {
        init();
        BoolString bs = Citizen.isZipCodeValid("2000", dataSource);
        assertTrue(bs.getQual());
    }

    @Test
    void testIsZipCodeValidWithWrongCode() {
        init();
        BoolString bs = Citizen.isZipCodeValid("1000", dataSource);
        assertFalse(bs.getQual());
    }

    @Test
    void testIsAgeValid() {
        BoolString bs = Citizen.isAgeValid(44);
        assertTrue(bs.getQual());
    }

    @Test
    void testIsAgeValidWithLargeNumber() {
        BoolString bs = Citizen.isAgeValid(244);
        assertFalse(bs.getQual());

        bs = Citizen.isAgeValid(4);
        assertFalse(bs.getQual());
    }

    @Test
    void testIsEmailValid() {
        BoolString bs = Citizen.isEmailValid("aaa@aaa.bb");
        assertTrue(bs.getQual());
    }

    @Test
    void testIsEmailValidWithoutAt() {
        BoolString bs = Citizen.isEmailValid("aaaaaa.bb");
        assertFalse(bs.getQual());
        bs = Citizen.isEmailValid(null);
        assertFalse(bs.getQual());
    }

    @Test
    void isEmailEqual() {
        BoolString bs = Citizen.isEmailEqual("aaa@aaa.bb", "aaa@aaa.bb");
        assertTrue(bs.getQual());
        bs = Citizen.isEmailEqual("aaa@aaa.bb", "baa@aaa.bb");
        assertFalse(bs.getQual());
    }

    @Test
    void testIsSocialSecurityNumberValid() {
        BoolString bs = Citizen.isSocialSecurityNumberValid("000000000");
        assertTrue(bs.getQual());
        bs = Citizen.isSocialSecurityNumberValid("085555989");
        assertTrue(bs.getQual());
        bs = Citizen.isSocialSecurityNumberValid("142164835");
        assertTrue(bs.getQual());
        bs = Citizen.isSocialSecurityNumberValid("291236571");
        assertTrue(bs.getQual());
    }

    @Test
    void testIsSocialSecurityNumberValidWithWrongNumber() {
        BoolString bs = Citizen.isSocialSecurityNumberValid("123456789");
        assertFalse(bs.getQual());
    }
}