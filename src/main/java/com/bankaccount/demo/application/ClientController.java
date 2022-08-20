package com.bankaccount.demo.application;


import com.bankaccount.demo.domain.DomainClientService;
import com.bankaccount.demo.domain.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private final DomainClientService clientService;

    @Autowired
    public ClientController(final DomainClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    String createClient(@RequestBody ClientDto client) {
        return "created success";
    }

    @GetMapping(value = "/{id}")
    String getClient(@PathVariable String id) {
        return "client : " + id;
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
