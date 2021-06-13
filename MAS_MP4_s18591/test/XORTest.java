import org.junit.Test;
import pja.edu.s18591.Attribute.exception.ValidationException;
import pja.edu.s18591.XOR.Church;
import pja.edu.s18591.XOR.County;
import pja.edu.s18591.XOR.Person;

public class XORTest {
    @Test(expected = ValidationException.class)
    public void xorTest(){
        Person person = new Person("John");
        Church church = new Church("Church");
        County county = new County("County");
        church.AddPerson(person);
        county.AddPerson(person);
    }
}
