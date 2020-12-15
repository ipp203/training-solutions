package week08.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    private List<CountryData> countryData = new ArrayList<>();

    public List<CountryData> getCountryData() {
        return new ArrayList<>(countryData);
    }

    public void readCountryData(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                CountryData cd = getCountryDataFromString(line);
                if (cd != null) {
                    countryData.add(cd);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file " + fileName, ioe);
        }
    }

    private CountryData getCountryDataFromString(String line) {
        String[] data = line.split(" ");
        if (data.length == 4) {
            return new CountryData(data[0],
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]));
        } else {
            return null;
        }
    }

    public CountryData maxPopulation() {
        int max = 0;
        CountryData result = null;
        for (CountryData cd : countryData) {
            if (cd.getPopulation() > max) {
                max = cd.getPopulation();
                result = cd;
            }
        }
        return result;
    }
}
