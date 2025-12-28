package com.examly.springapp.service;

import java.util.List;

public interface ModuleServiceImpl {
    public Module createModule(com.examly.springapp.model.Module module);
    public List<Module> getAllModules();
    public Module getAllModules(Long id);
    public Module updateModule(com.examly.springapp.model.Module module,Long id);
    public void deleteModule();
}
