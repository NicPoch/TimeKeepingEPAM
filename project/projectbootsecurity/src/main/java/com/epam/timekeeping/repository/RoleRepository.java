package com.epam.timekeeping.repository;


import com.epam.timekeeping.models.ERole;
import com.epam.timekeeping.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);

}
