package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.User;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserGet;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserPost;
import com.epam.timekeeping.variant.boot.projectboot.exception.user.UserIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.user.UserNotFound;
import com.epam.timekeeping.variant.boot.projectboot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper mapper;
    public UserGet getUserById(Integer id) throws UserNotFound
    {
        logger.info("Getting user with id: "+id);
        try {
            return  mapper.map(userRepository.findById(id).orElseThrow(()->new UserNotFound(id)),UserGet.class);
        }
        catch (UserNotFound userNotFound){
            logger.error("User not found "+id);
            throw userNotFound;
        }

    }
    public List<UserGet> getUsers(){
        logger.info("Getting all users");
        List<UserGet> users = new ArrayList<>();
        userRepository.findAll().forEach(u-> users.add(mapper.map(u,UserGet.class)));
        return users;
    }
    public UserGet createUser(UserPost user)throws UserIncorrectFormat {
        logger.info("Creating new user: "+user.toString());
        List<String> errors= new ArrayList<>();
        if(user.getUsername()==null||user.getUsername().trim().length()==0) errors.add("Empty username");
        if(userRepository.existsByUsernameIgnoreCase(user.getUsername())) errors.add("Existing username");
        if(user.getMail()==null || user.getMail().trim().length()==0) errors.add("Empty mail");
        if(userRepository.existsByMailIgnoreCase(user.getMail())) errors.add("Existing mail");

        if(errors.size()>0) throw new UserIncorrectFormat(errors);

        return mapper.map(userRepository.save(mapper.map(user,User.class)),UserGet.class);
    }
    public UserGet updateUser(UserPost user,Integer id)throws UserNotFound{
        logger.info("Updating user: "+user.toString());
        User entity = userRepository.findById(id).orElseThrow(()->new UserNotFound(id));
        entity.setMail((user.getMail()==null)?entity.getMail():user.getMail());
        entity.setName((user.getName()==null)?entity.getName():user.getName());
        entity.setUsername((user.getUsername()==null)?entity.getUsername():user.getUsername());
        entity.setPassword((user.getPassword()==null)?entity.getPassword():user.getPassword());
        return mapper.map(userRepository.save(entity),UserGet.class);
    }
    public UserGet deleteUser(Integer id){
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFound(id));
        userRepository.delete(user);
        return mapper.map(user,UserGet.class);
    }

}
