package com.bankaccount.demo.infrastructure;

import com.bankaccount.demo.domain.Client;
import com.bankaccount.demo.domain.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@AllArgsConstructor
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
