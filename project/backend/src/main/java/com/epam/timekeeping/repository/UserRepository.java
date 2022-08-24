package com.epam.timekeeping.repository;

import com.epam.timekeeping.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
