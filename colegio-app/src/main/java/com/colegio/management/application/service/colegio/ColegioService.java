package com.colegio.management.application.service.colegio;

import com.colegio.management.application.dto.ColegioDTO;
import com.colegio.management.domain.model.Colegio;

import java.util.List;

public interface ColegioService {
    ColegioDTO crearColegio(ColegioDTO colegio);
    List<ColegioDTO> obtenerTodosLosColegios();
    ColegioDTO obtenerColegioPorId(Long id);
    ColegioDTO actualizarColegio(Long id, ColegioDTO detallesColegio);
    void eliminarColegio(Long id);
}