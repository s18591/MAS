import org.junit.Test;
import pja.edu.s18591.Attribute.exception.ValidationException;
import pja.edu.s18591.Attribute.module.Church;

public class AttributeTest {


    @Test(expected = ValidationException.class)
    public void attributeTest(){
        Church church = new Church("L",5001);
        Church.setMinCost(1000);
        church.setCost(900);
    }

}
