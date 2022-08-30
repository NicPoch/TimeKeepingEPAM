package com.epam.timekeeping.variant.boot.projectboot.exception.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    Logger logger = LoggerFactory.getLogger(UserExceptionHandler.class);
    @ExceptionHandler(value = UserNotFound.class)
    public ResponseEntity<Object> exception(UserNotFound exception){
        logger.error("UserNotFound exception: "+exception.getId());
        return new ResponseEntity<>("Incorrect id: "+exception.getId(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = UserIncorrectFormat.class)
    public ResponseEntity<Object> exception(UserIncorrectFormat exception){
        logger.error("UserIncorrectFormat exception: "+String.join(", ",exception.getErrors()));
        return new ResponseEntity<>("Incorrect format: "+String.join("\n",exception.getErrors()), HttpStatus.NOT_ACCEPTABLE);
    }
}
