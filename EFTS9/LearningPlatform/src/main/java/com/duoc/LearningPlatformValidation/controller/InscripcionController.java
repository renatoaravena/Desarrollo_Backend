package com.duoc.LearningPlatformValidation.controller;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duoc.LearningPlatformValidation.dto.InscripcionDTO;
import com.duoc.LearningPlatformValidation.dto.InscripcionCreateDTO;
import com.duoc.LearningPlatformValidation.model.Curso;
import com.duoc.LearningPlatformValidation.model.Inscripcion;
import com.duoc.LearningPlatformValidation.model.Usuario;
import com.duoc.LearningPlatformValidation.services.CursoService;
import com.duoc.LearningPlatformValidation.services.InscripcionService;
import com.duoc.LearningPlatformValidation.services.UsuarioService;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/curso/{cursoId}")
    public List<InscripcionDTO> getByCurso(@PathVariable Long cursoId) {
        return inscripcionService.getByCurso(cursoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<InscripcionDTO> create(@RequestBody InscripcionCreateDTO dto) {

        Curso curso = cursoService.getById(dto.getCursoId());
        Usuario estudiante = usuarioService.getById(dto.getEstudianteId());

        if (curso == null || estudiante == null) {
            return ResponseEntity.badRequest().build();
        }

        Inscripcion inscripcion = new Inscripcion(
                null,
                curso,
                estudiante,
                new Date()
        );

        return ResponseEntity.ok(toDTO(inscripcionService.save(inscripcion)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        inscripcionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<InscripcionDTO> getAll() {
        return inscripcionService.getAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionDTO> update(@PathVariable Long id, @RequestBody InscripcionCreateDTO dto) {
        Inscripcion inscripcion = inscripcionService.getById(id);
        if (inscripcion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Curso curso = cursoService.getById(dto.getCursoId());
        Usuario estudiante = usuarioService.getById(dto.getEstudianteId());

        if (curso == null || estudiante == null) {
            return ResponseEntity.badRequest().build();
        }

        inscripcion.setCurso(curso);
        inscripcion.setEstudiante(estudiante);

        return ResponseEntity.ok(toDTO(inscripcionService.save(inscripcion)));
    }

    private InscripcionDTO toDTO(Inscripcion i) {
        return new InscripcionDTO(
                i.getId(),
                i.getCurso().getId(),
                i.getCurso().getNombre(),
                i.getEstudiante().getId(),
                i.getEstudiante().getNombre(),
                i.getFechaInscripcion()
        );
    }
}