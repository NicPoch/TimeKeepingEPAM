package com.epam.timekeeping.repository;

import com.epam.timekeeping.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Integer> {
}
