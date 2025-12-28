package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Enrollment;
import com.examly.springapp.repository.EnrollmentRepo;

@Service
public class EnrollmentService implements EnrollmentServiceImpl {
    
    private final EnrollmentRepo enrollmentRepo;

    public EnrollmentService(EnrollmentRepo enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }    
    
    public Enrollment createEnrollment(Enrollment enrollment){
        return enrollmentRepo.save(enrollment);
    }

    public List<Enrollment> getAllEnrollment(){
        return enrollmentRepo.findAll();
    }

    public Optional<Enrollment>  getEnrollmentById(Long id){
        Optional<Enrollment> val=enrollmentRepo.findById(id);
        return val;
    }

    public Enrollment updateEnrollment(Enrollment enrollment,Long id){
        Enrollment val=enrollmentRepo.findById(id).orElse(null);
        val.setEnrollmentDate(enrollment.getEnrollmentDate());
        val.setEnrollmentId(enrollment.getEnrollmentId());
        return val;
    }

    public void deleteEnrollment(Long id){
        enrollmentRepo.deleteById(id);
    }
}
