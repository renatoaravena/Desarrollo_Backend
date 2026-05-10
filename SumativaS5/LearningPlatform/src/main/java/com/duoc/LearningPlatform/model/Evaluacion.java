package com.duoc.LearningPlatform.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor // Genera un constructor vacío 
@AllArgsConstructor // Genera un constructor con todos los atributos

public class Evaluacion {
    private Long id;
    private Long cursoId;
    private String nombre;
    private int puntajeMaximo;
    private Date fechaEvaluacion;
}
