package com.epam.timekeeping.variant.boot.projectboot.repository;

import com.epam.timekeeping.variant.boot.projectboot.domain.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActivityRepository extends PagingAndSortingRepository<Activity,Integer> {
}
