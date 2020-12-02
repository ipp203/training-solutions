package objectclass;

public class Beer {
    private String name;
    private int price;

    public Beer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) { // generált metódus!
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        Beer beer = (Beer) o;
        boolean result;

        if (name == null) {
            result = beer.name == null;
        } else {
            result = name.equals(beer.name);
        }

        result = result && price == beer.price;

        return result;
    }
}
