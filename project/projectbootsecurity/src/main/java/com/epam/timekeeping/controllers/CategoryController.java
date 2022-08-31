package com.epam.timekeeping.controllers;

import com.epam.timekeeping.dto.category.CategoryDetail;
import com.epam.timekeeping.dto.category.CategoryDto;
import com.epam.timekeeping.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories(){
        logger.info("Get all categories");
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDetail> getCategories(@PathVariable int id){
        logger.info("Get category with id: "+id);
        return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDetail> postCategory(@RequestBody CategoryDto category){
        logger.info("Post category with body: "+category.toString());
        return new ResponseEntity<>(categoryService.createCategory(category),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDetail> updateCategory(@PathVariable int id,@RequestBody CategoryDto newCategory){
        logger.info("Put request with id "+id+" and body "+newCategory.toString());
        return new ResponseEntity<>(categoryService.updateCategory(newCategory,id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CategoryDetail> deleteCategory(@PathVariable int id){
        logger.info("Delete category with id: "+id);
        return new ResponseEntity<>(categoryService.deleteCategory(id),HttpStatus.OK);
    }
}
