package exceptions;

public class Polinom {
    private double[] coefficients;

    public Polinom(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polinom(String[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficientStrs is null");
        }

        try {
            this.coefficients = new double[coefficients.length];
            for (int i = 0; i < coefficients.length; i++) {
                this.coefficients[i] = Double.parseDouble(coefficients[i]);
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        }
    }

    public double[] getCoefficients() {
        return coefficients.clone();
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, (double) coefficients.length - 1 - i);
        }
        return result;
    }
}
