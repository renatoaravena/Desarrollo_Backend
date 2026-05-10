package com.duoc.LearningPlatformValidation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.Inscripcion;
import com.duoc.LearningPlatformValidation.repository.InscripcionRepository;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository repository;

    public List<Inscripcion> getAll() {
        return repository.findAll();
    }

    public List<Inscripcion> getByCurso(Long cursoId) {
        return repository.findByCursoId(cursoId);
    }

    public Inscripcion save(Inscripcion inscripcion) {
        return repository.save(inscripcion);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Inscripcion getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
