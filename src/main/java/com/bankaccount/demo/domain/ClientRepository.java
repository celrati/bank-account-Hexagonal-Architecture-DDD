package com.bankaccount.demo.domain;

import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findById(Long id);
    Client save(Client client);
    Client saveAndFlush(Client client);
}
