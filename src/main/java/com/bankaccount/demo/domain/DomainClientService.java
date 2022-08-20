package com.bankaccount.demo.domain;


import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.mappers.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DomainClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public DomainClientService(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public Long createClient(ClientDto clientDto) {
        Client client = ClientMapper.clientBuild(clientDto);
        clientRepository.save(client);
        return client.getId();
    }

    private Client getClient(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
