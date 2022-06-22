package com.example.elfabis.Repository;

import com.example.elfabis.Entity.Academician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcademicianRepository extends JpaRepository<Academician, Integer> {
    Optional<Academician> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}

