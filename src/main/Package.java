public class Package {
    private int weight;
    private ShipMethod shippingMethod;
    private State state;

    public Package(int weight) {
        this.weight = weight;
        this.state = new InTransitState();
    }

    public int getWeight() {
        return weight;
    }

    public ShipMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShipMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void sendPackage() {
        state.handle(this);
    }

}
