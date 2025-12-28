package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
// import org.hibernate.query.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.InstructorService;

@RestController
@RequestMapping(("api/instructors"))
public class InstructorController {
    InstructorService instructorService;
    public InstructorController(InstructorService instructorService){
        this.instructorService=instructorService;
    }
    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor){
        
            Instructor val=instructorService.createInstructor(instructor);
            return ResponseEntity.status(201).body(val);
        
    }

    @GetMapping
    public ResponseEntity<List<Instructor>>getAllInstructor(){
        
            List<Instructor> val=instructorService.getAllInstructor();
            if(val.isEmpty()){return ResponseEntity.noContent().build();}
            return ResponseEntity.status(200).body(val);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id){
        
            Instructor val=instructorService.getInstructorById(id);
            return  ResponseEntity.status(200).body(val) ;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id,@RequestBody Instructor instructor){

        Instructor val=instructorService.updateInstructor(id,instructor);
        return ResponseEntity.ok(val);
    }
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<Instructor>> getWithPagination(@PathVariable int page,@PathVariable int size){
        return ResponseEntity.ok(instructorService.getWithPagination(page, size));
    }

    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<?> getInstructorBySpecialization(@PathVariable String specialization){
        List<Instructor> val=instructorService.getInstructorBySpecialization(specialization);
        if(val.isEmpty()){
            return ResponseEntity.status(404).body("No instructors found with specialization: "+specialization);
        }
        return ResponseEntity.ok(val);
    }

    @DeleteMapping("")
    public void pc5(){}
}
