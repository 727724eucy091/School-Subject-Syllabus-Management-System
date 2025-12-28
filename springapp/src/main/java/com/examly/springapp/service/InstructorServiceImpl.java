package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.examly.springapp.model.Instructor;

public interface InstructorServiceImpl {

     public Instructor createInstructor(Instructor instructor);
     public List<Instructor> getAllInstructor();
     public Instructor getInstructorById(Long id);
     public Instructor updateInstructor(Long id,Instructor instructor);
     public Page<Instructor> getWithPagination(int page,int size);
     public List<Instructor> getInstructorBySpecialization(String specialization);
} 
