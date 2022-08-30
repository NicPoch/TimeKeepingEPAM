package com.epam.timekeeping.variant.boot.projectboot.exception.client;

import com.epam.timekeeping.variant.boot.projectboot.exception.client.ClientIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.client.ClientLoginIncorrect;
import com.epam.timekeeping.variant.boot.projectboot.exception.client.ClientNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientExceptionHandler {
    Logger logger = LoggerFactory.getLogger(ClientExceptionHandler.class);
    @ExceptionHandler(value = ClientNotFound.class)
    public ResponseEntity<Object> exception(ClientNotFound exception){
        logger.error("ClientNotFound exception: "+exception.getId());
        return new ResponseEntity<>("Incorrect id: "+exception.getId(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = ClientLoginIncorrect.class)
    public ResponseEntity<Object> exception(ClientLoginIncorrect exception){
        logger.error("ClientLoginIncorrect exception");
        return new ResponseEntity<>("Incorrect login", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = ClientIncorrectFormat.class)
    public ResponseEntity<Object> exception(ClientIncorrectFormat exception){
        logger.error("ClientIncorrectFormat exception: "+String.join(", ",exception.getErrors()));
        return new ResponseEntity<>("Incorrect format: "+String.join("\n",exception.getErrors()), HttpStatus.NOT_ACCEPTABLE);
    }
}
