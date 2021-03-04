package db_covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class CitizenService {


    private final List<Citizen> citizenList = new ArrayList<>();
    private final MariaDbDataSource dataSource;
    private final CitizensDao citizensDao;


    public CitizenService(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
        citizensDao = new CitizensDao(dataSource);
        citizensDao.createTables();
    }

    public List<Citizen> getCitizenList() {
        return new ArrayList<>(citizenList);
    }


    public void exportVaccinationLog(Path filename, String zipCode, LocalDate date) {
        List<Citizen> result = citizensDao.getCitizenByZipCodeOrderedByAge(zipCode, date, 2);
        result = result.subList(0, 16);

        LocalTime time = LocalTime.of(8, 0);
        try (BufferedWriter bw = Files.newBufferedWriter(filename, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW)) {
            bw.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
            for (Citizen c : result) {
                bw.write(time.toString() + ";" + c.toString() + "\n");
                time = time.plusMinutes(30);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Nem sikerült a fájl írása", ioe);
        }
    }

    public Map<Integer, Integer> getVaccinatedReportByZipCode(String zipCode) {
        List<Citizen> result = citizensDao.getCitizenByZipCodeOrderedByAge(
                zipCode,
                LocalDate.now().plusYears(1),
                3);
        return result.stream()
                .collect(Collectors.toMap(Citizen::getNumberOfVaccination, c -> 1, Integer::sum));
    }

    public List<Citizen> importCitizens(BufferedReader reader) {
        try (reader) {
            List<Citizen> invalidData = processFileAndGetContainedCitizens(reader);
            citizensDao.saveCitizens(citizenList);
            return invalidData;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file");
        }
    }

    public Optional<Citizen> containsCitizenBySsn(String ssn) {
        return citizensDao.getCitizenBySsn(ssn);
    }

    private List<Citizen> processFileAndGetContainedCitizens(BufferedReader reader) throws IOException {
        List<Citizen> invalidData = new ArrayList<>();
        String line = reader.readLine(); //fejlec
        while ((line = reader.readLine()) != null) {
            Citizen citizen = processLine(line);

            if (!Citizen.isCitizenValid(citizen, dataSource)) {
                invalidData.add(citizen);
            }
            if (!addCitizen(citizen)) {
                invalidData.add(citizen);
            }
        }
        return invalidData;
    }

    private Citizen processLine(String line) {
        String[] data = line.split(";");
        if (data.length == 5) {
            String name = data[0];
            String email = data[3];
            int age = Integer.parseInt(data[2]);
            String zipCode = data[1];
            String socialSecurityNumber = data[4];
            return new Citizen(name, email, age, zipCode, socialSecurityNumber);
        }
        throw new IllegalStateException("Nem feldolgozható adat " + line);
    }

    private boolean addCitizen(Citizen citizen) {
        if (citizenList.contains(citizen)) {
            return false;
        }
        citizenList.add(citizen);
        return true;
    }
}
