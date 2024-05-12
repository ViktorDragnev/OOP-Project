package bg.tu_varna.b4.f22621690.Project.MainCommands;

import bg.tu_varna.b4.f22621690.Project.Models.Command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Exiting the program.");
        System.exit(0);
    }
}
