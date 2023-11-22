import org.example.*;
import org.example.Package;
import org.junit.Test;

import static org.junit.Assert.*;

public class packageTest {

    @Test
    public void testCreatPackage() {
        int weight = 4;
        Package testPackage = new Package(weight);

        assertEquals(weight, testPackage.getWeight());
        assertEquals(testPackage.getState().getClass(), InTransitState.class);
    }

    @Test
    public void testShippingPrice() {
        int weight = 2;
        Package testPackage = new Package(weight);

        StandardShip standardShip = new StandardShip(testPackage);
        ExpressShip expressShip = new ExpressShip(testPackage);

        assertEquals(standardShip.getShipPrice(), weight * 2.5, 0.5);
        assertEquals(expressShip.getShipPrice(), weight * 3.5, 0.5);
    }

    @Test
    public void testPackageIsShipped() {
        int weight = 4;
        Package testPackage = new Package(weight);
        StandardShip standardShip = new StandardShip(testPackage);
        testPackage.setShippingMethod(standardShip);

        testPackage.sendPackage();

        State packageState = testPackage.getState();
        assertEquals(testPackage.getShippingMethod().getClass(), StandardShip.class);
        assertEquals(packageState.getClass(), DeliveredState.class);
    }
}
