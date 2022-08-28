package com.epam.timekeeping.variant.boot.projectboot.exception.activity;

import java.util.List;

public class ActivityIncorrectFormat extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public ActivityIncorrectFormat(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
