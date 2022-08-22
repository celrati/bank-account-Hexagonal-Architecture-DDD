package com.bankaccount.demo.infrastructure.implRepository;

import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.entity.Transaction;
import com.bankaccount.demo.domain.repository.ClientRepository;
import com.bankaccount.demo.domain.repository.TransactionRepository;
import com.bankaccount.demo.infrastructure.imported.ImportedClientJpaRepository;
import com.bankaccount.demo.infrastructure.imported.ImportedTransactionJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Primary
public class H2TransactionRepository implements TransactionRepository {

    private final ImportedTransactionJpaRepository impl;

    @Override
    public Optional<List<Transaction>> findByClient(Client client) {
        return impl.findByClient(client);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return impl.save(transaction);
    }


}
