package com.bankaccount.demo.infrastructure;

import com.bankaccount.demo.domain.repository.ClientRepository;
import com.bankaccount.demo.domain.service.DomainClientService;
import com.bankaccount.demo.domain.repository.TransactionRepository;
import com.bankaccount.demo.domain.service.DomainTransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    @Bean
    DomainClientService clientService(ClientRepository clientRepository, TransactionRepository transactionRepository) {
        return new DomainClientService(clientRepository, transactionRepository);
    }

    @Bean
    DomainTransactionService transactionService(ClientRepository clientRepository, TransactionRepository transactionRepository) {
        return new DomainTransactionService(clientRepository, transactionRepository);
    }

}
