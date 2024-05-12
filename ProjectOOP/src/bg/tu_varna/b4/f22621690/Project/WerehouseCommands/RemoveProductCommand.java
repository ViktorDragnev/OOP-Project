package bg.tu_varna.b4.f22621690.Project.WerehouseCommands;

import bg.tu_varna.b4.f22621690.Project.Models.Command;
import bg.tu_varna.b4.f22621690.Project.Models.Activity;
import bg.tu_varna.b4.f22621690.Project.Models.Log;
import bg.tu_varna.b4.f22621690.Project.Models.Product;
import bg.tu_varna.b4.f22621690.Project.Models.Warehouse;

import java.time.LocalDate;
import java.util.*;

public class RemoveProductCommand implements Command {

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter the quantity to remove: ");
        double quantityToRemove = scanner.nextDouble();
        scanner.nextLine();

        List<Product> matchingProducts = getMatchingProducts(productName);
        Collections.sort(matchingProducts);

        if (matchingProducts.isEmpty()) {
            System.out.println("No products with the given name found in the warehouse.");
            return;
        }

        double totalAvailableQuantity = getTotalAvailableQuantity(matchingProducts);

        if (quantityToRemove <= totalAvailableQuantity) {
            double remainingQuantityToRemove = quantityToRemove;

            for (Product product : matchingProducts) {
                double availableQuantity = product.getQuantity();

                if (remainingQuantityToRemove <= availableQuantity) {
                    product.setQuantity(availableQuantity - remainingQuantityToRemove);
                    Warehouse.logList.add(new Log(product.getName(), remainingQuantityToRemove, LocalDate.now(), Activity.REMOVE));
                    LogChangesCommand.saveLog();

                    if (product.getQuantity() <= 0) {
                        Warehouse.productList.remove(product);
                    }
                    break;
                } else {
                    Warehouse.logList.add(new Log(product.getName(), availableQuantity, LocalDate.now(), Activity.REMOVE));
                    LogChangesCommand.saveLog();
                    remainingQuantityToRemove -= availableQuantity;
                    Warehouse.productList.remove(product);
                }
            }
        } else {
            System.out.println("Not enough quantity available to remove the requested amount of '" + productName);
            System.out.print("Would you like to remove available quantity (Y/N)? ");
            String userChoice = scanner.nextLine();

            if (userChoice.equalsIgnoreCase("Y")) {
                for (Product product : matchingProducts) {
                    Warehouse.logList.add(new Log(product.getName(), product.getQuantity(), LocalDate.now(), Activity.REMOVE));
                }
                Warehouse.productList.removeAll(matchingProducts);
                LogChangesCommand.saveLog();
            } else if (userChoice.equalsIgnoreCase("N")) {
                System.out.println("No products were removed.");
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    private List<Product> getMatchingProducts(String productName) {
        List<Product> mP = new ArrayList<>();

        for (Product p : Warehouse.productList) {
            if (p.getName().equalsIgnoreCase(productName)) {
                mP.add(p);
            }
        }
        return mP;
    }

    private double getTotalAvailableQuantity(List<Product> mP1) {
        double totalAvailableQuantity = 0;
        for (Product product : mP1) {
            totalAvailableQuantity += product.getQuantity();
        }
        return totalAvailableQuantity;
    }

    @Override
    public void execute() {
        remove();
    }
}
