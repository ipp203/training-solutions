package week12.d01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsPacker {
    public int packGoods(int[][] types, int capacity) {
        List<ProductType> goods = typesToList(types);
        Collections.sort(goods);
        Collections.reverse(goods);
        int weightSum = 0;
        int priceSum = 0;
        for (ProductType productType : goods) {
            while (weightSum + productType.getWeight() <= capacity) {
                weightSum += productType.getWeight();
                priceSum += productType.getPrice();
            }
        }
        return priceSum;
    }

    private List<ProductType> typesToList(int[][] types) {
        if (types == null) {
            throw new IllegalArgumentException("types is null");
        }
        List<ProductType> result = new ArrayList<>();
        for (int[] arr : types) {
            result.add(new ProductType(arr[0], arr[1]));
        }
        return result;
    }
}
