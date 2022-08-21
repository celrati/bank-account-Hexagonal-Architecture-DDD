package com.bankaccount.demo.infrastructure;

import com.bankaccount.demo.domain.Client;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ImportedClientJpaRepository extends JpaRepository<Client, Long> {

    @Override
    Optional<Client> findById(Long aLong);

    @Override
    Client save(Client client);

    @Override
    Client saveAndFlush(Client client);
}
