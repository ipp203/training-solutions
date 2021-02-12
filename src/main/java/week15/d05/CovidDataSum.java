package week15.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CovidDataSum {
    private Map<String, Country> countryMap = new HashMap<>();

    public List<Country> getThreeMostCasesPerPopulation(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
        return getResult();
    }

    private void processLine(String line) {
        line.replace("Bonaire, Saint", "Bonaire Saint");

        String[] data = line.split(",");
        String name = data[4];
        int cases = 0;
        try {
            cases = Integer.parseInt(data[2]);
        } catch (NumberFormatException nfe) {
            return;
        }

        int population = 1;
        try {
            population = Integer.parseInt(data[7]);
        } catch (NumberFormatException nfe) {
            return;
        }

        incCountryMap(name, cases, population);
    }

    private void incCountryMap(String name, int cases, int population) {
        if (!countryMap.containsKey(name)) {
            Country country = new Country(name, population);
            countryMap.put(name, country);
        }
        countryMap.get(name).incCasesSum(cases);
    }

    private List<Country> getResult() {
/*        List<Country> countries = new ArrayList<>();
        countries.addAll(countryMap.values());
        Collections.sort(countries);
        Collections.reverse(countries);
        return countries.subList(0, 3);*/
        return countryMap.values().stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
    }
}
