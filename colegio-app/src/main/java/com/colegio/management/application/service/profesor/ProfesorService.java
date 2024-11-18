package com.colegio.management.application.service.profesor;

import com.colegio.management.application.dto.ProfesorAsignaturaResponse;
import com.colegio.management.domain.model.Profesor;

import java.util.List;

public interface ProfesorService {
    Profesor crearProfesor(Profesor profesor);
    List<Profesor> obtenerTodosLosProfesores();
    Profesor obtenerProfesorPorId(Long id);
    Profesor actualizarProfesor(Long id, Profesor detallesProfesor);
    void eliminarProfesor(Long id);
    List<ProfesorAsignaturaResponse> obtenerTodosLosProfesoresConAsignaturasYEstudiantes();
}
