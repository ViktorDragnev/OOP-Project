package bg.tu_varna.b4.f22621690.Project.MainCommands;

import bg.tu_varna.b4.f22621690.Project.Models.Command;
import bg.tu_varna.b4.f22621690.Project.Models.Warehouse;

import java.util.ArrayList;

public class CloseFileCommand implements Command {


    public static void closeFile() {
        if(OpenFileCommand.fileLoaded) {
            OpenFileCommand.fileLoaded = false;
            OpenFileCommand.openedFilePath = null;
            Warehouse.productList = new ArrayList<>();
            System.out.println("File closed successfully");
        }
    }


    @Override
    public void execute() {
        closeFile();
    }
}

