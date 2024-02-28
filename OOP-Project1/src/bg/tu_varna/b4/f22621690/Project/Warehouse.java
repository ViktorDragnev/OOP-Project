package bg.tu_varna.b4.f22621690.Project;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(Product product) {
        products.remove(product);
    }

    void updateProduct(Product oldProduct, Product newProduct) {
        if (products.contains(oldProduct)) {
            int index = products.indexOf(oldProduct);
            products.set(index, newProduct);
        }
    }

    List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    void printProducts() {
        for (Product product : products) {
            System.out.println(product.name + " - " + product.quantity + " " + product.unit + " - " + product.location);
        }
    }
}
