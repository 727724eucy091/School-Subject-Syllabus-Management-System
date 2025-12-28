package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springapp.repository.ModuleRepo;
import com.examly.springapp.model.Module;

@Service
public class ModuleService {
    private final ModuleRepo moduleRepo;

    public ModuleService(ModuleRepo moduleRepo) {
        this.moduleRepo = moduleRepo;
    }
    
    public Module createModule(Module module){
        return moduleRepo.save(module);   
    }

    public List<Module> getAllModules(){
        return moduleRepo.findAll();
    }

    public Module getAllModules(Long id){
        return moduleRepo.findById(id).orElse(null);
    }

    public Module updateModule(Module module,Long id){
        Module val=moduleRepo.findById(id).orElseThrow(null);
        val.setDescription(module.getDescription());
        val.setModuleId(module.getModuleId());
        val.setModuleName(module.getModuleName());
        return moduleRepo.save(val);
    }
    public void deleteModule(){
        moduleRepo.deleteAll();
    }
}