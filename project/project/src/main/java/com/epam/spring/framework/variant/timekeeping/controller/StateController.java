package com.epam.spring.framework.variant.timekeeping.controller;

import com.epam.spring.framework.variant.timekeeping.domain.State;
import com.epam.spring.framework.variant.timekeeping.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public List<State> getStates(){
        return stateService.getStates();
    }
    @GetMapping(value = "/{id}")
    public State getStates(@PathVariable int id){
        return stateService.getStateById(id);
    }
    @PostMapping
    public State getStates(@RequestBody State state){
        stateService.saveOrUpdateState(state);
        return state;
    }
    @PutMapping(value = "/{id}")
    public State updateState(@PathVariable int id,@RequestBody State newState){
        State state =this.stateService.getStateById(id);
        if(state!=null) stateService.saveOrUpdateState(newState);
        return newState;
    }
    @DeleteMapping(value = "/{id}")
    public State deleteState(@PathVariable int id){
        State state =this.stateService.getStateById(id);
        if(state!=null) stateService.deleteState(id);
        return state;
    }
}
