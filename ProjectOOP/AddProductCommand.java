package bg.tu_varna.b4.f22621690.Project.WerehouseCommands;

import bg.tu_varna.b4.f22621690.Project.Models.Command;
import bg.tu_varna.b4.f22621690.Project.Models.Activity;
import bg.tu_varna.b4.f22621690.Project.Models.Log;
import bg.tu_varna.b4.f22621690.Project.Models.Product;
import bg.tu_varna.b4.f22621690.Project.Models.Warehouse;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddProductCommand implements Command {

    private double getAvailableSpace() {
        double usedStorageSpace = 0;
        for (Product product : Warehouse.productList) {
            usedStorageSpace += product.getQuantity();
        }
        return Warehouse.storageSpace - usedStorageSpace;
    }

    private boolean hasEnoughSpace(Product product) {
        return product.getQuantity() <= getAvailableSpace();
    }

    private void add() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter expiry date (yyyy-MM-dd): ");
        String expiryDateStr = scanner.nextLine();
        System.out.print("Enter entry date (yyyy-MM-dd): ");
        String entryDateStr = scanner.nextLine();
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter unit: ");
        String unit = scanner.nextLine();
        System.out.print("Enter quantity: ");
        double quantity;
        try {
            quantity = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("quantity error input");
            return;
        }
        scanner.nextLine();
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        System.out.print("Enter comment: ");
        String comment = scanner.nextLine();
        System.out.print("Enter price per unit: ");
        double pricePerUnit;
        try {
            pricePerUnit = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("price error input");
            return;
        }
        scanner.nextLine();

        Product newProduct = new Product();
        newProduct.setName(productName);
        LocalDate expiryDate = LocalDate.parse(expiryDateStr);
        LocalDate entryDate = LocalDate.parse(entryDateStr);
        newProduct.setExpiryDate(expiryDate);
        newProduct.setEntryDate(entryDate);
        newProduct.setManufacturer(manufacturer);
        newProduct.setUnit(unit);
        newProduct.setQuantity(quantity);
        newProduct.setLocation(location);
        newProduct.setComment(comment);
        newProduct.setPricePerUnit(pricePerUnit);

        checkAndAddProduct(newProduct);
    }


    private void checkAndAddProduct(Product newProduct) {
        if (newProduct == null) {
            System.out.println("Invalid product.");
            return;
        }

        if (!hasEnoughSpace(newProduct)) {
            System.out.println("Not enough space available in storage!!!");
            return;
        }

        boolean productExists = false;

        for (Product product : Warehouse.productList) {
            if (product.getName().equalsIgnoreCase(newProduct.getName()) &&
                    product.getExpiryDate().equals(newProduct.getExpiryDate())) {
                newProduct.setLocation(product.getLocation());
                productExists = true;
                Warehouse.productList.add(newProduct);
                break;
            }
        }

        if (!productExists) {
            Warehouse.productList.add(newProduct);
        }

        Warehouse.logList.add(new Log(newProduct.getName(), newProduct.getQuantity(), newProduct.getEntryDate(), Activity.ADD));
        LogChangesCommand.saveLog();
    }


    @Override
    public void execute() {
        add();
    }
}
