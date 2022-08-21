package com.bankaccount.demo.application;


import com.bankaccount.demo.domain.ClientService;
import com.bankaccount.demo.domain.DomainClientService;
import com.bankaccount.demo.domain.dto.ClientDto;
import com.bankaccount.demo.domain.mappers.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    ResponseEntity<ClientDto> createClient(@RequestBody ClientDto client) {
        return ResponseEntity.ok(ClientMapper.clientDtoBuild(clientService.createClient(client)));
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(ClientMapper.clientDtoBuild(clientService.getClient(id)));
    }

    @GetMapping(value = "/{id}/deposit/{amount}")
    ResponseEntity<ClientDto> depositClient(@PathVariable Long id, @PathVariable double amount ) {
        return ResponseEntity.ok(ClientMapper.clientDtoBuild(clientService.depositClient(id, amount)));

    }

    @GetMapping(value = "/{id}/withdraw/{amount}")
    ResponseEntity<ClientDto> withdrawClient(@PathVariable Long id, @PathVariable double amount ) {
        return ResponseEntity.ok(ClientMapper.clientDtoBuild(clientService.withdrawClient(id, amount)));
    }
}
