package ioreadstring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path myFile;
    List<Human> humans;

    public FileManager(String path) {
        this.myFile = Path.of(path);
        humans = new ArrayList<>();
    }

    public Path getMyFile() {
        return myFile;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void readFromFile() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(myFile);
        } catch (IOException e) {
            throw new IllegalStateException("", e);
        }
        for (String line : lines) {
            String firstName = line.substring(0, line.indexOf(' '));
            String lastName = line.substring(line.indexOf(' ') + 1);
            humans.add(new Human(firstName, lastName));
        }
    }
}
