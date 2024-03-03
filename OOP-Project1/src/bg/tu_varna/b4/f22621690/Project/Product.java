package bg.tu_varna.b4.f22621690.Project;

import java.time.LocalDate;

public class Product {
    String name;
    LocalDate expiryDate;
    LocalDate entryDate;
    String manufacturer;
    String unit;
    int quantity;
    String location;
    String comment;

    public Product(String name, LocalDate expiryDate, LocalDate entryDate, String manufacturer, String unit, int quantity, String location, String comment) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.entryDate = entryDate;
        this.manufacturer = manufacturer;
        this.unit = unit;
        this.quantity = quantity;
        this.location = location;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getLocation() {
        return location;
    }

    public String getComment() {
        return comment;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
