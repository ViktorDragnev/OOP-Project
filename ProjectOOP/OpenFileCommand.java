package bg.tu_varna.b4.f22621690.Project.MainCommands;

import java.io.*;
import java.time.LocalDate;

import bg.tu_varna.b4.f22621690.Project.Models.Command;
import bg.tu_varna.b4.f22621690.Project.Models.Product;
import bg.tu_varna.b4.f22621690.Project.Models.Warehouse;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class OpenFileCommand implements Command {
    private static OpenFileCommand instance;
    public static boolean fileLoaded = false;
    public static String openedFilePath = "ProductInWarehouse.json";


    public static synchronized OpenFileCommand getInstance() {
        if (instance == null) {
            instance = new OpenFileCommand();
        }
        return instance;
    }


    public static void openFile() {
        try {
            File file = new File(openedFilePath);

            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created - " + openedFilePath);
                fileLoaded = true;
                return;
            }

            if (file.length() == 0) {
                System.out.println("File is empty - " + openedFilePath);
                fileLoaded = true;
                return;
            }

            try (FileReader reader = new FileReader(openedFilePath)) {
                JSONParser parser = new JSONParser();
                Object parsedObject = parser.parse(reader);

                if (parsedObject instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) parsedObject;
                    for (Object obj : jsonArray) {
                        JSONObject productObj = (JSONObject) obj;
                        Product product = new Product();
                        product.setName((String) productObj.get("name"));
                        product.setExpiryDate(LocalDate.parse((String) productObj.get("expiryDate")));
                        product.setEntryDate(LocalDate.parse((String) productObj.get("entryDate")));
                        product.setManufacturer((String) productObj.get("manufacturer"));
                        product.setUnit((String) productObj.get("unit"));
                        product.setQuantity(((Number) productObj.get("quantity")).doubleValue());
                        product.setLocation((String) productObj.get("location"));
                        product.setComment((String) productObj.get("comment"));
                        product.setPricePerUnit(((Number) productObj.get("pricePerUnit")).doubleValue());
                        Warehouse.productList.add(product);
                    }
                    System.out.println("Successfully opened " + openedFilePath);
                    fileLoaded = true;
                }

            } catch (IOException | ParseException e) {
                System.out.println("Error parsing or reading file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }


    public static boolean isFileLoaded() {
        return fileLoaded;
    }


    @Override
    public void execute() {
        openFile();
    }
}
