package com.example.elfabis.Controller;

import com.example.elfabis.Entity.EquivalentCourse;
import com.example.elfabis.Service.EquivalentCourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/equivalentCourses")
@AllArgsConstructor
public class EquivalentCourseController {
    @Autowired
    EquivalentCourseService equivalentCourseService;

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
}
