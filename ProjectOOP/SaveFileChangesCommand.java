package bg.tu_varna.b4.f22621690.Project.MainCommands;

import java.io.*;

import bg.tu_varna.b4.f22621690.Project.Models.Command;
import bg.tu_varna.b4.f22621690.Project.Models.Product;
import bg.tu_varna.b4.f22621690.Project.Models.Warehouse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SaveFileChangesCommand implements Command {


    public static void saveProductsInFile(String filePath) {
        JSONArray productsArray = new JSONArray();

        for (Product product : Warehouse.productList) {
            JSONObject productObj = getJsonObject(product);
            productsArray.add(productObj);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
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
        String filePath = "ProductInWarehouse.json";
        saveProductsInFile(filePath);
    }
}