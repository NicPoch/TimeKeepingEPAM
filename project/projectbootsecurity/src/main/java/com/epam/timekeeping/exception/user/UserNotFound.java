package com.epam.timekeeping.exception.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Long id;
}
