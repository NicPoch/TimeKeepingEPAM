package com.epam.spring.framework.variant.timekeeping.controller;

import com.epam.spring.framework.variant.timekeeping.domain.Client;
import com.epam.spring.framework.variant.timekeeping.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }
    @GetMapping(value = "/{id}")
    public Client getClients(@PathVariable int id){
        return clientService.getClientById(id);
    }
    @PostMapping
    public Client getClients(@RequestBody Client client){
        clientService.saveOrUpdateClient(client);
        return client;
    }
    @PutMapping(value = "/{id}")
    public Client updateClient(@PathVariable int id,@RequestBody Client newClient){
        Client client =this.clientService.getClientById(id);
        if(client!=null) clientService.saveOrUpdateClient(newClient);
        return newClient;
    }
    @DeleteMapping(value = "/{id}")
    public Client deleteClient(@PathVariable int id){
        Client client =this.clientService.getClientById(id);
        if(client!=null) clientService.deleteClient(id);
        return client;
    }
}
