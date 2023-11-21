import org.junit.Test;

import static org.junit.Assert.*;

public class packageTest {

    @Test
    public void testCreatPackage() {
        int weight = 4;
        Package testPackage = new Package(weight);

        assertEquals(weight, testPackage.getWeight());
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
