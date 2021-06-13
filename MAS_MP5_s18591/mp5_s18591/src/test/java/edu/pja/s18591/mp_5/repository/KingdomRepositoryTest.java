package edu.pja.s18591.mp_5.repository;

import edu.pja.s18591.mp_5.model.Kingdom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class KingdomRepositoryTest {
    @Autowired
    private KingdomRepository kingdomRepository;
    @PersistenceContext
    private EntityManager entityManager;
    Kingdom k1;

    @BeforeEach
    public void Init(){
        k1 = Kingdom.builder().name("L").kingName("L").build();
    }

    @Test
    public void KingdomTest() {
        assertNotNull(kingdomRepository);
    }

    @Test
        public void FetchKingdom() {
            Iterable<Kingdom> kingdoms = kingdomRepository.findAll();
            for (Kingdom k : kingdoms) {
                System.out.println(k);
            }
    }

    @Test
    public void saveKingdomTest(){
        kingdomRepository.save(k1);
        entityManager.flush();
        long count = kingdomRepository.count();
        assertEquals(count,1);
    }

    @Test
    public void testFindByName(){
        kingdomRepository.save(k1);
        entityManager.flush();
        System.out.println(kingdomRepository.findAll());
        List<Kingdom> l = kingdomRepository.findByName("L");
        System.out.println(l);
        assertEquals(l.get(0).getName(),"L");
    }
    @Test
    public void testFindByNameAndKingName(){
        kingdomRepository.save(k1);
        entityManager.flush();
        List<Kingdom> ll = kingdomRepository.findByNameAndKingName("L","L");
        System.out.println(ll);
        assertEquals(ll.get(0).getName(),"L");
        assertEquals(ll.get(0).getKingName(),"L");
    }

}

