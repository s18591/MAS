package edu.pja.s18591.mp_5.repository;

import edu.pja.s18591.mp_5.model.Contract;
import edu.pja.s18591.mp_5.model.Kingdom;
import edu.pja.s18591.mp_5.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class WithAttributeTest {

    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private KingdomRepository kingdomRepository;

    @PersistenceContext
    private EntityManager entityManager;

    Kingdom k1;
    Owner o1;
    Contract c1;

    @BeforeEach
    public void Init(){
        k1 = Kingdom.builder().name("L").kingName("L").build();
        o1 = Owner.builder().name("O").build();
        c1 = Contract.builder().kingdom(k1).owner(o1).startDate(LocalDate.MAX).tax(10f).build();
    }

    @Test
    public void dependenciesTest(){
        Assertions.assertNotNull(kingdomRepository);
        Assertions.assertNotNull(ownerRepository);
        Assertions.assertNotNull(contractRepository);
    }

    @Test
    public void saveTest(){
        k1.getContracts().add(c1);
        o1.setContract(c1);
        kingdomRepository.save(k1);
        ownerRepository.save(o1);
        contractRepository.save(c1);
        entityManager.flush();

        Optional<Kingdom> byId = kingdomRepository.findContractById(k1.getId());
        assertTrue(byId.isPresent());
        System.out.println(byId.get().getContracts());
        assertEquals(1,byId.get().getContracts().size());

    }



}
