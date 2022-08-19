package com.epam.variant.timekeeping.demo.controller;

import com.epam.variant.timekeeping.demo.model.State;
import com.epam.variant.timekeeping.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/api/states")
public class StateController {
    @Autowired
    private StateRepository stateRepository;

    @GetMapping
    public Iterable findAll(){
        return stateRepository.findAll();
    }
    @GetMapping("/{name}")
    public Iterable findByName(@PathVariable String name){
        return stateRepository.findByName(name);
    }
    @GetMapping("/{id}")
    public State  findOne(@PathVariable Long id) {
        return stateRepository.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public State create(@RequestBody State  book) {
        return stateRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            stateRepository.findById(id).orElseThrow(Exception::new);
            stateRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
