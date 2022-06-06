package com.example.elfabis.Controller;

import com.example.elfabis.Entity.Plan;
import com.example.elfabis.Service.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/plans")
@AllArgsConstructor
public class PlanController {
    @Autowired
    PlanService planService;

    @GetMapping
    public List<Plan> listAllUsers() {
        return planService.listAllPlans();
    }

    @PostMapping
    public ResponseEntity createCourse(@RequestBody Plan plan) {
        return ResponseEntity.ok(planService.createPlan(plan));
    }

    @PutMapping
    public ResponseEntity updateCourse(@RequestBody Plan plan) {
        return ResponseEntity.ok(planService.updatePlan(plan));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(planService.getPlanById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        planService.deletePlan(id);
        return ResponseEntity.ok("ok");
    }
}
