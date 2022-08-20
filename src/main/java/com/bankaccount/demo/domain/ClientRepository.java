package com.bankaccount.demo.domain;

import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findById(Long id);
    void save(Client client);

}
