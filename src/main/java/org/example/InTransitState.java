package org.example;

public class InTransitState implements State {

    private Package pkg;

    public InTransitState(Package pkg) {
        this.pkg = pkg;
    }
    @Override
    public void handle() {
        pkg.setState(new DeliveredState(this.pkg));
    }

    @Override
    public String toString() {
        return "Package is in transit.";
    }
}
