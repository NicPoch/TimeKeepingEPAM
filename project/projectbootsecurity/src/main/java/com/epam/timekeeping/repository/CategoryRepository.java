package com.epam.timekeeping.repository;

import com.epam.timekeeping.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Integer> {
}
