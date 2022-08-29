package com.epam.timekeeping.variant.boot.projectboot.exception.client;

import java.util.List;

public class ClientIncorrectFormat extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public ClientIncorrectFormat(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
