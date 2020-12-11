package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {
    public void writeTemperatures(Temperatures temperatures, String pathString) {
        try {
            Files.write(Path.of(pathString), temperatures.getData());
        } catch (IOException e) {
            throw new IllegalStateException("", e);
        }
    }

}
