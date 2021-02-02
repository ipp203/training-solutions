package week14.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ShopManager {

    Map<String, List<Shopping>> map = new HashMap<>();
    Set<String> productsName = new HashSet<>();

    public void readFile(BufferedReader reader) {
        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                splitLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void splitLine(String line) {
        String[] parts = line.split(": ");

        String shopperID = getShopperId(parts[0]);
        String shopID = getShopId(parts[0]);

        List<Product> products = getProductList(parts[1]);

        addToMap(shopperID, new Shopping(shopID, products));

        addProductsToProductsName(products);
    }

    private String getShopperId(String linePart) {
        return linePart.split("-")[0];
    }

    private String getShopId(String linePart) {
        return linePart.split("-")[1];
    }

    private List<Product> getProductList(String linePart) {
        List<Product> result = new ArrayList<>();
        String[] products = linePart.split(",");
        for (String p : products) {
            String name = p.substring(0, p.indexOf("("));
            String price = p.substring(p.indexOf("(") + 1, p.indexOf(")"));
            result.add(new Product(name, Integer.parseInt(price)));
        }
        return result;
    }

    private void addProductsToProductsName(List<Product> products) {
        productsName.addAll(products.stream()
                .map(Product::getName)
                .collect(Collectors.toSet())
        );
    }

    private void addToMap(String shopperId, Shopping list) {
        if (!map.containsKey(shopperId)) {
            map.put(shopperId, new ArrayList<>());
        }
        map.get(shopperId).add(list);
    }

    public int getPriceById(String id) {
        for (Map.Entry<String, List<Shopping>> entry : map.entrySet()) {
            int result = entry.getValue().stream()
                    .filter(s -> s.getId().equals(id))
                    .reduce(0, (i, s) -> i + s.sumPrice(), Integer::sum);
            if (result > 0) {
                return result;
            }
        }
        throw new IllegalArgumentException("No data");
    }

    public int getPriceByShopper(String shopperId) {
        List<Shopping> shopping = map.get(shopperId);
        return shopping.stream().reduce(0, (i, s) -> i + s.sumPrice(), Integer::sum);
    }

    public List<Product> sortedBy(String name, String shopId, Comparator<Product> comp) {

        List<Product> result;
        if (map.containsKey(name)) {
            result = map.get(name).stream()
                    .filter(s -> s.getId().equals(shopId))
                    .map(Shopping::getProducts)
                    .flatMap(l -> l.stream())
                    .sorted(comp)
                    .collect(Collectors.toList());
        }else{
            throw new IllegalArgumentException("No data");
        }
        return result;
    }

    public int numberProduct(String productName) {
        int sum = 0;
        for (Map.Entry<String, List<Shopping>> entry : map.entrySet()) {
            sum += entry.getValue().stream()
                    .map(Shopping::getProducts)
                    .flatMap(l -> l.stream())
                    .filter(p -> p.getName().equals(productName))
                    .count();
        }
        return sum;
    }

    public Map<String, Integer> statistics() {
        Map<String, Integer> result = new HashMap<>();
        for (String name : productsName) {
            result.put(name, numberProduct(name));
        }
        return result;
    }

//    public static void main(String[] args) {
//        ShopManager test = new ShopManager();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(ShopManager.class.getResourceAsStream("shoppinglist.txt")));
//        test.readFile(reader);
//        System.out.println(test.getPriceByShopper("BK123"));
//        System.out.println(test.getPriceById("1211"));
//        System.out.println(test.sortedBy("BK123", "1211", Comparator.comparing(Product::getName)));
//        System.out.println(test.sortedBy("BK123", "1211", Comparator.comparing(Product::getPrice)));
//        System.out.println(test.numberProduct("bread"));
//        Map<String, Integer> map = test.statistics();
//        System.out.println(map.entrySet());
//    }
}
