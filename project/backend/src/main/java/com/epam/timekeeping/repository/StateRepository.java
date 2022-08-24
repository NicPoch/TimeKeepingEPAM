package com.epam.timekeeping.repository;

import com.epam.timekeeping.domain.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State,Integer> {
}
