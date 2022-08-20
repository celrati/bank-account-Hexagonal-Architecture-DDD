package com.bankaccount.demo.infrastructure;

import com.bankaccount.demo.domain.ClientRepository;
import com.bankaccount.demo.domain.ClientService;
import com.bankaccount.demo.domain.DomainClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    @Bean
    DomainClientService clientService(ClientRepository clientRepository) {
        return new DomainClientService(clientRepository);
    }


}
