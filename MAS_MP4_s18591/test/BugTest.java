import org.junit.Assert;
import org.junit.Test;
import pja.edu.s18591.Bug.module.Contract;
import pja.edu.s18591.Bug.module.Owner;
import pja.edu.s18591.Bug.module.County;

import java.time.LocalDate;

public class BugTest {
    @Test
    public void bugTest(){
        Owner owner = new Owner("l");
        County county = new County("l");
        Contract contract = new Contract(LocalDate.MAX,10f,owner,county);
        Contract contract1 = new Contract(LocalDate.MAX,10f,owner,county);
        Assert.assertTrue(owner.getContracts().contains(contract));
        Assert.assertTrue(owner.getContracts().contains(contract1));
    }
}
