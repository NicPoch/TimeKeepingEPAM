package com.epam.timekeeping.variant.boot.projectboot.exception.activity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ActivityExceptionHandler {
    @ExceptionHandler(value = IncorrectActivitySort.class)
    public ResponseEntity<Object> exception(IncorrectActivitySort exception){
        return new ResponseEntity<>("Incorrect sort key: "+exception.getSort(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = ActivityNotFound.class)
    public ResponseEntity<Object> exception(ActivityNotFound exception){
        return new ResponseEntity<>("There is no activity with such id: "+exception.getId(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ActivityIncorrectFormat.class)
    public ResponseEntity<Object> exception(ActivityIncorrectFormat exception){
        return new ResponseEntity<>("Incorrect activity format: "+String.join("\n",exception.getErrors()),HttpStatus.BAD_REQUEST);
    }
}
