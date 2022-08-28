package com.epam.timekeeping.variant.boot.projectboot.exception.administrator;

public class AdministratorNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer id;

    public AdministratorNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}