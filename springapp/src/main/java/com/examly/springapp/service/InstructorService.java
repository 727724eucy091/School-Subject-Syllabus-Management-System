package com.examly.springapp.service;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;

@Service
public class InstructorService implements InstructorServiceImpl {
    InstructorRepo instructorRepo;

    public InstructorService(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @Override
    public Instructor createInstructor(Instructor instructor){
        
        Instructor val=instructorRepo.save(instructor);
        return val;
    }
    
    @Override
    public List<Instructor> getAllInstructor(){
        List<Instructor> val=instructorRepo.findAll();
        return val;
    }
    
    @Override
    public Instructor getInstructorById(Long id){
        return instructorRepo.findById(id).orElseThrow(()-> new RuntimeException());
        
    }

    @Override
    public Instructor updateInstructor(Long id,Instructor instructor){
        
        Instructor val=instructorRepo.findById(id).orElseThrow(RuntimeException::new);
        val.setEmail(instructor.getEmail());
        val.setInstructorName(instructor.getInstructorName());
        val.setPhoneNumber(instructor.getPhoneNumber());
        val.setSpecialization(instructor.getSpecialization());
        return instructorRepo.save(val);
       
    }
    @Override
    public Page<Instructor> getWithPagination(int page,int size){
        Pageable pageable=PageRequest.of(page,size);
        return instructorRepo.findAll(pageable);
    }

    @Override
    public List<Instructor> getInstructorBySpecialization(String specialization){
        return instructorRepo.findBySpecializationIgnoreCase(specialization);
    }


}
