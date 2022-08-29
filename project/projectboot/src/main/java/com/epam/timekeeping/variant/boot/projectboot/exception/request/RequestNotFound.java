package com.epam.timekeeping.variant.boot.projectboot.exception.request;

public class RequestNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer id;

    public RequestNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}