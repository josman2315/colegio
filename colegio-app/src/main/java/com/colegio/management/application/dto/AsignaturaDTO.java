package com.colegio.management.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class AsignaturaDTO {
    private Long asignaturaId;
    private String nombre;
    private ProfesorDTO profesor;
    private List<EstudianteDTO> estudiantes;
    private CursoDTO curso;
}
