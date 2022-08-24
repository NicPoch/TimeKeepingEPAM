package com.epam.timekeeping.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(nullable = false,unique = true,name = "username")
    private String username;

    @Column(nullable = false,name = "password")
    private String password;

    @Column(nullable = false,unique = true,name = "mail")
    private String mail;

    public User() {
        super();
    }

    public User(int id, String name, String username, String password, String mail) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
