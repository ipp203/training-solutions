package interfacestaticmethods;

import java.util.List;

public interface Valued {
    double getValue();

    static double totalValue(List<Valued> values) {
        double sum = 0;
        for (Valued value : values) {
            sum += value.getValue();
        }
        return sum;
    }
}
