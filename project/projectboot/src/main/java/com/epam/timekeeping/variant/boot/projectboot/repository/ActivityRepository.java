package com.epam.timekeeping.variant.boot.projectboot.repository;

import com.epam.timekeeping.variant.boot.projectboot.domain.Activity;
import com.epam.timekeeping.variant.boot.projectboot.domain.Category;
import com.epam.timekeeping.variant.boot.projectboot.domain.Client;
import com.epam.timekeeping.variant.boot.projectboot.domain.State;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ActivityRepository extends PagingAndSortingRepository<Activity,Integer> {
    List<Activity> findByAssignee(Client assignee);
    List<Activity> findByCategory(Category category);
    List<Activity> findByState(State state);
}
