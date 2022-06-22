package com.test.contractsserver.web;

import com.test.contractsserver.models.Contract;
import com.test.contractsserver.service.ContractService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    private ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public Iterable<Contract> getContracts() {
        return contractService.getContractsWithRelevance();
    }

}
