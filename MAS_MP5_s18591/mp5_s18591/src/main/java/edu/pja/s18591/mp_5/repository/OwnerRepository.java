package edu.pja.s18591.mp_5.repository;

import edu.pja.s18591.mp_5.model.Building;
import edu.pja.s18591.mp_5.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    public List<Owner> findByName(String name);
}
