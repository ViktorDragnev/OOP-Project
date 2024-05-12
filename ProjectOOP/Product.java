package bg.tu_varna.b4.f22621690.Project.Models;

import java.time.LocalDate;

public class Product implements Comparable<Product>{
    public String name;
    public LocalDate expiryDate;
    public LocalDate entryDate;
    public String manufacturer;
    public String unit;
    public double quantity;
    public String location;
    public String comment;
    public double pricePerUnit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public int compareTo(Product anotherProduct) {
        return this.expiryDate.compareTo(anotherProduct.expiryDate);
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Expiry date: " + expiryDate + '\n' +
                "Entry date: " + entryDate + '\n' +
                "Manufacturer: " + manufacturer + '\n' +
                "Unit: " + unit + '\n' +
                "Quantity: " + quantity + '\n' +
                "Location: " + location + '\n' +
                "Comment: " + comment + '\n' +
                "Price per unit: " + pricePerUnit;
    }
}
