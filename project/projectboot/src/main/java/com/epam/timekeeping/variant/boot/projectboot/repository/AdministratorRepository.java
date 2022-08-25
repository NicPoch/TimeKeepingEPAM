package com.epam.timekeeping.variant.boot.projectboot.repository;

import com.epam.timekeeping.variant.boot.projectboot.domain.Administrator;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdministratorRepository extends PagingAndSortingRepository<Administrator,Integer> {
}
