package com.example.elfabis.Repository;

import com.example.elfabis.Entity.GivenCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GivenCourseRepository extends JpaRepository<GivenCourse,Integer> {
}
