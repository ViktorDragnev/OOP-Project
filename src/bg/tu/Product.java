package bg.tu;

import java.time.LocalDate;

public class Product {
    public String name;
    int acceptYear;
    int acceptMonth;
    int acceptDay;
    int expiryYear;
    int expiryMonth;
    int expiryDay;
    public String manufacturer;
    public String units;
    public double availableQuantity;
    public String locationInWarehouse;
    public String comment;

    public Product(String name, int acceptYear, int acceptMonth, int acceptDay,
                   int expiryYear, int expiryMonth, int expiryDay, String manufacturer,
                   String units, double availableQuantity, String locationInWarehouse, String comment) {
        this.name = name;
        this.acceptYear = acceptYear;
        this.acceptMonth = acceptMonth;
        this.acceptDay = acceptDay;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
        this.expiryDay = expiryDay;
        this.manufacturer = manufacturer;
        this.units = units;
        this.availableQuantity = availableQuantity;
        this.locationInWarehouse = locationInWarehouse;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcceptYear() {
        return acceptYear;
    }

    public void setAcceptYear(int acceptYear) {
        this.acceptYear = acceptYear;
    }

    public int getAcceptMonth() {
        return acceptMonth;
    }

    public void setAcceptMonth(int acceptMonth) {
        this.acceptMonth = acceptMonth;
    }

    public int getAcceptDay() {
        return acceptDay;
    }

    public void setAcceptDay(int acceptDay) {
        this.acceptDay = acceptDay;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryDay() {
        return expiryDay;
    }

    public void setExpiryDay(int expiryDay) {
        this.expiryDay = expiryDay;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public double getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(double availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getLocationInWarehouse() {
        return locationInWarehouse;
    }

    public void setLocationInWarehouse(String locationInWarehouse) {
        this.locationInWarehouse = locationInWarehouse;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return " \nProduct's name: " + name + '\n' +
                " Date of acceptance in the warehouse: " + acceptDay +'.'+ acceptMonth +'.'+ acceptYear +'\n' +
                " Date of expiration of the product: " + expiryDay+'.' +expiryMonth+'.'+expiryYear+ '\n' +
                " Manufacturer: " + manufacturer + '\n' +
                " Units: " + units + '\n' +
                " Available quantity: " + availableQuantity + '\n' +
                " Location inside of the warehouse: " + locationInWarehouse + '\n' +
                " Comment: " + comment + "\n";
    }
}
