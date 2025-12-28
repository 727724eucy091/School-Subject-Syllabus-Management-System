package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Parent;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;
import com.examly.springapp.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    public final CourseService courseService;
    CourseRepo courseRepo;

    public CourseController(CourseService courseService,CourseRepo courseRepo) {
        this.courseService = courseService;
        this.courseRepo=courseRepo;
    }
    
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
            Course val=courseService.createCourse(course);
            return ResponseEntity.status(201).body(val);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        
            List<Course> val=courseService.getAllCourses();
            return ResponseEntity.status(200).body(val);
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id){
        Course newCourse = courseService.getCourseById(id).orElse(null);
        if(newCourse == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(newCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourseById(@PathVariable Long id,@RequestBody Course course){
        Course val=courseService.updateCourse(id, course);
        if(val==null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(val);
    }

    @GetMapping("instructor/{id}")
    public ResponseEntity<List<Course>> getCoursesByInstructor(@PathVariable Long id){
        List<Course> val=courseService.getCoursesByInstructor(id);
        return ResponseEntity.ok(val);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<?> findByLevel(@PathVariable String level){
        
        List<Course> val=courseService.findByLevel(level);
        if(val.isEmpty()){
            return ResponseEntity.status(204).body("No courses found at level: "+level);
        }
        return ResponseEntity.ok(val);
        
        
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){    }
}
