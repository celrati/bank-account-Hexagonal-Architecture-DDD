package com.bankaccount.demo.application;


import com.bankaccount.demo.domain.ClientService;
import com.bankaccount.demo.domain.DomainClientService;
import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.mappers.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    ClientDto createClient(@RequestBody ClientDto client) {
        return ClientMapper.clientDtoBuild(clientService.createClient(client));
    }

    @GetMapping(value = "/{id}")
    ClientDto getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @GetMapping(value = "/{id}/deposit/{amount}")
    String depositClient(@PathVariable String id) {
        return "client : " + id;
    }

    @GetMapping(value = "/{id}/withdraw/{amount}")
    String withdrawClient(@PathVariable String id) {
        return "client : " + id;
    }
}
