package com.epam.timekeeping.variant.boot.projectboot.exception.timecard;

import com.epam.timekeeping.variant.boot.projectboot.exception.timecard.TimecardIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.timecard.TimecardNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TimecardExceptionHandler {
    Logger logger = LoggerFactory.getLogger(TimecardExceptionHandler.class);
    @ExceptionHandler(value = TimecardNotFound.class)
    public ResponseEntity<Object> exception(TimecardNotFound exception){
        logger.error("TimeCardNotFound exception: "+exception.getId());
        return new ResponseEntity<>("Incorrect id: "+exception.getId(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = TimecardIncorrectFormat.class)
    public ResponseEntity<Object> exception(TimecardIncorrectFormat exception){
        logger.error("TimecardIncorrectFormat exception: "+String.join(", ",exception.getErrors()));
        return new ResponseEntity<>("Incorrect format: "+String.join("\n",exception.getErrors()), HttpStatus.NOT_ACCEPTABLE);
    }
}
