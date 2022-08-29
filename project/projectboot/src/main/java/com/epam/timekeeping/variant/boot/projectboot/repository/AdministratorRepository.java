package com.epam.timekeeping.variant.boot.projectboot.repository;

import com.epam.timekeeping.variant.boot.projectboot.domain.Administrator;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface AdministratorRepository extends PagingAndSortingRepository<Administrator,Integer> {
    boolean existsByMailIgnoreCase(String mail);

    boolean existsByUsernameIgnoreCase(String username);

    List<Administrator> findByRole(String role);

    Optional<Administrator> findByUsernameAndPassword(String username, String password);
}
