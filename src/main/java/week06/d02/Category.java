package week06.d02;

public enum Category {
    FROZEN("frozen"), DAIRY("dairy"), BAKEDGOODS("baked goods"), OTHER("other");
    private int number;
    private String name;

    Category(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + number;
    }

    public void incNumber() {
        number++;
    }
}
