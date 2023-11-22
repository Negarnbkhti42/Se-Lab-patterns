package org.example;

public class ExpressShip implements ShipMethod {
    private Package pkg;

    public ExpressShip(Package pkg) {
        this.pkg = pkg;
    }

    @Override
    public double getShipPrice() {
        return pkg.getWeight() * 3.5;
    }

    @Override
    public String toString() {
        return "the package will be delivered through express shipping with price of" + this.getShipPrice();
    }
}
