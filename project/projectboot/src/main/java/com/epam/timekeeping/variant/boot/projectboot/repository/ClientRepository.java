package com.epam.timekeeping.variant.boot.projectboot.repository;

import com.epam.timekeeping.variant.boot.projectboot.domain.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client,Integer> {
}
