package com.bankaccount.demo.infrastructure;

import com.bankaccount.demo.domain.ClientRepository;
import com.bankaccount.demo.domain.ClientService;
import com.bankaccount.demo.domain.DomainClientService;
import org.springframework.context.annotation.Bean;

public class BeanConfiguration {

    @Bean
    ClientService clientService(ClientRepository clientRepository) {
        return new DomainClientService(clientRepository);
    }
}
