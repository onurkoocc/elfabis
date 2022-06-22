package com.example.elfabis.Controller;

import com.example.elfabis.Entity.GivenCourse;
import com.example.elfabis.Repository.GivenCourseRepository;
import com.example.elfabis.Service.GivenCourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/givenCourses")
@AllArgsConstructor
public class GivenCourseController {
    @Autowired
    GivenCourseRepository givenCourseRepository;

    @Autowired
    GivenCourseService givenCourseService;

    @GetMapping
    public List<GivenCourse> listAllUsers() {
        return givenCourseService.listAllGivenCourses();
    }

    @PostMapping
    public ResponseEntity createGivenCourse(@RequestBody GivenCourse givenCourse) {
        if (givenCourse.getId() != null) {
            return ResponseEntity.ok("Creating given course is not possible because request has id");
        }
        return ResponseEntity.ok(givenCourseService.createGivenCourse(givenCourse));
    }

    @PutMapping
    public ResponseEntity updateGivenCourse(@RequestBody GivenCourse givenCourse) {
        if (givenCourse.getId() == null) {
            return ResponseEntity.ok("Updating given course is not possible because request doesn't have id");
        }
        if (givenCourseService.getGivenCourseById(givenCourse.getId()) == null) {
            return ResponseEntity.ok("Updating given course is not possible because there is no GivenCourse with given id");
        }
        return ResponseEntity.ok(givenCourseService.updateGivenCourse(givenCourse));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(givenCourseService.getGivenCourseById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        givenCourseService.deleteGivenCourse(id);
        return ResponseEntity.ok("ok");
    }
}
