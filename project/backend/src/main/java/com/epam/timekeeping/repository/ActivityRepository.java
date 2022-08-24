package com.epam.timekeeping.repository;

import com.epam.timekeeping.domain.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActivityRepository extends PagingAndSortingRepository<Activity,Integer> {
}
