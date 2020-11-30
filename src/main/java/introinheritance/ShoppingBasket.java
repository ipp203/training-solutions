package introinheritance;

public class ShoppingBasket {
    private Basket basket;

    public ShoppingBasket() {
        basket = new Basket();
    }

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {          // az összes tételre
        double sum = 0;
        for (Item item : basket.getItems()) {
            sum += item.getNettoPrice();
        }
        return sum;
    }

    public double sumTaxValue() {  // az összes tételre
        double sum = 0;
        for (Item item : basket.getItems()) {
            sum += item.getTaxAmount();
        }
        return sum;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {// befejezzük a vásárlást, a kosár ürítése
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() { // kikeresi és eltávolítja a kosárból a legdrágább tételt
        double maxim = Double.NEGATIVE_INFINITY;
        String maxPricedItemBarcode = "";
        for (Item item : basket.getItems()) {
            if (item.getNettoPrice() + item.getTaxAmount() > maxim) {
                maxim = item.getNettoPrice() + item.getTaxAmount();
                maxPricedItemBarcode = item.getBarcode();
            }
        }
        if (!"".equals(maxPricedItemBarcode)) {
            basket.removeItem(maxPricedItemBarcode);
        }
    }
}
