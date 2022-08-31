package com.epam.timekeeping.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class UserGet {
    private int id;
    private String name;
    private String username;
    private String email;

}
