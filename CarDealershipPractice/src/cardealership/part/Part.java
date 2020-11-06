package cardealership.part;

import cardealership.Item;

public class Part extends Item {

    public Part(String name, double price){
        super(name, price);
    }

    public String listItem() {
       return (super.getName() + ", $" + super.getPriceString());
    }
}
