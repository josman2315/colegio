package com.colegio.management.application.service.curso;

import com.colegio.management.domain.model.Curso;

import java.util.List;

public interface CursoService {
    Curso crearCurso(Curso curso);
    List<Curso> obtenerTodosLosCursos();
    Curso obtenerCursoPorId(Long id);
    Curso actualizarCurso(Long id, Curso detallesCurso);
    void eliminarCurso(Long id);
}
