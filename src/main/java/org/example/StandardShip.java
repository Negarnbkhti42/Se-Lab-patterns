package org.example;

public class StandardShip implements ShipMethod {
    private Package pkg;

    public StandardShip(Package pkg) {
        this.pkg = pkg;
    }

    @Override
    public double getShipPrice() {
        return pkg.getWeight() * 2.5;
    }

    @Override
    public String toString() {
        return "the package will be delivered through standard shipping with price of" + this.getShipPrice();
    }
}

