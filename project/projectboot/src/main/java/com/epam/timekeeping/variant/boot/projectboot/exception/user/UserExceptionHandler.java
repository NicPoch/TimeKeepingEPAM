package com.epam.timekeeping.variant.boot.projectboot.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(value = UserNotFound.class)
    public ResponseEntity<Object> exception(UserNotFound exception){
        return new ResponseEntity<>("Incorrect id: "+exception.getId(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = UserIncorrectFormat.class)
    public ResponseEntity<Object> exception(UserIncorrectFormat exception){
        return new ResponseEntity<>("Incorrect format: "+String.join("\n",exception.getErrors()), HttpStatus.NOT_ACCEPTABLE);
    }
}
