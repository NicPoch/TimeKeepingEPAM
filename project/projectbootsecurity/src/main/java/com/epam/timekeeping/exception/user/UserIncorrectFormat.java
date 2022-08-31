package com.epam.timekeeping.exception.user;

import java.util.List;

public class UserIncorrectFormat extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public UserIncorrectFormat(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
