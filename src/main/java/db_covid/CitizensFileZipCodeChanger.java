package db_covid;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CitizensFileZipCodeChanger {

    public static void main(String[] args) throws IOException {

        List<String> zipCodeLines = Files.readAllLines(Path.of("iranyitoszamok-varosok-2021.csv"));
        List<Integer> zipCodes = new ArrayList<>();
        zipCodeLines.remove(0);
        for (String line : zipCodeLines) {
            zipCodes.add(Integer.parseInt(line.split(";")[0]));
        }

        List<String> newCsv = new ArrayList<>();

        try (BufferedReader csvReader = Files.newBufferedReader(Path.of("citizens.csv"))) {
            Random rnd = new Random();
            String line = csvReader.readLine(); //fejlec
            newCsv.add(line);
            while ((line = csvReader.readLine()) != null) {

                int ssn;
                String[] data = line.split(";");
                try {
                    ssn = Integer.parseInt(data[4]) / 10;
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException nfe) {
                    throw new IllegalStateException(line, nfe);
                }

                data[1] = zipCodes.get(rnd.nextInt(zipCodes.size() / 10)).toString();
                data[4] = Integer.toString(10 * ssn + (
                        ssn / 10_000_000 % 10 * 3 +
                                ssn / 1_000_000 % 10 * 7 +
                                ssn / 100_000 % 10 * 3 +
                                ssn / 10_000 % 10 * 7 +
                                ssn / 1000 % 10 * 3 +
                                ssn / 100 % 10 * 7 +
                                ssn / 10 % 10 * 3 +
                                ssn % 10 * 7) % 10
                );

                newCsv.add(data[0] + ';' + data[1] + ';' + data[2] + ';' + data[3] + ';' + data[4]);
            }
        }

        Files.write(Path.of("citizens.csv"), newCsv);
    }
}

//mockaroo.com
//10*this+(this/10000000%10*3+this/1000000%10*7+this/100000%10*3+this/10000%10*7+this/1000%10*3+this/100%10*7+this/10%10*3+this%10*7)%10
