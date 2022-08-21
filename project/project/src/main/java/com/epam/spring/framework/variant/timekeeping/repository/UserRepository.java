package com.epam.spring.framework.variant.timekeeping.repository;

import com.epam.spring.framework.variant.timekeeping.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
