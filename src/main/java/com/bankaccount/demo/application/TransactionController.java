package com.bankaccount.demo.application;


import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.dto.TransactionDto;
import com.bankaccount.demo.domain.entity.Transaction;
import com.bankaccount.demo.domain.mappers.ClientMapper;
import com.bankaccount.demo.domain.mappers.TransactionMapper;
import com.bankaccount.demo.domain.service.ClientService;
import com.bankaccount.demo.domain.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;


    @GetMapping(value = "/{clientId}")
    ResponseEntity<List<TransactionDto>> getTransactions(@PathVariable Long clientId) {
        List<TransactionDto> transactions = transactionService.getTrasactions(clientId)
                .stream()
                .map(transaction -> TransactionMapper.transactionDtoBuild(transaction))
                .collect(Collectors.toList());

        return ResponseEntity.ok(transactions);
    }


}
