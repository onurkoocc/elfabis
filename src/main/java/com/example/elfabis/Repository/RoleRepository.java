package com.example.elfabis.Repository;

import com.example.elfabis.Entity.ERole;
import com.example.elfabis.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Override
    Optional<Role> findById(Integer integer);

    Optional<Role> findByName(ERole eRole);
}
