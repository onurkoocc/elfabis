package com.example.elfabis.Repository;

import com.example.elfabis.Entity.ERole;
import com.example.elfabis.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Override
    Optional<Role> findById(Integer integer);

    Optional<Role> findByName(ERole eRole);
}
