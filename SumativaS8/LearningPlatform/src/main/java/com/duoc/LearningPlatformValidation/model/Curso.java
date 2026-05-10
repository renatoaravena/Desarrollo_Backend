package com.duoc.LearningPlatformValidation.model;

import jakarta.persistence.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Usuario profesor;

    public Curso() {
    }

    public Curso(Long id, String nombre, String descripcion, Usuario profesor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesor = profesor;
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

    public Usuario getProfesor() {
        return profesor;
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

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }
}