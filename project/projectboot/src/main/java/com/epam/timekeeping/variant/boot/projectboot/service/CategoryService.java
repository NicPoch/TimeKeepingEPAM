package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.Category;
import com.epam.timekeeping.variant.boot.projectboot.domain.Category;
import com.epam.timekeeping.variant.boot.projectboot.dto.category.CategoryDetail;
import com.epam.timekeeping.variant.boot.projectboot.dto.category.CategoryDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.category.CategoryDetail;
import com.epam.timekeeping.variant.boot.projectboot.dto.category.CategoryDto;
import com.epam.timekeeping.variant.boot.projectboot.exception.category.CategoryNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.category.CategoryIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.category.CategoryNotFound;
import com.epam.timekeeping.variant.boot.projectboot.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    Logger logger = LoggerFactory.getLogger(CategoryService.class);
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper mapper;

    public CategoryDetail getCategoryById(Integer id)throws CategoryNotFound
    {
        return  mapper.map(categoryRepository.findById(id).orElseThrow(()->new CategoryNotFound(id)),CategoryDetail.class);
    }

    public List<CategoryDto> getCategories(){
        List<CategoryDto> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(c-> categories.add(mapper.map(c,CategoryDto.class)));
        return categories;
    }

    public CategoryDetail createCategory(CategoryDto dto)throws CategoryIncorrectFormat {
        List<String> errors = new ArrayList<>();
        if(dto.getName()==null || dto.getName().trim().length()==0) errors.add("Empty name");

        if(errors.size()>0) throw new CategoryIncorrectFormat(errors);
        return mapper.map(categoryRepository.save(mapper.map(dto, Category.class)),CategoryDetail.class);
    }

    public CategoryDetail updateCategory(CategoryDto dto,Integer id)throws CategoryNotFound {
        Category category = categoryRepository.findById(id).orElseThrow(()->new CategoryNotFound(id));
        category.setName((dto.getName()==null)?category.getName():dto.getName());
        category.setDescription((dto.getDescription()==null)?category.getDescription():dto.getDescription());

        return mapper.map(categoryRepository.save(category),CategoryDetail.class);
    }

    public CategoryDetail deleteCategory(Integer id)throws CategoryNotFound{
        Category category = categoryRepository.findById(id).orElseThrow(()->new CategoryNotFound(id));
        categoryRepository.deleteById(id);
        return mapper.map(category,CategoryDetail.class);
    }
}
