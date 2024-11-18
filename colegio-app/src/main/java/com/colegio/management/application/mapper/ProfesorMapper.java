package com.colegio.management.application.mapper;

import com.colegio.management.application.dto.ProfesorDTO;
import com.colegio.management.domain.model.Profesor;

public class ProfesorMapper {


    public static ProfesorDTO convertirADTO(Profesor profesor) {
        ProfesorDTO dto = new ProfesorDTO();
        dto.setProfesorId(profesor.getProfesorId());
        dto.setNombre(profesor.getNombre());
        return dto;
    }

    public static Profesor convertirAEntidad(ProfesorDTO dto) {
        Profesor profesor = new Profesor();
        profesor.setProfesorId(dto.getProfesorId());
        profesor.setNombre(dto.getNombre());
        return profesor;
    }
}
