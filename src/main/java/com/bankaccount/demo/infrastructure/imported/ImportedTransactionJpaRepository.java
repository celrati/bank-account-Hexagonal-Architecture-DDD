package com.bankaccount.demo.infrastructure.imported;

import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ImportedTransactionJpaRepository extends JpaRepository<Transaction, Long> {


    Optional<List<Transaction>>  findByClient(Client client);

    @Override
    Transaction save(Transaction transaction);

}
