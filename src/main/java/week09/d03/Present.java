package week09.d03;

public enum Present {
    TOY("toy"),
    ELECTRONIC("electronic"),
    HOUSEKEEPING("housekeeping"),
    DECORATION("decoration");

    private String name;

    Present(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
