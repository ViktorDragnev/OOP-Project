package bg.tu_varna.b4.f22621690.Project.WerehouseCommands;

import bg.tu_varna.b4.f22621690.Project.Command;
import bg.tu_varna.b4.f22621690.Project.Models.Log;
import bg.tu_varna.b4.f22621690.Project.Models.Warehouse;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LogChangesCommand implements Command {

    public static void saveLog() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Logs.txt",true))) {
            for (Log log : Warehouse.logList) {
                writer.write(log + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing logs to file.");
        }
    }

    public static void log() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting date: (yyyy-MM-dd)");
        LocalDate beginningDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter final date: (yyyy-MM-dd)");
        LocalDate finalDate = LocalDate.parse(scanner.nextLine());

        try (BufferedReader reader = new BufferedReader(new FileReader("Logs.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ", 2);

                if (parts.length >= 2) {

                    String dateString = parts[0];
                    LocalDate inputDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    if (!inputDate.isBefore(beginningDate) && !inputDate.isAfter(finalDate)) {

                        String logContent = parts[1];
                        System.out.println("Date: " + inputDate + ", Log Content: " + logContent);

                    }

                } else {
                    System.out.println("Invalid log entry: " + line);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void execute() {
        log();
    }
}
