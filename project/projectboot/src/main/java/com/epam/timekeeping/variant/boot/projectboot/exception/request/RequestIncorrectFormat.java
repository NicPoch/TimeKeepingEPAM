package com.epam.timekeeping.variant.boot.projectboot.exception.request;

import java.util.List;

public class RequestIncorrectFormat extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public RequestIncorrectFormat(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
