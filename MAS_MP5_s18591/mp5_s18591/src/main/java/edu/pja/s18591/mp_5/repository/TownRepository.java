package edu.pja.s18591.mp_5.repository;
import edu.pja.s18591.mp_5.model.Town;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TownRepository extends CrudRepository<Town,Long> {
    public List<Town> findByName(String name);
}
