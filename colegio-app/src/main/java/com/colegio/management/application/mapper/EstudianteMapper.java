package com.colegio.management.application.mapper;

import com.colegio.management.application.dto.EstudianteDTO;
import com.colegio.management.domain.model.Estudiante;

public class EstudianteMapper {

    public static EstudianteDTO convertirADTO(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setEstudianteId(estudiante.getEstudianteId());
        dto.setNombre(estudiante.getNombre());
        return dto;
    }

    public static Estudiante convertirAEntidad(EstudianteDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setEstudianteId(dto.getEstudianteId());
        estudiante.setNombre(dto.getNombre());
        return estudiante;
    }
}
