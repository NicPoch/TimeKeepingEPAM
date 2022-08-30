package com.epam.timekeeping.variant.boot.projectboot.user;

import com.epam.timekeeping.variant.boot.projectboot.domain.User;
import com.epam.timekeeping.variant.boot.projectboot.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserEntityTest {
    @Autowired
    private UserRepository userRepository;
    private User user,temp;

    @BeforeEach
    public void setUp(){
        user=new User(1,"Pepe Grillo","pepe","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8","example@example.com");
        user=userRepository.save(user);
    }
    @AfterEach
    public void tearDown(){
        userRepository.delete(user);
        userRepository.delete(temp);
        user=null;
        temp=null;
    }
    @Test
    public void getUser(){
        temp = userRepository.findById(user.getId()).get();
        assertNotNull(temp);
        assertEquals(temp.getName(),user.getName());
        assertEquals(temp.getId(),user.getId());
        assertEquals(temp.getPassword(),user.getPassword());
        assertEquals(temp.getMail(),user.getMail());
    }
    @Test
    public void testCreateValidUserAllArgs(){
        temp =new User(2,"Pepe Grillo","pepe2","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8","example@example2.com");
        temp=userRepository.save(temp);
        System.out.println(temp.getId());
        assertNotNull(temp,"Null user");
        assertEquals(temp.getName(),"Pepe Grillo","Incorrect name");
        assertEquals(temp.getUsername(),"pepe2","Incorrect id");
        assertEquals(temp.getPassword(),"5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8","incorrect password");
        assertEquals(temp.getMail(),"example@example2.com","Incorrect mail");
    }
    @Test
    public void testCreateValidUserNoArgs(){
        temp=new User();
        temp.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
        temp.setMail("mail@mail.com");
        temp.setName("Name");
        temp.setUsername("weird_user");
        temp=userRepository.save(temp);
        assertNotNull(temp);
        assertEquals(temp.getName(),"Name");
        assertEquals(temp.getUsername(),"weird_user");
        assertEquals(temp.getPassword(),"5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
        assertEquals(temp.getMail(),"mail@mail.com");
    }
    @Test
    public void testCreateInvalidUserAllArgsNoName(){
        try {
            temp =new User(2,null,"pepe2","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8","example@example2.com");
            temp=userRepository.save(temp);
            fail();
        }catch (Exception exception){
            assertTrue(true);
        }
    }
    @Test
    public void testCreateInvalidUserAllArgsNoUsername(){
        try {
            temp =new User(2,"Pepe grillo",null,"5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8","example@example2.com");
            temp=userRepository.save(temp);
            fail();
        }catch (Exception exception){
            assertTrue(true);
        }
    }
    @Test
    public void testCreateInvalidUserAllArgsNoPassword(){
        try {
            temp =new User(2,"Pepe grillo","username",null,"example@example2.com");
            temp=userRepository.save(temp);
            fail();
        }catch (Exception exception){
            assertTrue(true);
        }
    }
    @Test
    public void testCreateInvalidUserAllArgsMail(){
        try {
            temp =new User(2,"Pepe grillo","username","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8",null);
            temp=userRepository.save(temp);
            fail();
        }catch (Exception exception){
            assertTrue(true);
        }
    }
    @Test
    public void testCreateRepeatedUserAllArgsMail(){
        try {
            temp =new User(2,"Pepe Grillo","pepe2","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8","example@example.com");
            temp=userRepository.save(temp);
            fail();
        }catch (Exception exception){
            assertTrue(true);
        }
    }
    @Test
    public void testCreateRepeatedUserAllArgsUsername(){
        try {
            temp =new User(2,"Pepe Grillo","pepe","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8","example@m.com");
            temp=userRepository.save(temp);
            fail();
        }catch (Exception exception){
            assertTrue(true);
        }
    }
}
