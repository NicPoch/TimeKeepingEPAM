package com.epam.timekeeping.controller;

import com.epam.timekeeping.domain.User;
import com.epam.timekeeping.dto.User.UserDto;
import com.epam.timekeeping.dto.User.UserPostDto;
import com.epam.timekeeping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private UserDto userEntityToDTO(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setMail(user.getMail());
        return dto;
    }

    private User userPostDtoToEntity(UserPostDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setMail(dto.getMail());
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers().stream().map(this::userEntityToDTO).collect(Collectors.toList());
    }
    @GetMapping(value = "/{id}")
    public UserDto getUsers(@PathVariable int id){
        //TODO exception handling for 404
        return this.userEntityToDTO(userService.getUserById(id));
    }
    @PostMapping
    public UserDto postUsers(@RequestBody UserPostDto dto){
        //TODO Exception handling for 400
        User user = userPostDtoToEntity(dto);
        userService.saveOrUpdateUser(user);
        return this.userEntityToDTO(user);
    }
    @PutMapping(value = "/{id}")
    public UserDto updateUser(@PathVariable int id,@RequestBody UserPostDto dto){
        User user =this.userService.getUserById(id);
        if(user!=null) {
            User newUser = userPostDtoToEntity(dto);
            userService.saveOrUpdateUser(newUser);
            return userEntityToDTO(newUser);
        }
        //TODO exception handling for 404 or 402
        return null;
    }
    @DeleteMapping(value = "/{id}")
    public UserDto deleteUser(@PathVariable int id){
        User user =this.userService.getUserById(id);
        if(user!=null) {
            userService.deleteUser(id);
            return userEntityToDTO(user);
        }
        //TODO Exception handling for 404 and 403
        return null;
    }
}
