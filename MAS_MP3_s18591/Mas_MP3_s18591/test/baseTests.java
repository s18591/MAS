import org.junit.Assert;
import org.junit.Test;
import pja.edu.s18591.multi.module.Castle;
import pja.edu.s18591.multi.Interface.ICastle;
import pja.edu.s18591.multi.module.Town;
import pja.edu.s18591.multi.module.WalledCity;

import java.util.ArrayList;
import java.util.List;


public class baseTests {
    @Test
    public void multiInheritanceTest(){
        Town town = new Town("Gdansk",1000);
        Castle castle = new Castle("Lancaster",8);
        List<Town> towns = new ArrayList<>();
        List<ICastle> castles = new ArrayList<>();
        WalledCity walledCity = new WalledCity("Warsaw",10,"King",12);
        towns.add(town);
        castles.add(castle);
        towns.add(walledCity);
        castles.add(walledCity);
        Assert.assertTrue(castles.contains(walledCity));
        Assert.assertTrue(towns.contains(walledCity));
    }
}
