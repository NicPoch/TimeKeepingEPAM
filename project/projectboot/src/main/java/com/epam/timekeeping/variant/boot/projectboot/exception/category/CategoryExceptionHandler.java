package com.epam.timekeeping.variant.boot.projectboot.exception.category;

import com.epam.timekeeping.variant.boot.projectboot.exception.category.CategoryIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.category.CategoryNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryExceptionHandler {
    Logger logger = LoggerFactory.getLogger(CategoryExceptionHandler.class);
    @ExceptionHandler(value = CategoryNotFound.class)
    public ResponseEntity<Object> exception(CategoryNotFound exception){
        logger.error("CategoryNotFound exception: "+exception.getId());
        return new ResponseEntity<>("There is no category with such id: "+exception.getId(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = CategoryIncorrectFormat.class)
    public ResponseEntity<Object> exception(CategoryIncorrectFormat exception){
        logger.error("CategoryIncorrectFormat exception: "+String.join(", ",exception.getErrors()));
        return new ResponseEntity<>("Incorrect category format: "+String.join("\n",exception.getErrors()),HttpStatus.BAD_REQUEST);
    }
}
