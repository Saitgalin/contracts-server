package com.test.contractsserver.repository;


import com.test.contractsserver.models.Contract;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, Long> {
    
}
