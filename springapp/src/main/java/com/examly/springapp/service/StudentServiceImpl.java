package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.Student;

public interface StudentServiceImpl {
    public Student createStudent(Student student);
    public List<Student> getAllStudents();
    public Optional<Student> findStudentByID(Long id);
    public Optional<Student> findByEmail(String email);
    public Student updateStudent(Student student,Long id);

} 
