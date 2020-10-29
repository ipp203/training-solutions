package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store1 = new Store("Book");
        Store store2 = new Store("eBook");

        store1.store(33);
        store2.store(121);

        System.out.println(store1.getProduct() + ": " + store1.getStock());
        System.out.println(store2.getProduct() + ": " + store2.getStock());

        store1.dispatch(11);
        store2.dispatch(81);

        System.out.println(store1.getProduct() + ": " + store1.getStock());
        System.out.println(store2.getProduct() + ": " + store2.getStock());
    }
}
