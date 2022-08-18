package com.bankaccount.demo.domain;


import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.mappers.ClientMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DomainClientService implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public String createClient(ClientDto clientDto) {
        Client client = ClientMapper.clientBuild(clientDto);
        clientRepository.save(client);
        return client.getId();
    }

    private Client getClient(String id) {
        return clientRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
