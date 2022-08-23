package com.epam.spring.framework.variant.timekeeping.controller;

import com.epam.spring.framework.variant.timekeeping.domain.Administrator;
import com.epam.spring.framework.variant.timekeeping.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping
    public List<Administrator> getAdministrators(){
        return administratorService.getAdministrators();
    }
    @GetMapping(value = "/{id}")
    public Administrator getAdministrators(@PathVariable int id){
        return administratorService.getAdministratorById(id);
    }
    @PostMapping
    public Administrator getAdministrators(@RequestBody Administrator administrator){
        administratorService.saveOrUpdateAdministrator(administrator);
        return administrator;
    }
    @PutMapping(value = "/{id}")
    public Administrator updateAdministrator(@PathVariable int id,@RequestBody Administrator newAdministrator){
        Administrator administrator =this.administratorService.getAdministratorById(id);
        if(administrator!=null) administratorService.saveOrUpdateAdministrator(newAdministrator);
        return newAdministrator;
    }
    @DeleteMapping(value = "/{id}")
    public Administrator deleteAdministrator(@PathVariable int id){
        Administrator administrator =this.administratorService.getAdministratorById(id);
        if(administrator!=null) administratorService.deleteAdministrator(id);
        return administrator;
    }
}
