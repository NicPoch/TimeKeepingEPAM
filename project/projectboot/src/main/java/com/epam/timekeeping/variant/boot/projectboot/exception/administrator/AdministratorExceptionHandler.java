package com.epam.timekeeping.variant.boot.projectboot.exception.administrator;

import com.epam.timekeeping.variant.boot.projectboot.exception.administrator.AdministratorIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.administrator.AdministratorNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdministratorExceptionHandler {
    @ExceptionHandler(value = AdministratorNotFound.class)
    public ResponseEntity<Object> exception(AdministratorNotFound exception){
        return new ResponseEntity<>("Incorrect id: "+exception.getId(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = AdministratorLoginIncorrect.class)
    public ResponseEntity<Object> exception(AdministratorLoginIncorrect exception){
        return new ResponseEntity<>("Incorrect login", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = AdministratorIncorrectFormat.class)
    public ResponseEntity<Object> exception(AdministratorIncorrectFormat exception){
        return new ResponseEntity<>("Incorrect format: "+String.join("\n",exception.getErrors()), HttpStatus.NOT_ACCEPTABLE);
    }
}
