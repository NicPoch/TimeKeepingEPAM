package com.epam.timekeeping.variant.boot.projectboot.exception.request;

import com.epam.timekeeping.variant.boot.projectboot.exception.request.RequestIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.request.RequestNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestExceptionHandler {
    @ExceptionHandler(value = RequestNotFound.class)
    public ResponseEntity<Object> exception(RequestNotFound exception){
        return new ResponseEntity<>("Incorrect id: "+exception.getId(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = RequestIncorrectFormat.class)
    public ResponseEntity<Object> exception(RequestIncorrectFormat exception){
        return new ResponseEntity<>("Incorrect format: "+String.join("\n",exception.getErrors()), HttpStatus.NOT_ACCEPTABLE);
    }
}
