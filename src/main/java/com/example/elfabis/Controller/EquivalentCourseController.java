package com.example.elfabis.Controller;

import com.example.elfabis.Entity.EquivalentCourse;
import com.example.elfabis.Service.CourseService;
import com.example.elfabis.Service.EquivalentCourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/equivalentCourses")
@AllArgsConstructor
@EnableAutoConfiguration
public class EquivalentCourseController {
    @Autowired
    EquivalentCourseService equivalentCourseService;

    @Autowired
    CourseService courseService;

    @GetMapping
    public List<EquivalentCourse> listAllUsers() {
        return equivalentCourseService.listAllEquivalentCourses();
    }

    @PostMapping
    public ResponseEntity createCourse(@RequestBody EquivalentCourse equivalentCourse) {
        return ResponseEntity.ok(equivalentCourseService.createEquivalentCourse(equivalentCourse));
    }

    @PutMapping
    public ResponseEntity updateCourse(@RequestBody EquivalentCourse equivalentCourse) {
        return ResponseEntity.ok(equivalentCourseService.updateEquivalentCourse(equivalentCourse));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(equivalentCourseService.getEquivalentCourseById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        equivalentCourseService.deleteEquivalentCourse(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{id}/getallcoursesbyequivalentcourse")
    public ResponseEntity getAllCoursesByEquivalentCourse(@PathVariable("id") Integer id) {
        EquivalentCourse equivalentCourse = equivalentCourseService.getEquivalentCourseById(id);
        if (equivalentCourse == null) {
            return ResponseEntity.badRequest().body("There is not any equivalent course for this id");
        }
        return ResponseEntity.ok(courseService.getAllCoursesByEquivalentCourse(equivalentCourse));
    }
}
