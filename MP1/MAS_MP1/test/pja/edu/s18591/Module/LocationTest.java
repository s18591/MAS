package pja.edu.s18591.Module;

import org.junit.Before;
import org.junit.Test;
import pja.edu.s18591.Exeption.ValidationException;

import static org.junit.Assert.*;

public class LocationTest {

    Location location;
    Location location1;

    @Before
    public void setUp() {
        location1 = new Location("Byzantine empire", "Kingdom of Lotrik", "Thessaloniki");
        location = new Location("Empire of the Franks", "France", "Anju");
    }

    @Test(expected = ValidationException.class)
    public void setEmpire() {
        setUp();
        location.setEmpire("Alexandria");
        assertEquals(location.getEmpire(),"Alexandria");
        location.setEmpire("");
        location.setEmpire(null);
    }

    @Test(expected = ValidationException.class)
    public void setCountry() {
        setUp();
        location.setCountry("France");
        assertEquals(location.getCountry(),"France");
        location.setCountry("");
        location.setCountry(null);
    }

    @Test(expected = ValidationException.class)
    public void setDuchy() {
        setUp();
        location.setDuchy("Alexandria");
        assertEquals(location.getDuchy(),"Alexandria");
        location.setDuchy("");
        location.setDuchy(null);
    }
}