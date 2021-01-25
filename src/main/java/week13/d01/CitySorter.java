package week13.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

public class CitySorter {

    public City sortCities() {
        List<City> cities = loadFromFile();
        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                Collator collator = Collator.getInstance(new Locale("hu", "HU"));
                String s1 = o1.getName() + o1.getDistrict();
                String s2 = o2.getName() + o2.getDistrict();
                return collator.compare(s1, s2);
            }
        });
        return cities.get(0);
    }

    private List<City> loadFromFile() {
        List<City> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(CitySorter.class.getResourceAsStream("iranyitoszamok-varosok-2021.csv")))) {
            String line = br.readLine(); //fejlec
            while ((line = br.readLine()) != null) {
                result.add(lineToCity(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
        return result;
    }

    private City lineToCity(String line) {
        String[] data = line.split(";");
        int zipCode = Integer.parseInt(data[0]);
        String name = data[1];
        String district = "";
        if (data.length > 2) {
            district = data[2];
        }
        return new City(zipCode, name, district);
    }

    public static void main(String[] args) {
        System.out.println(new CitySorter().sortCities());
    }
}
