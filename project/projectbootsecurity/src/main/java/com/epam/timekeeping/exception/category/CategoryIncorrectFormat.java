package com.epam.timekeeping.exception.category;

import java.util.List;

public class CategoryIncorrectFormat extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public CategoryIncorrectFormat(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
