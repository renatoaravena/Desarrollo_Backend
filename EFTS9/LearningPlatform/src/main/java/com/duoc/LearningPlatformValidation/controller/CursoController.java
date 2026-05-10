package com.duoc.LearningPlatformValidation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duoc.LearningPlatformValidation.dto.CursoDTO;
import com.duoc.LearningPlatformValidation.dto.CursoCreateDTO;
import com.duoc.LearningPlatformValidation.model.Curso;
import com.duoc.LearningPlatformValidation.model.Usuario;
import com.duoc.LearningPlatformValidation.services.CursoService;
import com.duoc.LearningPlatformValidation.services.UsuarioService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<CursoDTO> getAll() {
        return cursoService.getAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> getById(@PathVariable Long id) {
        Curso curso = cursoService.getById(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDTO(curso));
    }

    @PostMapping
    public ResponseEntity<CursoDTO> create(@RequestBody CursoCreateDTO dto) {

        Usuario profesor = usuarioService.getById(dto.getProfesorId());
        if (profesor == null) {
            return ResponseEntity.badRequest().build();
        }

        Curso curso = new Curso(
                null,
                dto.getNombre(),
                dto.getDescripcion(),
                profesor
        );

        return ResponseEntity.ok(toDTO(cursoService.save(curso)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@PathVariable Long id, @RequestBody CursoCreateDTO dto) {

        Curso curso = cursoService.getById(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }

        Usuario profesor = usuarioService.getById(dto.getProfesorId());
        if (profesor == null) {
            return ResponseEntity.badRequest().build();
        }

        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setProfesor(profesor);

        return ResponseEntity.ok(toDTO(cursoService.save(curso)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private CursoDTO toDTO(Curso curso) {
        return new CursoDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getDescripcion(),
                curso.getProfesor().getId(),
                curso.getProfesor().getNombre()
        );
    }
}