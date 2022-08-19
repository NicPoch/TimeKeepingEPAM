package com.epam.spring.framework.variant.timekeeping.controller;

import com.epam.spring.framework.variant.timekeeping.domain.State;
import com.epam.spring.framework.variant.timekeeping.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class StateController {
    private StateRepository stateRepository;

    @Autowired
    public  StateController(StateRepository stateRepository){
        this.stateRepository=stateRepository;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request){
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/states",method = {RequestMethod.GET},produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE,MediaType.TEXT_XML_VALUE})
    public ResponseEntity<Iterable<State>> getStates(@RequestHeader HttpHeaders header){
        return new ResponseEntity<Iterable<State>>(this.stateRepository.findAll(),header, HttpStatus.OK);
    }
}
