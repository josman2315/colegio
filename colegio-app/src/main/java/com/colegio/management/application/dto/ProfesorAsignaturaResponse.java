package com.colegio.management.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfesorAsignaturaResponse {
    private String docente;
    private String materia;
    private String curso;
    private String estudiantes;
}