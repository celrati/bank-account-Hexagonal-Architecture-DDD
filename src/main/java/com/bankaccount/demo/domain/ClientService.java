package com.bankaccount.demo.domain;

import com.bankaccount.demo.domain.dto.ClientDto;


public interface ClientService {

    public Client createClient(ClientDto clientDto);
    public Client getClient(Long id);
    public Client depositClient(Long id, double amount);
    public Client withdrawClient(Long id, double amount);

}
