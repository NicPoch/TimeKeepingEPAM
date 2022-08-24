package com.epam.timekeeping.repository;

import com.epam.timekeeping.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
