package attributes.bill;

public class BillMain {
    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("alma", 2, 10.2));
        bill.addItem(new Item("korte", 3, 12.7));
        bill.addItem(new Item("dio", 20, 30.1));
        bill.addItem(new Item("repa", 2, 9.9));

        for (Item i : bill.getItems()) {
            System.out.println(i.getProduct() + " " + i.getQuantity() + "db " + i.getPrice() + " €");
        }
        System.out.println("Összesen: " + Math.round(100.0 * bill.calculateTotalPrice()) / 100.0 + " €");
    }
}
