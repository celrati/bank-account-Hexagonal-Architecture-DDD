package com.bankaccount.demo.infrastructure.implRepository;

import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.repository.ClientRepository;
import com.bankaccount.demo.infrastructure.imported.ImportedClientJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Primary
public class H2ClientRepository implements ClientRepository {

    private final ImportedClientJpaRepository impl;

    @Override
    public Optional<Client> findById(Long id) {
        return impl.findById(id);
    }

    @Override
    public Client save(Client client) {
        return impl.save(client);
    }

    @Override
    public Client saveAndFlush(Client client) {
        return impl.saveAndFlush(client);
    }

}
