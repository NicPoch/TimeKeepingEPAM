package com.epam.timekeeping.variant.boot.projectboot.user;

import com.epam.timekeeping.variant.boot.projectboot.domain.User;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserGet;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserLogin;
import com.epam.timekeeping.variant.boot.projectboot.dto.user.UserPost;
import com.epam.timekeeping.variant.boot.projectboot.exception.user.UserIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.user.UserNotFound;
import com.epam.timekeeping.variant.boot.projectboot.repository.UserRepository;
import com.epam.timekeeping.variant.boot.projectboot.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @Spy
    ModelMapper mapper=new ModelMapper();
    @Autowired
    @InjectMocks
    UserService userService;
    UserPost userPost;
    UserLogin userLogin;
    UserGet userGet;
    List<UserGet> usersGet;
    User user;
    List<User> users;

    @BeforeEach
    public void setUp(){
        user = new User(1,"example","example","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8","mail@mail.com");
        userPost = new UserPost(1,"example","example","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8","mail@mail.com");
        userLogin = new UserLogin("example","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
        userGet = new UserGet(1,"example","example","mail@mail.com");
        usersGet=new ArrayList<>(){{add(userGet);}};
        users=new ArrayList<>(){{add(user);}};
    }
    @AfterEach
    public void teardown(){
        user = null;
        userPost = null;
        userLogin = null;
        userGet = null;
        usersGet=null;
        users=null;
        userRepository.deleteAll();
    }
    @Test
    public void testGetUser(){
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.ofNullable(user));
        try {
            UserGet temp = userService.getUserById(1);
            assertEquals(temp.getName(),user.getName());
            assertEquals(temp.getMail(),user.getMail());
            assertEquals(temp.getUsername(),user.getUsername());
        }catch (UserNotFound exception){
            fail("There is a user");
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            fail("Exception generated");
        }
    }
    @Test
    public void testGetUserNonExistent(){
        Mockito.when(userRepository.findById(2)).thenReturn(Optional.ofNullable(null));
        try {
            UserGet temp = userService.getUserById(2);
            fail("Should´ve thrown an exception");
        }catch (UserNotFound exception){
            assertEquals(exception.getId(),2);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            fail("Exception generated");
        }
    }
    @Test
    public void testGetAllUser(){
        Mockito.when(userRepository.findAll()).thenReturn(users);
        try {
            List<UserGet> temp= userService.getUsers();
            assertEquals(temp.size(),1);
            UserGet tempGet=temp.get(0);
            assertEquals(tempGet.getName(),user.getName());
            assertEquals(tempGet.getMail(),user.getMail());
            assertEquals(tempGet.getUsername(),user.getUsername());
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            fail("Exception generated");
        }
    }
    @Test
    public void testCreateUser(){
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
        try {
            UserGet temp= userService.createUser(userPost);

            assertEquals(temp.getName(),user.getName());
            assertEquals(temp.getMail(),user.getMail());
            assertEquals(temp.getUsername(),user.getUsername());
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            fail("Exception generated");
        }
    }
    @Test
    public void testCreateInvalidUserEmptyUserName(){
        try {
            UserGet temp= userService.createUser(new UserPost(1,"name","","masomdoamsodnoandoonsndo","e@e.com"));
            fail();
        }
        catch (UserIncorrectFormat exception){
            assertTrue(true);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            fail("Exception generated");
        }
    }
    @Test
    public void testCreateInvalidUserNullUserName(){
        try {
            UserGet temp= userService.createUser(new UserPost(1,"name",null,"masomdoamsodnoandoonsndo","e@e.com"));
            fail();
        }
        catch (UserIncorrectFormat exception){
            assertTrue(true);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            fail("Exception generated");
        }
    }
    @Test
    public void testCreateInvalidUserRepeatedUserName(){
        Mockito.when(userRepository.existsByUsernameIgnoreCase(Mockito.any())).thenReturn(true);
        try {
            UserGet temp= userService.createUser(new UserPost(1,"name","example","masomdoamsodnoandoonsndo","e@e.com"));
            fail();
        }
        catch (UserIncorrectFormat exception){
            assertTrue(true);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            fail("Exception generated");
        }
    }
    @Test
    public void testCreateInvalidUserEmptyMail(){
        try {
            UserGet temp= userService.createUser(new UserPost(1,"name","myuser","masomdoamsodnoandoonsndo",""));
            fail();
        }
        catch (UserIncorrectFormat exception){
            assertTrue(true);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            fail("Exception generated");
        }
    }
    @Test
    public void testCreateInvalidUserNullMail(){
        try {
            UserGet temp= userService.createUser(new UserPost(1,"name","myuser","masomdoamsodnoandoonsndo",null));
            fail();
        }
        catch (UserIncorrectFormat exception){
            assertTrue(true);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            fail("Exception generated");
        }
    }
    @Test
    public void testCreateInvalidUserRepeatedMail(){
        Mockito.when(userRepository.existsByMailIgnoreCase(Mockito.any())).thenReturn(true);
        try {
            UserGet temp= userService.createUser(new UserPost(1,"name","sads","masomdoamsodnoandoonsndo","e@e.com"));
            fail();
        }
        catch (UserIncorrectFormat exception){
            assertTrue(true);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            fail("Exception generated");
        }
    }


}
