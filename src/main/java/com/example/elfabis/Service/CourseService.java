package com.example.elfabis.Service;

import com.example.elfabis.Entity.Course;
import com.example.elfabis.Entity.EquivalentCourse;
import com.example.elfabis.Entity.Plan;

import java.util.List;

public interface CourseService {
    List<Course> listAllCourses();

    Course getCourseById(Integer courseId);

    Course updateCourse(Course course);

    void deleteCourse(Integer courseId);

    Course createCourse(Course course);

    List<Course> getAllByPlan(Plan plan);

    List<Course> getAllCoursesByEquivalentCourse(EquivalentCourse equivalentCourse);
}
