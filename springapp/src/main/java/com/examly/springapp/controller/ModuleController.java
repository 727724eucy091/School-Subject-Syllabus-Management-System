package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.service.ModuleService;
import com.examly.springapp.model.Module;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
    ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping
    public ResponseEntity<Module> createProduct(@RequestBody Module module){
        return ResponseEntity.status(201).body(moduleService.createModule(module));
    }

    @GetMapping
    public ResponseEntity<List<Module>> getAllModules(){
        return ResponseEntity.status(200).body(moduleService.getAllModules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id){
        return ResponseEntity.status(200).body(moduleService.getAllModules(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@RequestBody Module module,@PathVariable Long id){
        return ResponseEntity.status(200).body(module);
    }
    @DeleteMapping
    public void deleteModule(){
        moduleService.deleteModule();
    }

}
