package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    Map<String, Integer> owls = new HashMap<>();

    public void readFromFile(BufferedReader reader) {
        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineToMap(line);
            }

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read from file");
        }

    }

    private void lineToMap(String line) {
        String[] data = line.split("=");
        if (data.length == 2) {
            String county = data[0];
            int number = Integer.parseInt(data[1]);
            owls.put(county, number);
        }
    }

    public int getNumberOfOwls(String county) {

        if (county == null || county.isBlank() || !owls.containsKey(county))
            return 0;

        return owls.get(county);

    }


}
