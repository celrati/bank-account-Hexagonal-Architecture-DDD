package com.bankaccount.demo.infrastructure;

import com.bankaccount.demo.domain.Client;
import com.bankaccount.demo.domain.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class H2ClientRepository implements ClientRepository {

    private final ImportedClientJpaRepository impl;

    @Autowired
    public H2ClientRepository(final ImportedClientJpaRepository impl) {
        this.impl = impl;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return impl.findById(id);
    }

    @Override
    public void save(Client client) {
        impl.save(client);
    }
}
