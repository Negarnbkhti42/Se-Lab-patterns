
public class InTransitState implements State {
    @Override
    public void handle(Package pkg) {
        System.out.println("Package is in transit.");
        pkg.setState(new DeliveredState());
    }
}
