package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientPostDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserLogin;
import com.epam.timekeeping.variant.boot.projectboot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDto> getClients(){
        return clientService.getClients();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getClients(@PathVariable int id){
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> postClients(@RequestBody ClientPostDto client){
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> loginClients(@RequestBody UserLogin client){
        return new ResponseEntity<>(clientService.login(client), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable int id,@RequestBody ClientPostDto client){
        return new ResponseEntity<>(clientService.updateClient(client,id), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable int id){
        return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK);
    }
}
