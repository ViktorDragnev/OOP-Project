package bg.tu_varna.b4.f22621690.Project;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AddProductCommand implements Command {
    public Warehouse warehouse;
    public Scanner scanner;

    AddProductCommand(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }


    @Override
    public void execute() {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        System.out.print("Enter expiry date (yyyy-MM-dd): ");
        String expiryDateStr = scanner.next();
        LocalDate expiryDate;

        try {
            expiryDate = LocalDate.parse(expiryDateStr);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            return;
        }

        System.out.print("Enter entry date (yyyy-MM-dd): ");
        String entryDateStr = scanner.next();
        LocalDate entryDate;
        try {
            entryDate = LocalDate.parse(entryDateStr);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            return;
        }

        System.out.print("Enter product manufacturer: ");
        scanner.nextLine();
        String manufacturer = scanner.nextLine();

        System.out.print("Enter product unit: ");
        String unit = scanner.next();

        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter product location: ");
        String location = scanner.nextLine();

        System.out.print("Enter product comment: ");
        String comment = scanner.nextLine();

        Product newProduct = new Product(name, expiryDate, entryDate, manufacturer, unit, quantity, location, comment);
        warehouse.addProduct(newProduct);
    }
}