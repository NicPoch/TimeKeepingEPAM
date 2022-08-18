package com.epam.timekeeping.repository;

import com.epam.timekeeping.domain.ToDo;
import org.springframework.data.repository.CrudRepository;
public interface ToDoRepository extends CrudRepository<ToDo,String> {

}
