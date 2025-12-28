package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.Enrollment;

public interface EnrollmentServiceImpl {

    public Enrollment createEnrollment(Enrollment enrollment);
    public List<Enrollment> getAllEnrollment();
    public Optional<Enrollment>  getEnrollmentById(Long id);
    public Enrollment updateEnrollment(Enrollment enrollment,Long id);
    public void deleteEnrollment(Long id);


} 
