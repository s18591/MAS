package edu.pja.s18591.mp_5.repository;

import edu.pja.s18591.mp_5.model.Building;
import edu.pja.s18591.mp_5.model.Kingdom;
import edu.pja.s18591.mp_5.model.Settlement;
import edu.pja.s18591.mp_5.model.Town;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AssociationTest {

    @Autowired
    private KingdomRepository kingdomRepository;
    @Autowired
    private SettlementRepository settlementRepository;
    @Autowired
    private TownRepository townRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    @PersistenceContext
    private EntityManager entityManager;

    Kingdom k1;
    Settlement s1;
    Town t1;
    Building b1;

    @BeforeEach
    public void Init(){
        k1 = Kingdom.builder().name("L").kingName("L").build();
        t1 = Town.builder().name("T").crafts(4).build();
        b1 = Building.builder().name("B").build();
    }


    @Test
    public void dependenciesTest(){
        assertNotNull(kingdomRepository);
        assertNotNull(settlementRepository);
        assertNotNull(townRepository);
        assertNotNull(buildingRepository);
    }

    @Test
    public void saveAllTest(){
        k1.getSettlements().add(t1);
        t1.setKingdom(k1);
        t1.getBuildings().add(b1);
        b1.setSettlement(t1);
        townRepository.save(t1);
        buildingRepository.save(b1);
        kingdomRepository.save(k1);
        entityManager.flush();

        Optional<Kingdom> byId = kingdomRepository.findById(k1.getId());
        assertTrue(byId.isPresent());
        System.out.println(byId.get().getSettlements());
        assertEquals(1,byId.get().getSettlements().size());

        Optional<Town> sById = townRepository.findById(t1.getId());
        assertTrue(sById.isPresent());
        System.out.println(sById.get().getBuildings());
        assertEquals(1,sById.get().getBuildings().size());

    }


}
