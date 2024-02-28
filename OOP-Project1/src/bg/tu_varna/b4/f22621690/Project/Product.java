package bg.tu_varna.b4.f22621690.Project;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Product {
    String name;
    Date expiryDate;
    Date entryDate;
    String manufacturer;
    String unit;
    int quantity;
    String location;
    String comment;

    public Product(String name, String expiryDate, String entryDate, String manufacturer, String unit, int quantity, String location, String comment) {
        this.name = name;
        this.expiryDate = parseDate(expiryDate);
        this.entryDate = parseDate(entryDate);
        this.manufacturer = manufacturer;
        this.unit = unit;
        this.quantity = quantity;
        this.location = location;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Date getEntryDate() {
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

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setEntryDate(Date entryDate) {
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

    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Error parsing date. Please enter the date in the format yyyy-MM-dd.");
            return null;
        }
    }
}
