package com.epam.timekeeping.controller;

import com.epam.timekeeping.domain.Category;
import com.epam.timekeeping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategory(){
        return categoryService.getCategories();
    }

    @GetMapping(value = "/{id}")
    public Category getCategory(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category postCategories(@RequestBody Category category){
        categoryService.saveOrUpdateCategory(category);
        return category;
    }

    @PutMapping(value = "/{id}")
    public Category updateCategory(@PathVariable int id,@RequestBody Category newCategory){
        Category category = this.categoryService.getCategoryById(id);
        if(category!=null) categoryService.saveOrUpdateCategory(newCategory);
        return newCategory;
    }

    @DeleteMapping(value = "/{id}")
    public Category deleteCategory(@PathVariable int id){
        Category category = categoryService.getCategoryById(id);
        if(category!=null) categoryService.deleteCategory(id);
        return category;
    }
}
