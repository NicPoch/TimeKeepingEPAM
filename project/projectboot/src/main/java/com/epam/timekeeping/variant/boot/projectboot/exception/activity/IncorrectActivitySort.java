package com.epam.timekeeping.variant.boot.projectboot.exception.activity;

public class IncorrectActivitySort extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String sort;

    public IncorrectActivitySort(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }
}
