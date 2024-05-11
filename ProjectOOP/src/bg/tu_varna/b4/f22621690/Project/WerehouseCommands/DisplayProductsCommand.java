package bg.tu_varna.b4.f22621690.Project.WerehouseCommands;

import java.io.FileReader;
import java.io.IOException;

import bg.tu_varna.b4.f22621690.Project.Command;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DisplayProductsCommand implements Command {

    @Override
    public void execute() {
        String filePath = "ProductInWarehouse.json";

        try (FileReader fileReader = new FileReader(filePath)) {
            JSONParser jsonParser = new JSONParser();
            Object parsedObject = jsonParser.parse(fileReader);

            if (parsedObject == null) {
                System.out.println("null field in parsed object");
                return;
            }

            if (parsedObject instanceof JSONArray productsArray) {
                displayProducts(productsArray);
            } else {
                System.out.println("error in the structure of the file read");
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Error reading products from file: " + e.getMessage());
        }
    }

    private void displayProducts(JSONArray productsArray) {
        for (Object obj : productsArray) {
            JSONObject productData = (JSONObject) obj;
            System.out.println("Name: " + productData.get("name"));
            System.out.println("Expiry Date: " + productData.get("expiryDate"));
            System.out.println("Entry Date: " + productData.get("entryDate"));
            System.out.println("Manufacturer: " + productData.get("manufacturer"));
            System.out.println("Unit: " + productData.get("unit"));
            System.out.println("Quantity: " + productData.get("quantity"));
            System.out.println("Location: " + productData.get("location"));
            System.out.println("Comment: " + productData.get("comment"));
            System.out.println("Price per unit: " + productData.get("pricePerUnit"));
            System.out.println();
        }
    }
}
