package com.epam.timekeeping.variant.boot.projectboot.exception.timecard;

public class TimecardNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer id;

    public TimecardNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}