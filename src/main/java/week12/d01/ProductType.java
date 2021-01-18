package week12.d01;

public class ProductType implements Comparable<ProductType> {
    private int weight;
    private int price;

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

    @Override
    public int compareTo(ProductType o) {
        return (int) ((double) price / weight - (double) o.price / o.weight);
    }
}
