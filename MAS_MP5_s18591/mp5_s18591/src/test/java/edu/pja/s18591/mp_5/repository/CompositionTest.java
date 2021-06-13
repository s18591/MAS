package edu.pja.s18591.mp_5.repository;

import edu.pja.s18591.mp_5.model.Building;
import edu.pja.s18591.mp_5.model.PartsOfBuilding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
public class CompositionTest {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private PartsOfTheBuildingRepository partsOfTheBuildingRepository;

    @PersistenceContext
    private EntityManager entityManager;

    Building b1;
    PartsOfBuilding p1;


    @BeforeEach
    public void Init() {
        b1 = Building.builder().name("B").build();
        p1 = PartsOfBuilding.builder().name("P").build();
    }

    @Test
    public void dependenciesTest() {
        Assertions.assertNotNull(buildingRepository);
        Assertions.assertNotNull(partsOfTheBuildingRepository);
    }

    @Test
    public void saveTest() {
        b1.getPartsOfBuildings().add(p1);
        p1.setBuilding(b1);
        entityManager.flush();
    }
}
