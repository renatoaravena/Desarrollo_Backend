package com.duoc.LearningPlatformValidation.dto;

import java.util.Date;

public class InscripcionDTO {

    private Long id;
    private Long cursoId;
    private String nombreCurso;
    private Long estudianteId;
    private String nombreEstudiante;
    private Date fechaInscripcion;

    public InscripcionDTO() {
    }

    public InscripcionDTO(Long id, Long cursoId, String nombreCurso,
                          Long estudianteId, String nombreEstudiante,
                          Date fechaInscripcion) {
        this.id = id;
        this.cursoId = cursoId;
        this.nombreCurso = nombreCurso;
        this.estudianteId = estudianteId;
        this.nombreEstudiante = nombreEstudiante;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Long getId() { return id; }
    public Long getCursoId() { return cursoId; }
    public String getNombreCurso() { return nombreCurso; }
    public Long getEstudianteId() { return estudianteId; }
    public String getNombreEstudiante() { return nombreEstudiante; }
    public Date getFechaInscripcion() { return fechaInscripcion; }

    public void setId(Long id) { this.id = id; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
    public void setNombreCurso(String nombreCurso) { this.nombreCurso = nombreCurso; }
    public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }
    public void setNombreEstudiante(String nombreEstudiante) { this.nombreEstudiante = nombreEstudiante; }
    public void setFechaInscripcion(Date fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
}