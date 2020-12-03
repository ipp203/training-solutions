package inheritancemethods;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Product {
    private String name;
    private BigDecimal unitWeight;
    private int numberOfDecimals = 2;

    public Product(String name, BigDecimal unitWeight, int numberOfDecimals) {
        this(name, unitWeight);
        this.numberOfDecimals = numberOfDecimals;
    }

    public Product(String name, BigDecimal unitWeight) {
        this.name = name;
        this.unitWeight = unitWeight;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }

    public BigDecimal totalWeight(int pieces) {
        return unitWeight.multiply(new BigDecimal(pieces))
                .setScale(numberOfDecimals, RoundingMode.HALF_UP);
    }
}
