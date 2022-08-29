package com.epam.timekeeping.variant.boot.projectboot.repository;

import com.epam.timekeeping.variant.boot.projectboot.domain.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends PagingAndSortingRepository<Client,Integer>{
        boolean existsByMailIgnoreCase(String mail);

        boolean existsByUsernameIgnoreCase(String username);

        List<Client> findAllByCompany(String company);
        Optional<Client> findByUsernameAndPassword(String username, String password);
}
