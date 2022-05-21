package com.example.elfabis.Controller;

import com.example.elfabis.Entity.Academician;
import com.example.elfabis.Service.AcademicianService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/academician")
@AllArgsConstructor
public class AcademicianController {
    @Autowired
    AcademicianService academicianService;

    @GetMapping("/users")
    public List<Academician> listAllUsers() { return academicianService.listAllAcademician(); }
}
