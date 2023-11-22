package org.example;

public class Package {
    private int weight;
    private ShipMethod shippingMethod;
    private State state;

    public Package(int weight) {
        this.weight = weight;
        this.state = new InTransitState(this);
    }

    public int getWeight() {
        return this.weight;
    }

    public ShipMethod getShippingMethod() {
        return this.shippingMethod;
    }

    public void setShippingMethod(ShipMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void sendPackage() {
        this.state.handle();
    }

}
