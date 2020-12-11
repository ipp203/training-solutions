package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {
    private List<String> ids = new ArrayList<>();

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }

    public void readIdsFromFile(String pathString) {
        Path path = Path.of(pathString);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ids.add(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found: " + pathString, ioe);
        }


    }
}
