package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Student;
import com.examly.springapp.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final StudentService studentService;
    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student val=studentService.createStudent(student);
        return ResponseEntity.status(201).body(val);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> val=studentService.getAllStudents();
        return ResponseEntity.status(200).body(val);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getAllStudentById(@PathVariable Long id){
        Optional<Student> val=studentService.findStudentByID(id);
        return ResponseEntity.status(200).body(val);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable Long id){
        Student val=studentService.updateStudent(student, id);
        if(val==null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(val);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Student>> findByEmail(@PathVariable String email){
        Optional<Student> val= studentService.findByEmail(email);
        return ResponseEntity.ok(val);
    }
}
