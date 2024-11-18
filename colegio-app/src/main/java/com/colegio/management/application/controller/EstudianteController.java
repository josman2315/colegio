package com.colegio.management.application.controller;

import com.colegio.management.application.service.estudiante.EstudianteService;
import com.colegio.management.domain.model.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.crearEstudiante(estudiante);
        return ResponseEntity.ok(nuevoEstudiante);
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantesPorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id);
        return ResponseEntity.ok(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiantes(@PathVariable Long id, @RequestBody Estudiante detallesEstudiante) {
        Estudiante estudianteActualizado = estudianteService.actualizarEstudiante(id, detallesEstudiante);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiantes(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}