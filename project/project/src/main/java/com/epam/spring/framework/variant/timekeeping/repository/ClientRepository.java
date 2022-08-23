package com.epam.spring.framework.variant.timekeeping.repository;

import com.epam.spring.framework.variant.timekeeping.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Integer> {
}
