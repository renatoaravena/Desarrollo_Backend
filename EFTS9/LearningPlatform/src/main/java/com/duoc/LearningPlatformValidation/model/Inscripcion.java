package com.duoc.LearningPlatformValidation.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Usuario estudiante;

    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;

    public Inscripcion() {
    }

    public Inscripcion(Long id, Curso curso, Usuario estudiante, Date fechaInscripcion) {
        this.id = id;
        this.curso = curso;
        this.estudiante = estudiante;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Long getId() {
        return id;
    }

    public Curso getCurso() {
        return curso;
    }

    public Usuario getEstudiante() {
        return estudiante;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setEstudiante(Usuario estudiante) {
        this.estudiante = estudiante;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}