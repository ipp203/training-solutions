package db_covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class CovidMain {

    private final Scanner scn;
    private final MariaDbDataSource dataSource;
    private final CitizenService citizenService;
    private final VaccinationService vaccinationService;

    private static final String MAIN_MENU = """
              Válasszon menüpontot!
            1. Egyedi regisztráció
            2. Tömeges regisztráció
            3. Oltási napló készítése
            4. Oltási felvétel
            5. Oltás törlése
            6. Riport
            7. Kilépés""";


    public CovidMain(Scanner scn) {
        this.scn = scn;

//        try {
//            dataSource = new MariaDbDataSource("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
//            dataSource.setUser("covid");
//            dataSource.setPassword("covid");
//        } catch (
//                SQLException e) {
//            throw new IllegalStateException("Cannot create datasource", e);
//        }

        try {
            dataSource = new MariaDbDataSource("jdbc:mariadb://localhost:3306/");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot create datasource", e);
        }

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery("CREATE DATABASE if NOT EXISTS covid");
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot create datasource", sqle);
        }

        citizenService = new CitizenService(dataSource);
        vaccinationService = new VaccinationService(dataSource);
        new ZipCodeDao(dataSource).createTableAndUploadData();
    }

    private void registerCitizen() {
        System.out.println("\nEgyedi regisztráció");

        String name;
        String ssn;
        String email;
        String zipCode;
        int age;

        name = getCitizenData("Kérem, adja meg a személy nevét!", Citizen::isNameValid);
        age = getCitizenData("Adja meg az életkorát!", Citizen::isAgeValid);
        ssn = getCitizenData("Kérem a TAJ számát!", Citizen::isSocialSecurityNumberValid);
        zipCode = getCitizenData("Írja be az irányító számát!", Citizen::isZipCodeValid);
        email = getCitizenData("Adja meg az e-mail címét", Citizen::isEmailValid, "Ismételje meg az e-mail címet!", Citizen::isEmailEqual);

        try {
            new CitizensDao(dataSource).saveCitizen(new Citizen(name, email, age, zipCode, ssn));
            System.out.println("A regisztráció sikeres volt.");
        } catch (IllegalStateException ise) {
            System.out.println("Hiba történt: " + ise.getMessage() + " " + ise.getCause().getMessage());
        }
    }

    //zipcode
    private String getCitizenData(String text, BiFunction<String, MariaDbDataSource, BoolString> validator) {
        String result;
        BoolString validResult;

        System.out.println(text);
        do {
            result = scn.nextLine();
            validResult = validator.apply(result, dataSource);
            System.out.println(validResult.getMessage());
        } while (!validResult.getQual());
        return result;
    }

    //age
    private int getCitizenData(String text, IntFunction<BoolString> validator) {
        int result = 0;
        BoolString validResult = new BoolString(false, "");

        System.out.println(text);
        do {
            try {
                result = Integer.parseInt(scn.nextLine());
                validResult = validator.apply(result);
                System.out.println(validResult.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Számot írjon be!");
            }
        } while (!validResult.getQual());
        return result;
    }

    private String getCitizenData(String text, Function<String, BoolString> validator) {
        String result;
        BoolString validResult;

        System.out.println(text);
        do {
            result = scn.nextLine();
            validResult = validator.apply(result);
            System.out.println(validResult.getMessage());
        } while (!validResult.getQual());
        return result;
    }

    //email
    private String getCitizenData(String text, Function<String, BoolString> validator,
                                  String text2, BiFunction<String, String, BoolString> validator2) {
        String result;
        BoolString validResult;

        System.out.println(text);
        do {
            result = scn.nextLine();
            validResult = validator.apply(result);
            System.out.println(validResult.getMessage());
        } while (!validResult.getQual());

        String result2;
        System.out.println(text2);
        do {
            result2 = scn.nextLine();
            validResult = validator2.apply(result, result2);
            System.out.println(validResult.getMessage());
        } while (!validResult.getQual());

        return result;
    }

    private void registerCitizens() {
        try {
            List<Citizen> invalidLines = registerCitizenList();
            if (!invalidLines.isEmpty()) {
                System.out.println("A következő adatok nem regisztrálhatók:");
                for (Citizen c : invalidLines) {
                    System.out.println(c);
                }
            }
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage() + ise.getCause().getMessage());
        }
    }

    private List<Citizen> registerCitizenList() {
        String filepath;

        System.out.println("\nTömeges regisztráció\nAdja meg a betöltendő fájl teljes elérési útját!");
        filepath = scn.nextLine();
        if (!Files.exists(Path.of(filepath))) {
            System.out.println("A fájl nem létezik!");
            return Collections.emptyList();
        }

        System.out.println("A fájl feldolgozása megkezdődött, kérem várjon!");
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filepath))) {
            return citizenService.importCitizens(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("A fájl olvasása nem sikerült", ioe);
        }
    }


    private void generateVaccintaionLog() {
        System.out.println("\nOltási napló mentése fájlba");
        LocalDate date = getDate();
        String zipCode = getZipCode();
        System.out.println("Adja meg a fájl nevét!");
        String filename = scn.nextLine();
        Path path = getAbsolutePath(filename);
        try {
            citizenService.exportVaccinationLog(path, zipCode, date);
            System.out.println("A mentés sikeres, a fájl helye: " + path.toString());
        } catch (IllegalStateException ise) {
            System.out.println("Hiba történt " + ise.getMessage() + " " + ise.getCause().getMessage());
        }
    }

    private Path getAbsolutePath(String filename) {
        Path path;
        if (Path.of(filename).getRoot() == null) {
            path = Path.of("").resolve(filename).toAbsolutePath();
        } else {
            path = Path.of(filename);
        }
        return path;
    }

    private LocalDate getDate() {
        LocalDate date = Citizen.DEFAULT_DATE;
        System.out.println("Adja meg a dátumot éééé.hh.nn formátumban!");
        boolean successInput = false;
        do {
            try {
                String dateString = scn.nextLine();
                date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
                successInput = true;
            } catch (DateTimeParseException dtpe) {
                System.out.println("Nem megfelelő formátum. Próbálja újra (éééé.hh.nn)!");
            }
        } while (!successInput);
        return date;
    }

    private String getZipCode() {
        String zipCode;
        System.out.println("Adja meg az irányítószámot!");
        BoolString successInput;
        do {
            zipCode = scn.nextLine();
            successInput = Citizen.isZipCodeValid(zipCode, dataSource);
        } while (!successInput.getQual());
        return zipCode;
    }

    private void doVaccination() {
        System.out.println("\nOltás regisztrálása");
        Citizen citizen = getSsnAndCheckDb();

        if (citizen.getNumberOfVaccination() > 1) {
            System.out.println(citizen.getName() + " megkapta a két oltást.");
            return;
        }

        LocalDate date = getDate();
        if (citizen.getLastVaccination().isAfter(date.minusDays(15))) {
            System.out.println(citizen.getName() + " 15 napon belül kapta az előző oltást.");
            return;
        }

        Vaccination.VaccinationType type = getVaccinationType();

        Vaccination vaccination = Vaccination.ofWithVaccinated(citizen.getId(), date, type);
        System.out.println(vaccinationService.registerVaccination(vaccination).getMessage());
    }

    private void undoVaccination() {
        System.out.println("\nOltás törlése");
        Citizen citizen = getSsnAndCheckDb();

        if (citizen.getNumberOfVaccination() <= 0) {
            System.out.println(citizen.getName() + " nem kapott oltást.");
            return;
        }

        LocalDate date = getDate();

        String note = getNote();

        Vaccination vaccination = Vaccination.ofWithFailed(citizen.getId(), date, note);
        System.out.println(vaccinationService.registerVaccination(vaccination).getMessage());
    }

    private Citizen getSsnAndCheckDb() {
        Optional<Citizen> citizen;
        do {
            String ssn = getCitizenData("Kérem a TAJ számot!", Citizen::isSocialSecurityNumberValid);
            citizen = citizenService.containsCitizenBySsn(ssn);
            if (citizen.isEmpty()) {
                System.out.println("Ezen a TAJ számon nincs regisztrált állampolgár.");
            }
        } while (citizen.isEmpty());

        System.out.println(citizen.get().toString());
        return citizen.get();
    }

    private Vaccination.VaccinationType getVaccinationType() {
        System.out.println("Kérem válasszon vakcina típust!");
        int i = 1;
        for (String s : Vaccination.VaccinationType.getVaccinationTypeList()) {
            System.out.printf("%d. %s%n", i, s);
            i++;
        }

        i = getSelector(1, Vaccination.VaccinationType.values().length);

        String vaccinationName = Vaccination.VaccinationType.getVaccinationTypeList().get(i - 1);
        return Vaccination.VaccinationType.valueOf(vaccinationName);
    }

    private String getNote() {
        System.out.println("Írja le a törlés okát!");
        return scn.nextLine();
    }

    private void printReport() {
        String zipCode = getZipCode();
        Map<Integer, Integer> result = citizenService.getVaccinatedReportByZipCode(zipCode);
        StringBuilder keys = new StringBuilder(String.format("%16s", "Oltások száma"));
        StringBuilder values = new StringBuilder(String.format("%16s", "Oltottak száma"));

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            keys.append(String.format("%5d", entry.getKey()));
            values.append(String.format("%5d", entry.getValue()));
        }

        System.out.println(keys.toString());
        System.out.println(values.toString() + "\n");
    }

    private int getSelector(int min, int max) {
        int selector = 0;
        boolean successInput = false;
        do {
            String temp = scn.nextLine();
            try {
                selector = Integer.parseInt(temp);
                successInput = selector >= min && selector <= max;
                if (!successInput) {
                    System.out.printf("%d - %d közötti számot válasszon!%n", min, max);
                }
            } catch (NumberFormatException nfe) {
                System.out.printf("%d - %d közötti számot válasszon!%n", min, max);
            }
        } while (!successInput);
        return selector;
    }


    public static void main(String[] args) {
        CovidMain cm = new CovidMain(new Scanner(System.in));
        int selector;

        do {
            System.out.println(MAIN_MENU);
            selector = cm.getSelector(1, 7);

            if (selector == 1) {
                cm.registerCitizen();
            }
            if (selector == 2) {
                cm.registerCitizens();
            }
            if (selector == 3) {
                cm.generateVaccintaionLog();
            }
            if (selector == 4) {
                cm.doVaccination();
            }
            if (selector == 5) {
                cm.undoVaccination();
            }
            if (selector == 6) {
                cm.printReport();
            }
        } while (selector != 7);
        System.out.println("Jó egészséget!");
    }


}
