package methodparam;

public class Measurement {
    private double[] values;

    public Measurement(double[] values) {
        this.values = values;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] > lower && values[i] < upper) {
                return i;

            }
        }
        return -1;
    }

    public double minimum() {
        double minimum = Double.POSITIVE_INFINITY;
        for (double i : values) {
            if (i < minimum) {
                minimum = i;
            }
        }
        return minimum;
    }

    public double maximum() {
        double maximum = Double.NEGATIVE_INFINITY;
        for (double i : values) {
            if (i > maximum) {
                maximum = i;
            }
        }
        return maximum;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }
}
