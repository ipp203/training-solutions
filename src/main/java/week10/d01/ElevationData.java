package week10.d01;

public class ElevationData {
    private double inc;
    private double dec;

    public double getInc() {
        return inc;
    }

    public double getDec() {
        return dec;
    }

    public void plusInc(double value) {
        inc += value;
    }

    public void plusDec(double value) {
        dec += value;
    }

}
