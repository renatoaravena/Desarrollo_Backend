package com.duoc.LearningPlatformValidation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duoc.LearningPlatformValidation.dto.UsuarioDTO;
import com.duoc.LearningPlatformValidation.dto.UsuarioCreateDTO;
import com.duoc.LearningPlatformValidation.model.Usuario;
import com.duoc.LearningPlatformValidation.services.UsuarioService;
import com.duoc.LearningPlatformValidation.dto.RegistroDTO;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioDTO> getAll() {
        return service.getAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id) {
        Usuario usuario = service.getById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDTO(usuario));
    }

    @PostMapping("/registro/estudiante")
    public ResponseEntity<UsuarioDTO> registrarEstudiante(@RequestBody RegistroDTO dto) {
        Usuario usuario = service.registrarEstudiante(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDTO(usuario));
    }

    @PostMapping("/registro/profesor")
    public ResponseEntity<UsuarioDTO> registrarProfesor(@RequestBody RegistroDTO dto) {
        Usuario usuario = service.registrarProfesor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDTO(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioCreateDTO dto) {

        Usuario usuario = service.getById(id);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        // SOLO actualiza si no es null
        if (dto.getNombre() != null) {
            usuario.setNombre(dto.getNombre());
        }

        if (dto.getCorreo() != null) {
            usuario.setCorreo(dto.getCorreo());
        }

        if (dto.getContrasena() != null) {
            usuario.setContrasena(dto.getContrasena());
        }

        if (dto.getRol() != null) {
            usuario.setRol(dto.getRol());
        }

    return ResponseEntity.ok(toDTO(service.save(usuario)));
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getRol()
        );
    }
}