package com.epam.timekeeping.variant.boot.projectboot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(nullable = false,unique = true,name = "username")
    private String username;

    @Column(nullable = false,name = "password")
    private String password;

    @Column(nullable = false,unique = true,name = "mail")
    private String mail;

    public User(int id, String name, String username, String password, String mail) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }
}
