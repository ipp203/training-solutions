package ioreadwritebytes;

public class Temperatures {
    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double result = 0.0;
        for (byte temp : data) {
            result += temp;
        }
        return result / (double) data.length;
    }

    public double getMonthAverage() {
        double result = 0.0;
        int startIndex = Math.max(0, data.length - 30);
        for (int i = startIndex; i < data.length; i++) {
            result += data[i];
        }
        return result / (double) (data.length - startIndex);
    }
}
