package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.dto.state.StateDetail;
import com.epam.timekeeping.variant.boot.projectboot.dto.state.StateDto;
import com.epam.timekeeping.variant.boot.projectboot.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<StateDto>> getStates(){
        return new ResponseEntity<>(stateService.getStates(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<StateDetail> getStates(@PathVariable int id){
        return new ResponseEntity<>(stateService.getStateById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StateDetail> postState(@RequestBody StateDto state){
        return new ResponseEntity<>(stateService.createState(state),HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<StateDetail> updateState(@PathVariable int id,@RequestBody StateDto newState){
        return new ResponseEntity<>(stateService.updateState(newState,id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<StateDetail> deleteState(@PathVariable int id){
        return new ResponseEntity<>(stateService.deleteState(id),HttpStatus.OK);
    }
}
