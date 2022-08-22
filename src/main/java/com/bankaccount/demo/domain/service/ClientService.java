package com.bankaccount.demo.domain.service;

import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.entity.Client;


public interface ClientService {

    public Client createClient(ClientDto clientDto);
    public Client getClient(Long id);
    public Client depositClient(Long id, double amount);
    public Client withdrawClient(Long id, double amount);

}
