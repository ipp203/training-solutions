package week08.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {

    public List<String> getTitlesOfExamples(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(ExamplesStore.class.getResourceAsStream(fileName)))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank() && line.charAt(0) == '#') {
                    result.add(line.substring(1).strip());
                }
            }

        } catch (NullPointerException npe) {
            throw new IllegalStateException("Can not find file!", npe);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }

        return result;
    }

}
