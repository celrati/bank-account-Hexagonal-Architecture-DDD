package com.bankaccount.demo.controller;


import com.bankaccount.demo.core.dto.ClientDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {


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
