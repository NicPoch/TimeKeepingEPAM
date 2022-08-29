package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.domain.User;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserGet;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserPost;
import com.epam.timekeeping.variant.boot.projectboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserGet>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUsers(@PathVariable int id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> postUsers(@RequestBody UserPost dto){
        return new ResponseEntity<>(userService.createUser(dto),HttpStatus.ACCEPTED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody UserPost dto){
        return new ResponseEntity<>(userService.updateUser(dto,id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }
}
