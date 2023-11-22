public class StandardShip implements ShipMethod {
    private Package pkg;

    public StandardShip(Package pkg) {
        this.pkg = pkg;
    }

    @Override
    public double getShipPrice() {
        return pkg.getWeight() * 2.5;
    }
}

