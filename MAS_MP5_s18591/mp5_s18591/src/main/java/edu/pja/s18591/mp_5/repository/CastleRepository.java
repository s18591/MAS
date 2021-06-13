package edu.pja.s18591.mp_5.repository;

import edu.pja.s18591.mp_5.model.Castle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CastleRepository extends CrudRepository<Castle,Long> {
    public List<Castle> findByName(String name);


}
