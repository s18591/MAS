package edu.pja.s18591.mp_5.repository;
import edu.pja.s18591.mp_5.model.Settlement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SettlementRepository extends CrudRepository<Settlement,Long> {
    public List<Settlement> findByName(String name);

    @Query("from Settlement as s left join s.buildings where s.id = :id")
    public Optional<Settlement> findById(@Param("id") Long id);
}
