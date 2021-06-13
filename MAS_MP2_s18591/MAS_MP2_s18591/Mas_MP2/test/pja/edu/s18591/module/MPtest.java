package pja.edu.s18591.module;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class MPtest {

    County county1 = new County("Ram");
    Owner owner1 = new Owner("Jim");
    //PartOfBuilding part1 = new PartOfBuilding("Block",building);
    Town town = new Town(1,"Warsaw");
    //Town town1 = new Town(2,null);

    @Test
    public void AttributeTest(){
        Contract contract = new Contract(LocalDate.now(),10f,owner1,county1);
        assertEquals(contract.getOwner(),owner1);
        assertEquals(contract.getCounty(),county1);
        Contract contract1 = new Contract(LocalDate.now(),10f,owner1,county1);
        assertNotEquals(contract.getCounty(),county1);
        assertNotEquals(contract.getOwner(),owner1);
        contract1.remove();
        assertNull(contract1.getOwner());
        assertNull(contract1.getCounty());
    }
    @Test
    public void BasicTest(){
        Town town2 = new Town(3,"Shinai");
        Building building2 = new Building("Khlev");
        town2.addBuilding(building2);
        assertTrue(town2.getBuildings().contains(building2));
        assertEquals(building2.getTown(),town2);
    }
    @Test
    public void Qualified(){
         county1.addTown(town);
         assertTrue(county1.getTownList().contains(town));
         assertEquals(town.getCounty(),county1);
         //county1.addTown(town1);
        //System.out.println(county1.getTownList());

    }
    @Test
    public void Composition(){
        Building building = new Building("School");
        PartOfBuilding part1 = new PartOfBuilding("Block",building);
        assertEquals(part1.getBuilding(),building);
        assertTrue(building.getParts().contains(part1));
        building.delete();
        assertFalse(building.getParts().contains(part1));
        assertNull(part1.getBuilding());
    }
}