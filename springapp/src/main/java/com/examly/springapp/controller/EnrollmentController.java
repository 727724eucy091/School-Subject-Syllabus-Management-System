package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

import com.examly.springapp.model.Enrollment;
import com.examly.springapp.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    public final EnrollmentService enrollmentService;
    public EnrollmentController(EnrollmentService enrollmentService){
        this.enrollmentService=enrollmentService;
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment){
        return ResponseEntity.status(201).body(enrollmentService.createEnrollment(enrollment));
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollment(){
        return ResponseEntity.status(200).body(enrollmentService.getAllEnrollment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Enrollment>> getEnrollmentById(@PathVariable Long id){
        return ResponseEntity.status(200).body(enrollmentService.getEnrollmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@RequestBody Enrollment enrollment,@PathVariable Long id){
        return ResponseEntity.status(200).body(enrollmentService.updateEnrollment(enrollment, id));
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id){
        enrollmentService.deleteEnrollment(id);
    }
    
}
