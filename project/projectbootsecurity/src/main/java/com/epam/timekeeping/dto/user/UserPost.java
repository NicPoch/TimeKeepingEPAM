package com.epam.timekeeping.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPost {
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Set<String> role;



}
