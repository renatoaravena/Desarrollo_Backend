package com.duoc.LearningPlatformValidation.dto;

public class CursoCreateDTO {

    private String nombre;
    private String descripcion;
    private Long profesorId;

    public CursoCreateDTO() {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }
}