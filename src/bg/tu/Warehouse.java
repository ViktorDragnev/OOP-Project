package bg.tu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Warehouse {
    public String name;
    public double storageSpace;
    public List<Product> productList = new ArrayList<>();

    public Warehouse(String name, double storageSpace) {
        this.name = name;
        this.storageSpace = storageSpace;
    }

    public void addProduct(Product product) {
        if (!storageSpaceCalculator(product)) {
            System.out.println("Not enough space in the warehouse to add product " + product.getName() + ".");
            return;
        }

        if (updateProductQuantity(product)) {
            System.out.println("Product '" + product.getName() + "' quantity updated successfully in the warehouse.");
        } else {
            productList.add(product);
            System.out.println("Product '" + product.getName() + "' added successfully to the warehouse.");
        }
    }

    public boolean updateProductQuantity(Product product) {
        for (Product p : productList) {
            if (p.getName().equalsIgnoreCase(product.getName()) &&
                    p.getExpiryYear() == product.getExpiryYear() &&
                    p.getExpiryMonth() == product.getExpiryMonth() &&
                    p.getExpiryDay() == product.getExpiryDay()) {
                p.setAvailableQuantity(p.getAvailableQuantity() + product.getAvailableQuantity());
                return true;
            }
        }
        return false;
    }

    public void removeProduct(String productName, int quantityToRemove) {
        List<Product> matchingProducts = getMatchingProducts(productName);

        if (matchingProducts.isEmpty()) {
            System.out.println("No products with the given name found in the warehouse.");
            return;
        }

        displayAvailableQuantitiesAndExpiryDates(matchingProducts);

        double totalAvailableQuantity = getTotalAvailableQuantity(matchingProducts);

        if (quantityToRemove <= totalAvailableQuantity) {
            removeProducts(matchingProducts, quantityToRemove);
        } else {
            System.out.println("Not enough quantity available to remove the requested amount (" + quantityToRemove + ") of product '" + productName + "'.");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Would you like to remove available quantity (Y/N)? ");
            String userChoice = scanner.nextLine().toUpperCase();

            if (userChoice.equals("Y")) {
                removeProducts(matchingProducts, totalAvailableQuantity);
            } else if (userChoice.equals("N")) {
                System.out.println("No products were removed.");
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    public void removeProducts(List<Product> matchingProducts, double quantityToRemove) {
        double removedQuantity = 0;
        for (Product product : matchingProducts) {
            if (removedQuantity >= quantityToRemove) break;

            double availableQuantity = product.getAvailableQuantity();
            if (availableQuantity >= quantityToRemove - removedQuantity) {
                removeProductAndUpdateList(product, quantityToRemove - removedQuantity);
                removedQuantity = quantityToRemove;
            } else {
                removeProductAndUpdateList(product, availableQuantity);
                removedQuantity += availableQuantity;
            }
        }
        System.out.println("Successfully removed " + removedQuantity + " units of product.");
    }

    public void removeProductAndUpdateList(Product product, double quantityToRemove) {
        product.setAvailableQuantity(product.getAvailableQuantity() - quantityToRemove);
        System.out.println("Removed " + quantityToRemove + " units from location " + product.getLocationInWarehouse() + ". Expiry: " + product.getExpiryDay() + "." + product.getExpiryMonth() + "." + product.getExpiryYear());
        if (product.getAvailableQuantity() == 0) {
            productList.remove(product);
        }
    }


    public double getTotalAvailableQuantity(List<Product> matchingProducts) {
        double totalAvailableQuantity = 0;
        for (Product product : matchingProducts) {
            totalAvailableQuantity += product.getAvailableQuantity();
        }
        return totalAvailableQuantity;
    }


    public List<Product> getMatchingProducts(String productName) {
        List<Product> matchingProducts = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().equalsIgnoreCase(productName)) {
                matchingProducts.add(p);
            }
        }
        return matchingProducts;
    }

    public void displayAvailableQuantitiesAndExpiryDates(List<Product> matchingProducts) {
        System.out.println("Available quantities and expiry dates:");
        for (Product p : matchingProducts) {
            System.out.println(p.getAvailableQuantity() + " units at location " + p.getLocationInWarehouse() + ", expiring on " + p.getExpiryDay() + "." + p.getExpiryMonth() + "." + p.getExpiryYear());
        }
    }

    public double calculateAvailableSpace() {
        double usedStorageSpace = 0;
        for (Product product : productList) {
            usedStorageSpace += product.getAvailableQuantity();
        }
        return storageSpace - usedStorageSpace;
    }

    public boolean storageSpaceCalculator(Product product) {
        double availableStorageSpace = calculateAvailableSpace();
        return product.getAvailableQuantity() <= availableStorageSpace;
    }

    public void displayProducts() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public void clean(int cleaningYear, int cleaningMonth, int cleaningDay) {
        LocalDate cleaningDate = LocalDate.of(cleaningYear, cleaningMonth, cleaningDay);

        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);

            if (product.getExpiryYear() < cleaningDate.getYear() ||
                    (product.getExpiryYear() == cleaningDate.getYear() && (product.getExpiryMonth() < cleaningDate.getMonthValue() ||
                            (product.getExpiryYear() == cleaningDate.getYear() && product.getExpiryMonth() == cleaningDate.getMonthValue() && product.getExpiryDay() <= cleaningDate.getDayOfMonth() - 5)))) {

                System.out.println("Removed expired or expiring soon product: " + product.getName() + ", Expiry Date: " + product.getExpiryDay() + "." + product.getExpiryMonth() + "." + product.getExpiryYear());
                productList.remove(i);
                i--;
            }
        }

        System.out.println("Warehouse cleaned successfully.");
        displayProducts();
    }

    public void logChanges(int fromYear, int fromMonth, int fromDay, int toYear, int toMonth, int toDay) {
        LocalDate startingDate = LocalDate.of(fromYear, fromMonth, fromDay);
        LocalDate finalDate = LocalDate.of(toYear, toMonth, toDay);

        for (Product product : productList) {
            if (isWithinPeriod(product.getAcceptYear(), product.getAcceptMonth(), product.getAcceptDay(), startingDate, finalDate)) {
                System.out.println("Product Name: " + product.getName());
                System.out.println("Accepted Date: " + product.getAcceptDay() + "." + product.getAcceptMonth() + "." + product.getAcceptYear());
                System.out.println("Action: " + (product.getAcceptYear() == fromYear && product.getAcceptMonth() == fromMonth && product.getAcceptDay() == fromDay ? "Loaded" : "Unloaded"));
                System.out.println();
            }
        }
    }

    private boolean isWithinPeriod(int year, int month, int day, LocalDate startDate, LocalDate endDate) {
        LocalDate productDate = LocalDate.of(year, month, day);
        return !productDate.isBefore(startDate) && !productDate.isAfter(endDate);
    }
}



