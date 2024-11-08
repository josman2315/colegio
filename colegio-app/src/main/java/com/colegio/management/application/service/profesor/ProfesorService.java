package com.colegio.management.application.service.profesor;

import com.colegio.management.application.dto.ProfesorAsignaturaResponse;

import java.util.List;

public interface ProfesorService {

    List<ProfesorAsignaturaResponse> obtenerTodosLosProfesoresConAsignaturasYEstudiantes();
}
