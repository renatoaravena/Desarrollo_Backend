package com.duoc.LearningPlatformValidation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.Curso;
import com.duoc.LearningPlatformValidation.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public List<Curso> getAll() {
        return repository.findAll();
    }

    public Curso getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Curso save(Curso curso) {
        return repository.save(curso);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}