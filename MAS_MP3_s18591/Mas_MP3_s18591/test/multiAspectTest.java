import org.junit.Assert;
import org.junit.Test;
import pja.edu.s18591.multiAspect.module.*;

public class multiAspectTest {
    @Test
    public void multiAspectTest(){
        Strategic strategicPoint = new StrategicPoint("River");
        Strategic resourceBase = new ResourceBase(1000);
        Town town = new Town("White",strategicPoint,10);
        Town town1 = new Town("White",resourceBase,10);
        Castle castle = new Castle("Black",strategicPoint,10);
        Castle castle1 = new Castle("Black",resourceBase,10);
        Assert.assertEquals(town.getStrategic(),strategicPoint);
        Assert.assertEquals(town1.getStrategic(),resourceBase);
        Assert.assertEquals(castle.getStrategic(),strategicPoint);
        Assert.assertEquals(castle1.getStrategic(),resourceBase);
        Assert.assertNotEquals(castle1.getStrategic(),strategicPoint);
        Assert.assertNotEquals(castle.getStrategic(),resourceBase);

    }
}
