package bg.tu_varna.b4.f22621690.Project;

import java.time.LocalDate;
import java.util.*;

public class Warehouse {
    //TODO: private static String logFilePath = "logChanges.txt";
    List<Product> products = new ArrayList<>();


    public void addProduct(Product product) {
        products.add(product);
    }


    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public Product getProductByNameAndExpiryDate(String name, LocalDate expiryDate) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getExpiryDate().equals(expiryDate)) {
                return product;
            }
        }
        return null;
    }

    public Product getProductByNameAndQuantity(String name, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getQuantity() <= quantity) {
                System.out.println("The product for removal is "+ product.getName() + "and was located on " + product.getLocation());
                return product;
            }

        }
        System.out.println("Product not found!");
        return null;
    }



    /*
    public void reduceProductByNameAndQuantity(String name, int quantity) {
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().equals(name)) {
                matchingProducts.add(product);
            }
        }

        if (matchingProducts.size() > 1) {
            Collections.sort(matchingProducts, (p1, p2) -> p1.getExpiryDate().compareTo(p2.getExpiryDate()));
        }

        int remainingQuantity = quantity;
        for (Product product : matchingProducts) {
            int quantityToReduce = Math.min(remainingQuantity, product.getQuantity());
            product.reduceQuantity(quantityToReduce);

            System.out.println("Reduced quantity of " + name + " in location " + product.getLocation() +
                    " by " + quantityToReduce + " from batch with expiry date " + product.getExpiryDate());

            remainingQuantity -= quantityToReduce;

            if (remainingQuantity == 0) {
                break;
            }
        }

        matchingProducts.removeIf(product -> product.getQuantity() == 0);
    }
    public void reduceQuantity(int quantityToReduce) {
        if (quantityToReduce >= 0 && quantityToReduce <= this.quantity) {
            this.quantity -= quantityToReduce;
        } else {
            System.out.println("Invalid quantity to reduce for product " + this.name);
        }
    }     */


}
