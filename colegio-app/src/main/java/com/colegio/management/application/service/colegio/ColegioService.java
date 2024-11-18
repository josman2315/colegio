package com.colegio.management.application.service.colegio;

import com.colegio.management.domain.model.Colegio;

import java.util.List;

public interface ColegioService {
    Colegio crearColegio(Colegio colegio);
    List<Colegio> obtenerTodosLosColegios();
    Colegio obtenerColegioPorId(Long id);
    Colegio actualizarColegio(Long id, Colegio detallesColegio);
    void eliminarColegio(Long id);
}