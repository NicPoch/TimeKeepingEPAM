package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.Client;
import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientDetailDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientPostDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserLogin;
import com.epam.timekeeping.variant.boot.projectboot.exception.client.ClientIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.client.ClientLoginIncorrect;
import com.epam.timekeeping.variant.boot.projectboot.exception.client.ClientNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.category.CategoryNotFound;
import com.epam.timekeeping.variant.boot.projectboot.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ModelMapper mapper;

    public ClientDetailDto getClientById(Integer id) throws ClientNotFound
    {
        return  mapper.map(clientRepository.findById(id).orElseThrow(()->new CategoryNotFound(id)),ClientDetailDto.class);
    }
    public List<ClientDto> getClients(){
        List<ClientDto> clients = new ArrayList<>();
        clientRepository.findAll().forEach(a->clients.add(mapper.map(a,ClientDto.class)));
        return clients;
    }

    public ClientDetailDto login(UserLogin login)throws ClientLoginIncorrect {
        return mapper.map(clientRepository.findByUsernameAndPassword(login.getUsername(),login.getPassword()).orElseThrow(()->new ClientLoginIncorrect()),ClientDetailDto.class);
    }

    public ClientDetailDto createClient(ClientPostDto client)throws ClientIncorrectFormat {
        List<String> errors= new ArrayList<>();
        if(client.getUsername()==null||client.getUsername().trim().length()==0) errors.add("Empty client name");
        if(clientRepository.existsByUsernameIgnoreCase(client.getUsername())) errors.add("Existing clientname");
        if(client.getMail()==null || client.getMail().trim().length()==0) errors.add("Empty mail");
        if(clientRepository.existsByMailIgnoreCase(client.getMail())) errors.add("Existing mail");

        if(errors.size()>0) throw new ClientIncorrectFormat(errors);

        return mapper.map(clientRepository.save(mapper.map(client, Client.class)),ClientDetailDto.class);
    }
    public ClientDetailDto updateClient(ClientPostDto client, Integer id)throws ClientNotFound {
        Client entity = clientRepository.findById(id).orElseThrow(()->new ClientNotFound(id));
        entity.setMail((client.getMail()==null)?entity.getMail():client.getMail());
        entity.setName((client.getName()==null)?entity.getName():client.getName());
        entity.setUsername((client.getUsername()==null)?entity.getUsername():client.getUsername());
        entity.setPassword((client.getPassword()==null)?entity.getPassword():client.getPassword());
        entity.setCompany((client.getCompany()==null)?entity.getCompany():client.getCompany());
        return mapper.map(clientRepository.save(entity),ClientDetailDto.class);
    }
    public ClientDetailDto deleteClient(Integer id){
        Client client = clientRepository.findById(id).orElseThrow(()->new ClientNotFound(id));
        clientRepository.delete(client);
        return mapper.map(client,ClientDetailDto.class);
    }
}
