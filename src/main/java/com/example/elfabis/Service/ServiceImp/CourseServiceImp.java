package com.example.elfabis.Service.ServiceImp;

import com.example.elfabis.Entity.Course;
import com.example.elfabis.Entity.EquivalentCourse;
import com.example.elfabis.Entity.Plan;
import com.example.elfabis.Repository.CourseRepository;
import com.example.elfabis.Repository.EquivalentCourseRepository;
import com.example.elfabis.Repository.PlanRepository;
import com.example.elfabis.Service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class CourseServiceImp implements CourseService {
    CourseRepository courseRepository;
    PlanRepository planRepository;
    EquivalentCourseRepository equivalentCourseRepository;

    @Override
    public List<Course> listAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Integer courseId) {
        return courseRepository.getById(courseId);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Integer courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllByPlan(Plan plan) {
        List<Course> courses = courseRepository.findAll();
        List<Course> coursesByPlan = new ArrayList<>();
        for (Course c : courses) {
            if (c.getPlan() != null) {
                Plan plan1 = planRepository.getById(c.getPlan().getId());
                if (plan1.getId() == plan.getId()) {
                    coursesByPlan.add(c);
                }
            }
        }
        return coursesByPlan;
    }

    @Override
    public List<Course> getAllCoursesByEquivalentCourse(EquivalentCourse equivalentCourse) {
        List<Course> courses = courseRepository.findAll();
        List<Course> coursesByEquivalentCourse = new ArrayList<>();
        for (Course c : courses) {
            if (c.getEquivalentCourse() != null) {
                EquivalentCourse equivalentCourse1 = equivalentCourseRepository.getById(c.getEquivalentCourse().getId());
                if (equivalentCourse1.getId() == equivalentCourse.getId()) {
                    coursesByEquivalentCourse.add(c);
                }
            }
        }
        return coursesByEquivalentCourse;
    }
}
