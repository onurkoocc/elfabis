package com.example.elfabis.Repository;

import com.example.elfabis.Entity.Course;
import com.example.elfabis.Entity.EquivalentCourse;
import com.example.elfabis.Entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
