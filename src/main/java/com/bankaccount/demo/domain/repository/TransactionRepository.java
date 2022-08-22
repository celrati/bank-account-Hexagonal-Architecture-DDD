package com.bankaccount.demo.domain.repository;

import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    Optional<List<Transaction>> findByClient(Client client);
    Transaction save(Transaction transaction);

}
