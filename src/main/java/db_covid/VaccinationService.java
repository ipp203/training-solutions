package db_covid;

import org.mariadb.jdbc.MariaDbDataSource;

public class VaccinationService {
    private final CitizensDao cd;

    public VaccinationService(MariaDbDataSource dataSource) {
        cd = new CitizensDao(dataSource);
    }

    public BoolString registerVaccination(Vaccination vaccination) {
        try {
            cd.saveVaccination(vaccination);
            return new BoolString(true, "A regisztráció sikeres volt");
        } catch (IllegalStateException ise) {
            return new BoolString(false, "Nem sikerült a regisztráció " +
                    ise.getMessage() + " " + ise.getCause().getMessage());
        }
    }
}
