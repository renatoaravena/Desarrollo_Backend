package com.duoc.LearningPlatformValidation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.Evaluacion;
import com.duoc.LearningPlatformValidation.repository.EvaluacionRepository;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository repository;

    public List<Evaluacion> getAll() {
        return repository.findAll();
    }

    public List<Evaluacion> getByCurso(Long cursoId) {
        return repository.findByCursoId(cursoId);
    }

    public Evaluacion save(Evaluacion evaluacion) {
        return repository.save(evaluacion);
    }
}
