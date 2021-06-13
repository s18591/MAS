package edu.pja.s18591.mp_5.repository;

import edu.pja.s18591.mp_5.model.Contract;
import edu.pja.s18591.mp_5.model.Kingdom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface KingdomRepository extends CrudRepository<Kingdom,Long> {
    public List<Kingdom> findByName(String name);
    public List<Kingdom> findByNameAndKingName(String name,String kingName);

    @Query("from Kingdom as k left join k.settlements where k.id = :id")
    public Optional<Kingdom> findById(@Param("id") Long id);

    @Query("from Kingdom as k left join k.contracts where k.id = :id")
    public Optional<Kingdom> findContractById(@Param("id") Long id);
}
