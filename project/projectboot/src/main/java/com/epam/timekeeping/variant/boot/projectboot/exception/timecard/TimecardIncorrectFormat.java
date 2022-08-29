package com.epam.timekeeping.variant.boot.projectboot.exception.timecard;

import java.util.List;

public class TimecardIncorrectFormat extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public TimecardIncorrectFormat(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
