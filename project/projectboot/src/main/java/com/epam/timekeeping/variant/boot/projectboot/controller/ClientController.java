package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientPostDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserLogin;
import com.epam.timekeeping.variant.boot.projectboot.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    Logger logger= LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDto> getClients(){
        logger.info("Get all clients");
        return clientService.getClients();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getClients(@PathVariable int id){
        logger.info("Get client with id: "+id);
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> postClients(@RequestBody ClientPostDto client){
        logger.info("Posting new client");
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> loginClients(@RequestBody UserLogin client){
        logger.info("Login client");
        return new ResponseEntity<>(clientService.login(client), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable int id,@RequestBody ClientPostDto client){
        logger.info("Put request for client with id: "+id);
        return new ResponseEntity<>(clientService.updateClient(client,id), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable int id){
        logger.info("Delete request for client with id: "+id);
        return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK);
    }
}
