package com.epam.timekeeping.variant.boot.projectboot.exception.request;

import com.epam.timekeeping.variant.boot.projectboot.exception.request.RequestIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.request.RequestNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestExceptionHandler {
    Logger logger = LoggerFactory.getLogger(RequestExceptionHandler.class);
    @ExceptionHandler(value = RequestNotFound.class)
    public ResponseEntity<Object> exception(RequestNotFound exception){
        logger.error("RequestNotFound exception: "+exception.getId());
        return new ResponseEntity<>("Incorrect id: "+exception.getId(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = RequestIncorrectFormat.class)
    public ResponseEntity<Object> exception(RequestIncorrectFormat exception){
        logger.error("RequestIncorrectFormat exception: "+String.join(", ",exception.getErrors()));
        return new ResponseEntity<>("Incorrect format: "+String.join("\n",exception.getErrors()), HttpStatus.NOT_ACCEPTABLE);
    }
}
