package com.colegio.management.application.service.asignatura;

import com.colegio.management.domain.model.Asignatura;

import java.util.List;

public interface AsignaturaService {
    Asignatura crearAsignatura(Asignatura asignatura);
    List<Asignatura> obtenerTodasLasAsignaturas();
    Asignatura obtenerAsignaturaPorId(Long id);
    Asignatura actualizarAsignatura(Long id, Asignatura detallesAsignatura);
    void eliminarAsignatura(Long id);
}
