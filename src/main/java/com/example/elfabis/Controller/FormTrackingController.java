package com.example.elfabis.Controller;

import com.example.elfabis.Entity.FormTracking;
import com.example.elfabis.Repository.FormTrackingRepository;
import com.example.elfabis.Service.FormTrackingService;
import com.example.elfabis.Service.FormTrackingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/formtrackings")
@AllArgsConstructor
public class FormTrackingController {
    @Autowired
    FormTrackingRepository formTrackingRepository;

    @Autowired
    FormTrackingService formTrackingService;

    @GetMapping
    public List<FormTracking> listAllUsers() { return formTrackingService.listAllFormTrackings(); }

    @PostMapping
    public ResponseEntity createFormTracking(@RequestBody FormTracking formTracking){
        return ResponseEntity.ok(formTrackingService.createFormTracking(formTracking));
    }

    @PutMapping
    public ResponseEntity updateFormTracking(@RequestBody FormTracking formTracking){
        return ResponseEntity.ok(formTrackingService.updateFormTracking(formTracking));
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(formTrackingService.getFormTrackingById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id){
        formTrackingService.deleteFormTracking(id);
        return ResponseEntity.ok("ok");
    }
}
