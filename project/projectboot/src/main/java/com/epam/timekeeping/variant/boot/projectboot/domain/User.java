package com.epam.timekeeping.variant.boot.projectboot.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Integer id;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(nullable = false,unique = true,name = "username")
    private String username;

    @Column(nullable = false,name = "password",length = 65)
    private String password;

    @Column(nullable = false,unique = true,name = "mail")
    private String mail;
}
