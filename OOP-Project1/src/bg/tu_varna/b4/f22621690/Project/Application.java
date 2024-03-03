package bg.tu_varna.b4.f22621690.Project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Application {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        //LocalDate comparisonDate = LocalDate.of(2022, 3, 2);

        /*try {
            LocalDate comparisonDate = LocalDate.of(2022, 3, 2);

            LocalDate entryDate1 = LocalDate.of(2022, 2, 28);
            LocalDate expiryDate1 = LocalDate.of(2022, 3, 1);

            LocalDate entryDate2 = LocalDate.of(2022, 2, 28);
            LocalDate expiryDate2 = LocalDate.of(2022, 3, 3);

            LocalDate expiryDate3 = LocalDate.of(2022, 3, 1);
            LocalDate entryDate3 = LocalDate.of(2022, 2, 28);

            Product product1 = new Product("Item1", expiryDate1, entryDate1, "M1", "litre", 10, "L1", "C1");
            Product product2 = new Product("Item2", expiryDate2, entryDate2, "M2", "kg", 5, "L2", "C2");
            Product product3 = new Product("Item3", expiryDate3, entryDate3, "M3", "gm", 10, "L2", "C3");

            warehouse.addProduct(product1);
            warehouse.addProduct(product2);
            warehouse.addProduct(product3);

            //System.out.println("\nAll Products:\n");
            //warehouse.printProducts();

            //warehouse.removeProduct(product1);
            //System.out.println("\nProducts after removal:\n");

            //warehouse.printProducts();

            //warehouse.cleanExpiredProducts(comparisonDate);

            /*try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Test.txt"))) {
                for (Product product : warehouse.products) {
                    bufferedWriter.write("Name: " + product.getName() + "\n");
                    bufferedWriter.write("Expiry Date: " + product.getExpiryDate() + "\n");
                    bufferedWriter.write("Entry Date: " + product.getEntryDate() + "\n");
                    bufferedWriter.write("Manufacturer: " + product.getManufacturer() + "\n");
                    bufferedWriter.write("Unit: " + product.getUnit() + "\n");
                    bufferedWriter.write("Quantity: " + product.getQuantity() + "\n");
                    bufferedWriter.write("Location: " + product.getLocation() + "\n");
                    bufferedWriter.write("Comment: " + product.getComment() + "\n\n");
                }

                System.out.println("Data successfully written to Test.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n1. Open File");
            System.out.println("2. Add product");
            System.out.println("3. Remove product");
            System.out.println("4. Display all products");
            System.out.println("5. Clean expired products");
            System.out.println("6. Save file changes");
            System.out.println("7. Save list in a different file");
            System.out.println("8. Close current file");
            System.out.println("9. Display all commands");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: \n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Warehouse.openFile("Test.txt");
                    break;


                case 2:
                    System.out.print("Enter product: ");
                    String productName = scanner.next();
                    LocalDate expiryDate = LocalDate.parse(scanner.next());
                    LocalDate entryDate = LocalDate.parse(scanner.next());
                    String manufacturer = scanner.next();
                    String unit = scanner.next();
                    int quantity = Integer.parseInt(scanner.next());
                    String location = scanner.next();
                    String comment = scanner.nextLine();
                    Product newProduct = new Product(productName, expiryDate, entryDate,
                            manufacturer, unit, quantity, location, comment);
                    warehouse.addProduct(newProduct);
                    break;



                case 3:
                    System.out.print("Remove product: ");
                    String productForRemovalName = scanner.next();
                    Product productToRemove = warehouse.getProductByName(productForRemovalName);

                    if (productToRemove != null) {
                        warehouse.removeProduct(productToRemove);
                        System.out.println("Product " + productForRemovalName + " removed successfully from " +
                                productToRemove.getLocation() + ".");
                    } else {
                        System.out.println("Product " + productForRemovalName + " not found.");
                    }
                    break;



                case 4:
                    warehouse.printProductsFromFile();
                    break;



                case 5:
                    Scanner dateForCleaning = new Scanner(System.in);
                    System.out.print("Enter date for cleaning: ");
                    String comparisonDateStr = dateForCleaning.next();
                    LocalDate comparisonDate = LocalDate.parse(comparisonDateStr);
                    warehouse.cleanExpiredProductsToCertainDate(comparisonDate);
                    dateForCleaning.close();
                    break;



                case 6:
                    warehouse.saveProductsInFile();
                    break;



                case 7:
                    warehouse.saveProductsToDifferentFile("Test2.txt");
                    break;



                case 8:
                    warehouse.closeFile();
                    break;



                case 9:
                    warehouse.displayHelp();
                    break;



                case 10:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;



                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (true);
    }
}

