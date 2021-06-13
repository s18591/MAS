import org.junit.Assert;
import org.junit.Test;
import pja.edu.s18591.Subset.Council;
import pja.edu.s18591.Subset.Owner;

public class SubsetTest {
    @Test
    public void subsetTest(){
        Owner owner = new Owner("l");
        Owner owner1 = new Owner("l");
        Council council = new Council("l",owner);
        council.addOwner(owner1);
        Assert.assertEquals(owner,council.getChancellor());
        Assert.assertTrue(council.getOwners().contains(owner));
    }
}
