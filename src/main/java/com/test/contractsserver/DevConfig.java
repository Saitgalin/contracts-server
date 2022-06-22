package com.test.contractsserver;

import com.test.contractsserver.models.Contract;
import com.test.contractsserver.repository.ContractRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Date;

@Configuration
public class DevConfig {

    @Bean
    public CommandLineRunner dataLoader(ContractRepository repository) {
        return args -> {
            for (int i = 0; i < 5; i++) {
                Contract notAvailableContract = Contract.builder()
                        .createdAt(new Date(106, Calendar.DECEMBER, 21))
                        .updatedAt(new Date(106, Calendar.DECEMBER, 23))
                        .build();
                repository.save(notAvailableContract);
            }

            for (int i = 0; i < 5; i ++) {
                Contract availableContract = Contract.builder()
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .build();
                repository.save(availableContract);
            }
        };
    }
}