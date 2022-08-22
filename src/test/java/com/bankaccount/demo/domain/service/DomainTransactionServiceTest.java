package com.bankaccount.demo.domain.service;

import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.entity.Transaction;
import com.bankaccount.demo.domain.repository.ClientRepository;
import com.bankaccount.demo.domain.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DomainTransactionServiceTest {

    @InjectMocks
    private DomainTransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {

        Transaction t1 = Transaction.builder()
                .id(1L)
                .amount(10)
                .build();

        List<Transaction> trs = Arrays.asList(new Transaction[]{t1});

        Mockito.when(this.transactionRepository.save(any())).thenReturn(t1);
        Mockito.when(this.transactionRepository.findByClient(any())).thenReturn(Optional.ofNullable(trs));


    }

    @Test
    void getTrasactionsTest() {
        final Client client  = Client.builder()
                .userName("userName")
                .birthDate(LocalDate.now())
                .balance(100)
                .build();

        Optional<List<Transaction>> ts = transactionRepository.findByClient(client);
        assertEquals(ts.get().size(), 1);
    }
}