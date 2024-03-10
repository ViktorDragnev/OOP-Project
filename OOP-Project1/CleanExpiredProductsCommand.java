package bg.tu_varna.b4.f22621690.Project;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CleanExpiredProductsCommand implements Command {
    public Warehouse warehouse;
    public Scanner scanner;


    public CleanExpiredProductsCommand(Warehouse warehouse, Scanner scanner) {
        this.warehouse=warehouse;
        this.scanner=scanner;
    }


    public void cleanExpiredProductsToCertainDate(LocalDate comparisonDate){
        List<Product> products = warehouse.getProducts();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (isExpired(product, comparisonDate)) {
                System.out.println("Removing expired product " + product.getName());
                iterator.remove();
            } else {
                System.out.println("Product " + product.getName() + " is still valid.");
            }
        }
    }

    public boolean isExpired(Product product, LocalDate comparisonDate) {
        return product.getExpiryDate().isBefore(comparisonDate);
    }



    @Override
    public void execute() {
        System.out.print("Enter date for cleaning: ");
        Scanner dateForCleaning = new Scanner(System.in);

        String comparisonDateStr = dateForCleaning.next();
        LocalDate comparisonDate = LocalDate.parse(comparisonDateStr);

        cleanExpiredProductsToCertainDate(comparisonDate);

        dateForCleaning.close();
    }
}
