package ioreadbytes;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixReaderTest {
    MatrixReader matrixReader = new MatrixReader();

/*    @Test
    void createMatrixDat() {
        Random rnd = new Random();
        byte[] bytes = new byte[1000];
        Path path = Path.of("src/test/resources/ioreadbytes/matrix.dat");
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 1000; j++) {
                    bytes[j] = (byte) rnd.nextInt(2);
                }

                Files.write(path, bytes, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

    @Test
    public void readBytesAndCreateMatrixTest() {
        assertEquals(0, matrixReader.getMyMatrix().size());
        matrixReader.readBytesAndCreateMatrix("matrix.dat");

        assertEquals(9, matrixReader.getMyMatrix().size());
        assertEquals(1000, matrixReader.getMyMatrix().get(5).length);
    }


    @Test
    public void numberOfColumnsWhereMoreZeros() {
        matrixReader.readBytesAndCreateMatrix("matrix.dat");
        assertEquals(505, matrixReader.numberOfColumnsWhereMoreZeros());
    }

}