package com.colegio.management.application.service.estudiante;

import com.colegio.management.application.dto.EstudianteDTO;

import java.util.List;

public interface EstudianteService {
    EstudianteDTO crearEstudiante(EstudianteDTO estudiante);
    List<EstudianteDTO> obtenerTodosLosEstudiantes();
    EstudianteDTO obtenerEstudiantePorId(Long id);
    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO detallesEstudiante);
    void eliminarEstudiante(Long id);
}
