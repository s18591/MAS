import org.junit.Test;
import pja.edu.s18591.Attribute.exception.ValidationException;
import pja.edu.s18591.Custom.Building;
import pja.edu.s18591.Custom.County;
import pja.edu.s18591.Custom.Town;

public class CustomTest {
    @Test(expected = ValidationException.class)
    public void customTest(){
        Building building = new Building("l");
        County county = new County("l");
        Town town = new Town(1,"L");
        town.addBuilding(building);
        county.removeTown(town);
    }
}
