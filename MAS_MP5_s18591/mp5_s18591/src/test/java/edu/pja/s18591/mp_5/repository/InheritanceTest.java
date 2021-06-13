package edu.pja.s18591.mp_5.repository;

import edu.pja.s18591.mp_5.model.Castle;
import edu.pja.s18591.mp_5.model.Kingdom;
import edu.pja.s18591.mp_5.model.Settlement;
import edu.pja.s18591.mp_5.model.Town;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class InheritanceTest {

    @Autowired
    private SettlementRepository settlementRepository;
    @Autowired
    private CastleRepository castleRepository;
    @Autowired
    private TownRepository townRepository;
    @PersistenceContext
    private EntityManager entityManager;
    Town t1;
    Castle c1;

    @BeforeEach
    public void InitData() {
        t1 = Town.builder()
                .name("T")
                .crafts(2)
                .build();
        c1 = Castle.builder()
                .name("C")
                .fortification(2)
                .build();

    }

    @Test
    public void DependenciesTest() {
        assertNotNull(townRepository);
        assertNotNull(castleRepository);
        assertNotNull(settlementRepository);
    }


    @Test
    public void SaveAllTest() {
        townRepository.save(t1);
        castleRepository.save(c1);
        entityManager.flush();
        Iterable<Settlement> settlements = settlementRepository.findAll();
        System.out.println(settlements);
        assertEquals(townRepository.count(),1);
        assertEquals(castleRepository.count(),1);
        assertEquals(settlementRepository.count(),2);
    }

    @Test
    public void AllFindByNameTest(){
        townRepository.save(t1);
        castleRepository.save(c1);
        entityManager.flush();

        List<Settlement> s = settlementRepository.findByName("C");
        System.out.println(s);
        assertEquals(s.get(0).getName(),"C");

        List<Castle> c = castleRepository.findByName("C");
        System.out.println(c);
        assertEquals(c.get(0).getName(),"C");

        List<Town> t = townRepository.findByName("T");
        System.out.println(t);
        assertEquals(t.get(0).getName(),"T");
    }


}