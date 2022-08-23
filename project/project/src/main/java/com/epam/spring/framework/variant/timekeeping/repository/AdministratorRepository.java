package com.epam.spring.framework.variant.timekeeping.repository;

import com.epam.spring.framework.variant.timekeeping.domain.Administrator;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator,Integer> {
}
