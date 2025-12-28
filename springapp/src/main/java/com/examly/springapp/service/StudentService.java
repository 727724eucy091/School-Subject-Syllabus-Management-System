package com.examly.springapp.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;

@Service
public class StudentService implements StudentServiceImpl{
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    
    @Override
    public Student createStudent(Student student){
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> findStudentByID(Long id){
        return studentRepo.findById(id);
    }

    @Override
    public Optional<Student> findByEmail(String email){
        return studentRepo.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student,Long id){
        Optional<Student> std=studentRepo.findById(id);
        if(std.isPresent()){
            Student val = std.get();
            val.setAddress(student.getAddress());
            val.setEmail(student.getEmail());
            val.setPhoneNumber(student.getPhoneNumber());
            val.setStudentName(student.getStudentName());
            return studentRepo.save(val);   
        }
        return null;
    }
}
