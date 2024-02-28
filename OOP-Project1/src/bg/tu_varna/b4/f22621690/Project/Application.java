package bg.tu_varna.b4.f22621690.Project;

public class Application {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Product product1 = new Product("Item1", "2022-03-01", "2022-02-28", "Manufacturer1", "litre", 10, "L1", "Comment1");
        Product product2 = new Product("Item2", "2022-04-01", "2022-03-28", "Manufacturer2", "kg", 5, "L2", "Comment2");

        warehouse.addProduct(product1);
        warehouse.addProduct(product2);

        System.out.println("All Products:");
        warehouse.printProducts();

        warehouse.removeProduct(product1);

        System.out.println("\nProducts after removal:");
        warehouse.printProducts();

        Product updatedProduct = new Product("Item3", "2022-03-01", "2022-04-01", "Manufacturer2","kg",6,"L1","Comment3");
        warehouse.updateProduct(product2, updatedProduct);

        System.out.println("\nProducts after update:");
        warehouse.printProducts();
    }
}

