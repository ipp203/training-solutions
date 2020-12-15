package ioreaderclasspath;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    private List<Country> countryList = new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public void readFromFile(String fileName) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream("/" + fileName)))) {
            String line;
            while ((line = bfr.readLine()) != null) {
                String[] data = line.split(" ");
                countryList.add(new Country(data[0], Integer.parseInt(data[1])));
            }
        } catch (FileNotFoundException fnfe) {
            throw new IllegalArgumentException("File not found", fnfe);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("IO exception", ioe);
        }

    }

    public int numberOFCountries() {
        return countryList.size();
    }

    public Country mostBorderCountries() {
        Country result = countryList.get(0);
        for (Country country : countryList) {
            if (result.getBorderCountries() < country.getBorderCountries()) {
                result = country;
            }
        }
        return result;
    }

}
