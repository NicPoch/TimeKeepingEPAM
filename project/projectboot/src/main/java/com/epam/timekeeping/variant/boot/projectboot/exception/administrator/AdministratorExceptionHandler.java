package com.epam.timekeeping.variant.boot.projectboot.exception.administrator;

import com.epam.timekeeping.variant.boot.projectboot.exception.administrator.AdministratorIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.administrator.AdministratorNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdministratorExceptionHandler {
    Logger logger = LoggerFactory.getLogger(AdministratorExceptionHandler.class);
    @ExceptionHandler(value = AdministratorNotFound.class)
    public ResponseEntity<Object> exception(AdministratorNotFound exception){
        logger.error("AdministratorNotFound exception: "+exception.getId());
        return new ResponseEntity<>("Incorrect id: "+exception.getId(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = AdministratorLoginIncorrect.class)
    public ResponseEntity<Object> exception(AdministratorLoginIncorrect exception){
        logger.error("AdministratorLoginIncorrect exception");
        return new ResponseEntity<>("Incorrect login", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = AdministratorIncorrectFormat.class)
    public ResponseEntity<Object> exception(AdministratorIncorrectFormat exception){
        logger.error("AdministratorIncorrectFormat exception: "+String.join(", ",exception.getErrors()));
        return new ResponseEntity<>("Incorrect format: "+String.join("\n",exception.getErrors()), HttpStatus.NOT_ACCEPTABLE);
    }
}
