package com.epam.spring.framework.variant.timekeeping.service;

import com.epam.spring.framework.variant.timekeeping.domain.Category;
import com.epam.spring.framework.variant.timekeeping.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category getCategoryById(Integer id)
    {
        return  categoryRepository.findOne(id);
    }

    public List<Category> getCategories(){
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    public void saveOrUpdateCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Integer id){
        categoryRepository.delete(id);
    }
}
