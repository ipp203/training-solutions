package ioreadbytes;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String fileName) {
        int sum = 0;
        try (InputStream inputStream = new BufferedInputStream(ByteChecker.class.getResourceAsStream("/ioreadbytes/" + fileName))) {
            int size;
            byte[] bytes = new byte[50];
            while ((size = inputStream.read(bytes)) > 0) {
                sum += size;
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
        return sum;
    }

}
