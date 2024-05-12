package bg.tu_varna.b4.f22621690.Project.WerehouseCommands;

import bg.tu_varna.b4.f22621690.Project.Models.Command;
import bg.tu_varna.b4.f22621690.Project.Models.Product;
import bg.tu_varna.b4.f22621690.Project.Models.Warehouse;

public class DisplayProductsCommand implements Command {

    @Override
    public void execute() {
        print();
    }

    public void print(){
        for(Product product : Warehouse.productList){
            System.out.println(product);
        }
    }
}
