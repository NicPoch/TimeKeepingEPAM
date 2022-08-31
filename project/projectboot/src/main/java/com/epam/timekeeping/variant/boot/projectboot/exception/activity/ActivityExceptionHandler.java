package com.epam.timekeeping.variant.boot.projectboot.exception.activity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ActivityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(ActivityExceptionHandler.class);
    @ExceptionHandler(value = IncorrectActivitySort.class)
    public ResponseEntity<Object> exception(IncorrectActivitySort exception){
        logger.error("IncorrectActivitySort exception: "+exception.getSort());
        return new ResponseEntity<>("Incorrect sort key: "+exception.getSort(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = ActivityNotFound.class)
    public ResponseEntity<Object> exception(ActivityNotFound exception){
        logger.error("ActivityNotFound exception: "+exception.getId());
        return new ResponseEntity<>("There is no activity with such id: "+exception.getId(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ActivityIncorrectFormat.class)
    public ResponseEntity<Object> exception(ActivityIncorrectFormat exception){
        logger.error("ActivityIncorrectFormat exception"+String.join(", ",exception.getErrors()));
        return new ResponseEntity<>("Incorrect activity format: "+String.join("\n",exception.getErrors()),HttpStatus.BAD_REQUEST);
    }
}
