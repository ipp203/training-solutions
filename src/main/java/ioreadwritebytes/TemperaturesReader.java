package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {
    public Temperatures readTemperatures(String pathString) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Path.of(pathString));
        } catch (IOException e) {
            throw new IllegalStateException("", e);
        }
        return new Temperatures(bytes);
    }
}
