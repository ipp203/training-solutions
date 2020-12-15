package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] image, Path path) {
        Path filePath = Path.of(path.toString() + "/image.png");
        try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(filePath))) {
            for (byte[] bytes : image) {
                bos.write(bytes);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("IO exception", e);
        }
    }
}
