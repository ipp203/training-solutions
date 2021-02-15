package exam03;

public enum CruiseClass {
    LUXURY(3.0), FIRST(1.8), SECOND(1.0);

    private double extraRate;

    CruiseClass(double extraRate) {
        this.extraRate = extraRate;
    }

    public double getExtraRate() {
        return extraRate;
    }


}
