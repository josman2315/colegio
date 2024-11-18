package com.colegio.management.application.service.estudiante;

import com.colegio.management.domain.model.Estudiante;

import java.util.List;

public interface EstudianteService {
    Estudiante crearEstudiante(Estudiante estudiante);
    List<Estudiante> obtenerTodosLosEstudiantes();
    Estudiante obtenerEstudiantePorId(Long id);
    Estudiante actualizarEstudiante(Long id, Estudiante detallesEstudiante);
    void eliminarEstudiante(Long id);
}
