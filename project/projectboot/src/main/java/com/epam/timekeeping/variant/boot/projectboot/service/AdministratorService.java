package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.Administrator;
import com.epam.timekeeping.variant.boot.projectboot.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorService {
    @Autowired
    AdministratorRepository administratorRepository;

    public Administrator getAdministratorById(Integer id)
    {
        return  administratorRepository.findById(id).get();
    }
    public List<Administrator> getAdministrators(){
        List<Administrator> administrators = new ArrayList<>();
        administratorRepository.findAll().forEach(administrators::add);
        return administrators;
    }
    public void saveOrUpdateAdministrator(Administrator administrator){
        administratorRepository.save(administrator);
    }
    public void deleteAdministrator(Integer id){
        administratorRepository.deleteById(id);
    }
}
