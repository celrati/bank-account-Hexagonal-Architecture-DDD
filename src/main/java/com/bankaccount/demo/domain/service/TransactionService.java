package com.bankaccount.demo.domain.service;

import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.entity.Transaction;

import java.util.List;


public interface TransactionService {

    public List<Transaction> getTrasactions(Long clientId);

}
