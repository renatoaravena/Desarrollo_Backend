package com.duoc.LearningPlatformValidation.dto;
public class CursoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long profesorId;
    private String nombreProfesor;

    public CursoDTO() {
    }

    public CursoDTO(Long id, String nombre, String descripcion, Long profesorId, String nombreProfesor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesorId = profesorId;
        this.nombreProfesor = nombreProfesor;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }
}