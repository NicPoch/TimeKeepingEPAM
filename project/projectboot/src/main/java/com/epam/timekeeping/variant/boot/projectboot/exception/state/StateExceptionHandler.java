package com.epam.timekeeping.variant.boot.projectboot.exception.state;

import com.epam.timekeeping.variant.boot.projectboot.exception.activity.IncorrectActivitySort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StateExceptionHandler {
    @ExceptionHandler(value = StateNotFound.class)
    public ResponseEntity<Object> exception(StateNotFound exception){
        return new ResponseEntity<>("There is no state with such id: "+exception.getId(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = StateIncorrectFormat.class)
    public ResponseEntity<Object> exception(StateIncorrectFormat exception){
        return new ResponseEntity<>("Incorrect state format: "+String.join("\n",exception.getErrors()),HttpStatus.BAD_REQUEST);
    }
}
