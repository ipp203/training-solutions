package lambdaprimitives;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;

public class SportGadgetStore {
    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    //    getNumberOfProducts(): összesen hány termék van a boltban,
    public int getNumberOfProducts() {
        return products.stream().mapToInt(Product::getNumber).sum();
    }

    //    getAveragePrice(): átlagosan mennyibe kerül egy termék. Ha nincs termék, 0-t adjon vissza.
    public double getAveragePrice() {
        OptionalDouble opt = products.stream().mapToDouble(Product::getPrice).average();
        if (opt.isPresent()) {
            return opt.getAsDouble();
        }
        return 0;
    }


    //   getExpensiveProductStatistics(double minPrice): adott árnál drágább termékek darabszámáról szolgáltat statisztikát. Az összesítést szövegként adja vissza az alábbi formában:
    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics statOfExpensiveProduct = products.stream().filter(p -> p.getPrice() > minPrice).
                mapToInt(Product::getNumber).summaryStatistics();
        if (statOfExpensiveProduct.getCount() == 0) {
            return "Nincs ilyen termék.";
        }
        return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.",
                statOfExpensiveProduct.getCount(),
                statOfExpensiveProduct.getMin(),
                statOfExpensiveProduct.getMax(),
                statOfExpensiveProduct.getSum());
    }

    //    Összesen 3 féle termék, amelyekből minimum 1 db, maximum 52 db, összesen 74 db van.
//
//    Ha nincs ilyen, akkor a visszaadott szöveg a Nincs ilyen termék. legyen!
}
