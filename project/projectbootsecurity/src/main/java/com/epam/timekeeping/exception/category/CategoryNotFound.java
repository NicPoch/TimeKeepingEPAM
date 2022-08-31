package com.epam.timekeeping.exception.category;

public class CategoryNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer id;

    public CategoryNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
