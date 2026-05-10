package com.duoc.LearningPlatformValidation.dto;

public class InscripcionCreateDTO {

    private Long cursoId;
    private Long estudianteId;

    public InscripcionCreateDTO() {
    }

    public Long getCursoId() {
        return cursoId;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }
}