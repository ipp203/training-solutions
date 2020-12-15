package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {
    public void writeAsBytes(List<String> words, Path path) {
        try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (String str : words) {
                if (str.charAt(0) != '_') {
                    bos.write(str.getBytes());
                }
            }
        } catch (FileNotFoundException fnfe) {
            throw new IllegalArgumentException("File not found", fnfe);
        } catch (IOException e) {
            throw new IllegalArgumentException("IO exception", e);
        }

    }
}
