package com.epam.timekeeping.controllers;

import com.epam.timekeeping.dto.user.UserGet;
import com.epam.timekeeping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserGet>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> getUserById(@PathVariable long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Object> postUsers(@RequestBody UserPost dto){
//        return new ResponseEntity<>(userService.createUser(dto),HttpStatus.ACCEPTED);
//    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody UserPost dto){
//        return new ResponseEntity<>(userService.updateUser(dto,id),HttpStatus.ACCEPTED);
//    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteUser(@PathVariable long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }
}
