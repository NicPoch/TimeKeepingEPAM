package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.domain.Category;
import com.epam.timekeeping.variant.boot.projectboot.dto.category.CategoryDetail;
import com.epam.timekeeping.variant.boot.projectboot.dto.category.CategoryDto;
import com.epam.timekeeping.variant.boot.projectboot.service.CategoryService;
import com.epam.timekeeping.variant.boot.projectboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories(){
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDetail> getCategories(@PathVariable int id){
        return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoryDetail> postCategory(@RequestBody CategoryDto category){
        return new ResponseEntity<>(categoryService.createCategory(category),HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDetail> updateCategory(@PathVariable int id,@RequestBody CategoryDto newCategory){
        return new ResponseEntity<>(categoryService.updateCategory(newCategory,id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CategoryDetail> deleteCategory(@PathVariable int id){
        return new ResponseEntity<>(categoryService.deleteCategory(id),HttpStatus.OK);
    }
}
