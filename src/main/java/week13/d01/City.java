package week13.d01;


public class City {
    private final String name;
    private final String district;
    private final int zipCode;

    public City(int zipCode, String name, String district) {
        this.name = name;
        this.district = district;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public String toString() {
        return name + " " + district + " " + zipCode;
    }
}
