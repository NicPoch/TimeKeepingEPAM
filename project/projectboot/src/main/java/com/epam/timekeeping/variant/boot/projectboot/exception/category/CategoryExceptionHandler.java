package com.epam.timekeeping.variant.boot.projectboot.exception.category;

import com.epam.timekeeping.variant.boot.projectboot.exception.category.CategoryIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.category.CategoryNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryExceptionHandler {
    @ExceptionHandler(value = CategoryNotFound.class)
    public ResponseEntity<Object> exception(CategoryNotFound exception){
        return new ResponseEntity<>("There is no category with such id: "+exception.getId(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = CategoryIncorrectFormat.class)
    public ResponseEntity<Object> exception(CategoryIncorrectFormat exception){
        return new ResponseEntity<>("Incorrect category format: "+String.join("\n",exception.getErrors()),HttpStatus.BAD_REQUEST);
    }
}
