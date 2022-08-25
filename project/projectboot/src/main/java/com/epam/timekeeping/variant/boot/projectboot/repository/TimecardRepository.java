package com.epam.timekeeping.variant.boot.projectboot.repository;

import com.epam.timekeeping.variant.boot.projectboot.domain.Timecard;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TimecardRepository extends PagingAndSortingRepository<Timecard, Integer> {
}