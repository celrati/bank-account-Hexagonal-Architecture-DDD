package com.bankaccount.demo.domain.mappers;

import com.bankaccount.demo.domain.Transaction;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransactionMapper {

    public Transaction transactionBuild(String clientId, double amount) {
        return Transaction
                .builder()
                .clientId(clientId)
                .amount(amount)
                .build();
    }
}
