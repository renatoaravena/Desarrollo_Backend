package com.duoc.LearningPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor // Genera un constructor vacío 
@AllArgsConstructor // Genera un constructor con todos los atributos

public class Usuario {
    private Long id;
    private String nombre;
    private String correo;
    private String contraseña;
    private String rol; 
}
