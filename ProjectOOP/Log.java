package bg.tu_varna.b4.f22621690.Project.Models;

import java.time.LocalDate;

public class Log {
    String name;
    double quantity;
    LocalDate date;
    Activity activity;

    public Log(String name, double quantity, LocalDate date, Activity activity) {
        this.name = name;
        this.quantity = quantity;
        this.date = date;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return switch (activity) {
            case ADD -> date + " - changes were made " + quantity + " " + name + " were accepted";
            case REMOVE -> date + " - changes were made " + quantity + " " + name + " were removed";
            case CLEAN -> date + " - changes were made " + quantity + " " + name + " were cleaned";
        };
    }
}

