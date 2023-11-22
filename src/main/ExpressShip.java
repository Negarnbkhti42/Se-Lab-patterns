public class ExpressShip implements ShipMethod {
    private Package pkg;

    public ExpressShip(Package pkg) {
        this.pkg = pkg;
    }

    @Override
    public double getShipPrice() {
        return pkg.getWeight() * 3.5;
    }
}
