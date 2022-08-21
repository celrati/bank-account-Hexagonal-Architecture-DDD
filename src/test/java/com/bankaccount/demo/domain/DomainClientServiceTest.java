package com.bankaccount.demo.domain;

import com.bankaccount.demo.domain.dto.ClientDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class DomainClientServiceTest {



    @MockBean
    @Qualifier("domainClientService")
    private DomainClientService clientService;

    @BeforeEach
    void setUp() {

        Client c1 = Client.builder()
                .id(1L)
                .userName("achraf")
                .balance(0)
                .build();

        Mockito.when(this.clientService.createClient(any())).thenReturn(c1);
    }

    @Test
    void createClient() {
        final ClientDto clientDto  = ClientDto.builder()
                .userName("userName")
                .birthDate(LocalDate.now())
                .balance(100)
                .build();

        Client c = clientService.createClient(clientDto);
        assertNotNull(c.getId());

    }
}