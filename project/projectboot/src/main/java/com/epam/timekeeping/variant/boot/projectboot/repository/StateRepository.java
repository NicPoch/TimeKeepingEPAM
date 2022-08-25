package com.epam.timekeeping.variant.boot.projectboot.repository;

import com.epam.timekeeping.variant.boot.projectboot.domain.State;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StateRepository extends PagingAndSortingRepository<State,Integer> {
}
