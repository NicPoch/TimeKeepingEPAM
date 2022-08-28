package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.domain.Administrator;
import com.epam.timekeeping.variant.boot.projectboot.dto.administrator.AdministratorDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.administrator.AdministratorPostDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserLogin;
import com.epam.timekeeping.variant.boot.projectboot.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping
    public List<AdministratorDto> getAdministrators(){
        return administratorService.getAdministrators();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getAdministrators(@PathVariable int id){
        return new ResponseEntity<>(administratorService.getAdministratorById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> postAdministrators(@RequestBody AdministratorPostDto administrator){
        return new ResponseEntity<>(administratorService.createAdministrator(administrator), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> loginAdministrators(@RequestBody UserLogin administrator){
        return new ResponseEntity<>(administratorService.login(administrator), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateAdministrator(@PathVariable int id,@RequestBody AdministratorPostDto administrator){
        return new ResponseEntity<>(administratorService.updateAdministrator(administrator,id), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteAdministrator(@PathVariable int id){
        return new ResponseEntity<>(administratorService.deleteAdministrator(id), HttpStatus.OK);
    }
}
