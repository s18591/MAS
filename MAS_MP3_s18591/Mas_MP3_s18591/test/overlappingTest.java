import org.junit.Assert;
import org.junit.Test;
import pja.edu.s18591.multi.exception.ValidationException;
import pja.edu.s18591.overlapping.Module.Building;
import pja.edu.s18591.overlapping.Module.BuildingType;

import java.util.EnumSet;

public class overlappingTest {
    @Test
    public void overlappingTest(){
        EnumSet<BuildingType> types = EnumSet.of(BuildingType.LIBRARY,BuildingType.STORAGE);
        EnumSet<BuildingType> types1 = EnumSet.of(BuildingType.LIBRARY);
        EnumSet<BuildingType> types2 = EnumSet.of(BuildingType.STORAGE);
        Building building = new Building(types,"L",10,10);
        Building building1 = new Building(types1,"L",10,10);
        Building building2 = new Building(types2,"L",10,10);
        Assert.assertEquals(building.getBooks(),10);
        Assert.assertEquals(building.getItems(),10);
        Assert.assertEquals(building1.getBooks(),10);
        Assert.assertEquals(building2.getItems(),10);
        try {
            building1.getItems();
            building2.getBooks();
        }catch (ValidationException e){
            e.printStackTrace();
        }

    }
}
