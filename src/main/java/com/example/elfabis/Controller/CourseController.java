package com.example.elfabis.Controller;

import com.example.elfabis.Entity.Course;
import com.example.elfabis.Repository.CourseRepository;
import com.example.elfabis.Service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/courses")
@AllArgsConstructor
@EnableAutoConfiguration
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseService courseService;

    @GetMapping
    public List<Course> listAllUsers() {
        return courseService.listAllCourses();
    }

    @PostMapping
    public ResponseEntity createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    @PutMapping
    public ResponseEntity updateCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.updateCourse(course));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("ok");
    }
}
