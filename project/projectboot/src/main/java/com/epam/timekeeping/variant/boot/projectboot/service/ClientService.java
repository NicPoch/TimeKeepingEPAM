package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.Client;
import com.epam.timekeeping.variant.boot.projectboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client getClientById(Integer id)
    {
        return  clientRepository.findById(id).get();
    }
    public List<Client> getClients(){
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }
    public void saveOrUpdateClient(Client client){
        clientRepository.save(client);
    }
    public void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }
}
