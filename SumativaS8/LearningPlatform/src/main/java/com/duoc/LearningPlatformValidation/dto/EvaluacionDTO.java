package com.duoc.LearningPlatformValidation.dto;

import java.util.Date;

public class EvaluacionDTO {

    private Long id;
    private Long cursoId;
    private String nombreCurso;
    private String nombre;
    private int puntajeMaximo;
    private Date fechaAplicacion;

    public EvaluacionDTO() {
    }

    public EvaluacionDTO(Long id, Long cursoId, String nombreCurso,
                         String nombre, int puntajeMaximo, Date fechaAplicacion) {
        this.id = id;
        this.cursoId = cursoId;
        this.nombreCurso = nombreCurso;
        this.nombre = nombre;
        this.puntajeMaximo = puntajeMaximo;
        this.fechaAplicacion = fechaAplicacion;
    }

    public Long getId() { return id; }
    public Long getCursoId() { return cursoId; }
    public String getNombreCurso() { return nombreCurso; }
    public String getNombre() { return nombre; }
    public int getPuntajeMaximo() { return puntajeMaximo; }
    public Date getFechaAplicacion() { return fechaAplicacion; }

    public void setId(Long id) { this.id = id; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
    public void setNombreCurso(String nombreCurso) { this.nombreCurso = nombreCurso; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPuntajeMaximo(int puntajeMaximo) { this.puntajeMaximo = puntajeMaximo; }
    public void setFechaAplicacion(Date fechaAplicacion) { this.fechaAplicacion = fechaAplicacion; }
}