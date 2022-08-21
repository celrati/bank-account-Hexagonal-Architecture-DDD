package com.bankaccount.demo.domain;


import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.mappers.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@AllArgsConstructor
@Transactional
public class DomainClientService implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client createClient(ClientDto clientDto) {
        Client client = ClientMapper.clientBuild(clientDto);
        return clientRepository.save(client);
    }

    @Override
    public ClientDto getClient(Long id) {
        Optional<Client> client = Optional.ofNullable(clientRepository
                .findById(id)
                .orElseThrow(RuntimeException::new));

        return ClientMapper.clientDtoBuild(client.get());

    }

}
