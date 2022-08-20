package com.epam.variant.timekeeping.demo.repository;

import com.epam.variant.timekeeping.demo.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends CrudRepository<State,Long> {
    List<State> findByName(String name);
}
