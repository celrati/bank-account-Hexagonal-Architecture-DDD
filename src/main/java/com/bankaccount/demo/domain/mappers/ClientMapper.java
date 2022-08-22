package com.bankaccount.demo.domain.mappers;


import com.bankaccount.demo.domain.entity.Client;
import com.bankaccount.demo.domain.dto.ClientDto;
import lombok.experimental.UtilityClass;

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
