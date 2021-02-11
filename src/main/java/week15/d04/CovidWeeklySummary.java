package week15.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CovidWeeklySummary {
    public String sumHungarianWeeklyCases(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            int max = 0;
            String result = "";
            String line;
            while ((line = br.readLine()) != null) {
                int numberOfCase = getNumberOfHungarianCase(line);
                if (numberOfCase > max) {
                    max = numberOfCase;
                    result = line.split(",")[1];
                }
            }
            return result;

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    private int getNumberOfHungarianCase(String line) {
        if (line.contains("Hungary")) {
            return Integer.parseInt(line.split(",")[2]);
        }
        return 0;
    }

}
