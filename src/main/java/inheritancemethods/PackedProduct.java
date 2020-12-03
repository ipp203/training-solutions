package inheritancemethods;

import java.math.BigDecimal;
import java.math.MathContext;

public class PackedProduct extends Product {
    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        BigDecimal numberOfBox = new BigDecimal(Math.ceil((double) pieces / packingUnit));
        return super.totalWeight(pieces).add(weightOfBox.multiply(numberOfBox));
    }
}
