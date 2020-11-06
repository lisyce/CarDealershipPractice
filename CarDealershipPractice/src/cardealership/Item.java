package cardealership;

public abstract class Item {

    private String name;
    private double price;
    private String priceString;
    private String description;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        setPriceString();
    }
    public Item (String name, double price, String description) {
        this(name, price);
        this.description = description;

        setPriceString();
    }

    public abstract String listItem();

    private void setPriceString() {
        if (this.price * 10 >= 1 && this.price * 10 < 100){this.priceString = this.price + "0";}
        else if(this.price * 10 >= 100){this.priceString = this.price + "0";}
        else {this.priceString = Double.toString(this.price);}
    }

    public String getName() {
        return name;
    }

    public String getPriceString() {
        return priceString;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
}
