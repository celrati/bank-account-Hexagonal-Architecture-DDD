package com.bankaccount.demo.domain.mappers;

import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.dto.TransactionDto;
import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.entity.Transaction;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransactionMapper {

    public Transaction transactionBuild(Client client, double amount) {
        return Transaction
                .builder()
                .client(client)
                .amount(amount)
                .build();
    }

    public TransactionDto transactionDtoBuild(Transaction transaction) {
        return TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .clientID(transaction.getClient().getId())
                .build();
    }
}
