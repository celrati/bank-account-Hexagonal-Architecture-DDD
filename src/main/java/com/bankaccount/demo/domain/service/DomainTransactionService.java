package com.bankaccount.demo.domain.service;

import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.entity.Transaction;
import com.bankaccount.demo.domain.repository.ClientRepository;
import com.bankaccount.demo.domain.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class DomainTransactionService implements TransactionService {

    private final ClientRepository clientRepository;
    private final TransactionRepository transactionRepository;


    private Optional<Client> getClientById(Long id) {
        return Optional.ofNullable(clientRepository
                .findById(id)
                .orElseThrow(RuntimeException::new));
    }

    @Override
    public List<Transaction> getTrasactions(Long clientId) {
        Client client = getClientById(clientId).get();
        Optional<List<Transaction>> transactionList = Optional.ofNullable(transactionRepository
                .findByClient(client)
                .orElseThrow(RuntimeException::new));

        return transactionList.get();
    }
}
