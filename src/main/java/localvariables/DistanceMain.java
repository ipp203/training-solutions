package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance d = new Distance(10.123,true);
        System.out.println("Távolság = " + d.getDistanceInKm() + " Pontosság: " + d.isExact());
        int i = (int) d.getDistanceInKm();
        System.out.println("Távolság = " + i + " km");
    }
}
