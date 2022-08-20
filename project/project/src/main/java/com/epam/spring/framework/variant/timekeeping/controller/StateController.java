package com.epam.spring.framework.variant.timekeeping.controller;

import com.epam.spring.framework.variant.timekeeping.domain.State;
import com.epam.spring.framework.variant.timekeeping.repository.StateRepository;
import com.epam.spring.framework.variant.timekeeping.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StateController {

    @Autowired
    private StateService stateService;

    @RequestMapping
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request){
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/states")
    public List<State> getStates(){
        return stateService.getStates();
    }
    @GetMapping(value = "/states/{id}")
    public State getStates(@PathVariable int id){
        return stateService.getStateById(id);
    }
    @PostMapping(value = "/states")
    public State getStates(@RequestBody State state){
        stateService.saveOrUpdateState(state);
        return state;
    }
    @PutMapping(value = "/states/{id}")
    public State updateState(@PathVariable int id,@RequestBody State newState){
        State state =this.stateService.getStateById(id);
        if(state!=null) stateService.saveOrUpdateState(newState);
        return newState;
    }
    @DeleteMapping(value = "/states/{id}")
    public State deleteState(@PathVariable int id){
        State state =this.stateService.getStateById(id);
        if(state!=null) stateService.deleteState(id);
        return state;
    }
}
