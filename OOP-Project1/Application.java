package bg.tu_varna.b4.f22621690.Project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Command> commands = new HashMap<>();

        commands.put(1, new OpenFileCommand(warehouse));
        commands.put(2, new AddProductCommand(warehouse, scanner));
        commands.put(3, new RemoveProductCommand(warehouse, scanner));
        commands.put(4, new DisplayProductsCommand(warehouse));
        commands.put(5, new CleanExpiredProductsCommand(warehouse, scanner));
        commands.put(6, new SaveFileChangesCommand(warehouse));
        commands.put(7, new SaveToDifferentFileCommand(warehouse));
        commands.put(8, new CloseFileCommand());
        commands.put(9, new DisplayHelpCommand());
        commands.put(10, new ExitCommand());

        while (true) {

            displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (commands.containsKey(choice)) {
                if (choice != 1 && !OpenFileCommand.isFileLoaded()) {
                    System.out.println("File must be open in order to " +
                            "use the rest of the commands.");

                } else {
                    commands.get(choice).execute();
                }

            } else {
                System.out.println("Invalid option. Please try again.");
            }

        }
    }

    private static void displayMenu() {
        System.out.println("\n1. Open File");
        System.out.println("2. Add product");
        System.out.println("3. Remove product");
        System.out.println("4. Display all products");
        System.out.println("5. Clean expired products");
        System.out.println("6. Save file changes");
        System.out.println("7. Save list in a different file");
        System.out.println("8. Close current file");
        System.out.println("9. Display all commands");
        System.out.println("10. Exit\n");
    }
}
