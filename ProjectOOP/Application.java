package bg.tu_varna.b4.f22621690.Project;

import bg.tu_varna.b4.f22621690.Project.MainCommands.*;
import bg.tu_varna.b4.f22621690.Project.Models.Command;
import bg.tu_varna.b4.f22621690.Project.WerehouseCommands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Integer, Command> commands = new HashMap<>();

        commands.put(1, new OpenFileCommand());
        commands.put(2, new AddProductCommand());
        commands.put(3, new RemoveProductCommand());
        commands.put(4, new DisplayProductsCommand());
        commands.put(5, new CleanExpiredProductsCommand());
        commands.put(6, new SaveFileChangesCommand());
        commands.put(7, new SaveToDifferentFileCommand());
        commands.put(8, new CloseFileCommand());
        commands.put(9, new LogChangesCommand());
        commands.put(10, new DisplayHelpCommand());
        commands.put(11, new ExitCommand());

        while (true) {

            System.out.println("\n1. Open File");
            System.out.println("2. Add product");
            System.out.println("3. Remove product");
            System.out.println("4. Display products");
            System.out.println("5. Clean expired products");
            System.out.println("6. Save file changes");
            System.out.println("7. Save list in a different file");
            System.out.println("8. Close current file");
            System.out.println("9. Display logs");
            System.out.println("10. Display commands");
            System.out.println("11. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("\n");

            if (commands.containsKey(choice)) {
                if (choice != 1 && !OpenFileCommand.isFileLoaded()) {
                    System.out.println("File must first be open in order to " +
                            "use the rest of the commands.");
                } else {
                    commands.get(choice).execute();
                }

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
