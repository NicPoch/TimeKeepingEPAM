package com.epam.timekeeping.variant.boot.projectboot.exception.administrator;

import java.util.List;

public class AdministratorIncorrectFormat extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public AdministratorIncorrectFormat(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
