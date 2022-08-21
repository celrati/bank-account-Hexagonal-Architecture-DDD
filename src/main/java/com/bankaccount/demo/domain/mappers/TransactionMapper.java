package com.bankaccount.demo.domain.mappers;

import com.bankaccount.demo.domain.Client;
import com.bankaccount.demo.domain.Transaction;
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
}
