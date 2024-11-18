package com.colegio.management.application.mapper;

import com.colegio.management.application.dto.AsignaturaDTO;
import com.colegio.management.application.dto.CursoDTO;
import com.colegio.management.application.dto.EstudianteDTO;
import com.colegio.management.application.dto.ProfesorDTO;
import com.colegio.management.domain.model.Asignatura;

import java.util.List;
import java.util.stream.Collectors;

public class AsignaturaMapper {

    public static AsignaturaDTO toDTO(Asignatura asignatura) {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setAsignaturaId(asignatura.getAsignaturaId());
        dto.setNombre(asignatura.getNombre());

        if (asignatura.getProfesor() != null) {
            ProfesorDTO profesorDTO = new ProfesorDTO();
            profesorDTO.setProfesorId(asignatura.getProfesor().getProfesorId());
            profesorDTO.setNombre(asignatura.getProfesor().getNombre());
            dto.setProfesor(profesorDTO);
        }

        if (asignatura.getEstudiantes() != null) {
            List<EstudianteDTO> estudiantesDTO = asignatura.getEstudiantes().stream()
                    .map(estudiante -> {
                        EstudianteDTO estudianteDTO = new EstudianteDTO();
                        estudianteDTO.setEstudianteId(estudiante.getEstudianteId());
                        estudianteDTO.setNombre(estudiante.getNombre());
                        return estudianteDTO;
                    })
                    .collect(Collectors.toList());
            dto.setEstudiantes(estudiantesDTO);
        }

        if (asignatura.getCurso() != null) {
            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setCursoId(asignatura.getCurso().getCursoId());
            cursoDTO.setGrado(asignatura.getCurso().getGrado());
            cursoDTO.setSalon(asignatura.getCurso().getSalon());
            dto.setCurso(cursoDTO);
        }

        return dto;
    }
}