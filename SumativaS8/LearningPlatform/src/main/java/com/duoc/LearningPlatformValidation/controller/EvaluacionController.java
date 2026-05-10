package com.duoc.LearningPlatformValidation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duoc.LearningPlatformValidation.dto.EvaluacionDTO;
import com.duoc.LearningPlatformValidation.dto.EvaluacionCreateDTO;
import com.duoc.LearningPlatformValidation.model.Curso;
import com.duoc.LearningPlatformValidation.model.Evaluacion;
import com.duoc.LearningPlatformValidation.services.CursoService;
import com.duoc.LearningPlatformValidation.services.EvaluacionService;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<EvaluacionDTO> getAll() {
        return evaluacionService.getAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/curso/{cursoId}")
    public List<EvaluacionDTO> getByCurso(@PathVariable Long cursoId) {
        return evaluacionService.getByCurso(cursoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<EvaluacionDTO> create(@RequestBody EvaluacionCreateDTO dto) {

        Curso curso = cursoService.getById(dto.getCursoId());

        if (curso == null) {
            return ResponseEntity.badRequest().build();
        }

        Evaluacion evaluacion = new Evaluacion(
                null,
                curso,
                dto.getNombre(),
                dto.getPuntajeMaximo(),
                dto.getFechaAplicacion()
        );

        return ResponseEntity.ok(toDTO(evaluacionService.save(evaluacion)));
    }

    private EvaluacionDTO toDTO(Evaluacion e) {
        return new EvaluacionDTO(
                e.getId(),
                e.getCurso().getId(),
                e.getCurso().getNombre(),
                e.getNombre(),
                e.getPuntajeMaximo(),
                e.getFechaAplicacion()
        );
    }
}