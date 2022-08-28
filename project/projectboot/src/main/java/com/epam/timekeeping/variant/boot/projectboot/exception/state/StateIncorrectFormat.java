package com.epam.timekeeping.variant.boot.projectboot.exception.state;

import java.util.List;

public class StateIncorrectFormat extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public StateIncorrectFormat(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
