package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;

public interface CourseServiceImpl {
     
    public Course createCourse(Course course);
    public List<Course> getAllCourses();
    public Optional<Course> getCourseById(Long id);
    public Course updateCourse(Long id,Course course);
    public List<Course> getCoursesByInstructor(Long instructorId);
    public void deleteCourse(Long id);
    public List<Course> findByLevel(String level);
} 
