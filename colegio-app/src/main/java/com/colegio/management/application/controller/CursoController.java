package com.colegio.management.application.controller;

import com.colegio.management.application.dto.CursoDTO;
import com.colegio.management.application.service.curso.CursoService;
import com.colegio.management.domain.model.Curso;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoDTO> crearCurso(@RequestBody CursoDTO curso) {
        CursoDTO nuevoCurso = cursoService.crearCurso(curso);
        return ResponseEntity.ok(nuevoCurso);
    }


    @GetMapping
    public ResponseEntity<List<CursoDTO>> obtenerTodosLosCursos() {
        List<CursoDTO> cursos = cursoService.obtenerTodosLosCursos();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerCursoPorId(@PathVariable Long id) {
        CursoDTO curso = cursoService.obtenerCursoPorId(id);
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> actualizarCurso(@PathVariable Long id, @RequestBody CursoDTO detallesCurso) {
        CursoDTO cursoActualizado = cursoService.actualizarCurso(id, detallesCurso);
        return ResponseEntity.ok(cursoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
