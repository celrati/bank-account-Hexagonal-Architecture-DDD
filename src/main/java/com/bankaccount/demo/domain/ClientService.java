package com.bankaccount.demo.domain;

import com.bankaccount.demo.domain.dto.ClientDto;


public interface ClientService {

    public Client createClient(ClientDto clientDto);
    public ClientDto getClient(Long id);

}
