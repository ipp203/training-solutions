package week12.d01;


public class ProductType implements Comparable<ProductType> {
    private final int weight;
    private final int price;

    public ProductType(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    private double getRate() {
        return (double) (price) / weight;
    }

    @Override
    public int compareTo(ProductType o) {
        return Double.compare(getRate(), o.getRate());
    }
}
