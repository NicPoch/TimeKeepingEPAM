package com.epam.timekeeping.variant.boot.projectboot.exception.state;

import com.epam.timekeeping.variant.boot.projectboot.exception.activity.IncorrectActivitySort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StateExceptionHandler {
    Logger logger = LoggerFactory.getLogger(StateExceptionHandler.class);
    @ExceptionHandler(value = StateNotFound.class)
    public ResponseEntity<Object> exception(StateNotFound exception){
        logger.error("StateNotFpund exception: "+exception.getId());
        return new ResponseEntity<>("There is no state with such id: "+exception.getId(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = StateIncorrectFormat.class)
    public ResponseEntity<Object> exception(StateIncorrectFormat exception){
        logger.error("StateIncorrectFormat exception: "+String.join(", ",exception.getErrors()));
        return new ResponseEntity<>("Incorrect state format: "+String.join("\n",exception.getErrors()),HttpStatus.BAD_REQUEST);
    }
}
