package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    private static final String STAR = "*";

    public String createHistogram(BufferedReader reader) {
        StringBuilder result = new StringBuilder();
        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(createStars(line));
                result.append("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        return result.toString();
    }

    private String createStars(String line) {
        StringBuilder result = new StringBuilder();
        try {
            int countStar = Integer.parseInt(line);
            for (int i = 0; i < countStar; i++) {
                result.append(STAR);
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("This line not a number: " + line);
        }
        return result.toString();
    }
}
