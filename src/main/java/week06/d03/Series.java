package week06.d03;

import java.util.List;

public class Series {

    enum SeriesType {DEC, INC, RANDOM}

    public SeriesType calculateSeriesType(List<Integer> series) {
        if (series == null || series.size() < 2) {
            throw new IllegalArgumentException("Size of series must be greater than 2!");
        }

        boolean novekvo = true;
        boolean csokkeno = true;
        for (int i = 1; i < series.size(); i++) {
            if (series.get(i - 1) > series.get(i)) {
                novekvo = false;
            }
            if (series.get(i - 1) < series.get(i)) {
                csokkeno = false;
            }
        }
        if (novekvo) {
            return SeriesType.INC;
        }
        if (csokkeno) {
            return SeriesType.DEC;
        }
        return SeriesType.RANDOM;

    }
}
