package com.epam.spring.framework.variant.timekeeping.controller;

import com.epam.spring.framework.variant.timekeeping.domain.User;
import com.epam.spring.framework.variant.timekeeping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping(value = "/{id}")
    public User getUsers(@PathVariable int id){
        return userService.getUserById(id);
    }
    @PostMapping
    public User getUsers(@RequestBody User user){
        userService.saveOrUpdateUser(user);
        return user;
    }
    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User newUser){
        User user =this.userService.getUserById(id);
        if(user!=null) userService.saveOrUpdateUser(newUser);
        return newUser;
    }
    @DeleteMapping(value = "/{id}")
    public User deleteUser(@PathVariable int id){
        User user =this.userService.getUserById(id);
        if(user!=null) userService.deleteUser(id);
        return user;
    }
}
