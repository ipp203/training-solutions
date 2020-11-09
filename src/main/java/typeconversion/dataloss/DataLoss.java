package typeconversion.dataloss;

public class DataLoss {

    private static final int NUMBEROFPRINTS = 3;

    public void dataLoss() {
        int counter = 0;

        for (long i = 0; i < Long.MAX_VALUE && counter < NUMBEROFPRINTS; i++) {
            if ((long) (float) i != i) {
                System.out.println(i);
                System.out.println(Long.toBinaryString(i));
                counter++;
            }

        }
    }

    public static void main(String[] args) {
        DataLoss dataLoss = new DataLoss();
        dataLoss.dataLoss();
    }
}
