package com.example.elfabis.Service.ServiceImp;

import com.example.elfabis.Entity.Course;
import com.example.elfabis.Repository.CourseRepository;
import com.example.elfabis.Service.CourseService;

import java.util.List;

public class CourseServiceImp implements CourseService {
    CourseRepository courseRepository;

    @Override
    public List<Course> listAllCourses(){
        return courseRepository.findAll();
    }
    @Override
    public Course getCourseById(Integer courseId){
        return courseRepository.getById(courseId);
    }
    @Override
    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }
    @Override
    public void deleteCourse(Integer courseId){
        courseRepository.deleteById(courseId);
    }
    @Override
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }
}
