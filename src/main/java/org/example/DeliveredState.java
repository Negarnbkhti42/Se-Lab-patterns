package org.example;

public class DeliveredState implements State {

    private Package pkg;

    public DeliveredState(Package pkg) {
        this.pkg = pkg;
    }
    @Override
    public void handle() {
        // do nothing
    }

    @Override
    public String toString() {
        return "Package has been delivered with price " + this.pkg.getShippingMethod().getShipPrice();
    }
}

