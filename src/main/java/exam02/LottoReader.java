package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {
    public static final int FIRST_FIELD = 11;
    public static final int LAST_FIELD = 15;
    private int[] numbers;

    public LottoReader(InputStream inputStream) {
        numbers = new int[90];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                for (int i = FIRST_FIELD; i <= LAST_FIELD; i++) {
                    numbers[Integer.parseInt(data[i]) - 1]++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    public int getNumber(int number) {
        return numbers[number - 1];
    }
}
