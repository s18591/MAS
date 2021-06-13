package edu.pja.s18591.mp_5.repository;

import edu.pja.s18591.mp_5.model.Building;
import edu.pja.s18591.mp_5.model.Kingdom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository extends CrudRepository<Building,Long> {
    public List<Building> findByName(String name);
}
