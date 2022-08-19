package com.epam.spring.framework.variant.timekeeping.repository;

import com.epam.spring.framework.variant.timekeeping.domain.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State,Long> {
}
