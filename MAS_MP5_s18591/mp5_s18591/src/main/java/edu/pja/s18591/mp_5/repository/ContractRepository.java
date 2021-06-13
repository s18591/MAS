package edu.pja.s18591.mp_5.repository;

import edu.pja.s18591.mp_5.model.Castle;
import edu.pja.s18591.mp_5.model.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract,Long> {
}
