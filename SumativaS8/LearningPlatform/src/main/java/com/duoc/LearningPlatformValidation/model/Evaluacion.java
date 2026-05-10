package com.duoc.LearningPlatformValidation.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private String nombre;
    private int puntajeMaximo;

    @Temporal(TemporalType.DATE)
    private Date fechaAplicacion;

    public Evaluacion() {
    }

    public Evaluacion(Long id, Curso curso, String nombre, int puntajeMaximo, Date fechaAplicacion) {
        this.id = id;
        this.curso = curso;
        this.nombre = nombre;
        this.puntajeMaximo = puntajeMaximo;
        this.fechaAplicacion = fechaAplicacion;
    }

    public Long getId() {
        return id;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntajeMaximo() {
        return puntajeMaximo;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntajeMaximo(int puntajeMaximo) {
        this.puntajeMaximo = puntajeMaximo;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }
}