package cardealership.car;

import cardealership.Item;

public class Car extends Item {

    private int yearManufactured;
    private String color;
    private String manufacturer;

    public Car(String name, double price, int yearManufactured, String color, String manufacturer) {
        super(name, price);
        this.yearManufactured = yearManufactured;
        this.color = color;
        this.manufacturer = manufacturer;
    }

    public String listItem() {
        return (this.color + " " + this.yearManufactured + " " + this.manufacturer + " " + super.getName() +
                ", $" + super.getPriceString());
    }

}
