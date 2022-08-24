package com.epam.timekeeping.repository;

import com.epam.timekeeping.domain.Administrator;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator,Integer> {
}
