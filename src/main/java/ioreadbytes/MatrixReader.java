package ioreadbytes;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {
    List<byte[]> myMatrix = new ArrayList<>();

    public List<byte[]> getMyMatrix() {
        return new ArrayList<>(myMatrix);
    }

    public void readBytesAndCreateMatrix(String fileName) {

        try (InputStream is = new BufferedInputStream(MatrixReader.class.getResourceAsStream("/ioreadbytes/" + fileName))) {
            int size;
            byte[] bytes = new byte[1000];
            while ((size = is.read(bytes)) > 0) {
                myMatrix.add(bytes);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("", ioe);
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int result = 0;
        int numberOfColumns = longestRowLength();
        int[] sums = new int[numberOfColumns];
        for (byte[] bytes : myMatrix) {
            for (int j = 0; j < bytes.length; j++) {
                sums[j] += bytes[j];
            }
        }

        for (int i : sums) {
            if (i > myMatrix.size() / 2) {
                result++;
            }
        }
        return result;
    }


    private int longestRowLength() {
        int length = 0;
        for (byte[] bytes : myMatrix) {
            if (length < bytes.length) {
                length = bytes.length;
            }
        }
        return length;
    }

}
