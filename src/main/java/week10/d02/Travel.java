package week10.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Travel {

    public int getStopWithMax(InputStream is) {
        int[] stops = new int[30];

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] data = line.split(" ");
                stops[Integer.parseInt(data[0])] += 1;
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }

        int index = 0;
        int maxPassenger = 0;
        for (int i = 0; i < stops.length; i++) {
            if (stops[i] > maxPassenger) {
                maxPassenger = stops[i];
                index = i;
            }
        }
        return index;
    }


}
