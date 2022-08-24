package com.epam.timekeeping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class WelcomeController {
    @GetMapping
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
