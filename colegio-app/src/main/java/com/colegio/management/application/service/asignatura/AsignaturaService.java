package com.colegio.management.application.service.asignatura;

import com.colegio.management.application.dto.AsignaturaDTO;
import com.colegio.management.domain.model.Asignatura;

import java.util.List;

public interface AsignaturaService {
    AsignaturaDTO crearAsignatura(Asignatura asignatura);
    List<AsignaturaDTO> obtenerTodasLasAsignaturas();
    AsignaturaDTO obtenerAsignaturaPorId(Long id);
    AsignaturaDTO actualizarAsignatura(Long id, Asignatura detallesAsignatura);
    void eliminarAsignatura(Long id);
}
