package bg.tu_varna.b4.f22621690.Project.MainCommands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bg.tu_varna.b4.f22621690.Project.Models.Command;
import bg.tu_varna.b4.f22621690.Project.Models.Product;
import bg.tu_varna.b4.f22621690.Project.Models.Warehouse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SaveToDifferentFileCommand implements Command {

    @Override
    public void execute() {
        System.out.println("New file name: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        if (!fileName.endsWith(".json")) {
            fileName += ".json";
        }

        SaveFileChangesCommand.saveProductsInFile(fileName);

    }
}
