package com.example.elfabis.Controller;

import com.example.elfabis.Entity.Role;
import com.example.elfabis.Repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public List<Role> listAll() {
        return roleRepository.findAll();
    }

}
