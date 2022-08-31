package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.dto.state.StateDetail;
import com.epam.timekeeping.variant.boot.projectboot.dto.state.StateDto;
import com.epam.timekeeping.variant.boot.projectboot.service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/states")
public class StateController {
    Logger logger = LoggerFactory.getLogger(StateController.class);

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<StateDto>> getStates(){
        logger.info("Get all states");
        return new ResponseEntity<>(stateService.getStates(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getStates(@PathVariable int id){
        logger.info("Get state with id: "+id);
        return new ResponseEntity<>(stateService.getStateById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> postState(@RequestBody StateDto state){
        logger.info("Posting new State");
        return new ResponseEntity<>(stateService.createState(state),HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateState(@PathVariable int id,@RequestBody StateDto newState){
        logger.info("Put request for state with id: "+id);
        return new ResponseEntity<>(stateService.updateState(newState,id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<StateDetail> deleteState(@PathVariable int id){
        logger.info("Delete request for state with id: "+id);
        return new ResponseEntity<>(stateService.deleteState(id),HttpStatus.OK);
    }
}
