package com.bankaccount.demo.domain.mappers;


import com.bankaccount.demo.domain.Client;
import com.bankaccount.demo.domain.Transaction;
import com.bankaccount.demo.domain.dto.ClientDto;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class ClientMapper {

    public Client clientBuild(ClientDto clientDto) {
        return Client.builder()
                .userName(clientDto.getUserName())
                .birthDate(clientDto.getBirthDate())
                .balance(clientDto.getBalance())
                .build();
    }

    public ClientDto clientDtoBuild(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .userName(client.getUserName())
                .birthDate(client.getBirthDate())
                .balance(client.getBalance())
                .build();
    }
}
