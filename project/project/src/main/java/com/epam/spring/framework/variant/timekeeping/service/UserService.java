package com.epam.spring.framework.variant.timekeeping.service;

import com.epam.spring.framework.variant.timekeeping.domain.User;
import com.epam.spring.framework.variant.timekeeping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(Integer id)
    {
        return  userRepository.findOne(id);
    }
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public void saveOrUpdateUser(User user){
        userRepository.save(user);
    }
    public void deleteUser(Integer id){
        userRepository.delete(id);
    }
}
