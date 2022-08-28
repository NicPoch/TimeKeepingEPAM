package com.epam.timekeeping.variant.boot.projectboot.dto.user;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin implements Serializable {
    private String username;
    private String password;
}
