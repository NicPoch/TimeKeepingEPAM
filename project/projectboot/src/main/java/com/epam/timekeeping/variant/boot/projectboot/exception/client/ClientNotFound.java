package com.epam.timekeeping.variant.boot.projectboot.exception.client;

public class ClientNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer id;

    public ClientNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}