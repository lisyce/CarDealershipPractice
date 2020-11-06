package cardealership.service;

import cardealership.Item;

public class Service extends Item {

    private int daysToComplete;

    public Service(String name, double price, int daysToComplete, String description) {
        super(name, price, description);
        this.daysToComplete = daysToComplete;
    }

    public String listItem() {
        return (super.getName() + ", $" + super.getPriceString() + ", " + this.daysToComplete + " days to complete");
    }


}
