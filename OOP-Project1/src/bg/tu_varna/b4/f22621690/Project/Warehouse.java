package bg.tu_varna.b4.f22621690.Project;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Warehouse {
    private static String logFilePath = "logChanges.txt";
    public static String openedFilePath;
    List<Product> products = new ArrayList<>();
    public static boolean fileLoaded = false;


    public static void openFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Successfully opened " + filePath);

            openedFilePath = filePath;
            fileLoaded = true;
        } catch (FileNotFoundException e) {
            createNewFile(filePath);
            System.out.println("File not found. Created a new file: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error reading products from file: " + e.getMessage());
        }
    }

    private static void createNewFile(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
        } catch (IOException e) {
            throw new RuntimeException("Error creating a new file: " + e.getMessage());
        }
    }

    public void closeFile() {
        if(fileLoaded) {
            fileLoaded = false;
            openedFilePath = null;
            System.out.println("File closed successfully");
        }else{
            System.out.println("File was closed already");
        }
    }



    public void printProductsFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Test.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading products from file: " + e.getMessage());
        }
    }


    public void addProduct(Product newProduct) {
        products.add(newProduct);
        logChanges(newProduct.getName(),newProduct.getQuantity());
    }

    public void removeProduct(Product product) {
        products.remove(product);
        logChanges(product.getName(), product.getQuantity());
    }

    private void logChanges(String productName,int quantity) {
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(logFilePath, true))) {
            logWriter.write("Product: " + productName + "\nQuantity: " + quantity +"\n");
        } catch (IOException e) {
            throw new RuntimeException("Error writing to log file: " + e.getMessage());
        }
    }


    public void cleanExpiredProductsToCertainDate(LocalDate comparisonDate) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (isExpired(product, comparisonDate)) {
                System.out.println("Removing expired product " + product.getName());
                iterator.remove();
            } else {
                System.out.println("Product " + product.getName() + " is still valid.");
            }
        }
    }

    public boolean isExpired(Product product, LocalDate comparisonDate) {
        return product.getExpiryDate().isBefore(comparisonDate);
    }



    public void saveProductsInFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Test.txt", true))) {
            for (Product product : products) {
                bufferedWriter.write("\nName: " + product.getName() + "\n");
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
            throw new RuntimeException("Error writing products to file: " + e.getMessage());
        }
    }



    public void saveProductsToDifferentFile(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                bufferedWriter.write("\nName: " + product.getName() + "\n");
                bufferedWriter.write("Expiry Date: " + product.getExpiryDate() + "\n");
                bufferedWriter.write("Entry Date: " + product.getEntryDate() + "\n");
                bufferedWriter.write("Manufacturer: " + product.getManufacturer() + "\n");
                bufferedWriter.write("Unit: " + product.getUnit() + "\n");
                bufferedWriter.write("Quantity: " + product.getQuantity() + "\n");
                bufferedWriter.write("Location: " + product.getLocation() + "\n");
                bufferedWriter.write("Comment: " + product.getComment() + "\n\n");
            }
            System.out.println("Data successfully written to " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error writing products to file: " + e.getMessage());
        }
    }



    public Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }



    public void displayHelp() {
        System.out.println("The following commands are supported:");
        System.out.println("1 - Opens Test.txt");
        System.out.println("2 - Adds a product to the list");
        System.out.println("3 - Removes a product by name");
        System.out.println("4 - Displays all products from the file");
        System.out.println("5 - Cleans all the products with expired date");
        System.out.println("6 - Saves the currently open file");
        System.out.println("7 - Saves the currently opened file anew");
        System.out.println("8 - Closes currently opened file");
        System.out.println("9 - Displays this information");
        System.out.println("10 - Exits the program");
    }
}

