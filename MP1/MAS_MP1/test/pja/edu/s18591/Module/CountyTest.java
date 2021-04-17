package pja.edu.s18591.Module;
import pja.edu.s18591.Exeption.ValidationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.*;

public class CountyTest {

    County county1;
    County county2;
    County county3;
    County county4;
    Location location;
    Location location1;
    List<String> baronies = new ArrayList<>();
    Set<String> religions = new HashSet<>();



    public void setUp() {
        baronies.add("ThessalonikiTemple");
        baronies.add("ThessalonikiCastle");
        baronies.add("ThessalonikiCity1");
        baronies.add("ThessalonikiCity2");
        religions.add("Slavs Paganism");
        religions.add("Scandinavian paganism");
        location1 = new Location("Byzantine empire", "Kingdom of Lotrik", "Thessaloniki");
        location = new Location("Empire of the Franks", "France", "Anju");
        county1 = new County("Anju", LocalDate.of(400, 12, 10), "Karl the great", "AnjuCity", "Catholicism", FormOfGovernment.Feodal, location);
        county2 = new County("Thessaloniki", LocalDate.of(400, 12, 10), "Karl the great", "ThessalonikiCity", "Orthodoxy Christianity", FormOfGovernment.Feodal, location1, 20, 2);
        county3 = new County("Thessaloniki1", LocalDate.of(400, 12, 10), "Otton I", baronies, religions, FormOfGovernment.Feodal, location1);
        county4 = new County("Anju", LocalDate.of(400, 12, 10), "Ivan", baronies, religions, FormOfGovernment.Feodal, location, 20, 2);
    }

    @org.junit.Test(expected = ValidationException.class)
    public void setLocation() {
        setUp();
        county2.setLocation(location1);
        assertEquals(county2.getLocation(), location1);
        county1.setLocation(null);
    }

    @org.junit.Test
    public void findByOwner() {
        setUp();
        List<County> counties;
      counties = County.findByOwner("Karl the great");
        assertEquals(counties.get(0).getOwner(),"Karl the great");
        assertEquals(counties.get(1).getOwner(),"Karl the great");
    }

    @org.junit.Test
    public void saveLoadExtent() {
        setUp();
        County.saveExtent();
        List<County> counties = new ArrayList<>(County.getCounties());
        County.loadExtent();
        List<County> counties1 = new ArrayList<>(County.getCounties());
        assertEquals(counties.size(),counties1.size());

    }

    @org.junit.Test(expected = ValidationException.class)
    public void addKnownReligion() {
        setUp();
        County.addKnownReligion("Islam");
        assertEquals(County.getKnownReligions().size(), 2);
        assertTrue(County.getKnownReligions().contains("Islam"));
        County.removeKnownReligion("Islam");
        County.addKnownReligion(null);
        County.addKnownReligion("");

    }

    @org.junit.Test(expected = ValidationException.class)
    public void addKnownReligions() {
        setUp();
        Set<String> nullSet = new HashSet<>();
        nullSet.add(null);
        County.addKnownReligions(religions);
        assertTrue(County.getKnownReligions().contains("Scandinavian paganism"));
        County.addKnownReligions(nullSet);
    }

    @org.junit.Test(expected = ValidationException.class)
    public void removeKnownReligion() {
        setUp();
        County.addKnownReligion("Shamanism1");
        System.out.println(County.getKnownReligions());
        assertTrue(County.getKnownReligions().contains("Shamanism1"));
        County.removeKnownReligion("Shamanism");
        assertFalse(County.getKnownReligions().contains("Shamanism"));
        County.removeKnownReligion("Shamanism1");
    }

    @org.junit.Test
    public void getProfit() {
        setUp();
        assertEquals(county2.getProfit(),new Integer(22));
        assertEquals(county1.getProfit(),null);
    }

    @org.junit.Test(expected = ValidationException.class)
    public void setIncome() {
        setUp();
        county2.setIncome(3);
        assertEquals(county2.getIncome(),new Integer(3));
        county2.setIncome(-2);

    }

    @org.junit.Test(expected = ValidationException.class)
    public void setBudget() {
        setUp();
        county2.setBudget(3);
        assertEquals(county2.getBudget(),new Integer(3));
        county2.setBudget(-2);
    }

    @org.junit.Test(expected = ValidationException.class)
    public void setFormOfGovernment() {
        setUp();
        county1.setFormOfGovernment(FormOfGovernment.Tribe);
        assertEquals(county1.getFormOfGovernment(),FormOfGovernment.Tribe);
        county1.setFormOfGovernment(null);
    }

    @org.junit.Test(expected = ValidationException.class)
    public void addReligion() {
        setUp();
        county1.addReligion("Islam");
        assertEquals(county1.getReligions().size(), 2);
        assertTrue(county1.getReligions().contains("Islam"));
        county1.addReligion(null);
        county1.addReligion("");
    }

    @org.junit.Test(expected = ValidationException.class)
    public void addReligions() {
        setUp();
        Set<String> nullSet = new HashSet<>();
        nullSet.add(null);
        county1.addReligions(religions);
        assertEquals(county1.getReligions().size(), 3);
        assertTrue(county1.getReligions().contains("Scandinavian paganism"));
        county1.addReligions(nullSet);
    }

    @org.junit.Test(expected = ValidationException.class)
    public void removeReligion() {
        setUp();
        county1.addReligion("Shamanism1");
        assertEquals(county1.getReligions().size(),2);
        county1.removeReligion("Shamanism1");
        assertEquals(county1.getReligions().size(),1);
        county1.removeReligion("Catholicism");
    }

    @org.junit.Test(expected = ValidationException.class)
    public void addBarony() {
        setUp();
        county1.addBarony("Havai");
        assertEquals(county1.getBaronies().size(), 2);
        assertTrue(county1.getBaronies().contains("Havai"));
        county1.addBarony(null);
        county1.addBarony("");
    }

    @org.junit.Test(expected = ValidationException.class)
    public void addBaronies() {
        setUp();
        List<String> nullSet = new ArrayList<>();
        nullSet.add(null);
        county1.addBaronies(baronies);
        assertEquals(county1.getBaronies().size(), 5);
        assertTrue(county1.getBaronies().contains("ThessalonikiCity1"));
        county1.addBaronies(nullSet);
    }

    @org.junit.Test(expected = ValidationException.class)
    public void removeBarony() {
        setUp();
        county1.addBarony("Havai");
        assertEquals(county1.getBaronies().size(),2);
        county1.removeReligion("Havai");
        assertEquals(county1.getBaronies().size(),1);
        county1.removeReligion("Anju");
    }

    @org.junit.Test(expected = ValidationException.class)
    public void setOwner() {
        setUp();
        county1.setOwner("Karl IV");
        assertEquals(county1.getOwner(),"Karl IV");
        county1.setOwner("");
        county1.setOwner(null);
    }

    @org.junit.Test(expected = ValidationException.class)
    public void setDateOfCreation() {
        setUp();
        county1.setDateOfCreation(LocalDate.of(20,9,10));
        assertEquals(county1.getDateOfCreation(),LocalDate.of(20,9,10));
        county1.setDateOfCreation(null);
    }

    @org.junit.Test(expected = ValidationException.class)
    public void setTitle() {
        setUp();
        county1.setTitle("Alexandria");
        assertEquals(county1.getTitle(),"Alexandria");
        county1.setTitle("");
        county1.setTitle(null);
    }
}