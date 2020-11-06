package cardealership.car;

public class Delorean extends Car {

    private boolean canTimeTravel;

    public Delorean(boolean canTimeTravel) {
        super("DeLorean", 70000, 1982, "silver", "DMC");
        this.canTimeTravel = canTimeTravel;
        if (this.canTimeTravel) {
            super.setPrice(100000);
            super.setName("Time Travelling DeLorean");
        }
    }
}
