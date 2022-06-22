package com.test.contractsserver.service;

import com.test.contractsserver.models.Contract;
import com.test.contractsserver.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class ContractService {

    private ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Iterable<Contract> getContractsWithRelevance() {
        Iterable<Contract> contracts = contractRepository.findAll();
        contracts.forEach(contract -> contract.setActuality(checkActuality(contract)));
        return contracts;
    }

    private boolean checkActuality(Contract contract) {
        return ChronoUnit.DAYS.between(
                contract.getUpdatedAt().toInstant(),
                new Date().toInstant()
        ) < 60;
    }
}
