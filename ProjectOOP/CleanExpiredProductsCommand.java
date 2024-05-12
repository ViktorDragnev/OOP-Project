package bg.tu_varna.b4.f22621690.Project.WerehouseCommands;

import bg.tu_varna.b4.f22621690.Project.Models.Command;
import bg.tu_varna.b4.f22621690.Project.Models.Activity;
import bg.tu_varna.b4.f22621690.Project.Models.Log;
import bg.tu_varna.b4.f22621690.Project.Models.Product;
import bg.tu_varna.b4.f22621690.Project.Models.Warehouse;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;

public class CleanExpiredProductsCommand implements Command {

    public void clean() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cleaning date: (yyyy-MM-dd)");
        LocalDate cleaningDate = LocalDate.parse(scanner.nextLine());

        Iterator<Product> iterator = Warehouse.productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getExpiryDate().isBefore(cleaningDate.minusDays(10))) {
                System.out.println("Removed expired or expiring soon product: " + product.getName() + ", Expiry Date: " + product.getExpiryDate());
                Warehouse.logList.add(new Log(product.getName(), product.getQuantity(), cleaningDate, Activity.CLEAN));
                LogChangesCommand.saveLog();
                iterator.remove();
            }
        }
    }

    @Override
    public void execute() {
        clean();
    }
}
