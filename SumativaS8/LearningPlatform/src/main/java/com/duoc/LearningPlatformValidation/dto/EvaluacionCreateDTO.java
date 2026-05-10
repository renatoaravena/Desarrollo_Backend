package com.duoc.LearningPlatformValidation.dto;
import java.util.Date;

public class EvaluacionCreateDTO {

    private Long cursoId;
    private String nombre;
    private int puntajeMaximo;
    private Date fechaAplicacion;

    public EvaluacionCreateDTO() {
    }

    public Long getCursoId() {
        return cursoId;
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

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
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