package com.colegio.management.application.dto;

import lombok.Data;

@Data
public class CursoDTO {
    private Long cursoId;
    private Integer grado;
    private String salon;
    private ColegioDTO colegio;
}
