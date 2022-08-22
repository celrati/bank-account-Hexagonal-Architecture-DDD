package com.bankaccount.demo.infrastructure.imported;

import com.bankaccount.demo.domain.entity.Client;
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
