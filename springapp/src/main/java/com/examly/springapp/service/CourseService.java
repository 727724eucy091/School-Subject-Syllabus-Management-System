package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;

@Service
public class CourseService implements CourseServiceImpl {
    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        
        this.courseRepo = courseRepo;
    }
    
    @Override
    public Course createCourse(Course course){
        
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id){
       return courseRepo.findById(id);
    }

    @Override
    public Course updateCourse(Long id,Course course){
        
        Optional<Course> val=courseRepo.findById(id);
        if(val.isPresent()){
            Course old=val.get();
            old.setCourseName(course.getCourseName());
            old.setDescription(course.getDescription());
            old.setDuration(course.getDuration());
            old.setPrice(course.getPrice());
            old.setLevel(course.getLevel());
            return courseRepo.save(old);
        }
        return null;
    }

    @Override
    public List<Course> getCoursesByInstructor(Long instructorId){
        return courseRepo.findByInstructorInstructorId(instructorId);
    }

    @Override
    public void deleteCourse(Long id){
        courseRepo.deleteById(id);
    }

    @Override
    public List<Course> findByLevel(String level){
        return courseRepo.findByLevel(level);
    }
}
