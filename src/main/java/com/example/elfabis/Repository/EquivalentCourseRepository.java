package com.example.elfabis.Repository;

import com.example.elfabis.Entity.EquivalentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquivalentCourseRepository extends JpaRepository<EquivalentCourse, Integer> {
}
