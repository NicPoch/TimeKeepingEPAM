package com.epam.timekeeping.variant.boot.projectboot.repository;

import com.epam.timekeeping.variant.boot.projectboot.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
}
