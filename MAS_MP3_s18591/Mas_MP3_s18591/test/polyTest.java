import org.junit.Assert;
import org.junit.Test;
import pja.edu.s18591.poly.module.Castle;
import pja.edu.s18591.poly.module.Town;

public class polyTest {
    @Test
    public void polyTest(){
        Castle castle = new Castle("sds",10,10);
        Town town = new Town("land",10,10);
        Assert.assertEquals(castle.calculateTaxes(),20);
        Assert.assertEquals(town.calculateTaxes(),20);
    }
}
