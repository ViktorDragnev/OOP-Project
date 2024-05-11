package bg.tu_varna.b4.f22621690.Project.MainCommands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bg.tu_varna.b4.f22621690.Project.Command;
import bg.tu_varna.b4.f22621690.Project.Models.Product;
import bg.tu_varna.b4.f22621690.Project.Models.Warehouse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SaveToDifferentFileCommand implements Command {

    public void saveProductsToDifferentFile(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            JSONArray productsArray = new JSONArray();

            for (Product product : Warehouse.productList) {
                JSONObject productObj = getJsonObject(product);

                productsArray.add(productObj);
            }

            bufferedWriter.write(productsArray.toJSONString());
            System.out.println("Data successfully written to " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error writing products to file: " + e.getMessage());
        }
    }

    private static JSONObject getJsonObject(Product product) {
        JSONObject productObj = new JSONObject();
        productObj.put("name", product.getName());
        productObj.put("expiryDate", product.getExpiryDate().toString());
        productObj.put("entryDate", product.getEntryDate().toString());
        productObj.put("manufacturer", product.getManufacturer());
        productObj.put("unit", product.getUnit());
        productObj.put("quantity", product.getQuantity());
        productObj.put("location", product.getLocation());
        productObj.put("comment", product.getComment());
        productObj.put("pricePerUnit", product.getPricePerUnit());
        return productObj;
    }

    @Override
    public void execute() {
        System.out.println("New file name: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        if (!fileName.endsWith(".json")) {
            fileName += ".json";
        }

        saveProductsToDifferentFile(fileName);

    }
}
