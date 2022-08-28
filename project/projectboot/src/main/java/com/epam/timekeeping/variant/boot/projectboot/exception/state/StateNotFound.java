package com.epam.timekeeping.variant.boot.projectboot.exception.state;

public class StateNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer id;

    public StateNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
