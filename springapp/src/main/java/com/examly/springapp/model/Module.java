package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToOne;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    private String moduleName;
    private String description;

    //..

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
    //..


    public Module() {
    }


    public Module(Long moduleId, String moduleName, String description, Course course) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.description = description;
        this.course = course;
    }


    public Long getModuleId() {
        return moduleId;
    }


    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }


    public String getModuleName() {
        return moduleName;
    }


    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Course getCourse() {
        return course;
    }


    public void setCourse(Course course) {
        this.course = course;
    }

    

}