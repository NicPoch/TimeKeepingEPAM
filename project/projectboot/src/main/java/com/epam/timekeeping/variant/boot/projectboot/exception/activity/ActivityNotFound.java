package com.epam.timekeeping.variant.boot.projectboot.exception.activity;

public class ActivityNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer id;

    public ActivityNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
