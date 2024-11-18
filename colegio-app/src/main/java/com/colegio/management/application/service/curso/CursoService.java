package com.colegio.management.application.service.curso;

import com.colegio.management.application.dto.CursoDTO;
import com.colegio.management.domain.model.Curso;

import java.util.List;

public interface CursoService {
    CursoDTO crearCurso(CursoDTO curso);
    List<CursoDTO> obtenerTodosLosCursos();
    CursoDTO obtenerCursoPorId(Long id);
    CursoDTO actualizarCurso(Long id, CursoDTO detallesCurso);
    void eliminarCurso(Long id);
}
