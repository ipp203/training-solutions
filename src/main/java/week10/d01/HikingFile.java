package week10.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HikingFile {
    double height = -1.0;

    public ElevationData getElevation(InputStream is) {
        ElevationData ed = new ElevationData();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                double actHeight = Float.parseFloat(data[2]);
                if (height > -1) {
                    if (actHeight > height) {
                        ed.plusInc(actHeight - height);
                    } else {
                        ed.plusDec(height - actHeight);
                    }
                }
                height = actHeight;
            }

        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Data can not parse.", nfe);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File can not read.", ioe);
        }
        return ed;
    }


}
