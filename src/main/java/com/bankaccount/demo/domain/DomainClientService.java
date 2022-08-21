package com.bankaccount.demo.domain;


import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.mappers.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@AllArgsConstructor
@Transactional
public class DomainClientService implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client createClient(ClientDto clientDto) {
        Client client = ClientMapper.clientBuild(clientDto);
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(Long id) {
        Optional<Client> client = getClientById(id);
        return client.get();

    }

    @Override
    public Client depositClient(Long id, double amount) {
        Client client = getClientById(id).get();
        client.setBalance(client.getBalance() + amount);
        return clientRepository.save(client);
    }

    @Override
    public Client withdrawClient(Long id, double amount) {
        Client client = getClientById(id).get();
        if(client.getBalance() < amount){
            throw new RuntimeException("insufficient balance");
        }
        client.setBalance(client.getBalance() - amount);
        return clientRepository.save(client);

    }

    private Optional<Client> getClientById(Long id) {
        return Optional.ofNullable(clientRepository
                .findById(id)
                .orElseThrow(RuntimeException::new));
    }

}
