package bg.tu_varna.b4.f22621690.Project.MainCommands;

import bg.tu_varna.b4.f22621690.Project.Command;

public class DisplayHelpCommand implements Command {

    @Override
    public void execute() {
        System.out.println("The following commands are supported:");
        System.out.println("1 - Open file");
        System.out.println("2 - Add a product to the list");
        System.out.println("3 - Remove a product by name");
        System.out.println("4 - Display all products from the file");
        System.out.println("5 - Clean all the products with expired date");
        System.out.println("6 - Save the currently open file");
        System.out.println("7 - Save the currently opened file anew");
        System.out.println("8 - Close currently opened file");
        System.out.println("9 - Display logs");
        System.out.println("10 - Display this information");
        System.out.println("11 - Exit the program");
    }
}
