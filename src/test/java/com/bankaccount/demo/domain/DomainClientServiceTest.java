package com.bankaccount.demo.domain;

import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.repository.ClientRepository;
import com.bankaccount.demo.domain.service.DomainClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class DomainClientServiceTest {


    @InjectMocks
    private DomainClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {

        Client c1 = Client.builder()
                .id(1L)
                .userName("achraf")
                .balance(0)
                .build();

        Mockito.when(this.clientRepository.save(any())).thenReturn(c1);
        Mockito.when(this.clientRepository.findById(any())).thenReturn(Optional.of(c1));


    }

    @Test
    void createClientTest() {
        final ClientDto clientDto  = ClientDto.builder()
                .userName("userName")
                .birthDate(LocalDate.now())
                .balance(100)
                .build();

        Client c = clientService.createClient(clientDto);
        assertEquals(c.getUserName(),"achraf");
    }

    @Test
    void getClientTest() {
        Client c = clientService.getClient(1L);
        assertEquals(c.getUserName(),"achraf");
    }

    @Test
    void depositClientTest() {
        Client c = clientService.getClient(1L);
        assertEquals(c.getUserName(),"achraf");
    }

    @Test
    void withdrawClientTest() {
        Client c = clientService.getClient(1L);
        assertEquals(c.getUserName(),"achraf");
    }
}