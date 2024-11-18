package com.colegio.management.application.service.profesor;

import com.colegio.management.application.dto.ProfesorAsignaturaResponse;
import com.colegio.management.application.dto.ProfesorDTO;
import com.colegio.management.domain.model.Profesor;

import java.util.List;

public interface ProfesorService {
    ProfesorDTO crearProfesor(ProfesorDTO profesor);
    List<ProfesorDTO> obtenerTodosLosProfesores();
    ProfesorDTO obtenerProfesorPorId(Long id);
    ProfesorDTO actualizarProfesor(Long id, ProfesorDTO detallesProfesor);
    void eliminarProfesor(Long id);
    List<ProfesorAsignaturaResponse> obtenerTodosLosProfesoresConAsignaturasYEstudiantes();
}
