package com.example.elfabis.Controller;

import com.example.elfabis.Entity.Course;
import com.example.elfabis.Entity.FormTracking;
import com.example.elfabis.Entity.GivenCourse;
import com.example.elfabis.Repository.CourseRepository;
import com.example.elfabis.Repository.FormTrackingRepository;
import com.example.elfabis.Repository.GivenCourseRepository;
import com.example.elfabis.Service.CourseService;
import com.example.elfabis.Service.FormTrackingService;
import com.example.elfabis.Service.GivenCourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/givencourses")
@AllArgsConstructor
public class GivenCourseController {
    @Autowired
    GivenCourseRepository givenCourseRepository;

    @Autowired
    GivenCourseService givenCourseService;

    @GetMapping
    public List<GivenCourse> listAllUsers() { return givenCourseService.listAllGivenCourses(); }

    @PostMapping("/addgivenCourse")
    public ResponseEntity createGivenCourse(@RequestBody GivenCourse givenCourse){
        return ResponseEntity.ok(givenCourseService.createGivenCourse(givenCourse));
    }

    @PutMapping("/updategivenCourse")
    public ResponseEntity updateGivenCourse(@RequestBody GivenCourse givenCourse){
        return ResponseEntity.ok(givenCourseService.updateGivenCourse(givenCourse));
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(givenCourseService.getGivenCourseById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id){
        givenCourseService.deleteGivenCourse(id);
        return ResponseEntity.ok("ok");
    }
}
