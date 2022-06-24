package com.example.elfabis.Controller;

import com.example.elfabis.Entity.Academician;
import com.example.elfabis.Payload.Request.UserInfoRequest;
import com.example.elfabis.Repository.AcademicianRepository;
import com.example.elfabis.Service.AcademicianService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/academicians")
@AllArgsConstructor
@EnableAutoConfiguration
public class AcademicianController {
    @Autowired
    AcademicianService academicianService;

    @Autowired
    AcademicianRepository academicianRepository;

    @GetMapping
    public List<Academician> listAllUsers() {
        return academicianService.listAllAcademicians();
    }

    @GetMapping("/commissioners")
    public List<Academician> listAllCommissioner() {
        return academicianService.listAllCommissioners();
    }

    @PostMapping("/addacademician")
    public ResponseEntity createAcademician(@RequestBody UserInfoRequest academician) {
        return ResponseEntity.ok(academicianService.createAcademician(academician));
    }

    @PutMapping("/updateacademician")
    public ResponseEntity updateAcademician(@RequestBody UserInfoRequest academician) {
        return ResponseEntity.ok(academicianService.updateAcademician(academician));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(academicianService.getAcademicianById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        academicianService.deleteAcademician(id);
        return ResponseEntity.ok("ok");
    }
}
