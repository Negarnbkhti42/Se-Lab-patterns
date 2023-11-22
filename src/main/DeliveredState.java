public class DeliveredState implements State {
    @Override
    public void handle(Package pkg) {
        System.out.println("Package has been delivered.");
    }
}

