package com.bankaccount.demo.domain.service;


import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.entity.Transaction;
import com.bankaccount.demo.domain.mappers.ClientMapper;
import com.bankaccount.demo.domain.mappers.TransactionMapper;
import com.bankaccount.demo.domain.repository.ClientRepository;
import com.bankaccount.demo.domain.repository.TransactionRepository;
import com.bankaccount.demo.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@AllArgsConstructor
@Transactional
public class DomainClientService implements ClientService {

    private final ClientRepository clientRepository;
    private final TransactionRepository transactionRepository;


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
        Transaction tr = TransactionMapper.transactionBuild(client, amount);
        transactionRepository.save(tr);
        return clientRepository.save(client);
    }

    @Override
    public Client withdrawClient(Long id, double amount) {
        Client client = getClientById(id).get();
        if(client.getBalance() < amount){
            throw new RuntimeException("insufficient balance");
        }
        client.setBalance(client.getBalance() - amount);
        Transaction tr = TransactionMapper.transactionBuild(client, -amount);
        transactionRepository.save(tr);
        return clientRepository.save(client);

    }



    private Optional<Client> getClientById(Long id) {
        return Optional.ofNullable(clientRepository
                .findById(id)
                .orElseThrow(RuntimeException::new));
    }

}
