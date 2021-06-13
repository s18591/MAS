import org.junit.Test;
import pja.edu.s18591.Attribute.exception.ValidationException;
import pja.edu.s18591.Unique.Town;

public class UniqueTest {

    @Test(expected = ValidationException.class)
    public void uniqueTest(){
        Town town = new Town(1,"l");
        Town town1 = new Town(1,"k");
    }
}
