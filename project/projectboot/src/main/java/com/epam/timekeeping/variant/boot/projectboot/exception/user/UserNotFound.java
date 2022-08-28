package com.epam.timekeeping.variant.boot.projectboot.exception.user;

public class UserNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer id;

    public UserNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}