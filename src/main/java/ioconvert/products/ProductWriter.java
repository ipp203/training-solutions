package ioconvert.products;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class ProductWriter {

    public void saveProduct(OutputStream outputStream, List<Product> products) {
        PrintStream ps = new PrintStream(new BufferedOutputStream(outputStream));
        for (Product product : products) {
            ps.print(product.getName());
            ps.print(";");
            ps.println(product.getPrice());
        }
        ps.close();
    }
}
