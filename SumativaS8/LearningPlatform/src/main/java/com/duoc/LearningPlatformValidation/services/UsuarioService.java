package com.duoc.LearningPlatformValidation.services;
import com.duoc.LearningPlatformValidation.dto.RegistroDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.LearningPlatformValidation.model.Usuario;
import com.duoc.LearningPlatformValidation.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Usuario registrarEstudiante(RegistroDTO dto) {
        Usuario usuario = new Usuario(
            null,
            dto.getNombre(),
            dto.getCorreo(),
            dto.getContrasena(),
            "ESTUDIANTE"
        );
        return repository.save(usuario);
    }

    public Usuario registrarProfesor(RegistroDTO dto) {
        Usuario usuario = new Usuario(
            null,
            dto.getNombre(),
            dto.getCorreo(),
            dto.getContrasena(),
            "Profesor"
        );
        return repository.save(usuario);
    }
}
