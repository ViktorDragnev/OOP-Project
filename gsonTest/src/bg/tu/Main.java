package bg.tu;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Warehouse warehouse1 = new Warehouse("WH1", 1000);

        Gson gson1 = new Gson();

        Product product1 = new Product("Apples", 2024, 12, 1, 2024, 12, 30, "M1", "kg", 50, "S5,R4,N3", "C1");
        Product product2 = new Product("Apples", 2024, 12, 1, 2024, 12, 30, "M1", "kg", 100, "S5,R4,N3", "C2");
        Product product3 = new Product("Apples", 2024, 9, 10, 2024, 10, 15, "M1", "kg", 100, "S5,R4,N2", "C3");


        warehouse1.addProduct(product1);
        warehouse1.addProduct(product2);
        warehouse1.addProduct(product3);


        String json1 = gson1.toJson(warehouse1);

        try (FileWriter fileWriter = new FileWriter("products.json")) {
            fileWriter.write(json1);
            System.out.println("JSON file saved.");
        } catch (IOException e) {
            System.err.println("Error with saving: " + e.getMessage());
        }


    }
}
