import org.junit.Assert;
import org.junit.Test;
import pja.edu.s18591.Ordered.Building;
import pja.edu.s18591.Ordered.Town;

public class OrderedTest {
    @Test
    public void orderedTest(){
        Town town = new Town(1,"l");
        Building building = new Building("Building1");
        Building building1 = new Building("Building2");
        town.addBuilding(building);
        town.addBuilding(building1);
        Assert.assertEquals(town.getBuildings().get(0),building);
        Assert.assertEquals(town.getBuildings().get(1),building1);
        town.removeBuilding(building);
        town.addBuilding(building);
        Assert.assertEquals(town.getBuildings().get(1),building);
        Assert.assertEquals(town.getBuildings().get(0),building1);
    }
}
